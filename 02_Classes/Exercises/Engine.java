package Exercises;

public class Engine {
    private String model;
    private int speed;
    private int power;
    private String displacement;
    private String efficiency;

    public Engine(int speed, int power) {
        this.speed = speed;
        this.power = power;
    }

    public Engine(String model, int power) {
        this.model = model;
        this.power = power;
        this.displacement = "n/a";
        this.efficiency = "n/a";
    }

    public int getPower() {
        return this.power;
    }

    public void setDisplacement(String displacement) {
        this.displacement = displacement;
    }

    public void setEfficiency(String efficiency) {
        this.efficiency = efficiency;
    }

    @Override
    public String toString() {
        return String.format("  %s:%n    Power: %d%n    Displacement: %s%n    Efficiency: %s",
                this.model, this.power, this.displacement, this.efficiency);
    }
}
