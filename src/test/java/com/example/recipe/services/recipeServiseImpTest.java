package com.example.recipe.services;

import com.example.recipe.Domain.Recipe;
import org.junit.Before;
import org.junit.Test;
import com.example.recipe.repositories.recipeRepository;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
public class recipeServiseImpTest {

    recipeServiseImp recipeServis;
    @Mock
    recipeRepository recipeRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        recipeServis=new recipeServiseImp(recipeRepository);

    }

    @Test
    public void getRecipes() {

        Recipe recipe=new Recipe();
        HashSet recipesData=new HashSet();
        recipesData.add(recipe);

        when(recipeServis.getRecipes()).thenReturn(recipesData);

        Set<Recipe> recipes=recipeServis.getRecipes();
        assertEquals(recipes.size(),3);
        verify(recipeRepository,times(1)).findAll();
    }
}