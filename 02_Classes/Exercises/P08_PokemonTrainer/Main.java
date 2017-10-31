package Exercises.P08_PokemonTrainer;

import java.util.*;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Map<String, Trainer> trainers = getTrainers();
        earnBadges(trainers);
        sortAndPrintResult(trainers);
    }

    private static Map<String, Trainer> getTrainers() {
        Map<String, Trainer> trainers = new LinkedHashMap<>();
        String[] input = scanner.nextLine().split("\\s+");
        while (!"Tournament".equals(input[0])) {
            String trainerName = input[0];
            String pokemonName = input[1];
            String element = input[2];
            int health = Integer.parseInt(input[3]);

            Pokemon pokemon = new Pokemon(pokemonName, element, health);
            trainers.putIfAbsent(trainerName, new Trainer(trainerName));
            trainers.get(trainerName).putPokemon(pokemon);
            input = scanner.nextLine().split("\\s+");
        }
        return trainers;
    }

    private static void earnBadges(Map<String, Trainer> trainers) {
        String element = scanner.nextLine();
        while (!"End".equals(element)) {
            for (Trainer trainer : trainers.values()) {
                trainer.checkIfElementIsPresent(element);
            }
            element = scanner.nextLine();
        }
    }

    private static void sortAndPrintResult(Map<String, Trainer> trainers) {
        trainers.values().stream()
                .sorted((t1, t2) -> Integer.compare(t2.getBadgeCount(), t1.getBadgeCount()))
                .forEach(System.out::println);
    }
}
