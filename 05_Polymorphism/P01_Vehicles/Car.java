package P01_Vehicles;

public class Car extends Vehicle {

    public Car(double fuel, double consumption) {
        super(fuel, consumption);
    }

    @Override
    protected void setConsumption(double consumption) {
        super.consumption = consumption + 0.9;
    }
}
