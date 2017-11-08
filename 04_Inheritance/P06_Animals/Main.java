package P06_Animals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Animal> animals = getAnimals(reader);
        for (Animal animal : animals) {
            System.out.println(animal);
        }
    }

    private static List<Animal> getAnimals(BufferedReader reader) throws IOException {
        List<Animal> animals = new LinkedList<>();
        while (true) {
            String kind = reader.readLine();
            if ("Beast!".equals(kind)) {
                break;
            }
            String[] animalData = reader.readLine().split("\\s+");

            String name = animalData[0];
            String age = animalData[1];
            String gender = animalData[2];

            try {
                switch (kind) {
                    case "Animal":
                        animals.add(new Animal(kind, name, age, gender));
                        break;
                    case "Dog":
                        animals.add(new Dog(kind, name, age, gender));
                        break;
                    case "Frog":
                        animals.add(new Frog(kind, name, age, gender));
                        break;
                    case "Cat":
                        animals.add(new Cat(kind, name, age, gender));
                        break;
                    case "Kitten":
                        if (!"Female".equals(gender)) {
                            throw new IllegalArgumentException("Invalid input!");
                        }
                        animals.add(new Kitten(kind, name, age, gender));
                        break;
                    case "Tomcat":
                        if (!"Male".equals(gender)) {
                            throw new IllegalArgumentException("Invalid input!");
                        }
                        animals.add(new Tomcat(kind, name, age, gender));
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid input!");
                }
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }
        }
        return animals;
    }
}
