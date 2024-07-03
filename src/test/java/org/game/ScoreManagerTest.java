package org.game;

import org.game.enums.Outcome;
import org.game.model.Computer;
import org.game.model.Player;
import org.game.model.ScoreManager;
import org.game.model.User;
import org.game.utils.ScannerInputProvider;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScoreManagerTest {
    public static final String USER_NAME = "SomeName";
    private final ScoreManager scoreManager = new ScoreManager();
    private final Player user = new User(USER_NAME, new ScannerInputProvider(new Scanner(System.in)));
    private final Player computer = new Computer();

    @Test
    public void testUpdateScore() {
        scoreManager.updateScore(Outcome.DRAW, computer, user);
        assertEquals(0, user.getWins());
        assertEquals(0, computer.getWins());

        scoreManager.updateScore(Outcome.USER_WIN, computer, user);
        assertEquals(1, user.getWins());
        assertEquals(0, computer.getWins());

        scoreManager.updateScore(Outcome.COMPUTER_WIN, computer, user);
        assertEquals(1, user.getWins());
        assertEquals(1, computer.getWins());
    }
}
