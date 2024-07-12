package org.game.model.player.factories;

import org.game.model.player.Player;
import org.game.model.player.User;

public class UserFactory implements PlayerFactory{

    @Override
    public Player createPlayer() {
        return new User();
    }
}
