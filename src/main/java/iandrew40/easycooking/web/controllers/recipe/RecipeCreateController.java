package iandrew40.easycooking.web.controllers.recipe;

import iandrew40.easycooking.service.models.recipe.RecipeCreateServiceModel;
import iandrew40.easycooking.service.services.recipe.RecipeCreateService;
import iandrew40.easycooking.web.models.recipe.RecipeCreateModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/recipe")
public class RecipeCreateController {

    private final ModelMapper modelMapper;
    private final RecipeCreateService recipeCreateService;

    @Autowired
    public RecipeCreateController(ModelMapper modelMapper, RecipeCreateService recipeCreateService) {
        this.modelMapper = modelMapper;
        this.recipeCreateService = recipeCreateService;
    }

    @GetMapping("/create-recipe")
    public String getCreateRecipe(Model model){
        model.addAttribute("model", new RecipeCreateModel());

        return "recipe/create-recipe.html";
    }

    @PostMapping("/create-recipe")
    public String createRecipe(@ModelAttribute RecipeCreateModel recipeCreateModel){

        RecipeCreateServiceModel recipeCreateServiceModel = this.modelMapper
                .map(recipeCreateModel, RecipeCreateServiceModel.class);
        recipeCreateService.create(recipeCreateServiceModel);

        return "redirect:/";
    }
}
