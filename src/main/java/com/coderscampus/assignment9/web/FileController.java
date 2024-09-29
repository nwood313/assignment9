package com.coderscampus.assignment9.web;

import com.coderscampus.assignment9.Recipe;
import com.coderscampus.assignment9.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class FileController {
    @Autowired
    private FileService fileService;

    @GetMapping("/all-recipes")
    public List<Recipe> allRecipes() throws Exception {
        return fileService.csvReader();
    }

    @GetMapping("/gluten-free")
    public List<Recipe> glutenFreeRecipes() throws Exception {
        List<Recipe> recipes = fileService.csvReader();
        return recipes.stream()
                .filter(recipe -> recipe.getGlutenFree())
                .collect(Collectors.toList());
    }

    @GetMapping("/vegan")
    public List<Recipe> veganRecipes() throws Exception {
        List<Recipe> recipes = fileService.csvReader();
        return recipes.stream()
                .filter(recipe -> recipe.getVegan())
                .collect(Collectors.toList());
    }

    @GetMapping("/vegan-and-gluten-free")
    public List<Recipe> veganAndGlutenFreeRecipes() throws Exception {
        List<Recipe> recipes = fileService.csvReader();
        return recipes.stream()
                .filter(recipe -> recipe.getVegan() && recipe.getGlutenFree())
                .collect(Collectors.toList());
    }

    @GetMapping("/vegetarian")
    public List<Recipe> vegetarianRecipes() throws Exception {
        List<Recipe> recipes = fileService.csvReader();
        return recipes.stream()
                .filter(recipe -> recipe.getVegetarian())
                .collect(Collectors.toList());
    }
}