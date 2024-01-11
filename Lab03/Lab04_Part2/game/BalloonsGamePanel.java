package game;

import shapes.ShapeContainer;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * BalloonsGamePanel creates a JPanel object which a game is being displayed on it
 * Balloons game is a game that user clicks on the growing circles to pop them and get point
 * Game is played by mouse owing to mouse listener on the panel
 *
 * @author 	Arda Iynem
 * @version 1.00 2.11.2021
 */
public class BalloonsGamePanel extends JPanel {
    // Variables
    private ShapeContainer balloons;
    private final Timer timer;
    private int points;
    private int elapsedTime;
    private final JLabel label;
    private static final int WIDTH = 587;
    private static final int HEIGHT = 364;
    private static final int DELAY = 50;
    private static final int GAME_DURATION = 10000;
    private static final int MIN_SELECTED = 2;
    private static final int MIN_BALLOON_AMOUNT = 15;
    private static final int START_BALLOON_AMOUNT = 25;

    // Constructor
    /**
     * Constructs a BalloonsGamePanel
     */
    public BalloonsGamePanel() {
        BalloonClicker balloonClicker = new BalloonClicker();
        addMouseListener(balloonClicker);
        setBackground(Color.YELLOW);

        TimeListener timeListener = new TimeListener();
        timer = new Timer(DELAY, timeListener);
        label = new JLabel("Points: " + points);
        add(label);
        createGame();
    }

    /**
     * Resets game related variables and creates balloon objects at random points in panel then restarts timer
     */
    private void createGame() {
        points = 0;
        elapsedTime = 0;
        balloons = new ShapeContainer();
        label.setText("Points: " + points);

        int x;
        int y;
        // Create balloon objects at random points within the panel
        for (int i = 0; i < START_BALLOON_AMOUNT; i++) {
            x = (int) (Math.random() * WIDTH);
            y = (int) (Math.random() * HEIGHT);
            balloons.add(new Balloon(x, y));
        }

        // Restart timer
        timer.restart();
    }

    // Inner Classes
    /**
     * This inner class is to create an action listener for timer
     * After each delay period of timer grows all and removes selected balloon objects
     * Creates new balloons if balloon size is less then a determined number
     * Then after a certain time,  asks user to play again or exit the game
     */
    private class TimeListener implements ActionListener {
        int x;
        int y;

        public void actionPerformed(ActionEvent event)
        {
            balloons.growAll();
            balloons.removeSelected();

            if (balloons.size() < MIN_BALLOON_AMOUNT) {
                x = (int) (Math.random() * WIDTH);
                y = (int) (Math.random() * HEIGHT);

                balloons.add(new Balloon(x, y));
            }

            elapsedTime += DELAY;

            if (elapsedTime == GAME_DURATION) {
                int a = JOptionPane.showConfirmDialog
                        (BalloonsGamePanel.this, "Play Again?",
                                "Game Over",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                if (a == 0) {
                    createGame();
                }
                else {
                    System.exit(0);
                }
            }

            repaint();
        }
    }

    /**
     * This inner class is to create a mouse listener for game panel
     * If clicked point is within a circle then these circles are selected
     * And if at least 2 circles are selected then point is incremented and label text is updated
     */
    private class BalloonClicker extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            if (balloons.selectAllAt(e.getX(), e.getY()) >= MIN_SELECTED) {
                points++;
                label.setText("Points: " + points);
            }
        }
    }

    // Support Methods
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        balloons.drawAll(g);
    }
}
