package com.example.recipe.services;

import com.example.recipe.Domain.Recipe;

import java.util.Set;

public interface recipeServise {

    Set<Recipe> getRecipes();

    Recipe findById(Long l);
}
