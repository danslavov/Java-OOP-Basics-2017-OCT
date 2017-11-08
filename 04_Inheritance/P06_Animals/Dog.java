package P06_Animals;

public class Dog extends Animal {

    public Dog(String kind, String name, String age, String gender) {
        super(kind, name, age, gender);
    }

    @Override
    public String produceSound() {
        return "BauBau";
    }
}
