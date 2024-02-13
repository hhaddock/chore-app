package com.atlas.menter.service.impl;

import com.atlas.menter.entity.Recipe;
import com.atlas.menter.repository.RecipeRepository;
import com.atlas.menter.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RecipeServiceImpl implements RecipeService {

    @Autowired
    RecipeRepository recipeRepository;

    @Override
    public Recipe createRecipe(Recipe recipe) {
        Recipe newRecipe = new Recipe(recipe.name, recipe.description);
        newRecipe.setIngredients(recipe.ingredients);
        recipeRepository.save(newRecipe);
        return newRecipe;
    }

    @Override
    public void updateRecipe(Long id, Recipe recipe) {

    }

    @Override
    public void deleteRecipe(Long id) {

    }

    @Override
    public Iterable<Recipe> getRecipes() {
        Iterable<Recipe> recipes = recipeRepository.findAll();
        return recipes;
    }

    @Override
    public Recipe getRecipeById(Long id) {
        Optional<Recipe> recipe = recipeRepository.findById(id);
        if(recipe.isPresent() && !recipe.isEmpty()){
            return recipe.get();
        }
        return null;
    }
}
