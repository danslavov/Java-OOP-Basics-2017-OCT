package Exercises;

import java.util.List;

public class Car {
    private String model;
    private double fuel;
    private double consumption;
    private int mileage;
    private String weight;
    private String color;
    private Engine engine;
    private Cargo cargo;
    private List<Tire> tires;

    Car(String model, double fuel, double consumption) {
        this.model = model;
        this.fuel = fuel;
        this.consumption = consumption;
        this.mileage = 0;
    }

    Car(String model, Engine engine, Cargo cargo, List<Tire> tires) {
        this.model = model;
        this.engine = engine;
        this.cargo =  cargo;
        this.tires = tires;
    }

    Car(String model, Engine engine) {
        this.model = model;
        this.engine = engine;
        this.weight = "n/a";
        this.color = "n/a";
    }

    public String getModel() {
        return this.model;
    }

    public Engine getEngine() {
        return this.engine;
    }

    public Cargo getCargo() {
        return this.cargo;
    }

    public List<Tire> getTires() {
        return this.tires;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void drive(double distance) {
        boolean fuelIsEnough = this.fuel >= distance * this.consumption;
        if (fuelIsEnough) {
            this.fuel -= distance * this.consumption;
            this.mileage += distance;
        } else {
            System.out.println("Insufficient fuel for the drive");
        }
    }

    @Override
    public String toString() {
        String resultForP05 = String.format("%s %.2f %d", model, fuel, mileage);
        String resultForP07 = String.format("%s:%n%s", model, engine);
        return resultForP07;
    }
}
