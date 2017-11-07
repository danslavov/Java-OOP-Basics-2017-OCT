package Exercises.P05_PizzaCalories;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String name;
    private Dough dough;
    private List<Topping> toppings;

    Pizza(String name, int toppingCount) {
        if (toppingCount < 0 || toppingCount > 10) {
            throw new InvalidParameterException("Number of toppings should be in range [0..10].");
        }
        setName(name);
        this.toppings = new ArrayList<>();
    }

    private void setName(String name) {
        if (name.isEmpty() || name.length() > 15) {
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }
        this.name = name;
    }

    private double calculateToppingCalories() {
        double calories = 0.0;
        for (Topping topping : this.toppings) {
            calories += topping.calculateCalories();
        }
        return calories;
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    public void addTopping(Topping topping) {
        this.toppings.add(topping);
    }

    public double calculateCalories() {
        return this.dough.calculateCalories() + this.calculateToppingCalories();
    }

    @Override
    public String toString() {
        return String.format("%s - %.2f", this.name, this.calculateCalories());
    }
}
