package P01_Vehicles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class Main {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static DecimalFormat df = new DecimalFormat("#.##");

    public static void main(String[] args) throws IOException {
        Car car = createVehicle();
        Truck truck = createVehicle("truck");
        processCommands(car, truck);
        printResult(car, truck);
    }

    private static Car createVehicle() throws IOException {
        String[] vehicleData = reader.readLine().split("\\s+");
        double fuel = Double.parseDouble(vehicleData[1]);
        double consumption = Double.parseDouble(vehicleData[2]);
        return new Car(fuel, consumption);
    }

    private static Truck createVehicle(String truck) throws IOException {
        String[] vehicleData = reader.readLine().split("\\s+");
        double fuel = Double.parseDouble(vehicleData[1]);
        double consumption = Double.parseDouble(vehicleData[2]);
        return new Truck(fuel, consumption);
    }

    private static void processCommands(Car car, Truck truck) throws IOException {
        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            String[] input = reader.readLine().split("\\s+");
            String command = input[0];
            String vehicleType = input[1];
            double parameter = Double.parseDouble(input[2]);

            if ("Drive".equals(command)) {
                if ("Car".equals(vehicleType)) {
                    processDrive(car, parameter);
                } else {
                    processDrive(truck, parameter);

                }
            } else {
                if ("Car".equals(vehicleType)) {
                    car.refuel(parameter);
                } else {
                    truck.refuel(parameter);
                }
            }
        }
    }

    private static void processDrive(Car car, double parameter) {
        try {
            car.drive(parameter);
            System.out.printf("Car travelled %s km%n", df.format(parameter));
        } catch (IllegalStateException ise) {
            System.out.println("Car needs refueling");
        }
    }

    private static void processDrive(Truck truck, double parameter) {
        try {
            truck.drive(parameter);
            System.out.printf("Truck travelled %s km%n", df.format(parameter));
        } catch (IllegalStateException ise) {
            System.out.println("Truck needs refueling");
        }
    }

    private static void printResult(Car car, Truck truck) {
        System.out.printf("Car: %.2f%nTruck: %.2f",
                car.getFuel(), truck.getFuel());
    }
}
