package com.example.recipe.services;

import com.example.recipe.Domain.Recipe;
import com.example.recipe.commands.RecipeCommand;
import com.example.recipe.converters.RecipeCommandToRecipe;

import java.util.Set;

public interface recipeServise {

    Set<Recipe> getRecipes();

    Recipe findById(Long l);
    RecipeCommand saveRecipeCommand(RecipeCommand recipeCommand);
}
