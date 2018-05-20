package com.example.recipe.Controllers;

import com.example.recipe.services.recipeServise;
import org.junit.Before;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.*;

public class ingredientsControllerTest {

    @Mock
    recipeServise redipeServise;
    ingredientsController controller;
    MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        controller=new ingredientsController(redipeServise);
    }


}