package org.game.model.choosestrategy;

import org.game.enums.Symbol;

import java.util.Random;

public class RandomChooseStrategy implements ChooseStrategy {
    
    @Override
    public Symbol chooseSymbol() {
        Random random = new Random();
        Symbol[] symbols = Symbol.values();
        int index = random.nextInt(symbols.length);
        return symbols[index];
    }
}
