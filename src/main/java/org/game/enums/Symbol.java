package org.game.enums;

public enum Symbol {
    PAPER("paper", "wraps"),
    SCISSORS("scissors", "cuts"),
    ROCK("rock", "blunts");

    private final String symbol;
    private final String winAction;

    Symbol(String symbol, String winAction) {
        this.symbol = symbol;
        this.winAction = winAction;
    }
    
    public String getSymbol() {
        return symbol;
    }
    
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
