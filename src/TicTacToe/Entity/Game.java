package TicTacToe.Entity;

import TicTacToe.ENUMS.CELL_STATE;
import TicTacToe.ENUMS.GAME_STATE;
import TicTacToe.ENUMS.PLAYER_TYPE;
import TicTacToe.Exceptions.InvalidBotCountException;
import TicTacToe.Exceptions.InvalidPlayerCountException;
import TicTacToe.Strategy.WINNING_STRATEGY.winningStrategy;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Board board;
    private List<Player> players;
    private List<Move> moves;
    private int currentPlayer;
    private Player winner;
    private GAME_STATE gameState;
    private List<winningStrategy> winningStrategies;

    private Game(int size, List<Player> player, List<winningStrategy> winningStrategy){
        this.board = new Board(size);
        this.players = player;
        this.winningStrategies = winningStrategy;
        this.moves = new ArrayList<Move>();
        this.currentPlayer = 0;
        this.winner = null;
        this.gameState = GAME_STATE.IN_PROGRESS;
    }
    public static GameBuilder getBuilder(){
        return new GameBuilder();
    }
    public static class GameBuilder{
        private List<Player> players;
        private List<winningStrategy> winningStrategies;
        private int size;
        public GameBuilder setPlayers(List<Player> players){
            this.players = players;
            return this;
        }
        public GameBuilder setWinningStrategies(List<winningStrategy> winningStrategies){
            this.winningStrategies = winningStrategies;
            return this;
        }
        public GameBuilder setSize(int size){
            this.size = size;
            return this;
        }
        private void validateBotCount() throws InvalidBotCountException {
            int botCount = 0;
            for(Player player : players){
                if(player.getPlayerType() == PLAYER_TYPE.BOT){
                    botCount++;
                }
            }
            if(botCount > 1){
                throw new InvalidBotCountException("Count of BOTs are greater than 1");
            }
        }

        private void validatePlayerCount() throws InvalidPlayerCountException {
            if(players.size() != size - 1){
                throw new InvalidPlayerCountException("Player count is invalid");
            }
        }

        private void validateUniqueSymbolsForEachPlayers(){

        }
        private void validate() throws InvalidBotCountException, InvalidPlayerCountException{
            validateBotCount();
            validateUniqueSymbolsForEachPlayers();
            validatePlayerCount();
        }
        public Game build() throws InvalidBotCountException {
            validate();
            return new Game(size, players, winningStrategies);
        }

    }
    public boolean isValid(Move move){
        Cell cell= move.getCell();
        int row= cell.getRow();
        int col= cell.getCol();
        if(row<0 || col<0 || row>=board.getSize() || col>=board.getSize()){
            return false;
        }
        else if(board.getBoard().get(row).get(col).getState() == CELL_STATE.IS_FILLED){
            return false;
        }
        return true;

    }
    public void makeMove(){
       Player playerToMakeMove= players.get(currentPlayer);
       Move move=playerToMakeMove.makeMove(board);
       if(!isValid(move)){
           throw new IllegalArgumentException("Invalid Move");
       }
       int row=move.getCell().getRow();
       int col=move.getCell().getCol();
       Cell cell= board.getBoard().get(row).get(col);
       cell.setPlayer(playerToMakeMove);
       cell.setState(CELL_STATE.IS_FILLED);
       Move finalMove= new Move(playerToMakeMove, cell);
       moves.add(finalMove);
       currentPlayer= (currentPlayer + 1) % players.size();

       if(checkWinner(finalMove)){
           winner= playerToMakeMove;
           gameState= GAME_STATE.SUCCESS;
       }
       else if(moves.size() == board.getSize() * board.getSize()){
           gameState= GAME_STATE.DRAW;
       }
    }
    private boolean checkWinner(Move move){
        for(winningStrategy winningStrategy: winningStrategies){
            if(winningStrategy.check(move,board)){
                return true;
            }
        }
        return false;
    }

    public Board getBoard() {
        return board;
    }


    public List<Player> getPlayers() {
        return players;
    }


    public List<Move> getMoves() {
        return moves;
    }


    public int getCurrentPlayer() {
        return currentPlayer;
    }


    public Player getWinner() {
        return winner;
    }


    public GAME_STATE getGameState() {
        return gameState;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public void setCurrentPlayer(int currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public void setGameState(GAME_STATE gameState) {
        this.gameState = gameState;
    }
}
