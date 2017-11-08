package P06_Animals;

public class Cat extends Animal {
    public Cat(String kind, String name, String age, String gender) {
        super(kind, name, age, gender);
    }

    @Override
    public String produceSound() {
        return "MiauMiau";
    }
}
