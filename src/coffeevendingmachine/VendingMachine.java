package coffeevendingmachine;

import java.util.HashMap;
import java.util.Map;

public class VendingMachine {

    private final static VendingMachine vending = new VendingMachine();

    private final Map<String, Coffee> recipes = new HashMap<>();
    private final Inventory inventory;

    private final Dispenser dispenser;
    private final PaymentProcessor paymentProcessor;

    public static VendingMachine getInstance(){
        return vending;
    }

    private VendingMachine (){
        inventory = new Inventory();
        dispenser=new Dispenser();
        paymentProcessor=new PaymentProcessor();
        addDefaultCoffee();
    }

    private void addDefaultCoffee(){
        recipes.put("Espresso", new Coffee("Espresso", 2.5, Map.of("Water", 50, "Coffee", 20)));
        recipes.put("Latte", new Coffee("Latte", 3.0, Map.of("Water", 50, "Coffee", 20, "Milk", 30)));
        recipes.put("Cappuccino", new Coffee("Cappuccino", 3.5, Map.of("Water", 50, "Coffee", 20, "Milk", 40)));
    }


    public void refillInventory(String name, Integer quantity){
        inventory.update(name,quantity);
        //can also perform update delete here
    }

    public void addCoffee(String name, double price, Map<String,Integer> recipe){
        recipes.put(name, new Coffee(name,price,recipe));
        //can also perform update, delete here
    }

    public void displayMenu(){
        for (String coffeeName : recipes.keySet()){
            System.out.println(coffeeName + " -> " + recipes.get(coffeeName).getPrice());
        }
    }

    public Coffee selectCoffee(String name){
        if (!recipes.containsKey(name)) System.out.println("Invalid coffee name selected");
        return recipes.get(name);
    }


    public void dispenseCoffee(Coffee coffee, double payment){
        //enough payment validation
        if (payment<coffee.getPrice()) System.out.println("Insufficient payment");
        //ingredient exist
        if (!inventory.isSufficientIngredients(coffee)) System.out.println("Insufficient ingredient");
        //proceed to subtract ingredient
        inventory.consume(coffee.getRecipe());
        dispenser.prepareDrink(coffee);

        double change = paymentProcessor.process(coffee.getPrice(), payment);
        if (change > 0) {
            System.out.println("Please collect your change: $" + change);
        }
    }
}
