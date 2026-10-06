package TicTacToe.Entity;

import TicTacToe.ENUMS.CellState;

public class Cell {
    private int row;
    private int col;
    private Player player;
    private CellState state;

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
        this.state=CellState.IS_EMPTY;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public CellState getState() {
        return state;
    }

    public void setState(CellState state) {
        this.state = state;
    }
    public void display(){
        if(this.state.equals(CellState.IS_EMPTY)) {
            System.out.print("|  |");
        }
        else{
            System.out.println("| " + this.getPlayer().getSymbol().getSymbol() + " |");
        }
    }
}
