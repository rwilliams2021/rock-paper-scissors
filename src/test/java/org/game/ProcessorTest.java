package org.game;

import org.game.enums.Outcome;
import org.game.enums.Symbol;
import org.game.model.Processor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProcessorTest {
    private Processor processor;
    
    @BeforeEach
    public void setUp() {
        processor = new Processor();
    }
    
    @Test
    public void testDetermineWinnerDraw() {
        assertEquals(Outcome.DRAW, processor.determineWinner(Symbol.ROCK, Symbol.ROCK));
        assertEquals(Outcome.DRAW, processor.determineWinner(Symbol.SCISSORS, Symbol.SCISSORS));
        assertEquals(Outcome.DRAW, processor.determineWinner(Symbol.PAPER, Symbol.PAPER));
    }
    
    @Test
    public void testDetermineWinnerUserWins() {
        assertEquals(Outcome.USER_WIN, processor.determineWinner(Symbol.ROCK, Symbol.SCISSORS));
        assertEquals(Outcome.USER_WIN, processor.determineWinner(Symbol.SCISSORS, Symbol.PAPER));
        assertEquals(Outcome.USER_WIN, processor.determineWinner(Symbol.PAPER, Symbol.ROCK));
    }
    
    @Test
    public void testDetermineWinnerComputerWins() {
        assertEquals(Outcome.COMPUTER_WIN, processor.determineWinner(Symbol.ROCK, Symbol.PAPER));
        assertEquals(Outcome.COMPUTER_WIN, processor.determineWinner(Symbol.SCISSORS, Symbol.ROCK));
        assertEquals(Outcome.COMPUTER_WIN, processor.determineWinner(Symbol.PAPER, Symbol.SCISSORS));
    }
}
