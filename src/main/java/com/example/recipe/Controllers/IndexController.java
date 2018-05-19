package com.example.recipe.Controllers;


import com.example.recipe.Domain.Category;
import com.example.recipe.Domain.unitOfMeasure;
import com.example.recipe.repositories.unitOfMeasureRepository;
import com.example.recipe.repositories.categoryRepository;
import com.zaxxer.hikari.util.SuspendResumeLock;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.recipe.services.recipeServise;

import java.util.Optional;

@Controller
public class IndexController {
    private final recipeServise recipeServise;

    public IndexController(recipeServise recipeServise) {
        this.recipeServise = recipeServise;
    }

    @RequestMapping({"","/","/index"})
    public String getIndexPage(Model model){
        model.addAttribute("recipes",recipeServise.getRecipes());

        System.out.println();
        return "index";
    }
}
