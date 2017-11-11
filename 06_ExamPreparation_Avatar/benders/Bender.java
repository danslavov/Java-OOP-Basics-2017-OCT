package benders;

public abstract class Bender {
    private String name;
    private int power;

    Bender(String name, int power) {
        this.setName(name);
        this.setPower(power);
    }

    protected String getName() {
        return this.name;
    }

    private void setName(String name) {
        this.name = name;
    }

    int getPower() {
        return power;
    }

    private void setPower(int power) {
        this.power = power;
    }

    public abstract double calculateTotalPower();

    @Override
    public abstract String toString();
}
