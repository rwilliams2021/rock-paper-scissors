package org.game.enums;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


/**
 * Unit tests for the Symbol enum.
 */
public class SymbolTest {
    
    public static final String ROCK = "rock";
    public static final String SCISSORS = "scissors";
    public static final String PAPER = "paper";
    public static final String INVALID_SYMBOL = "invalid";
    
    /**
     * Tests that valid string representations of symbols are correctly
     * converted to their corresponding Symbol enum values.
     *
     * @param symbol The string representation of the symbol.
     */
    @ParameterizedTest
    @ValueSource(strings = {ROCK, SCISSORS, PAPER})
    public void testFromStringSymbolValid(String symbol) {
        assertEquals(Symbol.valueOf(symbol.toUpperCase()), Symbol.fromStringSymbol(symbol));
    }
    
    /**
     * Tests that invalid string representations of symbols are correctly
     * handled and result in a null value.
     *
     * @param strSymbol The string representation of the symbol.
     */
    @ParameterizedTest
    @ValueSource(strings = {INVALID_SYMBOL, ""})
    public void testFromStringSymbolInvalid(String strSymbol) {
        Symbol symbol = Symbol.fromStringSymbol(strSymbol);
        assertNull(symbol);
    }
    
    /**
     * Tests that fromStringSymbol returns null when given a null input.
     */
    @Test
    public void testFromStringSymbolNull() {
        Symbol symbol = Symbol.fromStringSymbol(null);
        assertNull(symbol);
    }
}
