package org.game.enums;

import org.game.constants.SymbolConstants;

/**
 * Enum representing the possible symbols in Rock-Paper-Scissors.
 */
public enum Symbol {
    PAPER(SymbolConstants.PAPER, SymbolConstants.PAPER_WIN_ACTION),
    SCISSORS(SymbolConstants.SCISSORS, SymbolConstants.SCISSORS_WIN_ACTION),
    ROCK(SymbolConstants.ROCK, SymbolConstants.ROCK_WIN_ACTION);

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
