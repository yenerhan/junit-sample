package com.yener.testproject.basic.mincostpath;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MinCostPathTest {
    private MinCostPath minCostPath;
    /*
    * matrix,int[][],start cell,target cell,Cell(row,column)
    *start cell or target cell is out of matrix bound
    *start cell equals target cell then return cost of start cell
    *find min cost path for one row matrix
    * find min cost path for multi row matrix
    *right path cost,down path cost,diogonal path cost
    * */


    @BeforeEach
    void setUp() {
        minCostPath = new MinCostPath();
    }

    @Test
    @DisplayName("Throws IllegalArgumentException when the cell is out of matrix bound")
    void throwsIllegalArgumentExceptionWhenTheCellIsOutOfMatrixBound() {
        final int[][] matrix = {
                {4, 5, 6},
                {7, 8, 1}
        };
        assertAll("Start cell must be in matrix",
                () -> assertThrows(IllegalArgumentException.class, () -> minCostPath.find(matrix, new Cell(2, 1), new Cell(0, 2))),
                () -> assertThrows(IllegalArgumentException.class, () -> minCostPath.find(matrix, new Cell(-1, 1), new Cell(0, 2)))
        );

        assertAll("Target cell must be in matrix",
                () -> assertThrows(IllegalArgumentException.class, () -> minCostPath.find(matrix, new Cell(0, 0), new Cell(2, 1))),
                () -> assertThrows(IllegalArgumentException.class, () -> minCostPath.find(matrix, new Cell(-1, 1), new Cell(-1, 2)))
        );
    }

    @Test
    @DisplayName("Return the cost of start cell when the start cell is equal to target")
    void returnTheCostStartCellWhenTheStartCellIsEqualToTarget() {
        final int[][] matrix = {
                {3, 5, 7, 9}
        };

        assertEquals(3, minCostPath.find(matrix, new Cell(0, 0), new Cell(0, 0)));
        assertEquals(7, minCostPath.find(matrix, new Cell(0, 2), new Cell(0, 2)));
    }

    @Test
    @DisplayName("Find min cost for one row matrix")
    void  findMinCostPathForOneRowMatrix(){
        final int[][] matrix = {
                {3, 5, 7, 9}
        };

        assertEquals(8, minCostPath.find(matrix, new Cell(0, 0), new Cell(0, 1)));
        assertEquals(15, minCostPath.find(matrix, new Cell(0, 0), new Cell(0, 2)));

    }

    @Test
    @DisplayName("Find min cost for multi row matrix")
    void findMinCostPathForMultiRowMatrix(){
        final int[][] matrix = {
                {1, 2, 3, 4},
                {1, 3, 1, 2},
                {1, 2, 4, 5}
        };
    }
}
