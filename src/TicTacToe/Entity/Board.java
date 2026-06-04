package TicTacToe.Entity;

import TicTacToe.ENUMS.CELL_STATE;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private int size;
    private List<List<Cell>> grid;

    public Board(int size) {
        this.size = size;
        this.grid = new ArrayList<>();
        for(int i = 0; i < size; i++){
            this.grid.add(new ArrayList<>());
            for(int j = 0; j < size; j++){
                this.grid.get(i).add(new Cell(i,j));
            }
        }
    }
    public void print() { // List<List<Cell>>
        for (List<Cell> cells : grid) {
            for (Cell cell : cells) {
                if (cell.getState() == CELL_STATE.IS_EMPTY) {
                    System.out.print("|  |");
                } else {
                    System.out.print("| " + cell.getPlayer().getSymbol() + " |");
                }
            }
            System.out.println();
        }
    }
    public int getSize() {
        return size;
    }
    public List<List<Cell>> getBoard() {
        return grid;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<List<Cell>> getGrid() {
        return grid;
    }

    public void setGrid(List<List<Cell>> grid) {
        this.grid = grid;
    }
}
