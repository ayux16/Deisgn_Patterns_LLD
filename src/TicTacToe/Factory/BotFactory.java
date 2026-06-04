package TicTacToe.Factory;

import TicTacToe.ENUMS.BOT_DIFF_LEVEL;
import TicTacToe.Entity.Bot;
import TicTacToe.Strategy.BoTPLAYINGSTRATEGY.*;
public class BotFactory {
        public static Bot_Playing_Strategy getBotPlayingStrategy(BOT_DIFF_LEVEL botDiff) {
            if(botDiff.equals(BOT_DIFF_LEVEL.EASY)){
                return new EasyBotPlayingStrategy();
            }else if(botDiff.equals(BOT_DIFF_LEVEL.MEDIUM)){
                return new MediumBotPlayingStrategy();
            }else
                return new HardBotPlayingStrategy();
        }
}
