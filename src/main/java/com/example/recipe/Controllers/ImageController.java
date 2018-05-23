package com.example.recipe.Controllers;
import com.example.recipe.commands.RecipeCommand;
import com.example.recipe.services.ImageService;
import com.example.recipe.services.recipeServise;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

@Controller
public class ImageController {
    private final recipeServise recipeServise;
    private final ImageService imageService;

    public ImageController(com.example.recipe.services.recipeServise recipeServise, ImageService imageService) {
        this.recipeServise = recipeServise;
        this.imageService = imageService;
    }

    @GetMapping("recipe/{id}/image")
    public String ahowUploadForm(@PathVariable String id, Model model){

        model.addAttribute("recipe", recipeServise.findCommandById(Long.valueOf(id)));
        return "recipe/imageuploadform";
    }

    @PostMapping("recipe/{id}/image")
    public String handleImagePost(@PathVariable String id, @RequestParam("imagefile")MultipartFile file){

        imageService.saveImageFile(Long.valueOf(id),file);
        return "redirect:/recipe/"+ id + "/show";
    }

    @GetMapping("recipe/{id}/recipeimage")
    public void renderImageFromDb(@PathVariable String id, HttpServletResponse response)throws IOException {

        RecipeCommand command = recipeServise.findCommandById(Long.valueOf(id));
        if (command.getImage() != null) {
            byte[] byteArray = new byte[command.getImage().length];
            int i = 0;
            for (Byte wrappedByte : command.getImage()) {
                byteArray[i++] = wrappedByte;
            }
            response.setContentType("image/jpeg");
            InputStream is = new ByteArrayInputStream(byteArray);
            IOUtils.copy(is, response.getOutputStream());

        }
    }
}
