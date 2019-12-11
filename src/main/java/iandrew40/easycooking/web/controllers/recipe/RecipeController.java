package iandrew40.easycooking.web.controllers.recipe;

import iandrew40.easycooking.service.models.recipe.RecipeCreateServiceModel;
import iandrew40.easycooking.service.models.recipe.RecipeViewServiceModel;
import iandrew40.easycooking.service.services.recipe.RecipeCreateService;
import iandrew40.easycooking.web.models.recipe.RecipeCreateModel;
import iandrew40.easycooking.web.models.recipe.RecipeViewModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

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


    @GetMapping("/details/{recipe}")
    public ModelAndView getViewRecipe(@PathVariable String recipe, ModelAndView modelAndView){
        RecipeViewServiceModel recipeServiceModel = this.recipeCreateService.getRecipeByName(recipe);

        RecipeViewModel recipeViewModel = this.modelMapper
                .map(recipeServiceModel, RecipeViewModel.class);
        modelAndView.addObject("recipe", recipeViewModel);
        modelAndView.setViewName("recipe/view-recipe.html");

        return modelAndView;
    }



    @GetMapping("/create-recipe")
    public String getCreateRecipe(Model model){
        model.addAttribute("model", new RecipeCreateModel());

        return "recipe/create-recipe.html";
    }

    @PostMapping("/create-recipe")
    public String createRecipe(@ModelAttribute RecipeCreateModel recipeCreateModel, HttpServletRequest request){

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

        //Here we remove all empty fields from ingredients list.
        for (int i = 19; i >= 0; i--) {
            if (ingredients.get(i).equals("")){
            ingredients.remove(i);
            }
        }

        RecipeCreateServiceModel recipeCreateServiceModel = this.modelMapper
                .map(recipeCreateModel, RecipeCreateServiceModel.class);

        recipeCreateServiceModel.setIngredients(ingredients);

        String principal = request.getUserPrincipal().getName();
        recipeCreateServiceModel.setUser(principal);

        recipeCreateService.create(recipeCreateServiceModel);

        return "redirect:/";
    }
}
