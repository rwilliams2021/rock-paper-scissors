package org.game.enums;


public enum HandSymbol {
    PAPER("paper"),
    SCISSORS("scissors"),
    ROCK("rock");

    private final String symbol;

    HandSymbol(String symbol) {
        this.symbol = symbol;
    }
    
    public String getSymbol() {
        return symbol;
    }
    
    public static HandSymbol fromStringSymbol(String stringSymbol) {
        for (HandSymbol handSymbol : values()) {
            if (handSymbol.getSymbol().equalsIgnoreCase(stringSymbol)) {
                return handSymbol;
            }
        }
        return null;
    }
}
