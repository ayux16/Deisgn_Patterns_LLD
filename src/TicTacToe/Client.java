package TicTacToe;

import TicTacToe.Constructor.GameController;
import TicTacToe.ENUMS.BOT_DIFF_LEVEL;
import TicTacToe.ENUMS.GAME_STATE;
import TicTacToe.ENUMS.PLAYER_TYPE;
import TicTacToe.Entity.Bot;
import TicTacToe.Entity.Game;
import TicTacToe.Entity.Player;
import TicTacToe.Entity.Symbol;
import TicTacToe.Exceptions.InvalidBotCountException;
import TicTacToe.Strategy.WINNING_STRATEGY.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws InvalidBotCountException {
        Scanner sc=new Scanner(System.in);
        GameController gameController = new GameController();
        System.out.println("Enter the size of the board");
        int size=sc.nextInt();
        List<Player>  players = new ArrayList<>();
        players.add(new Player("Ayush",new Symbol('x'), PLAYER_TYPE.HUMAN));
        players.add(new Bot("Computer", new Symbol('O'), BOT_DIFF_LEVEL.HARD));

        List<winningStrategy>  winningStrategies = new ArrayList<>();
        winningStrategies.add(new ROW_WINNING_STRATEGY());
        winningStrategies.add(new Col_winning_strategy());
        winningStrategies.add(new Diagonal_winning_strategy());

        Game game= gameController.startGame(size,players,winningStrategies);
        while(gameController.getGameState(game) == GAME_STATE.IN_PROGRESS){
            System.out.println("Current Player is " + players.get(game.getCurrentPlayer()).getName());
            gameController.displayBoard(game);
            gameController.makeMove(game);
        }
        gameController.displayBoard(game);
        if(gameController.getGameState(game) == GAME_STATE.SUCCESS) {
            System.out.println("Game is won by " + gameController.getWinningPlayer(game).getName());
        }
        else if(gameController.getGameState(game) == GAME_STATE.TERMINATED || gameController.getGameState(game) == GAME_STATE.DRAW){
            System.out.println("Game is Draw");
        }
        else{
            System.out.println("Game is In Progress");
        }
    }
}
