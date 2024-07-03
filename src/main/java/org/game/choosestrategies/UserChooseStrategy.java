package org.game.choosestrategies;

import org.game.constants.Constants;
import org.game.enums.Symbol;
import org.game.exceptions.QuitGameException;
import org.game.view.InputProvider;

public class UserChooseStrategy implements ChooseStrategy {
    private final InputProvider inputProvider;
    
    public UserChooseStrategy(InputProvider inputProvider) {
        this.inputProvider = inputProvider;
    }
    
    
    @Override
    public Symbol chooseSymbol() throws QuitGameException {
        String userChoice = inputProvider.getInput(Constants.CHOOSE_SYMBOL_MSG);
        if (userChoice.equalsIgnoreCase(Constants.QUIT)) {
            throw new QuitGameException(Constants.GAME_QUIT);
        }
        return Symbol.fromStringSymbol(userChoice.toLowerCase());
    }
}
