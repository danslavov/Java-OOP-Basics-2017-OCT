package Exercises.P09_Google;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Map<String, Person> people = new LinkedHashMap<>();
        String[] input = scanner.nextLine().split("\\s+");
        while (!"End".equals(input[0])) {
            getData(input, people);
            input = scanner.nextLine().split("\\s+");
        }
        String name = scanner.nextLine();
        System.out.println(people.get(name));
    }

    private static void getData(String[] input, Map<String, Person> people) {
        String name = input[0];
        people.putIfAbsent(name, new Person(name));
        String entity = input[1];
        switch (entity) {
            case "company":
                people.get(name).setCompany(createCompany(input));
                break;
            case "car":
                people.get(name).setCar(createCar(input));
                break;
            case "parents":
                people.get(name).addParent(createCreature(input));
                break;
            case "children":
                people.get(name).addChild(createCreature(input));
                break;
            case "pokemon":
                people.get(name).addPokemon(createCreature(input));
                break;
        }
    }

    private static Company createCompany(String[] input) {
        String name = input[2];
        String department = input[3];
        Double salary = Double.parseDouble(input[4]);
        return new Company(name, department, salary);
    }

    private static Car createCar(String[] input) {
        String model = input[2];
        int speed = Integer.parseInt(input[3]);
        return new Car(model, speed);
    }

    private static Creature createCreature(String[] input) {
        String name = input[2];
        String property = input[3];
        return new Creature(name, property);
    }
}
