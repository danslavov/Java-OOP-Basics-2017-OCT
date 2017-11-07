package P04_MordorsCrueltyPlan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] foods = reader.readLine().toLowerCase().split("\\s+");
        int points = calculatePoints(foods);
        String mood = determineMood(points);
        System.out.println(points);
        System.out.println(mood);
    }

    private static String determineMood(int points) {
        String mood;
        if (points < -5) {
            mood = "Angry";
        } else if (points <= 0) {
            mood = "Sad";
        } else if (points <= 15) {
            mood = "Happy";
        } else {
            mood = "JavaScript";
        }
        return mood;
    }

    private static int calculatePoints(String[] foods) {
        int points = 0;
        for (String food : foods) {
            switch (food) {
                case "cram":
                    points += 2;
                    break;
                case "lembas":
                    points += 3;
                    break;
                case "apple":
                case "melon":
                    points += 1;
                    break;
                case "honeycake":
                    points += 5;
                    break;
                case "mushrooms":
                    points -= 10;
                    break;
                default:
                    points -= 1;
                    break;
            }
        }
        return points;
    }
}
