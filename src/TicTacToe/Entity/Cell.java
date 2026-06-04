package TicTacToe.Entity;

import TicTacToe.ENUMS.CELL_STATE;

public class Cell {
    private int row;
    private int col;
    private Player player;
    private CELL_STATE state;

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
        this.state=CELL_STATE.IS_EMPTY;
    }

    public CELL_STATE getState() {
        return state;
    }

    public void setState(CELL_STATE state) {
        this.state = state;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }
}
