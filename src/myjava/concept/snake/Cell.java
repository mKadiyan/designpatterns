package myjava.concept.snake;
public class Cell {

    final int row, col;
    CellType type;

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
    }
    
    enum CellType
    {
    	EMPTY,FOOD,SNAKE;
    }
    
}