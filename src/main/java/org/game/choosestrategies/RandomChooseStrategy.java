package org.game.choosestrategies;

import org.game.enums.Symbol;

import java.util.Random;

/**
 * Strategy for randomly choosing a symbol for the computer player.
 */
public class RandomChooseStrategy implements ChooseStrategy {
    
    @Override
    public Symbol chooseSymbol() {
        Random random = new Random();
        Symbol[] symbols = Symbol.values();
        int index = random.nextInt(symbols.length);
        return symbols[index];
    }
}
