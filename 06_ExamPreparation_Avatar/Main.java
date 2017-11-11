import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> wars = new LinkedList<>();
        String[] input = reader.readLine().split("\\s+");
        while (true) {
            String command = input[0];
            if ("Quit".equalsIgnoreCase(command)) {
                break;
            }
            switch (command) {
                case "Bender":
                    Controller.addBender(input);
                    break;
                case "Monument":
                    Controller.addMonument(input);
                    break;
                case "Status":
                    System.out.println(Controller.showStatus(input[1]));
                    break;
                case "War":
                    wars.add(input[1]);
                    Controller.beginWar();
                    break;
            }
            input = reader.readLine().split("\\s+");
        }
        for (int i = 0; i < wars.size(); i++) {
            System.out.printf("War %d issued by %s%n", i + 1, wars.get(i));
        }
    }
}
