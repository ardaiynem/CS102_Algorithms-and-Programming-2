/**
 * Hangman Class
 *
 * @author 	Arda Iynem
 * @version 1.00 04.10.2021
 */
public class Hangman {
    // Variables
    private final String[] secretWordList = new String[] {"bear", "elephant", "bunny", "lion", "giraffe",
            "kangaroo", "whale", "dolphin", "tiger", "platypus"};
    private StringBuffer secretWord;
    private final StringBuffer allLetters = new StringBuffer("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
    private StringBuffer usedLetters;
    private StringBuffer knownSoFar;
    private int numberOfIncorrectTries;
    private final int maxAllowedIncorrectTries;

    // Constructor
    public Hangman() {
        chooseSecretWord();
        numberOfIncorrectTries = 0;
        maxAllowedIncorrectTries = 6;
        usedLetters = new StringBuffer();
        knownSoFar = new StringBuffer();

        for (int i = 0; i < secretWord.length(); i++) {
            knownSoFar.append('-');
        }
    }

    // Accessor Methods
    public String getAllLetters() {return allLetters.toString();}

    public String getUsedLetters() {return usedLetters.toString();}

    public String getSecretWord() {
        return secretWord.toString();
    }

    public int getNumberOfIncorrectTries() {
        return numberOfIncorrectTries;
    }

    public int getMaxAllowedIncorrectTries() {
        return maxAllowedIncorrectTries;
    }

    public String getKnownSoFar() {
        return knownSoFar.toString();
    }

    // Support Methods
    /**
     * Assigns secretWord a random word from secretWordList
     */
    private void chooseSecretWord() {
        int random = (int) ( Math.random() * 10 );
        secretWord = new StringBuffer(secretWordList[random]);
    }

    // Service Methods
    /**
     * Tries the input letter and increments numberOfIncorrectTries if secretWord does not include
     * the input letter or changes knownSoFar if includes then appends input letter to usedLetters
     * @param letter Input letter
     * @return Amount of the input letter in secretWord
     */
    public int tryThis(char letter) {
        int occurrence;

        occurrence = 0;
        for (int i = 0; i < secretWord.length(); i++) {
            if (secretWord.charAt(i) == Character.toLowerCase(letter)) {
                occurrence++;
                knownSoFar.setCharAt(i, Character.toLowerCase(letter));
            }
        }

        if (occurrence == 0) {
            numberOfIncorrectTries++;
        }

        usedLetters.append(Character.toLowerCase(letter));
        return occurrence;
    }

    /**
     * @return If game is over or not
     */
    public boolean isGameOver() {
        return hasLost() || secretWord.toString().equals(knownSoFar.toString());
    }

    /**
     * @return If player has lost or not
     */
    public boolean hasLost() {
        return getNumberOfIncorrectTries() == getMaxAllowedIncorrectTries();
    }
}
