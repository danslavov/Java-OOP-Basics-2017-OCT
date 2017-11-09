package P03_WildFarm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        List<Animal> animals = getAndFeedAnimals();
        animals.forEach(System.out::println);
    }

    private static List<Animal> getAndFeedAnimals() throws IOException {
        List<Animal> animals = new LinkedList<>();
        while (true) {
            String[] animalData = reader.readLine().split("\\s+");
            if ("End".equalsIgnoreCase(animalData[0])) {
                break;
            }
            createAnimal(animals, animalData);
            feedAnimal(animals);
        }
        return animals;
    }

    private static void feedAnimal(List<Animal> animals) throws IOException {

        //read food data
        String[] foodData = reader.readLine().split("\\s+");
        char foodType = foodData[0].toLowerCase().charAt(0);
        int foodQuantity = Integer.parseInt(foodData[1]);

        // make sound
        Animal lastAnimal = animals.get(animals.size() - 1);
        lastAnimal.makeSound();

        // feed the food to the animal
        try {
            if (foodType == 'm') {
                lastAnimal.eat(new Meat(foodQuantity));
            } else {
                lastAnimal.eat(new Vegetable(foodQuantity));
            }
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }
    }

    private static void createAnimal(List<Animal> animals, String[] animalData) {
        String animalType = animalData[0];
        String animalName = animalData[1];
        double animalWeight = Double.parseDouble(animalData[2]);
        String animalLivingRegion = animalData[3];

        switch (animalType) {
            case "Cat":
                String breed = animalData[4];
                animals.add(new Cat(
                        animalType, animalName, animalWeight, animalLivingRegion, breed));
                break;
            case "Mouse":
                animals.add(new Mouse(
                        animalType, animalName, animalWeight, animalLivingRegion));
                break;
            case "Tiger":
                animals.add(new Tiger(
                        animalType, animalName, animalWeight, animalLivingRegion));
                break;
            case "Zebra":
                animals.add(new Zebra(
                        animalType, animalName, animalWeight, animalLivingRegion));
                break;
        }
    }
}


