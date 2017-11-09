package P03_WildFarm;

import java.text.DecimalFormat;

public class Cat extends Felime {

    protected String breed;

    Cat(String type, String name, double weight, String livingRegion, String breed) {
        super(type, name, weight, livingRegion);
        this.setBreed(breed);
    }

    protected String getBreed() {
        return this.breed;
    }

    protected void setBreed(String breed) {
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        System.out.println("Meowwww");
    }

    @Override
    protected void eat(Meat meat) {
        super.setFoodEaten(super.getFoodEaten() + meat.getQuantity());
    }

    @Override
    protected void eat(Vegetable vegetable) {
        super.setFoodEaten(super.getFoodEaten() + vegetable.getQuantity());
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.##");
        return String.format("%s[%s, %s, %s, %s, %d]",
                super.getAnimalType(), super.getAnimalName(), this.getBreed(),
                df.format(super.getAnimalWeight()), super.getLivingRegion(),
                super.getFoodEaten());
    }
}
