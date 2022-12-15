package my.app.cookbook.services;

import my.app.cookbook.model.Ingredient;

public interface IngredientService {
    void addIngredient(Ingredient ingredient);

    Ingredient getIngredient(long key);
}
