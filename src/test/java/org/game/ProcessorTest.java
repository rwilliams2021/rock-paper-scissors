package org.game;

import org.game.enums.Outcome;
import org.game.enums.Symbol;
import org.game.model.Processor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProcessorTest {
    
    @Test
    public void determineWinner() {
        assertEquals(Outcome.DRAW, Processor.getProcessor().determineWinner(Symbol.ROCK, Symbol.ROCK));
        assertEquals(Outcome.DRAW, Processor.getProcessor().determineWinner(Symbol.SCISSORS, Symbol.SCISSORS));
        assertEquals(Outcome.DRAW, Processor.getProcessor().determineWinner(Symbol.PAPER, Symbol.PAPER));
        assertEquals(Outcome.USER_WIN, Processor.getProcessor().determineWinner(Symbol.ROCK, Symbol.SCISSORS));
        assertEquals(Outcome.USER_WIN, Processor.getProcessor().determineWinner(Symbol.SCISSORS, Symbol.PAPER));
        assertEquals(Outcome.USER_WIN, Processor.getProcessor().determineWinner(Symbol.PAPER, Symbol.ROCK));
        assertEquals(Outcome.COMPUTER_WIN, Processor.getProcessor().determineWinner(Symbol.ROCK, Symbol.PAPER));
        assertEquals(Outcome.COMPUTER_WIN, Processor.getProcessor().determineWinner(Symbol.SCISSORS, Symbol.ROCK));
        assertEquals(Outcome.COMPUTER_WIN, Processor.getProcessor().determineWinner(Symbol.PAPER, Symbol.SCISSORS));
    }
}
