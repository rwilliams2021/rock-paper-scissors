package org.game.model.player;

import org.game.constants.Constants;
import org.game.utils.InputProvider;

public class PlayerFactory {
    public static Player createPlayer(String type, InputProvider inputProvider) {
        return switch (type) {
            case Constants.COMPUTER -> new Computer();
            case Constants.USER -> new User(inputProvider);
            default -> throw new IllegalArgumentException("Invalid player type");
        };
    }
}
