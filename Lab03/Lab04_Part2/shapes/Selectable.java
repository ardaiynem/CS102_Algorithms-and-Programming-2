package shapes;

/**
 * Selectable interface is used for unrelated classes with common functionalities
 *
 * @author 	Arda Iynem
 * @version 1.00 2.11.2021
 */
public interface Selectable {
    boolean getSelected();
    void setSelected(boolean isSelected);
    Shape contains(int x, int y);
}
