package entities.cells.bloodCells;

import entities.cells.Cell;

public abstract class BloodCell extends Cell {

    protected BloodCell(String id, int health, int positionRow, int positionCol) {
        super(id, health, positionRow, positionCol);
    }

    @Override
    public abstract int getEnergy();

    @Override
    public abstract String toString();
}
