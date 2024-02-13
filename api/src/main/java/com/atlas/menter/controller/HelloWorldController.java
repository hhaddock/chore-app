package com.atlas.menter.controller;

import com.atlas.menter.entity.Recipe;
import com.atlas.menter.service.impl.RecipeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.core.RepositoryCreationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HelloWorldController {

    @Autowired
    RecipeServiceImpl recipeService;

    @GetMapping("/hello-world")
    public String HelloWorld(@RequestParam(value = "name", defaultValue = "World") String name){
        Recipe r = recipeService.getRecipeById(1l);

        return String.format("Hello %s! recipe is %s", name, r.toString());
    };

    @PostMapping(value = "/api/recipe")
    public ResponseEntity<Object> createRecipe(@RequestBody Recipe recipe){
        try{
            Recipe r = recipeService.createRecipe(recipe);
            return new ResponseEntity<>(r, HttpStatus.CREATED);
        } catch (RepositoryCreationException ex){
            return new ResponseEntity<>("Error Creating Recipe", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/api/recipe")
    public ResponseEntity<List<Recipe>> getRecipies(){
        Iterable<Recipe> recipes = recipeService.getRecipes();
        return new ResponseEntity<>((List<Recipe>) recipes, HttpStatus.OK);
    }
}
