package TicTacToe.Strategy.WINNING_STRATEGY;

import TicTacToe.Entity.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ROW_WINNING_STRATEGY implements winningStrategy {

    Map<Integer, Map<Symbol,Integer>> rowmap = new HashMap<>();
    @Override
    public boolean check(Move move, Board board) {
        Cell cell=move.getCell();
        int row=cell.getRow();
        Player player=move.getPlayer();
        Symbol symbol=player.getSymbol();
        if(!rowmap.containsKey(row)){
            rowmap.put(row,new HashMap<>());
        }
        Map<Symbol,Integer> rowCheck = rowmap.get(row);
        if(!rowCheck.containsKey(symbol)){
            rowCheck.put(symbol,0);
        }
        rowCheck.put(symbol,rowCheck.get(symbol)+1);
        int count=rowCheck.get(symbol);
        return count==board.getSize();
    }
}
