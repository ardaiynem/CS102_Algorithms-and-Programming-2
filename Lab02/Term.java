/**
 * Term object contains two variables that is word and it's count in order to store all terms uniquely
 *
 * @author 	Arda Iynem
 * @version 1.00 26.10.2021
 */
public class Term {
    // Variables
    private String word;
    private int count;

    // Constructor
    /**
     * Constructs a term object
     * @param word Word of the term
     */
    public Term(String word) {
        this.word = word;
        count = 0;
    }

    // Service Methods
    /**
     * Increments the count of a term by one
     */
    public void incrementCount() {
        count++;
    }

    // Accessors
    /**
     * Accessor for count of a term
     * @return Count of a term
     */
    public int getCount() {
        return count;
    }

    /**
     * Accessor for word of a term
     * @return Word of a term
     */
    public String getWord() {
        return word;
    }

    // Mutators
    /**
     * Mutator for count of a term
     * @param count Input count
     */
    public void setCount(int count) {
        this.count = count;
    }

    /**
     * Mutator for word of a term
     * @param word Input word
     */
    public void setWord(String word) {
        this.word = word;
    }

}
