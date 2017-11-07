package Exercises.P05_PizzaCalories;

public class Topping {
    private static String currentType;
    private String type;
    private double weight;

    public Topping(String type, double weight) {
        currentType = type;
        this.setType(type);
        this.setWeight(weight);
    }

    private void setType(String type) {
        if (!"Meat".equals(type) && !"Veggies".equals(type) &&
                !"Cheese".equals(type) && !"Sauce".equals(type)) {
            throw new IllegalArgumentException("Cannot place " + type + " on top of your pizza.");
        }
        this.type = type;
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 50) {
            throw new IllegalArgumentException(currentType + " weight should be in the range [1..50].");
        }
        this.weight = weight;
    }

    public double calculateCalories() {
        double modifier = 0.0;
        switch (this.type) {
            case "Meat":
                modifier = 1.2;
                break;
            case "Veggies":
                modifier = 0.8;
                break;
            case "Cheese":
                modifier = 1.1;
                break;
            case "Sauce":
                modifier = 0.9;
                break;
        }
        return 2.0 * this.weight * modifier;
    }
}
