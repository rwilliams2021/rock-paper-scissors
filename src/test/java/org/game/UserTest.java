package org.game;

import org.game.constants.MessageConstants;
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

/**
 * Unit tests for the User class, which represents a human player in the game.
 */
public class UserTest {
    public static final String USER_NAME = "TestUser";
    private final InputProvider inputProvider = mock(InputProvider.class);
    private User user;
    
    @BeforeEach
    public void setUp() {
        when(inputProvider.getInput(MessageConstants.ENTER_NAME_MSG)).thenReturn(USER_NAME);
        user = new User();
    }
    
    /**
     * Tests that the User class correctly chooses a symbol when provided with valid input.
     */
    @Test
    public void testChooseSymbol() {
        when(inputProvider.getInput(anyString())).thenReturn(Symbol.ROCK.name());
        Symbol symbol = user.chooseSymbol();
        assertEquals(Symbol.ROCK, symbol);
    }
    
    /**
     * Tests that the User class correctly handles the user choosing to quit.
     * Ensures that chooseSymbol returns null when the user inputs the quit command.
     */
    @Test
    public void testUserQuits() {
        when(inputProvider.getInput(anyString())).thenReturn(MessageConstants.QUIT);
        assertNull(user.chooseSymbol());
    }
}
