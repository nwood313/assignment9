package com.coderscampus.assignment9.web;

import com.coderscampus.assignment9.domain.Recipe;
import com.coderscampus.assignment9.service.RecipeService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Collections;
import java.util.List;



@RestController
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @PostConstruct
    public void init() {
        try {
            recipeService.readRecipes();
        } catch (IOException e) {
            // Handle the exception and log an error message
        }
    }

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
        try {
            return recipeService.getGlutenFreeRecipes();
        } catch (Exception e) {
            // Handle the exception and return a user-friendly error message
            return Collections.emptyList();
        }
    }

    @GetMapping("/vegan")
    public List<Recipe> getVeganRecipes() {
        try {
            return recipeService.getVeganRecipes();
        } catch (Exception e) {
            // Handle the exception and return a user-friendly error message
            return Collections.emptyList();
        }
    }

    @GetMapping("/vegan-and-gluten-free")
    public List<Recipe> getVeganAndGlutenFreeRecipes() {
        try {
            return recipeService.getVeganAndGlutenFreeRecipes();
        } catch (Exception e) {
            // Handle the exception and return a user-friendly error message
            return Collections.emptyList();
        }
    }

    @GetMapping("/vegetarian")
    public List<Recipe> getVegetarianRecipes() {
        try {
            return recipeService.getVegetarianRecipes();
        } catch (Exception e) {
            // Handle the exception and return a user-friendly error message
            return Collections.emptyList();
        }
    }
}