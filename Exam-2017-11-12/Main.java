import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HealthManager manager = new HealthManager();

        String input;
        while (!"BEER IS COMING".equalsIgnoreCase(input = reader.readLine())) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            String result;

            switch (command) {
                case "checkCondition":
                    result = manager.checkCondition(tokens[1]);
                    if (result != null) {
                        System.out.print(result);
                    }
                    break;
                case "createOrganism":
                    result = manager.createOrganism(tokens[1]);
                    if (result != null) {
                        System.out.println(result);
                    }
                    break;
                case "addCluster":
                    String organismName = tokens[1];
                    String id = tokens[2];
                    int rows = Integer.parseInt(tokens[3]);
                    int cols = Integer.parseInt(tokens[4]);
                    result = manager.addCluster(organismName, id, rows, cols);
                    if (result != null) {
                        System.out.println(result);
                    }
                    break;
                case "addCell":
                    organismName = tokens[1];
                    String clusterId = tokens[2];
                    String cellType = tokens[3];
                    String cellId = tokens[4];
                    int health = Integer.parseInt(tokens[5]);
                    int positionRow = Integer.parseInt(tokens[6]);
                    int positionCol = Integer.parseInt(tokens[7]);
                    int additionalProperty = Integer.parseInt(tokens[8]);

                    result = manager.addCell(organismName, clusterId, cellType,
                            cellId, health, positionRow, positionCol, additionalProperty);
                    if (result != null) {
                        System.out.println(result);
                    }
                    break;
                case "activateCluster":
                    result = manager.activateCluster(tokens[1]);
                    if (result != null) {
                        System.out.println(result);
                    }
                    break;
            }
        }
    }
}
