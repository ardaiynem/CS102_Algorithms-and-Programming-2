package game;

import shapes.Circle;
import shapes.Drawable;
import java.awt.*;

/**
 * Balloon is an advanced Circle object due to additional grow and draw methods
 * Balloon objects extend and implement other classes in order to be used in the game
 *
 * @author 	Arda Iynem
 * @version 1.00 2.11.2021
 */
public class Balloon extends Circle implements Drawable {
    // Variables
    private static final int MIN_RADIUS = 25;
    private static final int MAX_RADIUS = 100;

    // Constructors
    /**
     * Constructs a balloon object
     * @param x x point
     * @param y y point
     */
    public Balloon(int x, int y) {
        super(x, y, MIN_RADIUS);
    }

    // Service Methods
    /**
     * Increments balloon's radius and sets it selected if radius is greater than 100
     */
    public void grow() {
        if (getRadius() < MAX_RADIUS) {
            this.setRadius(getRadius() + 1);
        }
        else {
            setRadius(0);
            this.setSelected(true);
        }
    }

    /**
     * Draws a circle by taking given point as center
     * @param g  Graphics of the component
     */
    @Override
    public void draw(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawOval(getX() - getRadius(), getY() - getRadius(), getRadius() * 2, getRadius() * 2);
    }
}
