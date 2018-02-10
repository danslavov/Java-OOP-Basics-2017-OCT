package entities.cells;

public abstract class Cell {

    private String id;
    private int health;
    private int positionRow;
    private int positionCol;

    protected Cell(String id, int health, int positionRow, int positionCol) {
        this.id = id;
        this.health = health;
        this.positionRow = positionRow;
        this.positionCol = positionCol;
    }

    public void setCoordinates(int row, int col) {
        this.positionRow = row;
        this.positionCol = col;
    }

    public int getHealth() {
        return this.health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getId() {
        return this.id;
    }

    public int getPositionRow() {
        return this.positionRow;
    }

    public int getPositionCol() {
        return this.positionCol;
    }

    public abstract int getEnergy();

    @Override
    public abstract String toString();
}
