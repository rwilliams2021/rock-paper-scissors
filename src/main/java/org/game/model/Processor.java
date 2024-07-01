package org.game.model;

import org.game.enums.HandSymbol;
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
    
    public Outcome getWinner(HandSymbol userSymbol, HandSymbol computerSymbol) {
        if (userSymbol == computerSymbol) {
            return Outcome.DRAW;
        }
        if (userSymbol == HandSymbol.ROCK && computerSymbol == HandSymbol.SCISSORS
                || userSymbol == HandSymbol.PAPER && computerSymbol == HandSymbol.ROCK
                || userSymbol == HandSymbol.SCISSORS && computerSymbol == HandSymbol.PAPER) {
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
