package benders;

public class EarthBender extends Bender {

    private double groundSaturation;

    public EarthBender(String name, int power, double groundSaturation) {
        super(name, power);
        this.setGroundSaturation(groundSaturation);
    }

    private double getGroundSaturation() {
        return groundSaturation;
    }

    private void setGroundSaturation (double groundSaturation) {
        this.groundSaturation = groundSaturation;
    }

    @Override
    public double calculateTotalPower() {
        return super.getPower() * this.getGroundSaturation();
    }

    @Override
    public String toString() {
        return String.format("###Earth Bender: %s, Power: %d, Ground Saturation: %.2f",
                super.getName(), super.getPower(), this.getGroundSaturation());
    }
}
