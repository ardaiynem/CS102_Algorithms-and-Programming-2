import java.util.ArrayList;

/**
 * CardGame
 * @author Arda Iynem (Only methods commmented "To Do" above them)
 * @version 1.0 11.10.2021
 */
public class CardGame
{
    // properties
    Cards             fullPack;
    ArrayList<Player> players;
    ScoreCard         scoreCard;
    Cards[]           cardsOnTable;
    int               roundNo;
    int               turnOfPlayer;
    
    // constructors

    /**
     * Constructs a card game
     * @param p1 Player 1
     * @param p2 Player 2
     * @param p3 Player 3
     * @param p4 Player 4
     */
    public CardGame( Player p1, Player p2, Player p3, Player p4)
    {
        // ToDo
        players = new ArrayList<Player>();
        fullPack = new Cards(true);
        cardsOnTable = new Cards[4];
        scoreCard = new ScoreCard(4);
        roundNo = 1;
        turnOfPlayer = 0;

        players.add(p1);
        players.add(p2);
        players.add(p3);
        players.add(p4);
        cardsOnTable[0] = new Cards(false);
        cardsOnTable[1] = new Cards(false);
        cardsOnTable[2] = new Cards(false);
        cardsOnTable[3] = new Cards(false);
        fullPack.shuffle();

        while (fullPack.valid > 0) {
            players.get(0).add(fullPack.getTopCard());
            players.get(1).add(fullPack.getTopCard());
            players.get(2).add(fullPack.getTopCard());
            players.get(3).add(fullPack.getTopCard());
        }
    }
    
    // methods

    /**
     * Plays the player's turn if conditions are fulfilled
     * Then increments all variables related to game
     * @param p Player
     * @param c Card
     * @return Whether turn is played or not
     */
    public boolean playTurn( Player p, Card c)
    {
        // Todo
        if (isTurnOf(p)) {
            cardsOnTable[turnOfPlayer].addTopCard(c);
            turnOfPlayer++;

            if (turnOfPlayer % 4 == 0) {
                // Find max card then increment scores who have played it
                Card maxCard = c;
                for (int i = 0; i < players.size() - 1; i++) {
                    Card tryCard = cardsOnTable[i].getTopCard();
                    if (maxCard.compareTo(tryCard) < 0) {
                        maxCard = tryCard;
                    }
                    cardsOnTable[i].addTopCard(tryCard);
                }

                for (int i = 0; i < players.size(); i++) {
                    Card tryCard = cardsOnTable[i].getTopCard();
                    if (tryCard.equals(maxCard)) {
                        scoreCard.update(i, 1);
                    }
                    cardsOnTable[i].addTopCard(tryCard);
                }

                roundNo++;
                turnOfPlayer = 0;
            }
            return true;
        }

        return false;
    }

    /**
     * Checks whether it is turn of the player
     * @param p Player
     * @return If it is player's turn
     */
    public boolean isTurnOf( Player p)
    {
        // ToDo
        return players.indexOf(p) == turnOfPlayer;
    }

    /**
     * If round 13 is over and roundNo is incremented to 14 then game is over
     * @return If game is over or not
     */
    public boolean isGameOver()
    {
        // ToDo
        return roundNo == 14;
    }

    /**
     * Score accessor
     * @param playerNumber Number of the player
     * @return Score of player
     */
    public int getScore( int playerNumber)
    {
        // ToDo
        return scoreCard.getScore(playerNumber);
    }

    /**
     * Name accessor
     * @param playerNumber Number of the player
     * @return Name of player
     */
    public String getName( int playerNumber)
    {
        // ToDo
        return players.get(playerNumber).getName();
    }

    /**
     * Round number accessor
     * @return Number of round
     */
    public int getRoundNo()
    {
        // ToDo
        return roundNo;
    }

    /**
     * Turn of player number accessor
     * @return Player number of current turn
     */
    public int getTurnOfPlayerNo()
    {
        // ToDo
        return turnOfPlayer;
    }

    /**
     * If score card's integer array has 1 at an index then player array's same index
     * is assigned to corresponding player object instead of being null
     * @return Array of players representing that if player object at an index is not null then that player has won
     */
    public Player[] getWinners()
    {
        // ToDo
        Player[] winners = new Player[players.size()];
        int[] winnerCard;

        winnerCard = scoreCard.getWinners();
        for (int i = 0; i < players.size(); i++) {
            if (winnerCard[i] == 1) {
                winners[i] = players.get(i);
            }
        }

        return winners;
    }
    
    public String showScoreCard()
    {
        return scoreCard.toString();
    }
    
}