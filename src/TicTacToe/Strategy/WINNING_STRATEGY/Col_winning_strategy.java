package TicTacToe.Strategy.WINNING_STRATEGY;

import TicTacToe.Entity.*;

import java.util.HashMap;
import java.util.Map;

public class Col_winning_strategy implements winningStrategy {

    Map<Integer, Map<Symbol,Integer>> colmap=new HashMap<>();
    @Override
    public boolean check(Move move, Board board) {
        Cell cell=move.getCell();
        int col=cell.getCol();
        Player player=cell.getPlayer();
        Symbol symbol=player.getSymbol();

        if(!colmap.containsKey(col)){
            colmap.put(col,new HashMap<>());
        }
        Map<Symbol,Integer> colCheck = colmap.get(col);
        if(!colCheck.containsKey(symbol)){
            colCheck.put(symbol,0);
        }
        colCheck.put(symbol,colCheck.get(symbol)+1);
        int count=colCheck.get(symbol);
       return count==board.getSize();
    }
}
