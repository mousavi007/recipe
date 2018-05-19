package com.example.recipe.Domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CategoryTest {

    Category category;

    @Before
    public void setUp(){

        category=new Category();
    }

    @Test
    public void getId() {

        Long idvqlue=4l;
        category.setId(idvqlue);
        assertEquals(idvqlue,category.getId());
    }

    @Test
    public void getDescription() {
    }

    @Test
    public void getRecipes() {
    }
}