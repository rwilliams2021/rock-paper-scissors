package org.game.model;

import org.game.constants.Constants;
import org.game.enums.Symbol;
import org.game.utils.InputUtil;

public class User implements Player {
    
    private final String name;
    
    public User() {
        name = InputUtil.getUserInput(Constants.ENTER_NAME_MSG);
    }
    
    @Override
    public Symbol chooseSymbol() {
        Symbol userSymbol;
        do {
            String userChoice = InputUtil.getUserInput(Constants.CHOOSE_SYMBOL_MSG);
            userSymbol = Symbol.fromStringSymbol(userChoice.toLowerCase());
            if (userSymbol == null) {
                System.out.println(Constants.INVALID_SYMBOL_MSG);
            }
        } while (userSymbol == null);
        return userSymbol;
    }
    
    @Override
    public String getName() {
        return name;
    }
}
