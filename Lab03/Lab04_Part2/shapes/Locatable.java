package shapes;

/**
 * Locatable interface is used for unrelated classes with common functionalities
 *
 * @author 	Arda Iynem
 * @version 1.00 2.11.2021
 */
public interface Locatable {
    int getX();
    int getY();
    void setLocation(int x, int y);
}
