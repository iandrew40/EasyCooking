package iandrew40.easycooking.data.repositories;

import iandrew40.easycooking.data.models.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, String> {

    Recipe findFirstByName(String name);

    List<Recipe> findAllByCategory(String categoryName);

    Recipe getByName(String name);

}
