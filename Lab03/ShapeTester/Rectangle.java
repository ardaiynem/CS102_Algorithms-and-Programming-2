/**
 * Rectangle inherits Shape class and implements Selectable interface in order to be used for more specific purposes
 * Also includes properties of a real rectangle and functions
 *
 * @author 	Arda Iynem
 * @version 1.00 2.11.2021
 */
public class Rectangle extends Shape implements Selectable {
    // Variables
    private final int width;
    private final int height;
    private boolean isSelected;

    // Constructor
    public Rectangle(int width, int height) {
        super();
        this.width = width;
        this.height = height;
        isSelected = false;
    }

    // Service Methods
    @Override
    public String toString() {
        return "" + getSelected();
    }

    // Superclass Methods
    /**
     * Calculates the area of rectangle
     * @return Area of rectangle
     */
    @Override
    public double getArea() {
        return width * height;
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
        boolean insideX;
        boolean insideY;

        insideX = false;
        insideY = false;
        if (x >= getX() && x <= getX() + width) {
            insideX = true;
        }

        if (y >= getY() && y <= getY() + height) {
            insideY = true;
        }

        if (insideX && insideY) {
            return this;
        }

        return null;
    }
}
