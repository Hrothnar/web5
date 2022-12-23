package my.app.cookbook.controllers;

import my.app.cookbook.model.Recipe;
import my.app.cookbook.services.impl.RecipeServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/recipe")
public class RecipeController {
    private final RecipeServiceImpl recipeService;

    public RecipeController(RecipeServiceImpl recipeService) {
        this.recipeService = recipeService;
    }

    @PostMapping
    public ResponseEntity<Long> addRecipe(@RequestBody Recipe recipe) {
        long id = recipeService.addRecipe(recipe);
        return ResponseEntity.ok(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recipe> getRecipe(@PathVariable(required = true) long id) {
        Recipe recipe = recipeService.getRecipe(id);
        if (recipe != null) {
            return ResponseEntity.ok(recipe);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Recipe> editRecipe(@PathVariable long id, @RequestBody Recipe recipe) {
        Recipe editRecipe = recipeService.editRecipe(recipe, id);
        if (editRecipe != null) {
            return ResponseEntity.ok(recipe);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeRecipe(@PathVariable long id) {
        if (recipeService.removeRecipe(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
    @GetMapping
    public ResponseEntity<Map<Long, Recipe>> getAllRecipes() {
        return ResponseEntity.ok(recipeService.getAllRecipes());
    }
    @GetMapping("/byIngredientId")
    public ResponseEntity<Map<Long, Recipe>> getRecipesByIngredientId(@RequestParam(required = true) Long id1, @RequestParam(required = false) Long id2) {
        Map<Long, Recipe> recipesList = recipeService.getRecipesByIngredientId(id1, id2);
        if (recipesList != null) {
            return ResponseEntity.ok(recipesList);
        }
        return ResponseEntity.notFound().build();
    }


}
