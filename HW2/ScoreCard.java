/**
 * ScoreCard - Maintains one integer score per player, for any number of players
 *            Caution: invalid player numbers result in run-time exception!
 * @author Arda Iynem (Only methods written To Do commment above them)
 * @version 1.0 11.10.2021
 */
public class ScoreCard
{
    // properties
    int[] scores;
    
    // constructors
    public ScoreCard( int noOfPlayers)
    {
        scores = new int[noOfPlayers];
        
        // init all scores to zero
        for ( int i = 0; i < scores.length; i++)
            scores[i] = 0;
    }
    
    // methods
    public int getScore( int playerNo)
    {
        return scores[ playerNo];
    }
    
    public void update( int playerNo, int amount)
    {
        scores[playerNo] += amount;
    }
    
    public String toString()
    {
        String s;
        s = "\n"
            + "_____________\n"
            + "\nPlayer\tScore\n"
            + "_____________\n";
        
        for ( int playerNo = 0; playerNo < scores.length; playerNo++)
        {
            s = s + (playerNo + 1) + "\t\t" + scores[playerNo] + "\n";
        }
        
        s += "_____________\n";
        return s;
    }

    /**
     * If players' score equals maxScore, increments the 0 to 1 in array at index of player's
     * @return Array of 1 and 0's representing that player at index of 1's have won
     */
    public int[] getWinners()
    {
        // ToDo
        int[] winners = new int[4];
        int maxScore;

        maxScore = scores[0];
        for (int i = 1; i < scores.length; i++) {
            if (maxScore < scores[i]) {
                maxScore = scores[i];
            }
        }

        for (int i = 0; i < scores.length; i++) {
            if (scores[i] == maxScore) {
                winners[i] = 1;
            }
        }

        return winners;
    }
    
} // end class ScoreCard
