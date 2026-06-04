package TicTacToe.Entity;

import TicTacToe.ENUMS.BOT_DIFF_LEVEL;
import TicTacToe.ENUMS.PLAYER_TYPE;
import TicTacToe.Factory.BotFactory;
import TicTacToe.Strategy.BoTPLAYINGSTRATEGY.Bot_Playing_Strategy;

public class Bot extends Player {
    private BOT_DIFF_LEVEL level;
    private Bot_Playing_Strategy strategy;

    public Bot(String name, Symbol Symbol, BOT_DIFF_LEVEL diff_level) {
        super(name, Symbol, PLAYER_TYPE.BOT);
        this.level=diff_level;
        this.strategy = BotFactory.getBotPlayingStrategy(diff_level);
    }

    public Bot_Playing_Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Bot_Playing_Strategy strategy) {
        this.strategy = strategy;
    }

    public BOT_DIFF_LEVEL getLevel() {
        return level;
    }

    public void setLevel(BOT_DIFF_LEVEL level) {
        this.level = level;
    }
    @Override
    public Move makeMove(Board board){
        Move move =strategy.makeMove(board);
        return move;
    }
}
