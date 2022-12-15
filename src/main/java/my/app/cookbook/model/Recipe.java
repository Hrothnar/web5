package my.app.cookbook.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.LinkedList;

@Data
@AllArgsConstructor
public class Recipe {
    private String name;
    private String cookingTime;
    private LinkedList<String> steps;
    private LinkedList<Ingredient> ingredients;
}
