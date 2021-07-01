package com.yener.testproject.basic.mincostpath;

public class MinCostPath {
    public int find(int[][] matrix, Cell start, Cell target) {
        validateifCellIsOutOfMatrixBound(matrix, start);
        validateifCellIsOutOfMatrixBound(matrix, target);

        if (start.equals(target)) {
            return matrix[start.getRow()][target.getColumn()];
        }

        Cell currentCell = start;
        int cost = 0;
        while (!currentCell.equals(target)) {
            cost += matrix[currentCell.getRow()][currentCell.getColumn()];
            currentCell = new Cell(currentCell.getRow(), currentCell.getColumn() + 1);
        }
        cost+=matrix[currentCell.getRow()][currentCell.getColumn()];
        return cost;
    }

    private void validateifCellIsOutOfMatrixBound(int[][] matrix, Cell cell) {
        if (cell.getRow() >= matrix.length || cell.getRow() < 0) {
            throw new IllegalArgumentException();
        }

        if (cell.getColumn() >= matrix[0].length || cell.getColumn() < 0) {
            throw new IllegalArgumentException();
        }
    }
}
