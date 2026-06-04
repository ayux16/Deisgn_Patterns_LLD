package TicTacToe.Strategy.WINNING_STRATEGY;

import TicTacToe.Entity.Board;
import TicTacToe.Entity.Cell;
import TicTacToe.Entity.Move;
import TicTacToe.Entity.Symbol;

import java.util.HashMap;
import java.util.Map;

public class Diagonal_winning_strategy implements winningStrategy {

    private final Map<Integer, Map<Symbol, Integer>> diagonalCounts = new HashMap<>();

    @Override
    public boolean check(Move move, Board board) {

        Cell cell = move.getCell();
        int row = cell.getRow();
        int col = cell.getCol();

        Symbol symbol = move.getPlayer().getSymbol();
        int size = board.getSize();

        boolean isWinner = false;

        // Main Diagonal
        if (row == col) {
            isWinner = updateCount(0, symbol, size);
        }

        // Anti Diagonal
        if (row + col == size - 1) {
            isWinner = isWinner || updateCount(1, symbol, size);
        }
        return isWinner;
    }

    private boolean updateCount(int diagonalType, Symbol symbol, int boardSize) {
        diagonalCounts.putIfAbsent(diagonalType, new HashMap<>());
        Map<Symbol, Integer> counts = diagonalCounts.get(diagonalType);
        counts.put(symbol, counts.getOrDefault(symbol, 0) + 1);
        return counts.get(symbol) == boardSize;
    }
}
