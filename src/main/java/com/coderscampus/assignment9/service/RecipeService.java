package com.coderscampus.assignment9.service;
import com.coderscampus.assignment9.domain.Recipe;
import com.coderscampus.assignment9.repository.RecipeRepository;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

    public void init() {
        List<Recipe> recipes = FileService.readRecipes("recipes.txt");
        recipes.forEach(recipe -> recipeRepository.addRecipe(recipe));
    }


    public List<Recipe> getAllRecipes() {
        return recipeRepository.getAllRecipes();
    }

    public List<Recipe> getGlutenFreeRecipes() {
        return recipeRepository.getGlutenFreeRecipes();
    }

    public List<Recipe> getVeganRecipes() {
        return recipeRepository.getVeganRecipes();
    }

    public List<Recipe> getVeganAndGlutenFreeRecipes() {
        return recipeRepository.getVeganAndGlutenFreeRecipes();
    }

    public List<Recipe> getVegetarianRecipes() {
        return recipeRepository.getVegetarianRecipes();
    }
}
