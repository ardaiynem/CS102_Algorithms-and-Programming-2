/**
 * Circle inherits Shape class and implements Selectable interface in order to be used for more specific purposes
 * Also includes properties of a real circle and functions
 *
 * @author 	Arda Iynem
 * @version 1.00 2.11.2021
 */
public class Circle extends Shape implements Selectable{
    // Variables
    private int radius;
    private boolean isSelected;

    // Constructor
    /**
     * Constructs a circle object at a point
     * @param x x point
     * @param y y point
     * @param radius Radius of circle
     */
    public Circle(int x, int y, int radius) {
        super(x, y);
        this.radius = radius;
        isSelected = false;
    }

    /**
     * Constructs a circle object
     * @param radius Radius of circle
     */
    public Circle(int radius) {
        super();
        this.radius = radius;
        isSelected = false;
    }

    // Service Methods
    /**
     * Accessor for radius
     * @return Radius of circle
     */
    public int getRadius() {
        return radius;
    }

    /**
     * Mutator for radius
     */
    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "" + getSelected();
    }

    // Superclass Methods
    /**
     * Calculates the area of circle by radius
     * @return Area of circle
     */
    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    // Interface Methods
    @Override
    public boolean getSelected() {
        return isSelected;
    }

    @Override
    public void setSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }

    @Override
    public Shape contains(int x, int y) {
        double diffX = Math.abs(x - getX());
        double diffY = Math.abs(y - getY());

        if (diffX * diffX + diffY * diffY <= radius * radius)
        {
            return this;
        }

        return null;
    }
}
