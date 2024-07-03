package org.game.model.choosestrategy;

import org.game.enums.Symbol;
import org.game.exceptions.QuitGameException;

public interface ChooseStrategy {
    Symbol chooseSymbol() throws QuitGameException;
}
