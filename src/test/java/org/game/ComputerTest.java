package org.game;

import org.game.enums.Symbol;
import org.game.model.player.Computer;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;


/**
 * Unit tests for the Computer player.
 */
public class ComputerTest {
    private final Computer computer = new Computer();
    
    /**
     * Tests that the Computer player chooses a valid symbol.
     * The chosen symbol must be one of the defined Symbol enum values.
     */
    @Test
    public void testChooseSymbol() {
        Symbol computerSymbol = computer.chooseSymbol();
        List<Symbol> symbols = List.of(Symbol.values());
        assertTrue(symbols.contains(computerSymbol));
    }
}
