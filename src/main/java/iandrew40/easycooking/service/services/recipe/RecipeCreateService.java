package iandrew40.easycooking.service.services.recipe;

import iandrew40.easycooking.service.models.recipe.RecipeCreateServiceModel;
import iandrew40.easycooking.service.models.recipe.RecipeViewServiceModel;

public interface RecipeCreateService {

    void create(RecipeCreateServiceModel recipeCreateServiceModel);

    RecipeViewServiceModel getRecipeByName(String name);

}
