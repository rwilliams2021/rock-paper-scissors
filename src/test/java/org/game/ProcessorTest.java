package org.game;

import org.game.enums.Outcome;
import org.game.enums.Symbol;
import org.game.model.Processor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * Unit tests for the Processor class, which determines the outcome of the game rounds.
 */
public class ProcessorTest {
    private Processor processor;
    
    @BeforeEach
    public void setUp() {
        processor = new Processor();
    }
    
    /**
     * Tests that determineWinner correctly identifies a draw outcome.
     */
    @Test
    public void testDetermineWinnerDraw() {
        assertEquals(Outcome.DRAW, processor.determineWinner(Symbol.ROCK, Symbol.ROCK));
        assertEquals(Outcome.DRAW, processor.determineWinner(Symbol.SCISSORS, Symbol.SCISSORS));
        assertEquals(Outcome.DRAW, processor.determineWinner(Symbol.PAPER, Symbol.PAPER));
    }
    
    /**
     * Tests that determineWinner correctly identifies when the user wins.
     */
    @Test
    public void testDetermineWinnerUserWins() {
        assertEquals(Outcome.USER_WIN, processor.determineWinner(Symbol.ROCK, Symbol.SCISSORS));
        assertEquals(Outcome.USER_WIN, processor.determineWinner(Symbol.SCISSORS, Symbol.PAPER));
        assertEquals(Outcome.USER_WIN, processor.determineWinner(Symbol.PAPER, Symbol.ROCK));
    }
    
    /**
     * Tests that determineWinner correctly identifies when the computer wins.
     */
    @Test
    public void testDetermineWinnerComputerWins() {
        assertEquals(Outcome.COMPUTER_WIN, processor.determineWinner(Symbol.ROCK, Symbol.PAPER));
        assertEquals(Outcome.COMPUTER_WIN, processor.determineWinner(Symbol.SCISSORS, Symbol.ROCK));
        assertEquals(Outcome.COMPUTER_WIN, processor.determineWinner(Symbol.PAPER, Symbol.SCISSORS));
    }
    
    /**
     * Tests that determineWinner correctly handles null inputs.
     */
    @Test
    public void testDetermineWinnerNullInputs() {
        assertNull(processor.determineWinner(null, Symbol.ROCK));
        assertNull(processor.determineWinner(Symbol.ROCK, null));
        assertNull(processor.determineWinner(null, null));
    }
}
