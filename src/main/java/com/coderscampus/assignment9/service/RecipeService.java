package com.coderscampus.assignment9.service;
import com.coderscampus.assignment9.domain.Recipe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class RecipeService {

    @Autowired
    private FileService fileService;

    private List<Recipe> recipes = new ArrayList<>();

    public void readRecipes() throws IOException {
        List<String[]> recipesData = fileService.readRecipes("recipes.txt");
        for (String[] recipeData : recipesData) {
            Recipe recipe = createRecipe(recipeData);
            addRecipe(recipe);
        }
    }

    private Recipe createRecipe(String[] recipeData) {
        Recipe recipe = new Recipe();
        recipe.setCookingMinutes(Integer.parseInt(recipeData[0]));
        recipe.setDairyFree(Boolean.parseBoolean(recipeData[1]));
        recipe.setGlutenFree(Boolean.parseBoolean(recipeData[2]));
        recipe.setInstructions(recipeData[3]);
        recipe.setPreparationMinutes(Double.parseDouble(recipeData[4]));
        recipe.setPricePerServing(Double.parseDouble(recipeData[5]));
        recipe.setReadyInMinutes(Integer.parseInt(recipeData[6]));
        recipe.setServings(Integer.parseInt(recipeData[7]));
        recipe.setSpoonacularScore(Double.parseDouble(recipeData[8]));
        recipe.setTitle(recipeData[9]);
        recipe.setVegan(Boolean.parseBoolean(recipeData[10]));
        recipe.setVegetarian(Boolean.parseBoolean(recipeData[11]));
        return recipe;
    }

    public void addRecipe(Recipe recipe) {
        if (!recipes.contains(recipe)) {
            recipes.add(recipe);
        }
    }

    public List<Recipe> getAllRecipes() {
        return new ArrayList<>(recipes);
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