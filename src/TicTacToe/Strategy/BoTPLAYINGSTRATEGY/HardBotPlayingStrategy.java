package TicTacToe.Strategy.BoTPLAYINGSTRATEGY;

import TicTacToe.Entity.Board;
import TicTacToe.Entity.Cell;
import TicTacToe.Entity.Move;
import TicTacToe.ENUMS.CellState;

import java.util.List;

public class HardBotPlayingStrategy implements Bot_Playing_Strategy {

    @Override
    public Move makeMove(Board board) {

        int size = board.getSize();
        List<List<Cell>> cells = board.getCell();

        // 1. Center
        if (size % 2 == 1) {
            int center = size / 2;

            if (cells.get(center).get(center).getState() == CellState.IS_EMPTY) {
                return new Move(null, cells.get(center).get(center));
            }
        }

        // 2. Corners
        int[][] corners = {
                {0, 0},
                {0, size - 1},
                {size - 1, 0},
                {size - 1, size - 1}
        };

        for (int[] corner : corners) {
            int row = corner[0];
            int col = corner[1];

            if (cells.get(row).get(col).getState() == CellState.IS_EMPTY) {
                return new Move(null, cells.get(row).get(col));
            }
        }

        // 3. Any empty cell
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {

                if (cells.get(row).get(col).getState() == CellState.IS_EMPTY) {
                    return new Move(null, cells.get(row).get(col));
                }
            }
        }

        return null;
    }
}