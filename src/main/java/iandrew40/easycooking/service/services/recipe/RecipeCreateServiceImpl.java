package iandrew40.easycooking.service.services.recipe;

import iandrew40.easycooking.data.models.Ingredient;
import iandrew40.easycooking.data.models.Recipe;
import iandrew40.easycooking.data.repositories.IngredientRepository;
import iandrew40.easycooking.data.repositories.RecipeRepository;
import iandrew40.easycooking.service.models.recipe.RecipeCreateServiceModel;
import iandrew40.easycooking.service.models.recipe.RecipeViewServiceModel;
import iandrew40.easycooking.service.services._shared.DateService;
import iandrew40.easycooking.web.models.recipe.RecipeCreateModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecipeCreateServiceImpl implements RecipeCreateService {

    private final ModelMapper modelMapper;
    private final RecipeRepository recipeRepository;
    private final IngredientRepository ingredientRepository;
    private final DateService dateService;


    @Autowired
    public RecipeCreateServiceImpl(ModelMapper modelMapper, RecipeRepository recipeRepository, IngredientRepository ingredientRepository, DateService dateService) {
        this.modelMapper = modelMapper;
        this.recipeRepository = recipeRepository;
        this.ingredientRepository = ingredientRepository;
        this.dateService = dateService;
    }

    @Override
    public List<String> addIngredientsToListAndRemoveEmptyEntries(RecipeCreateModel model) {
        List<String> ingredients = new ArrayList<>();

        ingredients.add(model.getIngredient1());
        ingredients.add(model.getIngredient2());
        ingredients.add(model.getIngredient3());
        ingredients.add(model.getIngredient4());
        ingredients.add(model.getIngredient5());
        ingredients.add(model.getIngredient6());
        ingredients.add(model.getIngredient7());
        ingredients.add(model.getIngredient8());
        ingredients.add(model.getIngredient9());
        ingredients.add(model.getIngredient10());
        ingredients.add(model.getIngredient11());
        ingredients.add(model.getIngredient12());
        ingredients.add(model.getIngredient13());
        ingredients.add(model.getIngredient14());
        ingredients.add(model.getIngredient15());
        ingredients.add(model.getIngredient16());
        ingredients.add(model.getIngredient17());
        ingredients.add(model.getIngredient18());
        ingredients.add(model.getIngredient19());
        ingredients.add(model.getIngredient20());

        //Here we remove all empty fields from ingredients list.
        for (int i = 19; i >= 0; i--) {
            if (ingredients.get(i).equals("")){
            ingredients.remove(i);
            }
        }

        return ingredients;

    }

    @Override
    public RecipeViewServiceModel getRecipeByName(String name) {

        Recipe recipeFound = this.recipeRepository.getByName(name);


        return this.modelMapper
                .map(recipeFound, RecipeViewServiceModel.class);
    }

    @Override
    public void create(RecipeCreateServiceModel recipeCreateServiceModel) {


        recipeCreateServiceModel.setDateAdded(this.dateService.getCurrentDate());


        //Here we convert the list of Strings to list of Ingredients
        List<Ingredient> ingredients = new ArrayList<>();
        for (String s : recipeCreateServiceModel.getIngredients()) {

            if (this.ingredientRepository.findByName(s) == null) {

                Ingredient ing = new Ingredient();
                ing.setName(s);
                ingredients.add(ing);
                this.ingredientRepository.saveAndFlush(ing);

            } else {

                Ingredient ing = this.ingredientRepository.findByName(s);
                ingredients.add(ing);
                this.ingredientRepository.saveAndFlush(ing);
            }

        }


        Recipe recipe = this.modelMapper.map(recipeCreateServiceModel, Recipe.class);
        recipe.setIngredients(ingredients);


        this.recipeRepository.saveAndFlush(recipe);

    }

}
