package com.coderscampus.assignment9.repository;

import com.coderscampus.assignment9.domain.Recipe;
import com.coderscampus.assignment9.service.FileService;
import jakarta.annotation.PostConstruct;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class RecipeRepository {
    private final FileService fileService;

    public RecipeRepository(FileService fileService) {
        this.fileService = fileService;
    }

    private final List<Recipe> recipes = new ArrayList<>();

@PostConstruct
public void readRecipes() throws IOException {
    List<CSVRecord> records = fileService.readFile();
    for (CSVRecord record : records) {
        Recipe recipe = new Recipe();
        recipe.setCookingMinutes(Integer.parseInt(record.get("Cooking Minutes")));
        recipe.setDairyFree(Boolean.parseBoolean(record.get("Dairy Free")));
        recipe.setGlutenFree(Boolean.parseBoolean(record.get("Gluten Free")));
        recipe.setInstructions(record.get("Instructions"));
        recipe.setPreparationMinutes(Double.parseDouble(record.get("Preparation Minutes")));
        recipe.setPricePerServing(Double.parseDouble(record.get("Price Per Serving")));
        recipe.setReadyInMinutes(Integer.parseInt(record.get("Ready In Minutes")));
        recipe.setServings(Integer.parseInt(record.get("Servings")));
        recipe.setSpoonacularScore(Double.parseDouble(record.get("Spoonacular Score")));
        recipe.setTitle(record.get("Title"));
        recipe.setVegan(Boolean.parseBoolean(record.get("Vegan")));
        recipe.setVegetarian(Boolean.parseBoolean(record.get("Vegetarian")));
        recipes.add(recipe);
        }
    }
    public List <Recipe> getAll() {
        return recipes;
    }
}
