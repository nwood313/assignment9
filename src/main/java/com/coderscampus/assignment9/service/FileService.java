package com.coderscampus.assignment9.service;
import com.coderscampus.assignment9.domain.Recipe;


import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;


@Service
public class FileService {

    public List<String[]> readRecipes(String filePath) throws IOException {
        List<String[]> recipes = new ArrayList<>();
        try (FileReader fileReader = new FileReader(filePath);
             Reader reader = fileReader;
             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
                     .withHeader()
                     .withIgnoreSurroundingSpaces())) {
            for (CSVRecord csvRecord : csvParser) {
                String[] recipeData = csvRecord.toMap().values().toArray(new String[0]);
                recipes.add(recipeData);
            }
        }
        return recipes;
    }
}