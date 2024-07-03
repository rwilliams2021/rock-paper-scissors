package org.game.model.choosestrategy;

import org.game.constants.Constants;
import org.game.enums.Symbol;
import org.game.exceptions.QuitGameException;
import org.game.utils.InputProvider;

public class UserChooseStrategy implements ChooseStrategy {
    private InputProvider inputProvider;
    
    @Override
    public Symbol chooseSymbol() throws QuitGameException {
        String userChoice = inputProvider.getInput(Constants.CHOOSE_SYMBOL_MSG);
        if (userChoice.equalsIgnoreCase(Constants.QUIT)) {
            throw new QuitGameException("Game quit by user");
        }
        return Symbol.fromStringSymbol(userChoice.toLowerCase());
    }
}
