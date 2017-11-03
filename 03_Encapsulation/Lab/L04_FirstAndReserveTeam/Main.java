package Lab.L04_FirstAndReserveTeam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Team myTeam = new Team("My team");
        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            String[] input = reader.readLine().split(" ");
            String firstName = input[0];
            String lastName = input[1];
            int age = Integer.parseInt(input[2]);
            double salary = Double.parseDouble(input[3]);
            Person player = new Person(firstName, lastName, age, salary);
            myTeam.addPlayer(player);
        }
        System.out.printf("First team have %d players%nReserve team have %d players",
                myTeam.getFirstTeam().size(), myTeam.getReserveTeam().size());
    }
}
