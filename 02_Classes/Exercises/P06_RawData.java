package Exercises;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class P06_RawData {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        List<Car> cars = getCars();
        printResult(cars);

    }

    private static List<Car> getCars() {
        List<Car> cars = new LinkedList<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] carData = scanner.nextLine().split("\\s+");
            String model = carData[0];
            Engine engine = getEngine(carData);
            Cargo cargo = getCargo(carData);
            List<Tire> tires = getTires(carData);
            cars.add(new Car(model, engine, cargo, tires));
        }
        return cars;
    }

    private static Engine getEngine(String[] carData) {
        int speed = Integer.parseInt(carData[1]);
        int power = Integer.parseInt(carData[2]);
        return new Engine(speed, power);
    }

    private static Cargo getCargo(String[] carData) {
        int weight = Integer.parseInt(carData[3]);
        String type = carData[4];
        return new Cargo(weight, type);
    }

    private static List<Tire> getTires(String[] carData) {
        List<Tire> tires = new LinkedList<>();
        for (int i = 5; i < 13; i++) {
            double pressure = Double.parseDouble(carData[i]);
            int age = Integer.parseInt(carData[++i]);
            tires.add(new Tire(pressure, age));
        }
        return tires;
    }

    private static void printResult(List<Car> cars) {
        String cargoTypeRequested = scanner.nextLine();
        for (Car car : cars) {
            if (cargoTypeRequested.equals(car.getCargo().getType())) {
                if ("fragile".equals(cargoTypeRequested)) {
                    for (Tire tire : car.getTires()) {
                        if (tire.getPressure() < 1) {
                            System.out.println(car.getModel());
                            break;
                        }
                    }
                } else {
                    if (car.getEngine().getPower() > 250) {
                        System.out.println(car.getModel());
                    }
                }
            }
        }
    }
}
