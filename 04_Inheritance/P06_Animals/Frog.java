package P06_Animals;

public class Frog extends Animal {

    public Frog(String kind, String name, String age, String gender) {
        super(kind, name, age, gender);
    }

    @Override
    public String produceSound() {
        return "Frogggg";
    }
}
