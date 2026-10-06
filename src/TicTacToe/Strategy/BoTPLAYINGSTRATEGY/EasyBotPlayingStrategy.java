package TicTacToe.Strategy.BoTPLAYINGSTRATEGY;

import TicTacToe.ENUMS.CellState;
import TicTacToe.Entity.Board;
import TicTacToe.Entity.Cell;
import TicTacToe.Entity.Move;

import java.util.List;

public class EasyBotPlayingStrategy implements Bot_Playing_Strategy {


    @Override
    public Move makeMove(Board board) {
        for(List<Cell> cells: board.getCell()){
            for(Cell cell: cells){
                if(cell.getState()== CellState.IS_EMPTY) {
                    return new Move(null,cell);
                }
            }
        }
        return null;
    }
}
