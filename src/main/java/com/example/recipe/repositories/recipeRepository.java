package com.example.recipe.repositories;

import com.example.recipe.Domain.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface recipeRepository extends CrudRepository<Recipe,Long> {

}
