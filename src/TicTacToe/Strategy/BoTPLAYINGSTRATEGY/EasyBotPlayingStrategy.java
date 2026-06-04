package TicTacToe.Strategy.BoTPLAYINGSTRATEGY;

import TicTacToe.ENUMS.CELL_STATE;
import TicTacToe.Entity.Board;
import TicTacToe.Entity.Bot;
import TicTacToe.Entity.Cell;
import TicTacToe.Entity.Move;

import java.util.List;

public class EasyBotPlayingStrategy implements Bot_Playing_Strategy {


    @Override
    public Move makeMove(Board board) {
        for(List<Cell> cells: board.getBoard()){
            for(Cell cell: cells){
                if(cell.getState()== CELL_STATE.IS_EMPTY) {
                    return new Move(null,cell);
                }
            }
        }
        return null;
    }
}
