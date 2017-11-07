package Exercises.P06_FootballTeamGenerator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Team> teams = new HashMap<>();

        String[] input = reader.readLine().split(";");
        while (!"END".equals(input[0])) {
            try {
                switch (input[0]) {
                    case "Team":
                        createTeam(input[1], teams);
                        break;
                    case "Add":
                        addPlayer(input, teams);
                        break;
                    case "Remove":
                        removePlayer(input, teams);
                        break;
                    case "Rating":
                        printResult(input[1], teams);
                        break;
                }
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }
            input = reader.readLine().split(";");
        }
    }

    private static void printResult(String name, Map<String, Team> teams) {
        System.out.println(teams.get(name));
    }

    private static void removePlayer(String[] input, Map<String, Team> teams) {
        String teamName = input[1];
        String playerName = input[2];
        Team team = teams.get(teamName);
        if (team != null) {
            team.removePlayer(playerName);
        }
    }

    private static void addPlayer(String[] input, Map<String, Team> teams) {
        String teamName = input[1];
        String playerName = input[2];
        int endurance = Integer.parseInt(input[3]);
        int sprint = Integer.parseInt(input[4]);
        int dribble = Integer.parseInt(input[5]);
        int passing = Integer.parseInt(input[6]);
        int shooting = Integer.parseInt(input[7]);
        Player player = new Player(
                playerName, endurance, sprint, dribble, passing, shooting
        );
        Team team = teams.get(teamName);
        if (team != null) {
            team.addPlayer(player);
        } else {
            System.out.println("Team " + teamName + " does not exist.");
        }
    }

    private static void createTeam(String name, Map<String, Team> teams) {
        teams.putIfAbsent(name, new Team(name));
    }
}
