package com.coderscampus.assignment9.web;

import com.coderscampus.assignment9.domain.Recipe;
import com.coderscampus.assignment9.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;



@RestController
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @GetMapping("/all-recipes")
    public List<Recipe> getAllRecipes() {
        try {
            return recipeService.getAllRecipes();
        } catch (Exception e) {
            // Handle the exception and return a user-friendly error message
            return Collections.emptyList();
        }
    }

    @GetMapping("/gluten-free")
    public List<Recipe> getGlutenFreeRecipes() {
        return recipeService.getGlutenFreeRecipes();
    }

    @GetMapping("/vegan")
    public List<Recipe> getVeganRecipes() {
        return recipeService.getVeganRecipes();
    }

    @GetMapping("/vegan-and-gluten-free")
    public List<Recipe> getVeganAndGlutenFreeRecipes() {
        return recipeService.getVeganAndGlutenFreeRecipes();
    }

    @GetMapping("/vegetarian")
    public List<Recipe> getVegetarianRecipes() {
        return recipeService.getVegetarianRecipes();
    }
}