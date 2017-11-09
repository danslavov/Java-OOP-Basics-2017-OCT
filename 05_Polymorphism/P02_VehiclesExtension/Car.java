package P02_VehiclesExtension;

public class Car extends Vehicle {

    public Car(double fuel, double consumption, double tank) {
        super(fuel, consumption, tank);
    }

    @Override
    protected void setConsumption(double consumption) {
        super.consumption = consumption + 0.9;
    }
}
