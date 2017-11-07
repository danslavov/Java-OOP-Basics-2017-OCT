package P03_Mankind;

public class Worker extends Human {
    private double salary;
    private double workHours;

    Worker(String firstName, String lastName, double salary, double workHours) {
        super(firstName, lastName);
        setSalary(salary);
        setWorkHours(workHours);
    }

    private double getSalary() {
        return this.salary;
    }

    private void setSalary(double salary) {
        if (salary < 10.0) {
            throw new IllegalArgumentException("Expected value mismatch!Argument: weekSalary");
        }
        this.salary = salary;
    }

    private double getWorkHours() {
        return this.workHours;
    }

    private void setWorkHours(double workHours) {
        if (workHours < 1 || workHours > 12) {
            throw new IllegalArgumentException("Expected value mismatch!Argument: workHoursPerDay");
        }
        this.workHours = workHours;
    }

    private double calculateSalaryPerHour() {
        return this.getSalary() / (this.getWorkHours() * 7);
    }

    @Override
    public String toString() {
        return String.format(
                "First Name: %s%nLast Name: %s%nWeek Salary: %.2f%n" +
                        "Hours per day: %.2f%nSalary per hour: %.2f",
                super.getFirstName(), super.getLastName(), this.getSalary(),
                this.getWorkHours(), this.calculateSalaryPerHour());
    }
}
