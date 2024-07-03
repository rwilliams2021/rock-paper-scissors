package org.game.enums;

import org.game.constants.Constants;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SymbolTest {
    
    public static final String ROCK = "rock";
    public static final String SCISSORS = "scissors";
    public static final String PAPER = "paper";
    public static final String INVALID_SYMBOL = "invalid";
    
    @Test
    public void testFromStringSymbol() {
        assertEquals(Symbol.ROCK, Symbol.fromStringSymbol(ROCK));
        assertEquals(Symbol.SCISSORS, Symbol.fromStringSymbol(SCISSORS));
        assertEquals(Symbol.PAPER, Symbol.fromStringSymbol(PAPER));
    }
    
    @Test
    public void testFromStringSymbolInvalid() {
        Symbol symbol = Symbol.fromStringSymbol(INVALID_SYMBOL);
        assertNull(symbol);
    }
}
