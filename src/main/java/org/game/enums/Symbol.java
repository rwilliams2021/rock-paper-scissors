package org.game.enums;


public enum Symbol {
    PAPER("paper"),
    SCISSORS("scissors"),
    ROCK("rock");

    private final String symbol;

    Symbol(String symbol) {
        this.symbol = symbol;
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
}
