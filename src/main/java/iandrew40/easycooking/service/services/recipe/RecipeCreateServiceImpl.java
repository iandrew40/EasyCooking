package iandrew40.easycooking.service.services.recipe;

import iandrew40.easycooking.data.models.Ingredient;
import iandrew40.easycooking.data.models.Recipe;
import iandrew40.easycooking.data.repositories.IngredientRepository;
import iandrew40.easycooking.data.repositories.RecipeRepository;
import iandrew40.easycooking.service.models.recipe.RecipeCreateServiceModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class RecipeCreateServiceImpl implements RecipeCreateService {

    private final ModelMapper modelMapper;
    private final RecipeRepository recipeRepository;
    private final IngredientRepository ingredientRepository;


    @Autowired
    public RecipeCreateServiceImpl(ModelMapper modelMapper, RecipeRepository recipeRepository, IngredientRepository ingredientRepository) {
        this.modelMapper = modelMapper;
        this.recipeRepository = recipeRepository;
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public void create(RecipeCreateServiceModel recipeCreateServiceModel) {


        recipeCreateServiceModel.setDateAdded(LocalDate.now());
        //recipeCreateServiceModel.setUser(); //get it from session


        //Here we convert the list of Strings to list of Ingredients
        List<Ingredient> ingredients = new ArrayList<>();
        for (String s : recipeCreateServiceModel.getIngredients()) {
            Ingredient ing = new Ingredient();
            ing.setName(s);
            ingredients.add(ing);
        }


        Recipe recipe = this.modelMapper.map(recipeCreateServiceModel, Recipe.class);
        recipe.setIngredients(ingredients);

        for (Ingredient ingredient : ingredients) {
            if (this.ingredientRepository.findByName(ingredient.getName()) == null){
            this.ingredientRepository.save(ingredient);
            }
        }


        System.out.println();
        this.recipeRepository.save(recipe);

    }

}
