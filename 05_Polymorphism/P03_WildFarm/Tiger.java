package P03_WildFarm;

public class Tiger extends Felime {

    public Tiger(String type, String name, double weight, String livingRegion) {
        super(type, name, weight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("ROAAR!!!");
    }

    @Override
    protected void eat(Meat meat) {
        super.setFoodEaten(super.getFoodEaten() + meat.getQuantity());
    }

    @Override
    protected void eat(Vegetable vegetable) {
        throw new IllegalArgumentException("Tigers are not eating that type of food!");
    }
}
