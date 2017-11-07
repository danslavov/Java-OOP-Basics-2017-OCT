package P03_Mankind;

public class Human {
    private String firstName;
    private String lastName;

    Human(String firstName, String lastName) {
        setFirstName(firstName);
        setLastName(lastName);
    }

    protected String getFirstName() {
        return this.firstName;
    }

    private void setFirstName(String name) {
        if (!Character.isUpperCase(name.charAt(0))) {        // not only letters
            throw new IllegalArgumentException("Expected upper case letter!Argument: firstName");
        }
        if (name.length() < 4) {
            throw new IllegalArgumentException("Expected length at least 4 symbols!Argument: firstName");   // "at least" or "more than" ?
        }
        this.firstName = name;
    }

    protected String getLastName() {
        return this.lastName;
    }

    private void setLastName(String name) {
        if (!Character.isUpperCase(name.charAt(0))) {        // not only letters
            throw new IllegalArgumentException("Expected upper case letter!Argument: lastName");
        }
        if (name.length() < 3) {
            throw new IllegalArgumentException("Expected length at least 3 symbols!Argument: lastName");
        }
        this.lastName = name;
    }
}
