package iandrew40.easycooking.web.controllers.home;

import iandrew40.easycooking.service.services.recipe.RecipeCreateService;
import iandrew40.easycooking.web.annotations.PageTitle;
import iandrew40.easycooking.web.models.recipe.RecipeViewModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.stream.Collectors;


@Controller
public class HomeController {

    private final RecipeCreateService recipeCreateService;
    private final ModelMapper modelMapper;

    @Autowired
    public HomeController(RecipeCreateService recipeCreateService, ModelMapper modelMapper) {
        this.recipeCreateService = recipeCreateService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/")
    @PreAuthorize("isAnonymous()")
    @PageTitle("Index")
    public String getIndex(ModelAndView modelAndView) {
        modelAndView.setViewName("/");
        return "/index";
    }

    @GetMapping("/home")
    @PreAuthorize("isAuthenticated()")
    @PageTitle("Home")
    public ModelAndView getHome(ModelAndView modelAndView) {
        List<RecipeViewModel> recipes = this.recipeCreateService.findAllRecipes()
                .stream().map(r -> this.modelMapper.map(r, RecipeViewModel.class))
                .collect(Collectors.toList());
        modelAndView.addObject("recipes", recipes);

        modelAndView.setViewName("home.html");
        return modelAndView;
    }
}
