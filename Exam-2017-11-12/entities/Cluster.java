package entities;

import entities.cells.Cell;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Cluster {

    private String id;
    private int rows;
    private int cols;
    private List<Cell> cells;

    public Cluster(String id, int rows, int cols) {
        this.id = id;
        this.rows = rows;
        this.cols = cols;
        this.cells = new LinkedList<>();
    }

    private int getRows() {
        return this.rows;
    }

    private int getCols() {
        return this.cols;
    }

    public String getId() {
        return this.id;
    }

    public List<Cell> getCells() {
        return this.cells;
    }

    public void addCell(Cell cell) {
        this.getCells().add(cell);
    }

    public Cell[][] getMatrix() {
        Cell[][] matrix = new Cell[this.rows][this.cols];
        for (Cell cell : cells) {
            int posRow = cell.getPositionRow();
            int posCol = cell.getPositionCol();
            matrix[posRow][posCol] = cell;
        }
        return matrix;
    }

    public void deleteCell(int row, int col) {
        cells.removeIf(c -> c.getPositionRow() == row && c.getPositionCol() == col);
    }

    public boolean cellIsInside(Cell cell) {
        return cell.getPositionRow() <= this.getRows() &&
                cell.getPositionCol() <= this.getCols() &&
                cell.getPositionRow() >= 0 && cell.getPositionCol() >= 0;
    }

    @Override
    public String toString() {

        StringBuilder result = new StringBuilder();
        result.append(String.format("----Cluster %s\n", getId()));
        Cell[][] matrix = this.getMatrix();
        for (Cell[] line : matrix) {
            for (Cell cell : line) {
                if (cell != null) {
                    result.append(cell);
                    result.append(System.lineSeparator());
                }
            }
        }
        return result.toString();
    }
}
