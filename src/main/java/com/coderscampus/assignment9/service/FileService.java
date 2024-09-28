package com.coderscampus.assignment9.service;
import com.coderscampus.assignment9.domain.Recipe;


import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;


import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

@Component
public class FileService {

    public static List<Recipe> readRecipes(String filePath) {
        List<Recipe> recipes = new ArrayList<>();

        try (Reader reader = new FileReader(filePath);
             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
                     .withHeader()
                     .withIgnoreSurroundingSpaces())) {

            for (CSVRecord csvRecord : csvParser) {
                Recipe recipe = new Recipe();
                recipe.setCookingMinutes(Integer.parseInt(csvRecord.get("Cooking Minutes")));
                recipe.setDairyFree(Boolean.parseBoolean(csvRecord.get("Dairy Free")));
                recipe.setGlutenFree(Boolean.parseBoolean(csvRecord.get("Gluten Free")));
                recipe.setInstructions(csvRecord.get("Instructions"));
                recipe.setPreparationMinutes(Double.parseDouble(csvRecord.get("Preparation Minutes")));
                recipe.setPricePerServing(Double.parseDouble(csvRecord.get("Price Per Serving")));
                recipe.setReadyInMinutes(Integer.parseInt(csvRecord.get("Ready In Minutes")));
                recipe.setServings(Integer.parseInt(csvRecord.get("Servings")));
                recipe.setSpoonacularScore(Double.parseDouble(csvRecord.get("Spoonacular Score")));
                recipe.setTitle(csvRecord.get("Title"));
                recipe.setVegan(Boolean.parseBoolean(csvRecord.get("Vegan")));
                recipe.setVegetarian(Boolean.parseBoolean(csvRecord.get("Vegetarian")));

                recipes.add(recipe);
                System.out.println(recipe); // Print each recipe

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return recipes;

    }
}