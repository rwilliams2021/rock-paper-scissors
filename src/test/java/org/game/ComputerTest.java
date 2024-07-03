package org.game;

import org.game.enums.Symbol;
import org.game.model.Computer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ComputerTest {
    private final Computer computer = new Computer();
    
    @Test
    public void testChooseSymbol() {
        Symbol computerSymbol = computer.chooseSymbol();
        List<Symbol> symbols = List.of(Symbol.values());
        assertTrue(symbols.contains(computerSymbol));
    }
}
