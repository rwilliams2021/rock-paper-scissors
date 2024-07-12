package org.game;

import org.game.constants.MessageConstants;
import org.game.enums.Outcome;
import org.game.enums.Symbol;
import org.game.model.Game;
import org.game.model.Processor;
import org.game.model.ScoreManager;
import org.game.model.player.Player;
import org.game.model.player.User;
import org.game.view.InputProvider;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Unit tests for the Game class using Mockito for mocking dependencies.
 */
@ExtendWith(MockitoExtension.class)
public class GameTest {
    
    public static final String USER_NAME = "TestUser";
    public static final String THREE_ROUNDS = "3";
    public static final String INVALID_INPUT_ROUNDS = "invalid";
    public static final String ZERO_ROUNDS = "0";
    public static final String VALID_ROUNDS = "2";
    public static final String ONE_ROUND = "1";
    @Mock
    private InputProvider inputProvider;
    
    @Mock
    private Player computer;
    
    @Mock
    private User user;
    
    @Mock
    private Processor processor;
    
    @Mock
    private ScoreManager scoreManager;
    
    @InjectMocks
    private Game game;
    
    @BeforeEach
    void setUp() {
        game = new Game(inputProvider, computer, user, processor, scoreManager);
    }
    
    /**
     * Tests the getNumberOfRounds method for valid input.
     */
    @Test
    void testGetNumberOfRounds() {
        when(inputProvider.getInput(anyString())).thenReturn(THREE_ROUNDS);
        int rounds = game.getNumberOfRounds();
        assertEquals(3, rounds);
    }
    
    /**
     * Tests the getNumberOfRounds method for invalid inputs. Ensures that the method prompts the user until a valid input is
     * provided.
     */
    @Test
    void testGetNumberOfRoundsWithInvalidInput() {
        when(inputProvider.getInput(anyString())).thenReturn(INVALID_INPUT_ROUNDS, ZERO_ROUNDS, VALID_ROUNDS);
        int rounds = game.getNumberOfRounds();
        assertEquals(2, rounds);
        verify(inputProvider, times(3)).getInput(MessageConstants.NUMBER_OF_GAMES_MSG);
    }
    
    /**
     * Tests the playRound method. Ensures that the user and computer choose symbols, the processor determines the winner, and the
     * scoreManager updates the score.
     */
    @Test
    void testPlayRound() {
        when(user.chooseSymbol()).thenReturn(Symbol.ROCK);
        when(computer.chooseSymbol()).thenReturn(Symbol.SCISSORS);
        when(processor.determineWinner(Symbol.ROCK, Symbol.SCISSORS)).thenReturn(Outcome.USER_WIN);
        
        game.playRound();
        
        verify(user, times(1)).chooseSymbol();
        verify(computer, times(1)).chooseSymbol();
        verify(processor, times(1)).determineWinner(Symbol.ROCK, Symbol.SCISSORS);
        verify(scoreManager, times(1)).updateScore(Outcome.USER_WIN, computer, user);
    }
    
    /**
     * Tests the play method. Ensures that the game plays the specified number of rounds.
     */
    @Test
    void testPlay() {
        when(user.getName()).thenReturn(USER_NAME);
        when(inputProvider.getInput(anyString())).thenReturn(ONE_ROUND);
        when(user.chooseSymbol()).thenReturn(Symbol.ROCK);
        when(computer.chooseSymbol()).thenReturn(Symbol.SCISSORS);
        when(processor.determineWinner(Symbol.ROCK, Symbol.SCISSORS)).thenReturn(Outcome.USER_WIN);
        
        game.play();
        
        verify(inputProvider, times(1)).getInput(MessageConstants.NUMBER_OF_GAMES_MSG);
        verify(user, times(1)).chooseSymbol();
        verify(computer, times(1)).chooseSymbol();
        verify(processor, times(1)).determineWinner(Symbol.ROCK, Symbol.SCISSORS);
        verify(scoreManager, times(1)).updateScore(Outcome.USER_WIN, computer, user);
    }
    
    /**
     * Tests the behavior of the play method for multiple rounds.
     */
    @Test
    void testPlayMultipleRounds() {
        when(user.getName()).thenReturn(USER_NAME);
        when(inputProvider.getInput(anyString())).thenReturn(THREE_ROUNDS);
        when(user.chooseSymbol()).thenReturn(Symbol.ROCK);
        when(computer.chooseSymbol()).thenReturn(Symbol.SCISSORS);
        when(processor.determineWinner(Symbol.ROCK, Symbol.SCISSORS)).thenReturn(Outcome.USER_WIN);
        
        game.play();
        
        // Verify that the game plays three rounds
        verify(inputProvider, times(1)).getInput(MessageConstants.NUMBER_OF_GAMES_MSG);
        verify(user, times(3)).chooseSymbol();
        verify(computer, times(3)).chooseSymbol();
        verify(processor, times(3)).determineWinner(Symbol.ROCK, Symbol.SCISSORS);
        verify(scoreManager, times(3)).updateScore(Outcome.USER_WIN, computer, user);
    }
    
    /**
     * Tests the initialiseUser method. Ensures that the input provider and user's name are set correctly.
     */
    @Test
    void testInitialiseUser() {
        when(inputProvider.getInput(MessageConstants.ENTER_NAME_MSG)).thenReturn(USER_NAME);
        
        game.initialiseUser();
        
        verify(user, times(1)).setInputProvider(inputProvider);
        verify(user, times(1)).setName(USER_NAME);
    }
    
    /**
     * Tests the initialiseUser method with an invalid player type.
     */
    @Test
    void testInitialiseUserWithInvalidPlayerType() {
        Player invalidPlayer = mock(Player.class);
        
        Game invalidGame = new Game(inputProvider, computer, invalidPlayer, processor, scoreManager);
        
        IllegalArgumentException exception =
                Assertions.assertThrows(IllegalArgumentException.class, invalidGame::initialiseUser);
        
        assertEquals(MessageConstants.INVALID_PLAYER_TYPE_MSG + invalidPlayer.getClass(), exception.getMessage());
    }
}
