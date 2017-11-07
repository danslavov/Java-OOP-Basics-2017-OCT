package P03_Mankind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        try {
            Student student = createStudent();
            Worker worker = createWorker();
            System.out.println(student);
            System.out.println(worker);
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }
    }

    private static Worker createWorker() throws IOException {
        String[] workerData = reader.readLine().split("\\s+");
        String firstName = workerData[0];
        String lastName = workerData[1];
        double salary = Double.parseDouble(workerData[2]);
        double workHours = Double.parseDouble(workerData[3]);
        return new Worker(firstName, lastName, salary, workHours);
    }

    private static Student createStudent() throws IOException {
        String[] studentData = reader.readLine().split("\\s+");
        String firstName = studentData[0];
        String lastName = studentData[1];
        String facultyNumber = studentData[2];
        return new Student(firstName, lastName, facultyNumber);
    }
}
