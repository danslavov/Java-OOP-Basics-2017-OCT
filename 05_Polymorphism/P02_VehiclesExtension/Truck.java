package P02_VehiclesExtension;

public class Truck extends Vehicle {

    public Truck(double fuel, double consumption, double tank) {
        super(fuel, consumption, tank);
    }

    @Override
    protected void setConsumption(double consumption) {
        super.consumption = consumption + 1.6;
    }

    @Override
    public void refuel(double amount) {
        super.refuel(amount * 95 / 100);
    }
}
