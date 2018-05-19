package com.example.recipe.bootstrap;

import com.example.recipe.Domain.*;
import com.example.recipe.repositories.categoryRepository;
import com.example.recipe.repositories.recipeRepository;
import com.example.recipe.repositories.unitOfMeasureRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TestBootStrap implements ApplicationListener<ContextRefreshedEvent> {

    private final categoryRepository categoryRepository;
    private final recipeRepository recipeRepository;
    private final unitOfMeasureRepository unitOfMeasureRepository;

    public TestBootStrap(categoryRepository categoryRepository,recipeRepository recipeRepository, unitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.recipeRepository = recipeRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }
    @Transactional
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        recipeRepository.saveAll(getrecipes());
    }

    private List<Recipe> getrecipes(){
        List<Recipe> recipes = new ArrayList<>(1);

        Optional<unitOfMeasure> EachUnit=unitOfMeasureRepository.findByDescription("Each");
        if(!EachUnit.isPresent()){
            throw new RuntimeException("Expected UOM Not Found");
        }

        Optional<unitOfMeasure> TablespoonUnit=unitOfMeasureRepository.findByDescription("Tablespoon");
        if(!TablespoonUnit.isPresent()){
            throw new RuntimeException("Expected UOM Not Found");
        }

        unitOfMeasure eachUom = EachUnit.get();
        unitOfMeasure tableSpoonUom = TablespoonUnit.get();

        Optional<Category> americanCategoryOptional = categoryRepository.findByDescription("American");

        if(!americanCategoryOptional.isPresent()){
            throw new RuntimeException("Expected Category Not Found");
        }

        Optional<Category> mexicanCategoryOptional = categoryRepository.findByDescription("Mexican");

        if(!mexicanCategoryOptional.isPresent()){
            throw new RuntimeException("Expected Category Not Found");
        }

        Category americanCategory = americanCategoryOptional.get();
        Category mexicanCategory = mexicanCategoryOptional.get();

        Recipe guacRecipe = new Recipe();
        guacRecipe.setDescription("Perfect Guacamole");
        guacRecipe.setPreptime(10);
        guacRecipe.setCooktime(0);
        guacRecipe.setDifficulty(Difficulty.EASY);
        guacRecipe.setDirections("1 Cut avocado, remove flesh: Cut the avocados in half. Remove seed. Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon" +
                "\n" +
                "2 Mash with a fork: Using a fork, roughly mash the avocado. (Don't overdo it! The guacamole should be a little chunky.)" +
                "\n" +
                "3 Add salt, lime juice, and the rest: Sprinkle with salt and lime (or lemon) juice. The acid in the lime juice will provide some balance to the richness of the avocado and will help delay the avocados from turning brown.\n" +
                "Add the chopped onion, cilantro, black pepper, and chiles. Chili peppers vary individually in their hotness. So, start with a half of one chili pepper and add to the guacamole to your desired degree of hotness.\n" +
                "Remember that much of this is done to taste because of the variability in the fresh ingredients. Start with this recipe and adjust to your taste.\n" +
                "4 Cover with plastic and chill to store: Place plastic wrap on the surface of the guacamole cover it and to prevent air reaching it. (The oxygen in the air causes oxidation which will turn the guacamole brown.) Refrigerate until ready to serve.\n" +
                "Chilling tomatoes hurts their flavor, so if you want to add chopped tomato to your guacamole, add it just before serving.\n" +
                "\n" +
                "\n" +
                "Read more: http://www.simplyrecipes.com/recipes/perfect_guacamole/#ixzz4jvpiV9Sd");

        Notes guacNotes = new Notes();
        guacNotes.setRecipeNotes("For a very quick guacamole just take a 1/4 cup of salsa and mix it in with your mashed avocados.\n" +
                "Feel free to experiment! One classic Mexican guacamole has pomegranate seeds and chunks of peaches in it (a Diana Kennedy favorite). Try guacamole with added pineapple, mango, or strawberries.\n" +
                "The simplest version of guacamole is just mashed avocados with salt. Don't let the lack of availability of other ingredients stop you from making guacamole.\n" +
                "To extend a limited supply of avocados, add either sour cream or cottage cheese to your guacamole dip. Purists may be horrified, but so what? It tastes great.\n" +
                "\n" +
                "\n" +
                "Read more: http://www.simplyrecipes.com/recipes/perfect_guacamole/#ixzz4jvoun5ws");

        guacNotes.setRecipe(guacRecipe);
        guacRecipe.setNotes(guacNotes);

        guacRecipe.addIngredient(new Ingredients("ripe avocados", new BigDecimal(2), eachUom));
        guacRecipe.addIngredient(new Ingredients("Kosher salt", new BigDecimal(".5"), tableSpoonUom));
        guacRecipe.addIngredient(new Ingredients("fresh lime juice or lemon juice", new BigDecimal(2), tableSpoonUom));
        guacRecipe.addIngredient(new Ingredients("minced red onion or thinly sliced green onion", new BigDecimal(2), tableSpoonUom));

        guacRecipe.getCategory().add(americanCategory);
        guacRecipe.getCategory().add(mexicanCategory);

        guacRecipe.setUrl("http://www.simplyrecipes.com/recipes/perfect_guacamole/");
        guacRecipe.setServices(4);
        guacRecipe.setSource("Simply Recipes");

        //add to return list
        recipes.add(guacRecipe);


        return recipes;
    }
}
