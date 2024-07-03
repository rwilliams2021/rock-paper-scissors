package org.game.enums;

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
    @ValueSource(strings = {ROCK, SCISSORS, PAPER})
    public void testFromStringSymbolValid(String symbol) {
        assertEquals(Symbol.valueOf(symbol.toUpperCase()), Symbol.fromStringSymbol(symbol));
    }

    @ParameterizedTest
    @ValueSource(strings = {INVALID_SYMBOL, ""})
    public void testFromStringSymbolInvalid(String strSymbol) {
        Symbol symbol = Symbol.fromStringSymbol(strSymbol);
        assertNull(symbol);
    }
}
