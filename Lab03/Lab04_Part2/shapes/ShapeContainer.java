package shapes;

import game.Balloon;
import java.awt.*;
import java.util.ArrayList;

/**
 * Shape Container stores all objects inherited from Shape class in an Array List
 * Also contains useful service methods to use balloon circles in the game and GUI
 *
 * @author 	Arda Iynem
 * @version 1.00 2.11.2021
 */
public class ShapeContainer {
    // Variables
    private final ArrayList<Shape> shapes;

    // Constructor
    /**
     * Constructs a ShapeContainer
     */
    public ShapeContainer() {
        shapes = new ArrayList<Shape>();
    }

    // Service Methods
    /**
     * Adds a shape to ShapeContainer's array
     * @param s Shape to be added
     */
    public void add(Shape s) {
        shapes.add(s);
    }

    /**
     * Calculates the sum of all shapes' areas
     * @return Total area of objects
     */
    double getArea() {
        double totalArea;

        totalArea = 0;
        for (Shape shape : shapes) {
            totalArea += shape.getArea();
        }

        return totalArea;
    }

    /**
     * First shape found containing x, y point within is selected and returned
     * @param x x point
     * @param y y point
     * @return First shape found containing x, y point within
     */
    public Shape contains(int x, int y) {
        for (Shape shape : shapes) {
            Selectable check = (Selectable) shape;
            if (check.contains(x, y) != null) {
                check.setSelected(true);
                return shape;
            }
        }

        return null;
    }

    /**
     * Removes all selected objects in the ShapeContainer's array
     */
    public void removeSelected(){
        for (int i = 0; i < shapes.size(); i++) {
            Selectable check = (Selectable) shapes.get(i);
            if (check.getSelected()) {
                shapes.remove(i);
                i--;
            }
        }
    }

    /**
     * Amount of shapes in the ShapeContainer's array
     * @return  array's size
     */
    public int size() {
        return shapes.size();
    }

    /**
     * Select all objects in the ShapeContainer's array containing given point
     * @param x x point
     * @param y y point
     * @return Count of shapes selected at given point
     */
    public int selectAllAt(int x, int y) {
        int countSelected;

        countSelected = 0;
        for (Shape shape : shapes) {
            Selectable check = (Selectable) shape;
            if (check.contains(x, y) != null) {
                check.setSelected(true);
                countSelected++;
            }
        }

        return countSelected;
    }

    /**
     * Invokes grow method of all balloon objects in the ShapeContainer's array
     */
    public void growAll() {
        for (Shape shape : shapes) {
            Balloon balloon = (Balloon) shape;
            balloon.grow();
        }
    }

    /**
     * Invokes draw method of all balloon objects in the ShapeContainer's array
     */
    public void drawAll(Graphics g) {
        for (Shape shape : shapes) {
            Drawable balloon = (Drawable) shape;
            balloon.draw(g);
        }
    }

    @Override
    public String toString() {
        String showString;

        showString = "";
        for (Shape shape : shapes) {
            showString += shape + "\n";
        }

        return showString;
    }
}
