import entities.Cluster;
import entities.Organism;
import entities.cells.Cell;
import entities.cells.bloodCells.RedBloodCell;
import entities.cells.bloodCells.WhiteBloodCell;
import entities.cells.microbes.Bacteria;
import entities.cells.microbes.Fungi;
import entities.cells.microbes.Virus;

public class Factory {

    Cell makeCell(String cellType, String cellId, int health, int positionRow, int positionCol, int additionalProperty) {

        switch (cellType) {
            case "RedBloodCell":
                return new RedBloodCell(cellId, health, positionRow, positionCol, additionalProperty);
            case "WhiteBloodCell":
                return new WhiteBloodCell(cellId, health, positionRow, positionCol, additionalProperty);
            case "Bacteria":
                return new Bacteria(cellId, health, positionRow, positionCol, additionalProperty);
            case "Fungi":
                return new Fungi(cellId, health, positionRow, positionCol, additionalProperty);
            case "Virus":
                return new Virus(cellId, health, positionRow, positionCol, additionalProperty);
            default:
                return null;
        }
    }

    Cluster makeCluster(String id, int rows, int cols) {
        return new Cluster(id, rows, cols);
    }

    Organism makeOrganism(String name) {
        return new Organism(name);
    }

}
