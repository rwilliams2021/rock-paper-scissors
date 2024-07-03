package org.game.model;

import org.game.enums.Symbol;

import java.util.Random;

public class Computer extends Player {
    
    @Override
    public Symbol chooseSymbol() {
        Random random = new Random();
        Symbol[] symbols = Symbol.values();
        int index = random.nextInt(symbols.length);
        return symbols[index];
    }
}
