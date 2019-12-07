package iandrew40.easycooking.data.repositories;

import iandrew40.easycooking.data.models.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, String> {

    Ingredient findByName(String name);
}
