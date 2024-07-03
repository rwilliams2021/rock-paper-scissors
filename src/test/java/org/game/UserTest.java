package org.game;

import org.game.constants.Constants;
import org.game.enums.Symbol;
import org.game.model.User;
import org.game.utils.InputProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserTest {
    public static final String INVALID_SYMBOL = "invalid";
    private User user;
    private InputProvider inputProvider;
    
    @BeforeEach
    public void setUp() {
        inputProvider = mock(InputProvider.class);
        user = new User(inputProvider);
    }
    
    @Test
    public void testChooseSymbol() {
        when(inputProvider.getInput(anyString())).thenReturn(Symbol.ROCK.name());
        Symbol symbol = user.chooseSymbol();
        assertEquals(Symbol.ROCK, symbol);
    }
    
    @Test
    public void testChooseSymbolInvalid() {
        when(inputProvider.getInput(anyString())).thenReturn(INVALID_SYMBOL);
        Symbol symbol = user.chooseSymbol();
        assertNull(symbol);
    }
}
