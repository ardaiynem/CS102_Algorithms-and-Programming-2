/**
 * Point class represents a point in a 2D space.
 *
 * @author 	Arda Iynem
 * @version 1.00 11.10.2021
 */
public class Point {
    // Variables
    private double x;
    private double y;

    // Constructor
    /**
     * Constructs a Point
     */
    public Point(double x, double y) {
        setX(x);
        setY(y);
    }

    // Accessor Methods
    /**
     * X accessor
     * @return x
     */
    public double getX() {
        return x;
    }

    /**
     * Y accessor
     * @return y
     */
    public double getY() {
        return y;
    }

    // Mutator Methods
    /**
     * X mutator
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * Y mutator
     */
    public void setY(double y) {
        this.y = y;
    }

    // Service Methods
    @Override
    public String toString() {
        return "Point{" + "x=" + x + ", y=" + y + '}';
    }
}
