package TicTacToe.Entity;

import TicTacToe.ENUMS.CellState;
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
    private int nextTurnIndex;
    private Player winner;
    private GAME_STATE gameState;
    private List<winningStrategy> winningStrategies;

    private Game(int size, List<Player> player, List<winningStrategy> winningStrategy){
        this.board = new Board(size);
        this.players = player;
        this.winningStrategies = winningStrategy;
        this.moves = new ArrayList<>();
        this.nextTurnIndex = 0;
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

        public List<Player> getPlayers() {
            return players;
        }

        public List<winningStrategy> getWinningStrategies() {
            return winningStrategies;
        }

        public int getSize() {
            return size;
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
    public Board getBoard() {
        return board;
    }
    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }
    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Move> getMoves() {
        return moves;
    }
    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public Player getWinner() {
        return winner;
    }
    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public GAME_STATE getGameState() {
        return gameState;
    }
    public void setGameState(GAME_STATE gameState) {
        this.gameState = gameState;
    }

    public int getNextTurnIndex() {
        return nextTurnIndex;
    }
    public void setNextTurnIndex(int nextTurnIndex) {
        this.nextTurnIndex = nextTurnIndex;
    }

    public List<winningStrategy> getWinningStrategies() {
        return winningStrategies;
    }
    public void setWinningStrategies(List<winningStrategy> winningStrategies) {
        this.winningStrategies = winningStrategies;
    }


    public void makeMove(){
        Player currentPlayer=players.get(nextTurnIndex);
        System.out.println("This is "+currentPlayer.getName()+" move");
        Move move=currentPlayer.makeMove(board);
        nextTurnIndex =(nextTurnIndex + 1) % players.size();
        //fill the cell in the board
        Cell cell=move.getCell();
        int row=cell.getRow();
        int col=cell.getCol();
        Cell currentCell=this.board.getCell().get(row).get(col);
        currentCell.setPlayer(currentPlayer);
        currentCell.setState(CellState.IS_FILLED);

        //save the move
        this.moves.add(move);

        //Check winner after every move.
        if(checkWinner(move)){
            this.winner=currentPlayer;
            this.gameState=GAME_STATE.SUCCESS;
        }
        else if(moves.size()==this.board.getSize()*this.board.getSize()){
            this.gameState=GAME_STATE.DRAW;
        }

    }
    private boolean checkWinner(Move move){
        for(winningStrategy winningStrategy: winningStrategies){
            if(winningStrategy.check(move,this.board)){
                return true;
            }
        }
        return false;
    }

}
