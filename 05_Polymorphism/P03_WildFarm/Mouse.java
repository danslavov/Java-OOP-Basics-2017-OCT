package P03_WildFarm;

public class Mouse extends Mammal {

    public Mouse(String type, String name, double weight, String livingRegion) {
        super(type, name, weight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("SQUEEEAAAK!");
    }

    @Override
    protected void eat(Meat meat) {
        throw new IllegalArgumentException("Mice are not eating that type of food!");
    }

    @Override
    protected void eat(Vegetable vegetable) {
        super.setFoodEaten(super.getFoodEaten() + vegetable.getQuantity());
    }
}
