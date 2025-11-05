package coffeevendingmachine;

import java.util.Map;

public class Coffee {

    private String name;
    private double price;
    Map<String,Integer> recipeIngredients;

    public Coffee (String name, double price, Map<String,Integer> recipeIngredients){
        this.name=name;
        this.price=price;
        this.recipeIngredients=recipeIngredients;
    }

    public double getPrice() {
        return this.price;
    }

    public Map<String, Integer> getRecipe() {
        return this.recipeIngredients;
    }

    public String getName() {
        return this.name;
    }
}
