package advertisementengine;

public class Advertiser {
    private final String id;
    private final String name;
    private double budget;

    public Advertiser(String id, String name, double budget) {
        this.id = id;
        this.name = name;
        this.budget = budget;
    }

    public double getBudget() { return budget; }

    public void addBudget(double amount) {
        this.budget += amount;
    }

    public void deductBudget(double amount) {
        if (amount > budget) throw new IllegalArgumentException("Insufficient budget");
        this.budget -= amount;
    }
}
