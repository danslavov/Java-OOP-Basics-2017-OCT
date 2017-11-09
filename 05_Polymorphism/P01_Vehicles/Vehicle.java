package P01_Vehicles;

public abstract class Vehicle {
    private double fuel;
    protected double consumption;

    protected Vehicle(double fuel, double consumption) {
        setFuel(fuel);
        setConsumption(consumption);
    }

    protected double getFuel() {
        return this.fuel;
    }

    protected void setFuel(double fuel) {
        // validations?
        this.fuel = fuel;
    }

    private double getConsumption() {
        return this.consumption;
    }

    protected abstract void setConsumption(double consumption);

    public void drive(double distance) {
        //validations?
        if (distance * this.getConsumption() > this.getFuel()) {
            throw new IllegalStateException();
        }
        this.setFuel(this.getFuel() - (distance * getConsumption()));
    }

    public void refuel(double amount) {
        //validations?
        this.setFuel(this.getFuel() + amount);
    }
}
