package com.coderscampus.assignment9.service;

import com.coderscampus.assignment9.Recipe;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

@Service
public class FileService {
    private final String fileName;

    @Autowired
    public FileService(@Value("recipes.txt") String fileName) throws Exception {
        this.fileName = fileName;
    }

    public List<Recipe> CSVReader() throws Exception {
        List<Recipe> recipes = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            String[] headers = new String[12];
            int i = 0;
            // Read the header lines
            while ((line = br.readLine()) != null && i < 12) {
                headers[i++] = line.trim();
            }
            // Read the rest of the file
            while ((line = br.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(line, ",");
                Recipe recipe = new Recipe();
                recipe.setTitle(st.nextToken());
                recipe.setCookingMinutes(Integer.parseInt(st.nextToken()));
                recipe.setDairyFree(st.nextToken().trim().equalsIgnoreCase("true"));
                recipe.setGlutenFree(st.nextToken().trim().equalsIgnoreCase("true"));
                recipe.setInstructions(st.nextToken());
                recipe.setPreparationMinutes(Double.parseDouble(st.nextToken()));
                recipe.setPricePerServing(Double.parseDouble(st.nextToken()));
                recipe.setReadyInMinutes(Integer.parseInt(st.nextToken()));
                recipe.setServings(Integer.parseInt(st.nextToken()));
                recipe.setSpoonacularScore(Double.parseDouble(st.nextToken()));
                recipe.setTitle(st.nextToken());
                recipe.setVegetarian(st.nextToken().trim().equalsIgnoreCase("true"));
                recipes.add(recipe);
            }
        } catch (IOException e) {
            throw new Exception("Error reading file", e);
        }
        return recipes;
    }
}