package Exercises;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P07_CarSalesman {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Map<String, Engine> engines = getEngines();
        Map<String, Car> cars = getCars(engines);
        printResult(cars);
    }

    private static Map<String,Engine> getEngines() {
        Map<String,Engine> engines = new HashMap<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] engineDetails = scanner.nextLine().split("\\s+");
            String model = engineDetails[0];
            int power = Integer.parseInt(engineDetails[1]);
            Engine engine = new Engine(model, power);
            if (engineDetails.length == 3) {
                String optionalParameter = engineDetails[2];
                if (isNum(optionalParameter)) {
                    engine.setDisplacement(optionalParameter);
                } else {
                    engine.setEfficiency(optionalParameter);
                }
            } else if (engineDetails.length == 4) {
                String displacement = engineDetails[2];
                String efficiency = engineDetails[3];
                engine.setEfficiency(efficiency);
                engine.setDisplacement(displacement);
            }
            engines.put(model, engine);
        }
        return engines;
    }

    private static Map<String,Car> getCars(Map<String, Engine> engines) {
        Map<String, Car> cars = new LinkedHashMap<>();
        int m = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < m; i++) {
            String[] carDetails = scanner.nextLine().split("\\s+");
            String model = carDetails[0];
            Engine engine = engines.get(carDetails[1]);
            Car car = new Car(model, engine);
            if (carDetails.length == 3) {
                String optionalParameter = carDetails[2];
                if (isNum(optionalParameter)) {
                    car.setWeight(optionalParameter);
                } else {
                    car.setColor(optionalParameter);
                }
            } else if (carDetails.length == 4) {
                String weight = carDetails[2];
                String color = carDetails[3];
                car.setWeight(weight);
                car.setColor(color);
            }

            cars.put(model, car);
        }
        return cars;
    }

    private static void printResult(Map<String, Car> cars) {
        for (Car car : cars.values()) {
            System.out.println(car);
        }
    }

    private static boolean isNum(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }
}
