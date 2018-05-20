package com.example.recipe.services;

import com.example.recipe.Domain.Recipe;
import com.example.recipe.repositories.recipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
public class recipeServiseImp implements recipeServise {

    private final recipeRepository recipeRepository;

    public recipeServiseImp(recipeRepository recipeRepository) {
        this.recipeRepository= recipeRepository;
    }

    @Override
    public Set<Recipe> getRecipes() {

        log.debug("i am in service");
        Set<Recipe> recipes=new HashSet<>();
        recipeRepository.findAll().iterator().forEachRemaining(recipes::add);

        return recipes;
    }

    @Override
    public Recipe findById(Long l) {

        Optional<Recipe> recipeOptional = recipeRepository.findById(l);

        if (!recipeOptional.isPresent()) {
            throw new RuntimeException("Recipe Not Found!");
        }

        return recipeOptional.get();
    }
}
