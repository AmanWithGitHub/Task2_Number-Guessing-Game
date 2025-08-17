import javax.swing.JOptionPane;
import java.util.Random;

public class NumberGuessingGame {

    public static void main(String[] args) {
        // Step 1: Generate a random number between 1 and 100
        Random random = new Random();
        int secretNumber = random.nextInt(100) + 1; // +1 ensures the range is 1-100, not 0-99
        int userGuess = 0;
        int attempts = 0;

        // Display a message to the user
        JOptionPane.showMessageDialog(null, "Welcome to the Number Guessing Game!\nI have selected a number between 1 and 100.\nCan you guess it?");

        // Step 2: Start the game loop
        while (userGuess != secretNumber) {
            // Get user input using a dialogue box
            String input = JOptionPane.showInputDialog(null, "Enter your guess:");

            // Handle user closing the dialogue box
            if (input == null) {
                JOptionPane.showMessageDialog(null, "Game ended. Thanks for playing!");
                return; // Exit the program
            }

            try {
                // Convert the input string to an integer
                userGuess = Integer.parseInt(input);
                attempts++; // Increment attempts counter

                // Step 3: Provide feedback
                if (userGuess < 1 || userGuess > 100) {
                    JOptionPane.showMessageDialog(null, "Please enter a number between 1 and 100.");
                } else if (userGuess < secretNumber) {
                    JOptionPane.showMessageDialog(null, "Your guess is too low! Try again.");
                } else if (userGuess > secretNumber) {
                    JOptionPane.showMessageDialog(null, "Your guess is too high! Try again.");
                } else {
                    JOptionPane.showMessageDialog(null, "Congratulations! You guessed the correct number: " + secretNumber + "\nIt took you " + attempts + " attempts.");
                }
            } catch (NumberFormatException e) {
                // Handle cases where the user enters non-numeric input
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number.");
            }
        }
    }
}