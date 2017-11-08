package P06_Animals;

public class Tomcat extends Cat {
    Tomcat(String kind, String name, String age, String gender) {
        super(kind, name, age, gender);
    }

    @Override
    public String produceSound() {
        return "Give me one million b***h";
    }

}
