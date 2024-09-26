package com.coderscampus.assignment9;

public class Recipe {

    private Integer cookingMinutes;

    private Boolean dairyFree;

    private Boolean glutenFree;

    private String instructions;

    private Double preparationMinutes;

    private Double pricePerServing;

    private Integer readyInMinutes;

    private Integer servings;

    private Double spoonacularScore;

    private String title;

    private Boolean vegan;

    private Boolean vegetarian;

    public Recipe(Integer cookingMinutes, Boolean dairyFree, Boolean glutenFree,
                  String instructions, Double preparationMinutes, Double pricePerServing,
                  Integer readyInMinutes, Integer servings, Double spoonacularScore, String title,
                  Boolean vegan, Boolean vegetarian) {
        this.cookingMinutes = cookingMinutes;
        this.dairyFree = dairyFree;
        this.glutenFree = glutenFree;
        this.instructions = instructions;
        this.preparationMinutes = preparationMinutes;
        this.pricePerServing = pricePerServing;
        this.readyInMinutes = readyInMinutes;
        this.servings = servings;
        this.spoonacularScore = spoonacularScore;
        this.title = title;
        this.vegan = vegan;
        this.vegetarian = vegetarian;
    }

    public Integer getCookingMinutes() {
        return cookingMinutes;
    }

    public Boolean getDairyFree() {
        return dairyFree;
    }

    public Boolean getGlutenFree() {
        return glutenFree;
    }

    public String getInstructions() {
        return instructions;
    }

    public Double getPreparationMinutes() {
        return preparationMinutes;
    }

    public Double getPricePerServing() {
        return pricePerServing;
    }

    public Integer getReadyInMinutes() {
        return readyInMinutes;
    }

    public Integer getServings() {
        return servings;
    }

    public Double getSpoonacularScore() {
        return spoonacularScore;
    }

    public String getTitle() {
        return title;
    }

    public Boolean getVegan() {
        return vegan;
    }

    public Boolean getVegetarian() {
        return vegetarian;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "cookingMinutes=" + cookingMinutes +
                ", dairyFree=" + dairyFree +
                ", glutenFree=" + glutenFree +
                ", instructions='" + instructions + '\'' +
                ", preparationMinutes=" + preparationMinutes +
                ", pricePerServing=" + pricePerServing +
                ", readyInMinutes=" + readyInMinutes +
                ", servings=" + servings +
                ", spoonacularScore=" + spoonacularScore +
                ", title='" + title + '\'' +
                ", vegan=" + vegan +
                ", vegetarian=" + vegetarian +
                '}';
    }
}
