package shapes;

/**
 * Shape class is a superclass representing a shape which implements Locatable
 * In order to have location properties and functions
 *
 * @author 	Arda Iynem
 * @version 1.00 2.11.2021
 */
public abstract class Shape implements Locatable {
    // Variables
    private int x;
    private int y;

    // Constructors
    /**
     * Constructs a Shape with coordinates 0, 0
     */
    public Shape() {
        x = 0;
        y = 0;
    }

    /**
     * Constructs a Shape with given coordinates
     */
    public Shape(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Service Methods
    /**
     * Abstract method to get area
     * @return Area
     */
    public abstract double getArea();

    // Interface Methods
    /**
     * Accessor for x
     * @return x point
     */
    @Override
    public int getX() {
        return x;
    }

    /**
     * Accessor for y
     * @return y point
     */
    @Override
    public int getY() {
        return y;
    }

    /**
     * Mutator for x and y
     * @param x x point
     * @param y y point
     */
    @Override
    public void setLocation(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
