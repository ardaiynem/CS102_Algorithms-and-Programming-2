/**
 * Circle class represents a circle in a 2D space
 *
 * @author 	Arda Iynem
 * @version 1.00 11.10.2021
 */
public class Circle {
    // Variables
    private Point center;
    private double radius;

    // Constructor
    /**
     * Constructs a Circle
     */
    public Circle(Point center, double radius) {
        setCenter(center);
        setRadius(radius);
    }

    // Accessor Methods
    /**
     * Center accessor
     * @return Center point of circle
     */
    public Point getCenter() {
        return center;
    }

    /**
     * Radius accessor
     * @return Radius of circle
     */
    public double getRadius() {
        return radius;
    }

    // Mutator Methods
    /**
     * Center mutator
     */
    public void setCenter(Point center) {
        this.center = center;
    }

    /**
     * Radius mutator
     */
    public void setRadius(double radius) {
        this.radius = radius;
    }

    // Service Methods
    /**
     * Checks whether a point is inside the circle
     * @return If point is within the circle
     */
    public boolean contains(Point point) {
        double diffX = Math.abs(point.getX() - center.getX());
        double diffY = Math.abs(point.getY() - center.getY());

        return diffX * diffX + diffY * diffY <= getRadius() * getRadius();
    }

    @Override
    public String toString() {
        return "Circle{" +
                "center=" + center +
                ", radius=" + radius +
                '}';
    }
}
