package org.game;

import org.game.constants.Constants;
import org.game.constants.MessageConstants;
import org.game.enums.Outcome;
import org.game.model.player.Computer;
import org.game.model.player.Player;
import org.game.model.ScoreManager;
import org.game.model.player.User;
import org.game.view.InputProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ScoreManagerTest {
    public static final String USER_NAME = "SomeName";
    private ScoreManager scoreManager;
    private Player user;
    private Player computer;
    
    @BeforeEach
    public void setUp() {
        scoreManager = new ScoreManager();
        computer = new Computer();
        InputProvider inputProvider = mock(InputProvider.class);
        when(inputProvider.getInput(MessageConstants.ENTER_NAME_MSG)).thenReturn(USER_NAME);
        user = new User(inputProvider);
    }
    
    @Test
    public void testUpdateScoreDraw() {
        scoreManager.updateScore(Outcome.DRAW, computer, user);
        assertEquals(0, user.getWins());
        assertEquals(0, computer.getWins());
    }
    
    @Test
    public void testUpdateScoreUserWins() {
        scoreManager.updateScore(Outcome.USER_WIN, computer, user);
        assertEquals(1, user.getWins());
        assertEquals(0, computer.getWins());
    }
    
    @Test
    public void testUpdateScoreComputerWins() {
        scoreManager.updateScore(Outcome.COMPUTER_WIN, computer, user);
        assertEquals(0, user.getWins());
        assertEquals(1, computer.getWins());
    }
}
