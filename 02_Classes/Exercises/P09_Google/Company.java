package Exercises.P09_Google;

public class Company {
    private String name;
    private String department;
    private double salary;

    public Company(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public Company() {
    }

    @Override
    public String toString() {
        if (this.name != null) {
            return String.format("%s %s %.2f%n", name, department, salary);
        } else {
            return "";
        }
    }
}
