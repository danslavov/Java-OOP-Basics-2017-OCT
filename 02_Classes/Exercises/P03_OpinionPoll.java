package Exercises;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class P03_OpinionPoll {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Person> persons = new LinkedList<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String name = input[0];
            int age = Integer.parseInt(input[1]);
            persons.add(new Person(name, age));
        }
        persons.stream()
                .filter(p -> p.getAge() > 30)
                .sorted(Person::compareTo)
                .forEach(System.out::println);
    }
}
