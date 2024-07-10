package org.game.choosestrategies;

import org.game.constants.MessageConstants;
import org.game.enums.Symbol;
import org.game.view.InputProvider;

/**
 * Strategy for allowing the user to choose a symbol.
 */
public class UserChooseStrategy implements ChooseStrategy {
    private final InputProvider inputProvider;
    
    public UserChooseStrategy(InputProvider inputProvider) {
        this.inputProvider = inputProvider;
    }
    
    
    @Override
    public Symbol chooseSymbol() {
        Symbol userSymbol = null;
        while (userSymbol == null) {
            String userChoice = inputProvider.getInput(MessageConstants.CHOOSE_SYMBOL_MSG).trim();
            if (userChoice.equalsIgnoreCase(MessageConstants.QUIT)) {
                return null;
            }
            userSymbol = Symbol.fromStringSymbol(userChoice.toLowerCase());
            if (userSymbol == null) {
                System.out.println(MessageConstants.INVALID_SYMBOL_MSG);
            }
        }
        return userSymbol;
    }
}
