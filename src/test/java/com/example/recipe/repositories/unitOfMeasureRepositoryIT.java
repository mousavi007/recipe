package com.example.recipe.repositories;

import com.example.recipe.Domain.unitOfMeasure;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class unitOfMeasureRepositoryIT {

    @Autowired
    unitOfMeasureRepository unitOfMeasureRepository;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void findByDescription() {

        Optional<unitOfMeasure> unitOfMeasure=unitOfMeasureRepository.findByDescription("Teaspoon");
        assertEquals("Teaspoon",unitOfMeasure.get().getDescription());

    }

    @Test
    public void findByDescriptionCup() {

        Optional<unitOfMeasure> unitOfMeasure=unitOfMeasureRepository.findByDescription("Cup");
        assertEquals("Cup",unitOfMeasure.get().getDescription());

    }


}