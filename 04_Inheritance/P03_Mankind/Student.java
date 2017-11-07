package P03_Mankind;

public class Student extends Human {
    private String facultyNumber;

    Student(String firstName, String lastName, String facultyNumber) {
        super(firstName, lastName);
        setFacultyNumber(facultyNumber);
    }

    private String getFacultyNumber() {
        return this.facultyNumber;
    }

    private void setFacultyNumber(String number) {
        if (number.length() < 5 || number.length() > 10) {
            throw new IllegalArgumentException("Invalid faculty number!");
        }
        this.facultyNumber = number;
    }

    @Override
    public String toString() {
        return String.format(
                "First Name: %s%nLast Name: %s%nFaculty number: %s",
                super.getFirstName(), super.getLastName(), this.getFacultyNumber());
    }
}
