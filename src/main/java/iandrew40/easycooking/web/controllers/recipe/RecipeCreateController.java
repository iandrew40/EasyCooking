package iandrew40.easycooking.web.controllers.recipe;

import iandrew40.easycooking.data.models.Ingredient;
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

import java.util.ArrayList;
import java.util.List;

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

        List<String> ingredients = new ArrayList<>();
        ingredients.add(recipeCreateModel.getIngredient1());
        ingredients.add(recipeCreateModel.getIngredient2());
        ingredients.add(recipeCreateModel.getIngredient3());
        ingredients.add(recipeCreateModel.getIngredient4());
        ingredients.add(recipeCreateModel.getIngredient5());
        ingredients.add(recipeCreateModel.getIngredient6());
        ingredients.add(recipeCreateModel.getIngredient7());
        ingredients.add(recipeCreateModel.getIngredient8());
        ingredients.add(recipeCreateModel.getIngredient9());
        ingredients.add(recipeCreateModel.getIngredient10());
        ingredients.add(recipeCreateModel.getIngredient11());
        ingredients.add(recipeCreateModel.getIngredient12());
        ingredients.add(recipeCreateModel.getIngredient13());
        ingredients.add(recipeCreateModel.getIngredient14());
        ingredients.add(recipeCreateModel.getIngredient15());
        ingredients.add(recipeCreateModel.getIngredient16());
        ingredients.add(recipeCreateModel.getIngredient17());
        ingredients.add(recipeCreateModel.getIngredient18());
        ingredients.add(recipeCreateModel.getIngredient19());
        ingredients.add(recipeCreateModel.getIngredient20());

        List<Ingredient> obj = (List)ingredients;



        RecipeCreateServiceModel recipeCreateServiceModel = this.modelMapper
                .map(recipeCreateModel, RecipeCreateServiceModel.class);
        recipeCreateService.create(recipeCreateServiceModel);

        recipeCreateServiceModel.setIngredients(obj);
        System.out.println();
        return "redirect:/";
    }
}
