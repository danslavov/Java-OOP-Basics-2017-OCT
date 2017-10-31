package Exercises;

public class Person {
    private String name;
    private int age;

    Person() {
        this("No name", 1);
    }

    Person(int age) {
        this("No name", age);
    }

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("%s - %d", this.name, this.age);
    }

    public int compareTo(Person otherPerson) {
        return this.name.compareTo(otherPerson.name);
    }
}
