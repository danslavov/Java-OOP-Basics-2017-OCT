package Exercises.P05_PizzaCalories;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split("\\s+");
        String pizzaName = input[1];
        int toppingCount = Integer.parseInt(input[2]);

        try {
            Pizza pizza = new Pizza(pizzaName, toppingCount);

            input = reader.readLine().split("\\s+");

            while (!"END".equals(input[0])) {
                if ("Dough".equals(input[0])) {
                    String name = input[1];
                    String bakingTechnique = input[2];
                    double weight = Double.parseDouble(input[3]);
                    Dough dough = new Dough(name, bakingTechnique, weight);
                    pizza.setDough(dough);
                } else {
                    String type = input[1];
                    double weight = Double.parseDouble(input[2]);
                    Topping topping = new Topping(type, weight);
                    pizza.addTopping(topping);
                }
                input = reader.readLine().split("\\s+");
            }

            System.out.println(pizza);

        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }
    }
}
