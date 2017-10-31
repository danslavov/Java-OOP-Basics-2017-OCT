package Exercises;

import java.util.*;

public class P04_CompanyRoster {

    public static void main(String[] args) {
        Map<String, Department> departments = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            Employee e = getEmployeeData(input);
            String departmentName = input[3];
            departments.putIfAbsent(departmentName, new Department(departmentName));
            departments.get(departmentName).addEmployee(e);
        }
        printResult(departments);
    }

    private static void printResult(Map<String, Department> departments) {
        Optional<Department> maxDept = departments.values().stream()
                .max(Comparator.comparingDouble(Department::getAverageSalary));
        if (maxDept.isPresent()) {
            System.out.printf("Highest Average Salary: %s%n", maxDept.get().getName());
            maxDept.get().printEmployees();
        }
    }

    private static Employee getEmployeeData(String[] input) {
        String name = input[0];
        double salary = Double.parseDouble(input[1]);
        String position = input[2];
        String departmentName = input[3];
        Employee e = new Employee(name, salary, position, departmentName);
        if (input.length == 5) {
            if (input[4].contains("@")) {
                String email = input[4];
                e.setEmail(email);
            } else {
                int age = Integer.parseInt(input[4]);
                e.setAge(age);
            }
        }
        if (input.length == 6) {
            String email = input[4];
            int age = Integer.parseInt(input[5]);
            e.setEmail(email);
            e.setAge(age);
        }
        return e;
    }
}
