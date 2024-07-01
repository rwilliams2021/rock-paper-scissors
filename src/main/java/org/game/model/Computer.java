package org.game.model;

import org.game.enums.HandSymbol;

import java.util.Random;

public class Computer {
    public HandSymbol generateRandomSymbol() {
        Random random = new Random();
        HandSymbol[] symbols = HandSymbol.values();
        int index = random.nextInt(symbols.length);
        return symbols[index];
    }
}
