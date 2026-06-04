package TicTacToe.Constructor;

import TicTacToe.ENUMS.GAME_STATE;
import TicTacToe.Entity.Board;
import TicTacToe.Entity.Game;
import TicTacToe.Entity.Move;
import TicTacToe.Entity.Player;
import TicTacToe.Exceptions.InvalidBotCountException;
import TicTacToe.Exceptions.InvalidPlayerCountException;
import TicTacToe.Strategy.WINNING_STRATEGY.winningStrategy;

import java.util.List;

public class Game_Constructor {
    public Game startGame(int size, List<Player> players, List<winningStrategy> winningStrategy) throws InvalidBotCountException, InvalidPlayerCountException {
        return Game.getBuilder()
                .setSize(size)
                .setPlayers(players)
                .setWinningStrategies(winningStrategy)
                .build();
    }
    public void makeMove(Game game) {
        game.makeMove();
    }
     public void displayBoard(Game game) {
        game.getBoard().print();
    }
    public GAME_STATE getGameState(Game game) {
        return game.getGameState();
    }
    public Player getWinningPlayer(Game game) {
        return game.getWinner();
    }
    public void Undo(Game game) {
       // game.undo();

    }
}
//start_game
//getCurrentPlayer
//makeMove
//displayBoard
//checkState
