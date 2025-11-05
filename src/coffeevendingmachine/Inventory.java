package coffeevendingmachine;

import java.util.HashMap;
import java.util.Map;

public class Inventory {

    private final Map<String,Integer> ingredientInventory = new HashMap<>();

    public void update(String name, Integer quantity) {
        ingredientInventory.put(name,ingredientInventory.getOrDefault(name,0)+quantity);
    }

    public boolean isSufficientIngredients(Coffee coffee) {
        Map<String, Integer> required = coffee.getRecipe();
        for (Map.Entry<String, Integer> entry : required.entrySet()) {
            String ingredient = entry.getKey();
            int available = ingredientInventory.getOrDefault(ingredient, 0);
            if (available < entry.getValue()) {
                return false;
            }
        }
        return true;
    }

    public void consume(Map<String, Integer> recipe) {
        return;
    }
}
