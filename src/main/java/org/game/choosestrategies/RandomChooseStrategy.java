package org.game.choosestrategies;

import org.game.enums.Symbol;

import java.util.Random;

/**
 * Strategy for randomly choosing a symbol for the computer player.
 */
public class RandomChooseStrategy implements ChooseStrategy {
    
    private final Random random = new Random();
    
    @Override
    public Symbol chooseSymbol() {
        Symbol[] symbols = Symbol.values();
        int index = random.nextInt(symbols.length);
        return symbols[index];
    }
}
