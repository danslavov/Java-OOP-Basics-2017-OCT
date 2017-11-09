package P03_WildFarm;

public abstract class Animal {

    private String animalType;
    private String animalName;
    private double animalWeight;
    private int foodEaten;

    Animal(String type, String name, double weight) {
        this.setAnimalType(type);
        this.setAnimalName(name);
        this.setAnimalWeight(weight);
    }

    protected String getAnimalName() {
        return this.animalName;
    }

    protected void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    protected String getAnimalType() {
        return this.animalType;
    }

    protected void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    protected double getAnimalWeight() {
        return this.animalWeight;
    }

    protected void setAnimalWeight(double animalWeight) {
        this.animalWeight = animalWeight;
    }

    protected int getFoodEaten() {
        return this.foodEaten;
    }

    protected void setFoodEaten(int foodEaten) {
        this.foodEaten = foodEaten;
    }

    public abstract void makeSound();

    protected abstract void eat(Meat meat);

    protected abstract void eat(Vegetable vegetable);
}
