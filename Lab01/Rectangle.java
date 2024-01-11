/**
 * Rectangle class represents a rectangle in a 2D space.
 *
 * @author 	Arda Iynem
 * @version 1.00 11.10.2021
 */
public class Rectangle {
    // Variables
    private Point corner;
    private double width;
    private double height;

    // Constructor
    /**
     * Constructs a Rectangle
     */
    public Rectangle(Point corner, double height, double width) {
        setCorner(corner);
        setHeight(height);
        setWidth(width);
    }

    // Accessor Methods
    /**
     * Height accessor
     * @return Height
     */
    public double getHeight() {
        return height;
    }

    /**
     * Width accessor
     * @return Width
     */
    public double getWidth() {
        return width;
    }

    /**
     * Corner accessor
     * @return Corner's point representation
     */
    public Point getCorner() {
        return corner;
    }

    // Mutator Methods
    /**
     * Height mutator
     */
    public void setHeight(double height) {
        this.height = height;
    }

    /**
     * Width mutator
     */
    public void setWidth(double width) {
        this.width = width;
    }

    /**
     * Corner mutator
     */
    public void setCorner(Point corner) {
        this.corner = corner;
    }

    // Service Methods
    /**
     * Checks whether a point is inside the rectangle
     * @return If point is within the rectangle
     */
    public boolean contains(Point point) {
        boolean insideX;
        boolean insideY;

        insideX = false;
        insideY = false;
        if (point.getX() >= corner.getX() && point.getX() <= corner.getX() + this.getWidth()) {
            insideX = true;
        }

        if (point.getY() >= corner.getY() && point.getY() <= corner.getY() + this.getHeight()) {
            insideY = true;
        }

        return insideX && insideY;
    }

    /**
     * Creates random point within the rectangle
     * @return A point within the rectangle
     */
    public Point getRandomPoint() {
        Point randomPoint;
        double x;
        double y;

        x = corner.getX() + (Math.random() * getWidth());
        y = corner.getY() + (Math.random() * getHeight());
        randomPoint = new Point(x, y);

        return randomPoint;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "corner=" + corner +
                ", width=" + width +
                ", height=" + height +
                '}';
    }
}
