package org.game.view;

/**
 * Interface for providing user input.
 */
public interface InputProvider {
    
    /**
     * Gets input from the user based on a prompt.
     * @param prompt The prompt to display to the user.
     * @return The user's input.
     */
    String getInput(String prompt);
}
