package com.coderscampus.assignment9.service;

import com.coderscampus.assignment9.domain.Recipe;

import jakarta.annotation.PostConstruct;
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

    @PostConstruct
    public void init() {
        try {
            readRecipes();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void readRecipes() throws IOException {
        List<Recipe> recipesData = fileService.readRecipes();
        recipes.clear();
        recipes.addAll(recipesData);
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