package P02_VehiclesExtension;

public abstract class Vehicle {
    private double fuel;
    protected double consumption;
    private double tank;

    protected Vehicle(double fuel, double consumption, double tank) {
        setFuel(fuel);
        setConsumption(consumption);
        setTank(tank);
    }

    protected double getFuel() {
        return this.fuel;
    }

    protected void setFuel(double fuel) {
        if (fuel < 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        this.fuel = fuel;
    }

    protected double getConsumption() {
        return this.consumption;
    }

    protected abstract void setConsumption(double consumption);

    private double getTank() {
        return this.tank;
    }

    private void setTank(double tank) {
        this.tank = tank;
    }

    public void drive(double distance) {
        if (distance * this.getConsumption() > this.getFuel()) {
            throw new IllegalStateException();
        }
        this.setFuel(this.getFuel() - (distance * this.getConsumption()));
    }

    public void refuel(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        if (this.getFuel() + amount > this.getTank()) {
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }
        this.setFuel(this.getFuel() + amount);
    }
}
