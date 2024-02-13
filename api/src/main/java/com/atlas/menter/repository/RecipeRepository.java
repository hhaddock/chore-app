package com.atlas.menter.repository;

import com.atlas.menter.entity.Recipe;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {

    List<Recipe> findByName(String name);
    Recipe findById(long id);

//    Recipe createRecipe(Recipe newRecipe);
}
