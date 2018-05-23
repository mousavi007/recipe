package com.example.recipe.services;

import com.example.recipe.commands.IngredientCommand;

public interface ingredientService {

    IngredientCommand findByRecipeIdAndIngredientId(Long recipeId, Long Id);

    IngredientCommand saveIngredientCommand(IngredientCommand command);
    public void deleteById(Long recipeId, Long idToDelete);
}
