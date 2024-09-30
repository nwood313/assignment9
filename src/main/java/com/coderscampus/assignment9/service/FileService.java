package com.coderscampus.assignment9.service;
import com.coderscampus.assignment9.service.RecipeService;

import com.coderscampus.assignment9.domain.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

@Service
public class FileService {

    @Value("classpath:recipes.txt")
    private Resource file;

    public List<Recipe> readRecipes() throws IOException {
        List<Recipe> recipes = new ArrayList<>();

        try (InputStream inputStream = file.getInputStream();
             Reader reader = new InputStreamReader(inputStream);
             CSVParser parser = new CSVParser(reader,
                     CSVFormat.EXCEL.withHeader().withIgnoreSurroundingSpaces()
                             )) {
            for (CSVRecord csvRecord : parser) {
                String[] recipeData = csvRecord.toMap().values().toArray(new String[0]);
                Recipe recipe = new Recipe();
                try {
                    recipe.setCookingMinutes(Integer.parseInt(recipeData[0]));
                } catch (NumberFormatException e) {
                    recipe.setCookingMinutes(0);
                }
                recipe.setDairyFree(Boolean.parseBoolean(recipeData[1]));
                recipe.setGlutenFree(Boolean.parseBoolean(recipeData[2]));
                recipe.setInstructions(recipeData[3]);
                try {
                    recipe.setPreparationMinutes(Double.parseDouble(recipeData[4]));
                } catch (NumberFormatException e) {
                    recipe.setPreparationMinutes(0.0);
                }
                try {
                    recipe.setPricePerServing(Double.parseDouble(recipeData[5]));
                } catch (NumberFormatException e) {
                    recipe.setPricePerServing(0.0);
                }
                try {
                    recipe.setReadyInMinutes(Integer.parseInt(recipeData[6]));
                } catch (NumberFormatException e) {
                    recipe.setReadyInMinutes(0);
                }
                try {
                    recipe.setServings(Integer.parseInt(recipeData[7]));
                } catch (NumberFormatException e) {
                    recipe.setServings(0);
                }
                try {
                    recipe.setSpoonacularScore(Double.parseDouble(recipeData[8]));
                } catch (NumberFormatException e) {
                    recipe.setSpoonacularScore(0.0);
                }
                recipe.setTitle(recipeData[9]);
                recipe.setVegan(Boolean.parseBoolean(recipeData[10]));
                recipe.setVegetarian(Boolean.parseBoolean(recipeData[11]));
                recipes.add(recipe);
            }
        }

        return recipes;
    }
}