package P06_Animals;

public class Kitten extends Cat {
    public Kitten(String kind, String name, String age, String gender) {
        super(kind, name, age, gender);
    }

    @Override
    public String produceSound() {
        return "Miau";
    }
}
