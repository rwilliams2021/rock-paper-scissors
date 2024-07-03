package org.game.enums;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class SymbolTest {
    
    public static final String ROCK = "rock";
    public static final String SCISSORS = "scissors";
    public static final String PAPER = "paper";
    public static final String INVALID_SYMBOL = "invalid";
    
    @ParameterizedTest
    @ValueSource(strings = {"rock", "scissors", "paper"})
    public void testFromStringSymbolValid(String symbol) {
        assertEquals(Symbol.valueOf(symbol.toUpperCase()), Symbol.fromStringSymbol(symbol));
    }

    @Test
    public void testFromStringSymbolInvalid() {
        Symbol symbol = Symbol.fromStringSymbol(INVALID_SYMBOL);
        assertNull(symbol);
    }
}
