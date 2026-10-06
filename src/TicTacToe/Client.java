package TicTacToe;

import TicTacToe.Controller.GameController;
import TicTacToe.ENUMS.BOT_DIFF_LEVEL;
import TicTacToe.ENUMS.GAME_STATE;
import TicTacToe.ENUMS.PLAYER_TYPE;
import TicTacToe.Entity.*;
import TicTacToe.Exceptions.InvalidBotCountException;
import TicTacToe.Strategy.WINNING_STRATEGY.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws InvalidBotCountException {
       Scanner sc=new Scanner(System.in);
        System.out.println("Enter size of the board");
        int size=sc.nextInt();
        List<Player> players = new ArrayList<>();
        players.add(new HumanPlayer(
                "Ayush",
                new Symbol('X'),
                PLAYER_TYPE.HUMAN
        ));
        players.add(new Bot(
                "Bot",
                new Symbol('O'),
                PLAYER_TYPE.BOT,
                BOT_DIFF_LEVEL.EASY
        ));
        List<winningStrategy> winningStrategies=new ArrayList<>();
        winningStrategies.add(new ROW_WINNING_STRATEGY());
        winningStrategies.add(new Col_winning_strategy());
        winningStrategies.add(new Diagonal_winning_strategy());

        GameController gameController=new GameController();
        Game game=gameController.startGame(size,players,winningStrategies);

        while(gameController.getGameState(game).equals(GAME_STATE.IN_PROGRESS)){
            gameController.displayBoard(game);
            gameController.makeMove(game);
        }

        // Game is either DRAW or ENDED.
        if (gameController.getGameState(game).equals(GAME_STATE.SUCCESS)) {
            gameController.displayBoard(game);
            System.out.println(game.getWinner().getName() + " has WON the game!!!!!");
        } else {
            gameController.displayBoard(game);
            System.out.println("Game has DRAWN, you can start another game.");
        }
    }
}
