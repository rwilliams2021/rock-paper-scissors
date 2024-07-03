package org.game;

import org.game.model.Game;
import org.game.model.Player;
import org.game.model.Processor;
import org.game.model.ScoreManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.game.enums.Symbol;
import org.game.enums.Outcome;
import org.game.constants.Constants;
import org.game.exceptions.QuitGameException;
import org.game.utils.InputProvider;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class GameTest {
    
    public static final String USER_NAME = "TestUser";
    public static final String NUMBER_OF_ROUNDS = "3";
    public static final String INVALID_INPUT_ROUNDS = "invalid";
    public static final String ZERO_ROUNDS = "0";
    public static final String VALID_ROUNDS = "2";
    public static final String ONE_ROUND = "1";
    @Mock
    private InputProvider inputProvider;
    
    @Mock
    private Player computer;
    
    @Mock
    private Player user;
    
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
    
    @Test
    void testGetNumberOfRounds() {
        when(inputProvider.getInput(anyString())).thenReturn(NUMBER_OF_ROUNDS);
        int rounds = game.getNumberOfRounds();
        assertEquals(3, rounds);
    }
    
    @Test
    void testGetNumberOfRoundsWithInvalidInput() {
        when(inputProvider.getInput(anyString())).thenReturn(INVALID_INPUT_ROUNDS, ZERO_ROUNDS, VALID_ROUNDS);
        int rounds = game.getNumberOfRounds();
        assertEquals(2, rounds);
        verify(inputProvider, times(3)).getInput(Constants.NUMBER_OF_GAMES_MSG);
    }
    
    @Test
    void testGetUserSymbol() throws QuitGameException {
        when(user.chooseSymbol()).thenReturn(Symbol.ROCK);
        
        Symbol symbol = game.getUserSymbol();
        
        assertEquals(Symbol.ROCK, symbol);
    }
    
    @Test
    void testGetUserSymbolWithNullSymbol() throws QuitGameException {
        when(user.chooseSymbol()).thenReturn(null, Symbol.PAPER);
        
        Symbol symbol = game.getUserSymbol();
        
        assertEquals(Symbol.PAPER, symbol);
        verify(user, times(2)).chooseSymbol();
    }
    
    @Test
    void testPlayRound() throws QuitGameException {
        when(user.chooseSymbol()).thenReturn(Symbol.ROCK);
        when(computer.chooseSymbol()).thenReturn(Symbol.SCISSORS);
        when(processor.determineWinner(Symbol.ROCK, Symbol.SCISSORS)).thenReturn(Outcome.USER_WIN);
        
        game.playRound();
        
        verify(user, times(1)).chooseSymbol();
        verify(computer, times(1)).chooseSymbol();
        verify(processor, times(1)).determineWinner(Symbol.ROCK, Symbol.SCISSORS);
        verify(scoreManager, times(1)).updateScore(Outcome.USER_WIN, computer, user);
    }
    
    @Test
    void testPlay() throws QuitGameException {
        when(user.getName()).thenReturn(USER_NAME);
        when(inputProvider.getInput(anyString())).thenReturn(ONE_ROUND);
        when(user.chooseSymbol()).thenReturn(Symbol.ROCK);
        when(computer.chooseSymbol()).thenReturn(Symbol.SCISSORS);
        when(processor.determineWinner(Symbol.ROCK, Symbol.SCISSORS)).thenReturn(Outcome.USER_WIN);
        
        game.play();
        
        verify(inputProvider, times(1)).getInput(Constants.NUMBER_OF_GAMES_MSG);
        verify(user, times(1)).chooseSymbol();
        verify(computer, times(1)).chooseSymbol();
        verify(processor, times(1)).determineWinner(Symbol.ROCK, Symbol.SCISSORS);
        verify(scoreManager, times(1)).updateScore(Outcome.USER_WIN, computer, user);
    }
}
