package org.game;

import org.game.constants.MessageConstants;
import org.game.enums.Outcome;
import org.game.model.ScoreManager;
import org.game.model.player.Computer;
import org.game.model.player.Player;
import org.game.model.player.User;
import org.game.view.InputProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Unit tests for the ScoreManager class, which manages the scores of the players.
 */
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
        user = new User();
    }
    
    /**
     * Tests that updateScore correctly handles a draw outcome.
     * Ensures that the scores of both the user and the computer remain unchanged.
     */
    @Test
    public void testUpdateScoreDraw() {
        scoreManager.updateScore(Outcome.DRAW, computer, user);
        assertEquals(0, user.getWins());
        assertEquals(0, computer.getWins());
    }
    
    /**
     * Tests that updateScore correctly increments the user's score when the user wins.
     */
    @Test
    public void testUpdateScoreUserWins() {
        scoreManager.updateScore(Outcome.USER_WIN, computer, user);
        assertEquals(1, user.getWins());
        assertEquals(0, computer.getWins());
    }
    
    /**
     * Tests that updateScore correctly increments the computer's score when the computer wins.
     */
    @Test
    public void testUpdateScoreComputerWins() {
        scoreManager.updateScore(Outcome.COMPUTER_WIN, computer, user);
        assertEquals(0, user.getWins());
        assertEquals(1, computer.getWins());
    }
}
