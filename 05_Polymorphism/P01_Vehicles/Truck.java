package P01_Vehicles;

public class Truck extends Vehicle {

    public Truck(double fuel, double consumption) {
        super(fuel, consumption);
    }

    @Override
    protected void setConsumption(double consumption) {
        super.consumption = consumption + 1.6;
    }

    @Override
    public void refuel(double amount) {
        super.setFuel(super.getFuel() + (amount * 95 / 100) );
    }
}
