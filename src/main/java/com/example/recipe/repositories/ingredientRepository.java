package com.example.recipe.repositories;

import com.example.recipe.Domain.Ingredients;
import org.springframework.data.repository.CrudRepository;

public interface ingredientRepository extends CrudRepository<Ingredients,Long> {
}
