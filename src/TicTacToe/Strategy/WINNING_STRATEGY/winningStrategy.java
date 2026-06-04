package TicTacToe.Strategy.WINNING_STRATEGY;

import TicTacToe.Entity.Board;
import TicTacToe.Entity.Game;
import TicTacToe.Entity.Move;

public interface winningStrategy {
     boolean check(Move move, Board board);

}
