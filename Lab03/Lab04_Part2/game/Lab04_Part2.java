package game;

import javax.swing.*;

/**
 * This is the App class containing frame in main method
 *
 * @author 	Arda Iynem
 * @version 1.00 2.11.2021
 */
public class Lab04_Part2 {
    // Variables
    static final int FRAME_WIDTH = 600;
    static final int FRAME_HEIGHT = 400;

    public static void main(String[] args) {
        JFrame frame;
        BalloonsGamePanel gamePanel;

        // Create frame then add panel
        frame = new JFrame();
        gamePanel = new BalloonsGamePanel();
        frame.add(gamePanel);


        // Set the frame then make it visible
        frame.setTitle("Lab04b - Balloons");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setVisible(true);
    }
}
