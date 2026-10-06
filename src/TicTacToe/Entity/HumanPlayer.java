package TicTacToe.Entity;

import TicTacToe.ENUMS.PLAYER_TYPE;

import java.util.Scanner;

public class HumanPlayer extends Player{
    private Scanner scanner = new Scanner(System.in);
    public HumanPlayer(String name, Symbol Symbol, PLAYER_TYPE player) {
        super(name, Symbol, player);
    }
    @Override
    public Move makeMove(Board board) {

        // For human to make the move, row and column indexes are required in the input.
        System.out.println("Please enter the row index:");
        int row=scanner.nextInt();
        System.out.println("Please enter the col index:");
        int col=scanner.nextInt();
        //validateMove()
        //check if row and col is valid or not
        //check if cell is already filled or not;
        return new Move(this, new Cell(row, col));
    }
    private boolean validateMove(Board board, int row, int column) {
        // TODO: Implement this.
        return false;
    }
}
