package entities.cells.microbes;

import entities.cells.Cell;

public abstract class Microbe extends Cell {

    private int virulence;

    protected Microbe(String id, int health, int positionRow,
                   int positionCol, int virulence) {
        super(id, health, positionRow, positionCol);
        this.virulence = virulence;
    }

    protected int getVirulence() {
        return  this.virulence;
    }

    @Override
    public abstract int getEnergy();

    @Override
    public abstract String toString();
}
