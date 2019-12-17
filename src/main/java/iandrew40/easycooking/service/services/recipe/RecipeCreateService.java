package iandrew40.easycooking.service.services.recipe;

import iandrew40.easycooking.service.models.recipe.RecipeCreateServiceModel;
import iandrew40.easycooking.service.models.recipe.RecipeViewServiceModel;
import iandrew40.easycooking.web.models.recipe.RecipeCreateModel;

import java.util.List;

public interface RecipeCreateService {

    void create(RecipeCreateServiceModel recipeCreateServiceModel);

    RecipeViewServiceModel getRecipeByName(String name);

    //Adding the strings from the RecipeViewModel to list and removing the empty ones
    List<String> addIngredientsToListAndRemoveEmptyEntries(RecipeCreateModel model);

    List<RecipeViewServiceModel> findAllRecipes();

    RecipeViewServiceModel findById(String id);
}
