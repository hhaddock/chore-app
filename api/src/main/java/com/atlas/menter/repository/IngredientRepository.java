package com.atlas.menter.repository;

import com.atlas.menter.entity.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredient, Long> {

    Ingredient findByRecipeId(Long id);
}
