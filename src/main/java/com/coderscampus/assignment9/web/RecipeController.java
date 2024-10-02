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
            return Collections.emptyList();
        }
    }

    @GetMapping("/gluten-free")
    public List<Recipe> getGlutenFreeRecipes() {
        try {
            return recipeService.getGlutenFreeRecipes();
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }

    @GetMapping("/vegan")
    public List<Recipe> getVeganRecipes() {
        try {
            return recipeService.getVeganRecipes();
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }

    @GetMapping("/vegan-and-gluten-free")
    public List<Recipe> getVeganAndGlutenFreeRecipes() {
        try {
            return recipeService.getVeganAndGlutenFreeRecipes();
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }

    @GetMapping("/vegetarian")
    public List<Recipe> getVegetarianRecipes() {
        try {
            return recipeService.getVegetarianRecipes();
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }
}