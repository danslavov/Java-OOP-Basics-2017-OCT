package Exercises.P09_Google;

public class Car {
    private String model;
    private int speed;

    public Car(String model, int speed) {
        this.model = model;
        this.speed = speed;
    }

    public Car() {
    }

    @Override
    public String toString() {
        if (this.model != null) {
            return String.format("%s %s%n", model, speed);
        } else {
            return "";
        }
    }
}
