package P02_VehiclesExtension;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class Main {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static DecimalFormat df = new DecimalFormat("#.##");

    public static void main(String[] args) throws IOException {
        Car car = createCar();
        Truck truck = createTruck();
        Bus bus = createBus();
        processCommands(car, truck, bus);
        printResult(car, truck, bus);
    }

    private static Car createCar() throws IOException {
        String[] vehicleData = reader.readLine().split("\\s+");
        double fuel = Double.parseDouble(vehicleData[1]);
        double consumption = Double.parseDouble(vehicleData[2]);
        double tank = Double.parseDouble(vehicleData[3]);
        return new Car(fuel, consumption, tank);
    }

    private static Truck createTruck() throws IOException {
        String[] vehicleData = reader.readLine().split("\\s+");
        double fuel = Double.parseDouble(vehicleData[1]);
        double consumption = Double.parseDouble(vehicleData[2]);
        double tank = Double.parseDouble(vehicleData[3]);
        return new Truck(fuel, consumption, tank);
    }

    private static Bus createBus() throws IOException {
        String[] vehicleData = reader.readLine().split("\\s+");
        double fuel = Double.parseDouble(vehicleData[1]);
        double consumption = Double.parseDouble(vehicleData[2]);
        double tank = Double.parseDouble(vehicleData[3]);
        return new Bus(fuel, consumption, tank);
    }

    private static void processCommands(Car car, Truck truck, Bus bus) throws IOException {
        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            String[] input = reader.readLine().split("\\s+");
            String command = input[0];
            String vehicleType = input[1];
            double parameter = Double.parseDouble(input[2]);

            switch (vehicleType) {
                case "Car":
                    executeCommand(car, command, parameter);
                    break;
                case "Truck":
                    executeCommand(truck, command, parameter);
                    break;
                case "Bus":
                    executeCommand(bus, command, parameter);
                    break;
            }
        }
    }

    private static void executeCommand(Car car, String command, double parameter) {
        if ("Drive".equals(command)) {
            try {
                car.drive(parameter);
                System.out.printf("Car travelled %s km%n", df.format(parameter));
            } catch (IllegalStateException ise) {
                System.out.println("Car needs refueling");
            }
        } else {
            try {
                car.refuel(parameter);
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }
        }
    }

    private static void executeCommand(Truck truck, String command, double parameter) {
        if ("Drive".equals(command)) {
            try {
                truck.drive(parameter);
                System.out.printf("Truck travelled %s km%n", df.format(parameter));
            } catch (IllegalStateException ise) {
                System.out.println("Truck needs refueling");
            }
        } else {
            try {
                truck.refuel(parameter);
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }
        }
    }

    private static void executeCommand(Bus bus, String command, double parameter) {
        if ("Drive".equals(command)) {
            try {
                bus.drive(parameter);
                System.out.printf("Bus travelled %s km%n", df.format(parameter));
            } catch (IllegalStateException ise) {
                System.out.println("Bus needs refueling");
            }
        } else if ("DriveEmpty".equals(command)) {
            try {
                bus.driveEmpty(parameter);
                System.out.printf("Bus travelled %s km%n", df.format(parameter));
            } catch (IllegalStateException ise) {
                System.out.println("Bus needs refueling");
            }
        } else {
            try {
                bus.refuel(parameter);
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }
        }
    }


    private static void printResult(Car car, Truck truck, Bus bus) {
        System.out.printf("Car: %.2f%nTruck: %.2f%nBus: %.2f",
                car.getFuel(), truck.getFuel(), bus.getFuel());
    }
}
