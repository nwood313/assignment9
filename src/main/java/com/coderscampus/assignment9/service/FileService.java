package com.coderscampus.assignment9.service;

import org.apache.commons.csv.QuoteMode;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

@Service
public class FileService {

    public List<CSVRecord> readFile() {
        try (FileReader fileReader = new FileReader("src/main/resources/recipes.txt");
            CSVParser csvParser= CSVFormat.DEFAULT
                                          .withHeader()
                                          .withIgnoreSurroundingSpaces()
                                          .withEscape('\\')
                                          .withQuoteMode(QuoteMode.MINIMAL)
                                          .parse(fileReader)) {
                return csvParser.getRecords();
        } catch (Exception e) {
            throw new RuntimeException("Error reading CSV file " + e.getMessage());
        }
    }
}


//             Reader reader = new InputStreamReader(inputStream);
//             CSVParser parser = new CSVParser(reader,
//                     CSVFormat.EXCEL
//                             .withHeader()
//                             .withIgnoreSurroundingSpaces())) {
//
//            for (CSVRecord csvRecord : parser) {
//                String[] recipeData = csvRecord.toMap()
//                        .values()
//                        .toArray(new String[0]);
//                Recipe recipe = new Recipe();
//                try {
//                    recipe.setCookingMinutes(Integer.parseInt(recipeData[0]));
//                    recipe.setPreparationMinutes(Double.parseDouble(recipeData[4]));
//                    recipe.setPricePerServing(Double.parseDouble(recipeData[5]));
//                    recipe.setReadyInMinutes(Integer.parseInt(recipeData[6]));
//                    recipe.setServings(Integer.parseInt(recipeData[7]));
//                    recipe.setSpoonacularScore(Double.parseDouble(recipeData[8]));
//
//                } catch (NumberFormatException e) {
//                    recipe.setCookingMinutes(0);
//                    recipe.setPreparationMinutes(0.0);
//                    recipe.setPricePerServing(0.0);
//                    recipe.setReadyInMinutes(0);
//                    recipe.setServings(0);
//                    recipe.setSpoonacularScore(0.0);
//
//                }
//                recipe.setDairyFree(Boolean.parseBoolean(recipeData[1]));
//                recipe.setGlutenFree(Boolean.parseBoolean(recipeData[2]));
//                recipe.setInstructions(recipeData[3]);
//                recipe.setTitle(recipeData[9]);
//                recipe.setVegan(Boolean.parseBoolean(recipeData[10]));
//                recipe.setVegetarian(Boolean.parseBoolean(recipeData[11]));
//                recipes.add(recipe);
//            }
//        }
//
//        return recipes;
//    }
//}