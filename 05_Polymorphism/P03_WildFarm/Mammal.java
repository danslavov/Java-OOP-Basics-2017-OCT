package P03_WildFarm;

import java.text.DecimalFormat;

public abstract class Mammal extends Animal {

    private String livingRegion;

    public Mammal(String type, String name, double weight, String livingRegion) {
        super(type, name, weight);
        this.setLivingRegion(livingRegion);
    }

    protected String getLivingRegion() {
        return this.livingRegion;
    }

    protected void setLivingRegion(String region) {
        this.livingRegion = region;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.##");
        return String.format("%s[%s, %s, %s, %d]",
                super.getAnimalType(), super.getAnimalName(),
                df.format(super.getAnimalWeight()), this.getLivingRegion(),
                super.getFoodEaten());
    }
}
