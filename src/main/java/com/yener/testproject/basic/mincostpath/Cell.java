package com.yener.testproject.basic.mincostpath;

public class Cell {

    private final int row;
    private final int column;

    public Cell(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    @Override
    public boolean equals(Object obj) {
        if(!Cell.class.isInstance(obj)){
            return false;
        }
        return ((Cell) obj).getRow()==this.row && ((Cell) obj).getColumn()==this.column;
    }
}
