package my.app.cookbook.controllers;

import my.app.cookbook.model.Ingredient;
import my.app.cookbook.model.Recipe;
import my.app.cookbook.services.impl.IngredientServiceImpl;
import my.app.cookbook.services.impl.RecipeServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;

@RestController
@RequestMapping("/cooking")
public class CookController {
    private RecipeServiceImpl recipeService;
    private IngredientServiceImpl ingredientService;

    public CookController(RecipeServiceImpl recipeService, IngredientServiceImpl ingredientService) {
        this.recipeService = recipeService;
        this.ingredientService = ingredientService;
    }

    @PostMapping("/recipes/add")
    public ResponseEntity recipe(@RequestBody Recipe recipe) {
        recipeService.addRecipe(recipe);
        return ResponseEntity.ok(recipe);
    }

    @GetMapping("/recipes/{id}")
    public Recipe showRecipe(@PathVariable long id) {
        return recipeService.getRecipe(id);
    }

    @PostMapping("/ingredients/add")
    public ResponseEntity ingredient(@RequestBody Ingredient ingredient) {
        ingredientService.addIngredient(ingredient);
        return ResponseEntity.ok(ingredient);
    }

    @GetMapping("/ingredients/{id}")
    public Ingredient showIngredient(@PathVariable long id) {
        return ingredientService.getIngredient(id);
    }


}
