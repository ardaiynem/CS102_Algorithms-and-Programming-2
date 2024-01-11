import java.util.Scanner;

/**
 * Document Analyzer inputs the amount of the documents and name of them in order to initialize them as Document objects
 * Then allows user to analyze these documents with different approaches
 *
 * @author 	Arda Iynem
 * @version 1.00 26.10.2021
 */
public class DocumentAnalyzer {
    // Variables
    static Document[] documents;
    static int docNumber;

    public static void main(String[] args) {
        String fileName;
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of documents:");
        docNumber = sc.nextInt();
        documents = new Document[docNumber];

        // Initializes all document objects according to inputted file name by user
        for (int i = 0; i < docNumber; i++) {
            System.out.println("Enter the name of the document " + (i + 1) + " :");
            fileName = sc.next();

            documents[i] = new Document(fileName);
        }

        // Allows user tho choose what operation it wants to perform in a loop until input is x
        String choice;
        do {
            System.out.println("Enter an option (enter x to quit):");
            choice = sc.next();

            if (choice.equals("1")) {
                System.out.println("Enter the word which you want to find the frequency:");
                showFrequency(sc.next());
            }
            else if (choice.equals("2")) {
                showMostUsedTerm();
            }
            else if (choice.equals("3")) {
                System.out.println("Enter the word which you want to calculate tf-idf:");
                calcTfIdf(sc.next());
            }
        } while (!choice.equalsIgnoreCase("x"));

        sc.close();
    }

    // Support Methods
    /**
     * Displays the frequency of a word for all documents
     * @param word Word
     */
    public static void showFrequency(String word) {
        for (int i = 0; i < docNumber; i++) {
            System.out.println("Document " + (i + 1));
            System.out.println("Word: " + word);
            System.out.printf("Term Frequency: %.6f\n", documents[i].getFrequency(word));
        }
    }

    /**
     * Displays the the most used term for all documents
     */
    public static void showMostUsedTerm(){
        for (int i = 0; i < docNumber; i++) {
            System.out.println("Document " + (i + 1));
            System.out.println("Word: " + documents[i].mostUsedTerm().getWord());
            System.out.println("Number of the appearance:  " + documents[i].mostUsedTerm().getCount());
        }
    }

    /**
     * Calculates tfidf of a word
     * @param word Word to be calculated
     */
    public static void calcTfIdf(String word) {
        double idf;
        int docsIncludingWord;

        docsIncludingWord = 0;
        for (Document doc : documents) {
            if (doc.getCount(word) != 0) {
                docsIncludingWord++;
            }
        }

        idf = Math.log(docNumber / (double) docsIncludingWord);
        for (int i = 0; i < docNumber; i++) {
            double tfidf;
            tfidf = documents[i].getFrequency(word) * idf;

            System.out.println("Document " + (i + 1));
            System.out.println("Word: " + word);
            System.out.printf("tf-idf: %.6f\n", tfidf);

        }
    }
}
