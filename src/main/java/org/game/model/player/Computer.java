package org.game.model.player;

import org.game.enums.Symbol;
import org.game.model.choosestrategy.RandomChooseStrategy;

public class Computer extends Player {
    
    @Override
    public Symbol chooseSymbol() {
        return new RandomChooseStrategy().chooseSymbol();
    }
}
