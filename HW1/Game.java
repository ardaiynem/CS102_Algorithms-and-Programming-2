import java.util.Scanner;

/**
 * Game Class
 *
 * @author 	Arda Iynem
 * @version 1.00 04.10.2021
 */
public class Game {
    public static void main(String[] args) {
        // Variables
        Scanner input = new Scanner(System.in);
        Hangman hangman = new Hangman();
        StringBuffer lettersLeft;
        boolean isUsed;
        char letter;

        // Loop repeats until game ends
        lettersLeft = new StringBuffer(hangman.getAllLetters());
        do {
            isUsed = false;
            System.out.print("Choose a letter: ");
            letter = input.next().charAt(0);

            // Loop checks if input letter is used before
            for (int i = 0; i < hangman.getUsedLetters().length(); i++) {
                if (Character.toLowerCase(letter) == (hangman.getUsedLetters().charAt(i))) {
                    isUsed = true;
                }
            }

            // If letter is not used before removes the input letter from lettersLeft then prints required content
            if (!isUsed) {
                for (int i = 0; i < lettersLeft.length(); i++) {
                    if (lettersLeft.charAt(i) == Character.toUpperCase(letter)) {
                        lettersLeft.setCharAt(i, '-');
                    }
                }

                System.out.printf("This letter occurs in the word %d times - Remaining Try Number: %d" +
                        "%nKnown word so far: %s%n%nAvailable Letters: %s%n",
                        hangman.tryThis(letter), hangman.getMaxAllowedIncorrectTries() - hangman.getNumberOfIncorrectTries(),
                        hangman.getKnownSoFar(), lettersLeft);
            }
            else {
                System.out.println("You've already input this letter!");
            }

        } while(!hangman.isGameOver());

        // Prints out the ending result when the loop has been terminated
        if (hangman.hasLost()) {
            System.out.println("\n\nSorry, you lost! The secret word was: " + hangman.getSecretWord());
        }
        else {
            System.out.println("\n\nCongrats! You won!");
        }
    }
}
