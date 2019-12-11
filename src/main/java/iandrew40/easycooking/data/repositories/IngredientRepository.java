package iandrew40.easycooking.data.repositories;

import iandrew40.easycooking.data.models.Ingredient;
import iandrew40.easycooking.data.models.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, String> {

    Ingredient findByName(String name);

}
