package iandrew40.easycooking.service.services.recipe;

import iandrew40.easycooking.data.models.Recipe;
import iandrew40.easycooking.data.repositories.RecipeRepository;
import iandrew40.easycooking.service.models.recipe.RecipeCreateServiceModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class RecipeCreateServiceImpl implements RecipeCreateService{

    private final ModelMapper modelMapper;
    private final RecipeRepository recipeRepository;

    @Autowired
    public RecipeCreateServiceImpl(ModelMapper modelMapper, RecipeRepository recipeRepository) {
        this.modelMapper = modelMapper;
        this.recipeRepository = recipeRepository;
    }

    @Override
    public void create(RecipeCreateServiceModel recipeCreateServiceModel) {

        recipeCreateServiceModel.setDateAdded(LocalDate.now());
        //recipeCreateServiceModel.setUser(); //get it from session

        Recipe recipe = this.modelMapper.map(recipeCreateServiceModel, Recipe.class);

        this.recipeRepository.save(recipe);

    }

}
