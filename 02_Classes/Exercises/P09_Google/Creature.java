package Exercises.P09_Google;

public class Creature {
    private String name;
    private String property;

    public Creature(String name, String property) {
        this.name = name;
        this.property = property;
    }

    public Creature() {
    }

    @Override
    public String toString() {
        return name + " " + property;
    }
}
