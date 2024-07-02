package org.game.model;

import org.game.enums.Symbol;
import org.game.enums.Outcome;

public class Processor {
    private static final Processor processor = new Processor();
    
    private Processor() {
    }
    
    public static Processor getProcessor() {
        return processor;
    }
    private int userWins = 0;
    private int computerWins = 0;
    
    public Outcome getWinner(Symbol userSymbol, Symbol computerSymbol) {
        if (userSymbol == computerSymbol) {
            return Outcome.DRAW;
        }
        if (userSymbol == Symbol.ROCK && computerSymbol == Symbol.SCISSORS
                || userSymbol == Symbol.PAPER && computerSymbol == Symbol.ROCK
                || userSymbol == Symbol.SCISSORS && computerSymbol == Symbol.PAPER) {
            userWins++;
            return Outcome.USER_WIN;
        }
        computerWins++;
        return Outcome.COMPUTER_WIN;
    }
    
    public String getScoreUpdate() {
        return "Your score: " + userWins + "\n" + "Computer score: " + computerWins;
    }
}
