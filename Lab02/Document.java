import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Document object processes each word of a text file and stores each unique word as a term in an array
 *
 * @author 	Arda Iynem
 * @version 1.00 26.10.2021
 */
public class Document {
    // Variables
    private String fileName;
    private final Term[] terms;
    private File textFile;
    private int termCount;
    private int totalWordCount;

    // Constructors
    /**
     * Constructs a Document object without taking a file as a text
     */
    public Document() {
        terms = new Term[10000];
        termCount = 0;
        totalWordCount = 0;
    }

    /**
     * Constructs a Document object with the text file from given filepath
     */
    public Document(String fileName) {
        this();
        this.fileName = fileName;
        textFile = new File("C:\\texts\\" + fileName);
        processDocument();
    }

    // Support Methods
    /**
     * Scans all of the words in the text with Scanner object then stores all unique terms in an array
     */
    private void processDocument() {
        Scanner scan;
        String word;
        boolean isExist;

        try {
            scan = new Scanner(textFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }

        // Specify the delimiters in order to take only regular words as tokens.
        scan.useDelimiter(("[.,:;()?!\"\\s]+"));

        // Assign first term of the array in order to compare whether following terms are equal to any prior term
        // Then increment the related variables just as how it is done in the loop
        terms[0] = new Term(scan.next());
        terms[0].incrementCount();
        termCount++;
        totalWordCount++;
        while (scan.hasNext()) {
            word = scan.next();
            isExist = false;

            // Compares the new term with the preceding ones in the array to check if it is unique or not
            if (termCount < 10000) {
                for (int i = 0; i < termCount; i++) {
                    // If new term already exists, then increments the corresponding term's count
                    if (terms[i].getWord().equalsIgnoreCase(word)) {
                        isExist = true;
                        terms[i].incrementCount();
                    }
                }

                // Adds the new term into array if it is not exist in the array
                if (!isExist) {
                    terms[termCount] = new Term(word);
                    terms[termCount].incrementCount();
                    termCount++;
                }

                totalWordCount++;
            }
        }

        scan.close();
    }

    // Service Methods
    /**
     * Checks how many times a word appears in a text
     * @param word Word to be checked
     * @return Count of the word
     */
    public int getCount(String word) {
        for (int i = 0; i < termCount; i++) {
            if (terms[i].getWord().equalsIgnoreCase(word)) {
                return terms[i].getCount();
            }
        }

        return 0;
    }

    /**
     * Calculates the frequency of a word in a text
     * @param word Word to be checked
     * @return Frequency of a word in a text
     */
    public double getFrequency(String word) {
        return getCount(word) / (double) totalWordCount;
    }

    /**
     * Finds the most used term in a text by checking the counts of the terms in the array of terms
     * @return Term appearing most times in a text
     */
    public Term mostUsedTerm() {
        Term maxUsedTerm;

        maxUsedTerm = terms[0];
        // Compares whether a term appears more than the so far found max appearing term
        // If so, replaces maxUsedTerms with the new most appearing term
        for (int i = 1; i < termCount; i++) {
            if (maxUsedTerm.getCount() < terms[i].getCount()) {
                maxUsedTerm = terms[i];
            }
        }

        return maxUsedTerm;
    }

    // Accessors
    /**
     * Accessor for file name
     * @return File name
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * Accessor for total word count
     * @return Total word count
     */
    public int getTotalWordCount() {
        return totalWordCount;
    }

    /**
     * Accessor for unique word count
     * @return Unique term count
     */
    public int getTermCount() {
        return termCount;
    }

    // Mutators
    /**
     * Mutator for file name
     * @param fileName File name
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
        textFile = new File("C:\\texts\\" + fileName);
        processDocument();
    }
}
