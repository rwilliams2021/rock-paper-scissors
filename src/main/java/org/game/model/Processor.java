package org.game.model;

import org.game.enums.Symbol;
import org.game.enums.Outcome;

/**
 * Class responsible for determining the winner of a round.
 */
public class Processor {
    
    /**
     * Determines the outcome of a round based on the chosen symbols.
     * @param userSymbol The user's chosen symbol.
     * @param computerSymbol The computer's chosen symbol.
     * @return The outcome of the round.
     */
    public Outcome determineWinner(Symbol userSymbol, Symbol computerSymbol) {
        if (userSymbol == null || computerSymbol == null) {
            return null;
        }
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
