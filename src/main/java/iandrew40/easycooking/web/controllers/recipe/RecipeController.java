package iandrew40.easycooking.web.controllers.recipe;

import iandrew40.easycooking.service.models.recipe.RecipeCreateServiceModel;
import iandrew40.easycooking.service.models.recipe.RecipeViewServiceModel;
import iandrew40.easycooking.service.services.recipe.RecipeCreateService;
import iandrew40.easycooking.web.annotations.PageTitle;
import iandrew40.easycooking.web.models.recipe.RecipeCreateModel;
import iandrew40.easycooking.web.models.recipe.RecipeViewModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/recipe")
public class RecipeController {

    private final ModelMapper modelMapper;
    private final RecipeCreateService recipeCreateService;

    @Autowired
    public RecipeController(ModelMapper modelMapper, RecipeCreateService recipeCreateService) {
        this.modelMapper = modelMapper;
        this.recipeCreateService = recipeCreateService;
    }


//    @GetMapping("/details/{recipe}")
//    public ModelAndView getViewRecipe(@PathVariable String recipe, ModelAndView modelAndView) {
//        RecipeViewServiceModel recipeServiceModel = this.recipeCreateService.getRecipeByName(recipe);
//
//        RecipeViewModel recipeViewModel = this.modelMapper
//                .map(recipeServiceModel, RecipeViewModel.class);
//        modelAndView.addObject("recipe", recipeViewModel);
//        modelAndView.setViewName("recipe/view-recipe.html");
//
//        return modelAndView;
//    }


    @GetMapping("/create-recipe")
    @PageTitle("Create recipe")
    @PreAuthorize("isAuthenticated()")
    public String getCreateRecipe(Model model) {
        model.addAttribute("model", new RecipeCreateModel());

        return "recipe/create-recipe.html";
    }

    @PostMapping("/create-recipe")
    public String createRecipe(@ModelAttribute RecipeCreateModel recipeCreateModel, HttpServletRequest request) {


        RecipeCreateServiceModel recipeCreateServiceModel = this.modelMapper
                .map(recipeCreateModel, RecipeCreateServiceModel.class);

        recipeCreateServiceModel.setIngredients(this.recipeCreateService
                .addIngredientsToListAndRemoveEmptyEntries(recipeCreateModel));

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        recipeCreateServiceModel.setUser(name);


        recipeCreateService.create(recipeCreateServiceModel);

        return "redirect:/home";
    }

    @GetMapping("/details/{id}")
    @PageTitle("Recipe Details")
    @PreAuthorize("isAuthenticated()")
    public ModelAndView recipeDetails(@PathVariable String id, ModelAndView modelAndView) {
        RecipeViewServiceModel serviceViewModel = this.recipeCreateService.findById(id);

        RecipeViewModel recipeViewModel = this.modelMapper.map(serviceViewModel, RecipeViewModel.class);
        modelAndView.addObject("recipe", recipeViewModel);
        modelAndView.setViewName("recipe/view-recipe.html");
        return modelAndView;
    }

}
