import entities.Cluster;
import entities.Organism;
import entities.cells.Cell;

import java.util.HashMap;
import java.util.Map;

public class HealthManager {

    private Map<String, Organism> organisms = new HashMap<>();

    private Factory factory = new Factory();


    String checkCondition(String organismName) {
        if (!organisms.containsKey(organismName)) {
            return null;
        }
        Organism organism = organisms.get(organismName);
        return organism.toString();
    }

    String createOrganism(String name) {

        if (organisms.containsKey(name)) {
            return String.format("Organism %s already exists", name);
        }

        Organism organism = factory.makeOrganism(name);
        organisms.put(name, organism);
        return String.format("Created organism %s", name);
    }

    String addCluster(String organismName, String id, int rows, int cols) {
        if (!organisms.containsKey(organismName)) {
            return null;
        }
        Organism organism = organisms.get(organismName);
        if (organism.getClusters().containsKey(id)) {
            return null;
        }
        Cluster cluster = factory.makeCluster(id, rows, cols);
        organism.addCluster(cluster);

        return String.format("Organism %s: Created cluster %s",
                organism.getName(), id);
    }

    String addCell(String organismName, String clusterId, String cellType,
                   String cellId, int health, int positionRow, int positionCol,
                   int additionalProperty) {

        if (!organisms.containsKey(organismName)) {
            return null;
        }
        Organism organism = organisms.get(organismName);
        if (!organism.getClusters().containsKey(clusterId)) {
            return null;
        }
        Cluster cluster = organism.getClusters().get(clusterId);
        Cell cell = factory.makeCell(cellType, cellId, health, positionRow, positionCol, additionalProperty);
        if (cluster.cellIsInside(cell)) {
            cluster.addCell(cell);
        }

        return String.format("Organism %s: Created cell %s in cluster %s",
                organism.getName(), cell.getId(), cluster.getId());
    }

    String activateCluster(String organismName) {

        if (!organisms.containsKey(organismName)) {
            return null;
        }
        Organism organism = organisms.get(organismName);
        Cluster cluster = organism.getClusterToActivate();

        if (cluster.getCells().size() < 2) {
            return null;
        }

        Cell[][] matrix = cluster.getMatrix();
        Cell startCell = null;
        Cell currentCell;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[row][col] != null) {
                    currentCell = matrix[row][col];
                    cluster.deleteCell(row, col);
                    if (startCell == null) {
                        startCell = currentCell;
                    } else {
                        if ("RedBloodCell".equals(startCell.getClass().getSimpleName()) ||
                                "WhiteBloodCell".equals(startCell.getClass().getSimpleName())) {
                            startCell.setHealth(startCell.getHealth() + currentCell.getHealth());
//                            cluster.deleteCell(row, col);
                            startCell.setCoordinates(row, col);
                        } else {

                            while (true) {

                                // start attacks
                                currentCell.setHealth(
                                        currentCell.getHealth() - startCell.getEnergy());

                                if (currentCell.getHealth() <= 0) {

                                    // start wins, current is deleted
                                    cluster.deleteCell(row, col);
                                    startCell.setCoordinates(row, col);
                                    break;
                                }

                                // current attacks
                                startCell.setHealth(
                                        startCell.getHealth() - currentCell.getEnergy());

                                if (startCell.getHealth() <= 0) {

                                    // current wins
                                    cluster.deleteCell(row, col);
                                    startCell = currentCell;
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }
        cluster.addCell(startCell);

        return String.format("Organism %s: Activated cluster %s. Cells left: %d",
                organism.getName(), cluster.getId(), cluster.getCells().size());
    }
}
