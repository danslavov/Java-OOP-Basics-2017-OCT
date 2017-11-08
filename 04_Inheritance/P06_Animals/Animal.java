package P06_Animals;

public class Animal {
    private String kind;
    private String name;
    private int age;
    private String gender;

    public Animal(String kind, String name, String age, String gender) {
        setKind(kind);
        setName(name);
        setAge(age);
        setGender(gender);
    }

    private String getKind() {
        return this.kind;
    }

    private void setKind(String kind) {
        boolean kindIsWrong = !"Animal". equals(kind) && !"Dog". equals(kind)
                && !"Cat". equals(kind) && !"Frog". equals(kind)
                && !"Kitten". equals(kind) && !"Tomcat". equals(kind);
        if (kindIsWrong) {
            throw new IllegalArgumentException("Invalid input!");
        }
        this.kind = kind;
    }

    private String getName() {
        return this.name;
    }

    private void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Invalid input!");
        }
        this.name = name;
    }

    private int getAge() {
        return this.age;
    }

    private void setAge(String input) {
        int age;
        try {
            age = Integer.parseInt(input);
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("Invalid input!");
        }
        if (age < 0) {
            throw new IllegalArgumentException("Invalid input!");
        }
        this.age = age;
    }

    private String getGender() {
        return this.gender;
    }

    private void setGender(String gender) {
        if (!"Male".equals(gender) && !"Female".equals(gender)) {
            throw new IllegalArgumentException("Invalid input!");
        }
        this.gender = gender;
    }

    protected String produceSound() {
        return "Not implemented!";
    }

    @Override
    public String toString() {
        return String.format("%s%n%s %d %s%n%s",
                this.getKind(),
                this.getName(), this.getAge(), this.getGender(),
                this.produceSound());
    }
}
