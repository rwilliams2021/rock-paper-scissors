package org.game.enums;

import org.game.constants.Constants;

public enum Symbol {
    PAPER(Constants.PAPER, Constants.PAPER_WIN_ACTION),
    SCISSORS(Constants.SCISSORS, Constants.SCISSORS_WIN_ACTION),
    ROCK(Constants.ROCK, Constants.ROCK_WIN_ACTION);

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
