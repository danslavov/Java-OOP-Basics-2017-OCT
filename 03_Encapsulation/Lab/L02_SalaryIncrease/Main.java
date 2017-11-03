package Lab.L02_SalaryIncrease;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        List<PersonWithSalary> persons = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] input = reader.readLine().split(" ");
            persons.add(new PersonWithSalary(input[0], input[1], Integer.parseInt(input[2]), Double.parseDouble(input[3])));
        }
        int bonus = Integer.parseInt(reader.readLine());
        for (PersonWithSalary person : persons) {
            person.increaseSalary(bonus);
            System.out.println(person.toString());
        }
    }
}
