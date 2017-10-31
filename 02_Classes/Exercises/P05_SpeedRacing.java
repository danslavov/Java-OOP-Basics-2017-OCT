package Exercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P05_SpeedRacing {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Map<String, Car> cars = getCars();
        processDrive(cars);
        cars.values().forEach(System.out::println);
    }

    private static void processDrive(Map<String, Car> cars) {
        String[] input = scanner.nextLine().split("\\s+");
        while (!"End".equals(input[0])) {
            String model = input[1];
            double distance = Double.parseDouble(input[2]);
            cars.get(model).drive(distance);
            input = scanner.nextLine().split("\\s+");
        }
    }

    private static Map<String, Car> getCars() {
        Map<String, Car> cars = new LinkedHashMap<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] carData = scanner.nextLine().split("\\s+");
            String model = carData[0];
            double fuel = Double.parseDouble(carData[1]);
            double consumption = Double.parseDouble(carData[2]);
            cars.putIfAbsent(model, new Car(model, fuel, consumption));
        }
        return cars;
    }
}
