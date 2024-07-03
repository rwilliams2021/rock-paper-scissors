package org.game;

import org.game.constants.Constants;
import org.game.enums.Symbol;
import org.game.model.player.User;
import org.game.view.InputProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserTest {
    public static final String USER_NAME = "TestUser";
    private final InputProvider inputProvider = mock(InputProvider.class);
    private User user;
    
    @BeforeEach
    public void setUp() {
        when(inputProvider.getInput(Constants.ENTER_NAME_MSG)).thenReturn(USER_NAME);
        user = new User(inputProvider);
    }
    
    @Test
    public void testChooseSymbol() {
        when(inputProvider.getInput(anyString())).thenReturn(Symbol.ROCK.name());
        Symbol symbol = user.chooseSymbol();
        assertEquals(Symbol.ROCK, symbol);
    }
    
    @Test
    public void testUserQuits() {
        when(inputProvider.getInput(anyString())).thenReturn(Constants.QUIT);
        assertNull(user.chooseSymbol());
    }
}
