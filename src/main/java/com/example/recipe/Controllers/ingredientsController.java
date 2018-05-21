package com.example.recipe.Controllers;

import com.example.recipe.services.recipeServise;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Slf4j
@Controller
public class ingredientsController {

    recipeServise recipeServise;
    public ingredientsController(recipeServise recipeServise) {
        this.recipeServise=recipeServise;
    }

    @GetMapping
    @RequestMapping("/recipe/{recipeId}/ingredients")
    public String listIngredients(@PathVariable String recipeId,Model model){
        log.debug("getting Ingredients list for recipe ID: "+ recipeId);
        model.addAttribute("recipe", recipeServise.findCommandById(Long.valueOf(recipeId)));
        return "recipe/ingredients/list";
    }
}
