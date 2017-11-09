package P03_WildFarm;

public class Zebra extends Mammal {

    public Zebra(String type, String name, double weight, String livingRegion) {
        super(type, name, weight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("Zs");
    }

    @Override
    protected void eat(Meat meat) {
        throw new IllegalArgumentException("Zebras are not eating that type of food!");
    }

    @Override
    protected void eat(Vegetable vegetable) {
        super.setFoodEaten(super.getFoodEaten() + vegetable.getQuantity());
    }
}
