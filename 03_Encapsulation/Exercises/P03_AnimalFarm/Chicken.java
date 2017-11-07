package Exercises.P03_AnimalFarm;

public class Chicken {
    private String name;
    private int age;

    Chicken(String name, int age) {
        setName(name);
        setAge(age);
    }

    private String getName() {
        return this.name;
    }

    private void setName(String name) {
        if (name == null || name.isEmpty() || " ".equals(name)) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        this.name = name;
    }

    private int getAge() {
        return this.age;
    }

    private void setAge(int age) {
        if (age < 0 || age > 15) {
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        }
        this.age = age;
    }

    public String showEggsPerDay() {
        String eggsPerDay;
        if (getAge() < 6) {
            eggsPerDay = "2";
        } else if (getAge() < 12) {
            eggsPerDay = "1";
        } else {
            eggsPerDay = "0.75";
        }
        return String.format("Chicken %s (age %d) can produce %s eggs per day.",
                getName(), getAge(), eggsPerDay);
    }
}
