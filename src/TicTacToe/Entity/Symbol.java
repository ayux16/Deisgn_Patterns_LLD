package TicTacToe.Entity;

public class Symbol {
    private char symbol;

    public Symbol(char symbol) {
        this.symbol = symbol;
    }
    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return String.valueOf(symbol);
    }
}
