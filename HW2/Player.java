/**
 * Player - Simple card game player with name and hand of cards
 *         Provides facilities to create a full pack of 52 cards
 *         and to shuffle the cards.
 * @author Arda Iynem (Only methods commmented "To Do" above them)
 * @version 1.0 11.10.2021
 */
public class Player
{
    // properties
    String name;
    Cards hand;
    
    // constructors

    /**
     * Constructs a Player object
     * @param name Name of player
     */
    public Player( String name)
    {
        // ToDo
        this.name = name;
        hand = new Cards(false);
    }
    
    // methods
    public String getName()
    {
        return name;
    }

    /**
     * Adds the input Card into the Player's deck
     * @param c Card
     */
    public void add( Card c)
    {
        // ToDo
        hand.addTopCard(c);
    }

    /**
     * Plays the top card of a player's deck
     * @return Top card of player's deck
     */
    public Card playCard()
    {
        // ToDo
        return hand.getTopCard();
    }
    
} // end class Player
