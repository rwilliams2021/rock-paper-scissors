package org.game.enums;

/**
 * Enum representing the possible symbols in Rock-Paper-Scissors.
 */
public enum Symbol {
    PAPER("paper", "wraps"),
    SCISSORS("scissors", "cuts"),
    ROCK("rock", "blunts");

    private final String symbol;
    private final String winAction;
    
    /**
     * Constructor to set the symbol and its win action.
     * @param symbol The string representation of the symbol.
     * @param winAction The action this symbol performs when it wins.
     */
    Symbol(String symbol, String winAction) {
        this.symbol = symbol;
        this.winAction = winAction;
    }
    
    public String getSymbol() {
        return symbol;
    }
    
    /**
     * Converts a string to a corresponding Symbol enum.
     * @param stringSymbol The string representation of the symbol.
     * @return The corresponding Symbol, or null if no match is found.
     */
    public static Symbol fromStringSymbol(String stringSymbol) {
        for (Symbol handSymbol : values()) {
            if (handSymbol.getSymbol().equalsIgnoreCase(stringSymbol)) {
                return handSymbol;
            }
        }
        return null;
    }
    
    public static String getWinAction(Symbol symbol) {
        return symbol.winAction;
    }
}
