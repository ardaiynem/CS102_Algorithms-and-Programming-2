import java.util.Scanner;

/**
 * CardGameTest
 * @author Arda Iynem (Only methods commmented "To Do" above them)
 * @version 1.0 11.10.2021
 */
public class CardGameTest
{
    public static void main( String[] args)
    {
        Scanner scan = new Scanner( System.in);

        System.out.println( "Start of CardGameTest\n");

        // CONSTANTS

        // VARIABLES
        Card       c;
        Cards      cards;
        ScoreCard  scores;
        Player     p;
        CardGame   game;

        // PROGRAM CODE

        // test Card class
        c = new Card( 1);
        System.out.println( c);
        System.out.println();

        // test Cards class
        cards = new Cards( true);
        cards.addTopCard( c);
        cards.testOnlyPrint();  // remove method after testing!

        cards.shuffle();
        System.out.println("\n\n Deck After Shuffle \n");
        cards.testOnlyPrint();

        // test ScoreCard class
        scores = new ScoreCard( 4);
        scores.update( 3, 1);
        scores.update( 1, 2);
        System.out.println( "\n" + scores );

        // test Player class
        // ToDo
        p = new Player("test0");
        System.out.println(p.getName());
        p.add(c);
        p.add(new Card(4));
        p.hand.testOnlyPrint();

        p.playCard();
        System.out.println("\nAfter card c has been played\n");
        p.hand.testOnlyPrint();

        // test CardGame class too?
        // Todo
        Player p1 = new Player("test1");
        Player p2 = new Player("test2");
        Player p3 = new Player("test3");
        Player p4 = new Player("test4");

        game = new CardGame(p1, p2, p3, p4);
        System.out.println(game.getName(game.getTurnOfPlayerNo()) + "---" + game.getScore(game.getTurnOfPlayerNo())
                + "---" + game.getRoundNo() + "\n\n");

        game.playTurn(p1, p1.playCard());
        game.playTurn(p2, p2.playCard());
        game.playTurn(p3, p3.playCard());

        System.out.println(game.getName(game.getTurnOfPlayerNo()) + "---" + game.getScore(game.getTurnOfPlayerNo())
                + "---" + game.getRoundNo() + "\n\n");

        game.playTurn(p4, p4.playCard());
        System.out.println(game.getName(game.getTurnOfPlayerNo()) + "---" + game.getScore(game.getTurnOfPlayerNo())
                + "---" + game.getRoundNo() + "\n\n");
        System.out.println(game.showScoreCard());



        // Once you have all the bits working, complete the MyCardGame program
        // that provides a menu allowing any of the players to play their card,
        // an option to see the score card, and one to quit the game at any time.
        // When the game is over it should print out the winners.

        System.out.println( "\nEnd of CardGameTest\n" );
    }

} // end of class CardGameTest
