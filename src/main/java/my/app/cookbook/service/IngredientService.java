package my.app.cookbook.service;

import my.app.cookbook.model.Ingredient;

import java.util.Map;

public interface IngredientService {
    long addIngredient(Ingredient ingredient);
    Ingredient getIngredient(long key);
    Ingredient editIngredient(Ingredient ingredient, long id);
    boolean removeIngredient(long id);
    Map<Long, Ingredient> getAllIngredients();
}
