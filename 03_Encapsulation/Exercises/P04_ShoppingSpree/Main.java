package Exercises.P04_ShoppingSpree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        Map<String, PersonOrProduct> people = fillList();
        Map<String, PersonOrProduct> products = fillList();
        peopleBuyProducts(people, products);
        printResult(people);
    }

    private static Map<String, PersonOrProduct> fillList() throws IOException {
        Map<String, PersonOrProduct> elements = new LinkedHashMap();
        String input = reader.readLine();
        String[] elementTokens = input.split(";");
        for (String token : elementTokens) {
            String[] nameAndMoney = token.split("=");
            String name = nameAndMoney[0];
            int money = Integer.parseInt(nameAndMoney[1]);
            try {
                elements.put(name, new PersonOrProduct(name, money));
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
                System.exit(0);
            }
        }
        return elements;
    }

    private static void peopleBuyProducts(Map<String, PersonOrProduct> people, Map<String, PersonOrProduct> products) throws IOException {
        String[] input = reader.readLine().split("\\s+");
        while (!"END".equals(input[0])) {
            String personName = input[0];
            String productName = input[1];
            try {
                people.get(personName).buyProduct(products.get(productName));
                System.out.println(personName + " bought " + productName);
            } catch (IllegalStateException ise) {
                System.out.println(ise.getMessage());
            }
            input = reader.readLine().split("\\s+");
        }
    }

    private static void printResult(Map<String, PersonOrProduct> people) {
        for (PersonOrProduct person : people.values()) {
            System.out.print(person.getName() + " - ");
            if (!person.getProducts().isEmpty()) {
                for (int i = 0; i < person.getProducts().size(); i++) {
                    String productName = person.getProducts().get(i).getName();
                    System.out.print(productName);
                    if (i < person.getProducts().size() - 1) {
                        System.out.print(", ");
                    }
                }
            } else {
                System.out.print("Nothing bought");
            }
            System.out.println();
        }
    }
}
