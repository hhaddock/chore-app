package com.atlas.menter.service;

import com.atlas.menter.entity.Recipe;

import java.util.Set;

public interface RecipeService {
    public abstract Recipe createRecipe(Recipe recipe);
    public abstract void updateRecipe(Long id, Recipe recipe);
    public abstract void deleteRecipe(Long id);
    public abstract Iterable<Recipe> getRecipes();

    public abstract Recipe getRecipeById(Long id);
}
