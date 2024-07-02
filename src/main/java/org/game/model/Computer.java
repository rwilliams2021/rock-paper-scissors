package org.game.model;

import org.game.enums.Symbol;

import java.util.Random;

public class Computer implements Player {
    
    @Override
    public String getName() {
        return "Computer";
    }
    
    @Override
    public Symbol chooseSymbol() {
        Random random = new Random();
        Symbol[] symbols = Symbol.values();
        int index = random.nextInt(symbols.length);
        return symbols[index];
    }
}
