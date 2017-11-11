package benders;

public class FireBender extends Bender {

    private double heatAggression;

    public FireBender(String name, int power, double heatAggression) {
        super(name, power);
        this.setHeatAggression(heatAggression);
    }

    private double getHeatAggression() {
        return heatAggression;
    }

    private void setHeatAggression (double heatAggression) {
        this.heatAggression = heatAggression;
    }

    @Override
    public double calculateTotalPower() {
        return super.getPower() * this.getHeatAggression();
    }

    @Override
    public String toString() {
        return String.format("###Fire Bender: %s, Power: %d, Heat Aggression: %.2f",
                super.getName(), super.getPower(), this.getHeatAggression());
    }
}
