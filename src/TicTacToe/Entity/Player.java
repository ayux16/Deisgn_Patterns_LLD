package TicTacToe.Entity;
import TicTacToe.ENUMS.PLAYER_TYPE;

import java.util.Scanner;

public abstract class Player {
    private String Name;
    private Symbol symbol;
    private PLAYER_TYPE player;

    public Player(String name, Symbol Symbol, PLAYER_TYPE player) {
        this.Name = name;
        this.symbol = Symbol;
        this.player = player;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Symbol getSymbol() {
        return symbol;
    }



    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }
    public Move makeMove(Board board) {
        System.out.println("Enter the row no for where you want to make your move");
        int row = sc.nextInt();

        System.out.println("Enter the col no for where you want to make your move");
        int col = sc.nextInt();

        return new Move(this, new Cell(row, col));
    }
    public PLAYER_TYPE getPlayerType() {
        return player;
    }

    public void setPlayerType(PLAYER_TYPE player) {
        this.player = player;
    }
}
