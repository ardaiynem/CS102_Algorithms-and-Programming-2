/**
 * Card - a single playing card
 * @author Arda Iynem (Only methods commmented "To Do" above them)
 * @version 1.0 11.10.2021
 */
public class Card
{
    final String[] SUITS = { "Hearts", "Diamonds", "Spades", "Clubs"};
    final String[] FACES = { "A", "2", "3", "4", "5",
                             "6", "7", "8", "9", "10",
                             "J", "Q", "K"};
    
    final int NO_OF_CARDS_IN_SUIT = 13;

    // properties
    int  cardNo;
    
    // constructors
    public Card( int faceValue, int suit )
    {
        cardNo = faceValue + suit * NO_OF_CARDS_IN_SUIT;
    }
    
    public Card( int cardNumber)
    {
        cardNo = cardNumber;
    }
    
    public int getFaceValue()
    {
        return cardNo % NO_OF_CARDS_IN_SUIT;
    }
    
    public int getSuit()
    {
        return cardNo / NO_OF_CARDS_IN_SUIT;
    }
    
    public String toString()
    {
        return FACES[ getFaceValue() ] + " of " + SUITS[ getSuit() ];
    }

    /**
     * Check if two cards' face values are same
     * @param c Card
     * @return Whether compared cards' face values match or not
     */
    public boolean equals( Card c)
    {
        // ToDo
        return cardNo % NO_OF_CARDS_IN_SUIT == c.getFaceValue();
    }

    /**
     * Subtracts two cards' face values to find which one has bigger. If values are equal, returns 0.
     * @param c Card
     * @return An integer
     */
    public int compareTo( Card c)
    {
        // ToDo
        return cardNo % NO_OF_CARDS_IN_SUIT - c.getFaceValue();
    }
}