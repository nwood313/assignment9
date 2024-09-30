package com.coderscampus.assignment9.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

@Service
public class FileService {

    @Value("recipes.txt")
    private String filePath;

    public List<String[]> readRecipes() throws IOException {
        List<String[]> recipes = new ArrayList<>();

        try (Reader reader = new FileReader(filePath);
             CSVParser parser = new CSVParser(reader,
                     CSVFormat.DEFAULT
                             .withDelimiter(',')
                             .withQuote('"')
                             .withHeader("")
                             .withTrim()
                             .withIgnoreHeaderCase())) {
            for (CSVRecord csvRecord : parser) {
                String[] recipeData = csvRecord.toMap().values().toArray(new String[0]);
                recipes.add(recipeData);
            }
        }

        return recipes;
    }
}