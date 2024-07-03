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
    
    public Outcome determineWinner(Symbol userSymbol, Symbol computerSymbol) {
        if (userSymbol == computerSymbol) {
            return Outcome.DRAW;
        }
        if (userSymbol == Symbol.ROCK && computerSymbol == Symbol.SCISSORS
                || userSymbol == Symbol.PAPER && computerSymbol == Symbol.ROCK
                || userSymbol == Symbol.SCISSORS && computerSymbol == Symbol.PAPER) {
            return Outcome.USER_WIN;
        }
        return Outcome.COMPUTER_WIN;
    }
    

}
