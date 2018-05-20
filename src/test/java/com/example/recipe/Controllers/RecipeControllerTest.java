package com.example.recipe.Controllers;

import com.example.recipe.Domain.Recipe;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import com.example.recipe.services.recipeServise;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class RecipeControllerTest {

    @Mock
    recipeServise recipeServise;

    RecipeController recipeController;
    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);
        recipeController=new RecipeController(recipeServise);
    }

    @Test
    public void showById() throws Exception {

        Recipe recipe= new Recipe();
        recipe.setId(11l);
        MockMvc mockMvc= MockMvcBuilders.standaloneSetup(recipeController).build();
        when(recipeServise.findById(anyLong())).thenReturn(recipe);
        mockMvc.perform(get("/recipe/show/1")).andExpect(status().isOk())
                .andExpect(view().name("recipe/show"));
    }
}