import java.util.Random;

/**
 * Cards - Maintains a collection of zero or more playing cards.
 *         Provides facilities to create a full pack of 52 cards
 *         and to shuffle the cards.
 * @author Arda Iynem (Only methods commmented "To Do" above them)
 * @version 1.0 11.10.2021
 */
public class Cards
{
    final int NO_OF_CARDS_IN_FULL_PACK = 52;
    
    // properties
    Card[] cards;
    int    valid;  // number of cards currently in collection
    
    // constructors
    public Cards( boolean fullPack)
    {
        cards = new Card[NO_OF_CARDS_IN_FULL_PACK];
        valid = 0;
        
        if ( fullPack)
            createFullPackOfCards();
    }
    
    // methods
    public Card getTopCard()
    {
        Card tmp;

        if ( valid <= 0)
            return null;
        else
        {
            valid--;
            tmp = cards[valid];
            cards[valid] = null;
            return tmp;
        }
    }
    
    public boolean addTopCard( Card c)
    {
        if ( valid < cards.length)
        {
            cards[valid] = c;   // should this be cloned? Yes nothing about card objects changes through the game
            valid++;
            return true;
        }
        return false;
    }

    /**
     * Creates a full pack of cards in order
     */
    private void createFullPackOfCards()
    {
        // Todo
        for (int i = 0; i < NO_OF_CARDS_IN_FULL_PACK; i++) {
            addTopCard( new Card(i) );
        }
    }

    /**
     * Shuffles the cards in a deck
     */
    public void shuffle()
    {
        // Todo
        Random rnd = new Random();
        int randomIndex;

        for ( int i = 0; i < cards.length; i++) {
            Card tmpCard;
            randomIndex = rnd.nextInt(cards.length);

            tmpCard = cards[i];
            cards[i] = cards[randomIndex];
            cards[randomIndex] = tmpCard;
        }
    }
    
    
    // For testOnly... remove from production version!
    public void testOnlyPrint()
    {
        for ( int i =0; i < valid; i++)
        {
            System.out.println( cards[i] );
        }
    }
    
} // end class Cards
