package org.game.model.player;

import org.game.constants.Constants;
import org.game.enums.Symbol;
import org.game.exceptions.QuitGameException;
import org.game.model.choosestrategy.UserChooseStrategy;
import org.game.utils.InputProvider;

public class User extends Player {
    
    public User(InputProvider inputProvider) {
        name = inputProvider.getInput(Constants.ENTER_NAME_MSG);
    }
    
    @Override
    public Symbol chooseSymbol() throws QuitGameException {
        return new UserChooseStrategy().chooseSymbol();
    }
}
