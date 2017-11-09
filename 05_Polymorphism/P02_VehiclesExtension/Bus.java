package P02_VehiclesExtension;

public class Bus extends Vehicle {

    public Bus(double fuel, double consumption, double tank) {
        super(fuel, consumption, tank);
    }

    public void driveEmpty(double distance) {
        super.drive(distance);
    }

    @Override
    public void drive(double distance) {
        if (distance * super.getConsumption() > super.getFuel()) {
            throw new IllegalStateException();
        }
        this.setFuel(this.getFuel() - (distance * (super.getConsumption() + 1.4)));
    }

    @Override
    protected void setConsumption(double consumption) {
        super.consumption = consumption;
    }
}
