package TicTacToe.Entity;

import TicTacToe.ENUMS.BOT_DIFF_LEVEL;
import TicTacToe.ENUMS.PLAYER_TYPE;
import TicTacToe.Factory.BotFactory;
import TicTacToe.Strategy.BoTPLAYINGSTRATEGY.Bot_Playing_Strategy;

public class Bot extends Player {
    private BOT_DIFF_LEVEL level;
    private Bot_Playing_Strategy playingStrategy;

    public Bot(String name, Symbol Symbol,PLAYER_TYPE playerType, BOT_DIFF_LEVEL diff_level) {
        super(name, Symbol, playerType);
        this.level=diff_level;
        // Strategy + Factory design patterns.
        this.playingStrategy = BotFactory.getBotPlayingStrategy(diff_level);
    }
    @Override
    public Move makeMove(Board board) {
        Move move = playingStrategy.makeMove(board);
        move.setPlayer(this);

        return move;
    }
}
