package com.coderscampus.assignment9.service;

import com.coderscampus.assignment9.Recipe;


import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;


@Service
public class FileService {
    private final String fileName;

    @Autowired
    public FileService(@Value("recipes.txt") String fileName) throws Exception {
        this.fileName = fileName;
    }

    public List<Recipe> csvReader() throws Exception {
        List<Recipe> recipes = new ArrayList<>();
        try (Reader reader = new FileReader(fileName);
             CSVReader csvReader = new CSVReaderBuilder(reader)
                     .withSkipLines(1) // Skip the header row
                     .build()) {
            String[] nextLine;
            while ((nextLine = csvReader.readNext()) != null) {
                Boolean isVegan = true;
                Boolean isGlutenFree = true;


                // Parse cooking minutes
                String cookingMinutes = nextLine[0].trim();
                int cookingMinutesValue;
                if (cookingMinutes.matches("\\d+")) {
                    cookingMinutesValue = Integer.parseInt(cookingMinutes);
                } else {
                    cookingMinutesValue = 0; // Default value if not a valid integer
                }

                // Parse preparation minutes
                String preparationMinutes = nextLine[4].trim();
                double preparationMinutesValue;
                if (preparationMinutes.matches("\\d+(\\.\\d+)?")) {
                    preparationMinutesValue = Double.parseDouble(preparationMinutes);
                } else {
                    preparationMinutesValue = 0.0; // Default value if not a valid double
                }

                // Parse price per serving
                String pricePerServing = nextLine[5].trim();
                double pricePerServingValue;
                if (pricePerServing.matches("\\d+(\\.\\d+)?")) {
                    pricePerServingValue = Double.parseDouble(pricePerServing);
                } else {
                    pricePerServingValue = 0.0; // Default value if not a valid double
                }

                // Parse ready in minutes
                String readyInMinutes = nextLine[6].trim();
                int readyInMinutesValue;
                if (readyInMinutes.matches("\\d+")) {
                    readyInMinutesValue = Integer.parseInt(readyInMinutes);
                } else {
                    readyInMinutesValue = 0; // Default value if not a valid integer
                }

                // Parse servings
                String servings = nextLine[7].trim();
                int servingsValue;
                if (servings.matches("\\d+")) {
                    servingsValue = Integer.parseInt(servings);
                } else {
                    servingsValue = 0; // Default value if not a valid integer
                }

                // Parse spoonacular score
                String spoonacularScore = nextLine[8].trim();
                double spoonacularScoreValue;
                if (spoonacularScore.matches("\\d+(\\.\\d+)?")) {
                    spoonacularScoreValue = Double.parseDouble(spoonacularScore);
                } else {
                    spoonacularScoreValue = 0.0; // Default value if not a valid double
                }

                Recipe recipe = new Recipe(
                        cookingMinutesValue,
                        isVegan,
                        isGlutenFree,
                        nextLine[3],
                        preparationMinutesValue,
                        pricePerServingValue,
                        readyInMinutesValue,
                        servingsValue,
                        spoonacularScoreValue,
                        nextLine[9],
                        isVegan,
                        isGlutenFree
                );

                recipes.add(recipe);
            }
        } catch (IOException e) {
            throw new Exception("Error reading file", e);
        }
        return recipes;
    }
}