package com.coderscampus.assignment9.repository;

import com.coderscampus.assignment9.domain.Recipe;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class RecipeRepository {

    private List<Recipe> recipes = new ArrayList<>();

    public void addRecipe(Recipe recipe) {
        recipes.add(recipe);
    }

    public List<Recipe> getAllRecipes() {
        return recipes;
    }

    public List<Recipe> getGlutenFreeRecipes() {
        return recipes.stream()
                      .filter(Recipe::getGlutenFree)
                      .collect(Collectors.toList());
    }

    public List<Recipe> getVeganRecipes() {
        return recipes.stream()
                      .filter(Recipe::getVegan)
                      .collect(Collectors.toList());
    }

    public List<Recipe> getVeganAndGlutenFreeRecipes() {
        return recipes.stream()
                      .filter(r -> r.getVegan() && r.getGlutenFree())
                      .collect(Collectors.toList());
    }

    public List<Recipe> getVegetarianRecipes() {
        return recipes.stream()
                      .filter(Recipe::getVegetarian)
                      .collect(Collectors.toList());
    }
}