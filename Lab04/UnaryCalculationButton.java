import operations.Operation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * UnaryCalculationButton inherits JButton to create a specific button object
 * and implements ActionListener to behave also as a listener for unary operations
 *
 * @author 	Arda Iynem
 * @version 1.00 15.11.2021
 */
public class UnaryCalculationButton extends CalculationButton{
    // Constructor
    /**
     * Constructs a UnaryCalculationButton by passing panel objects and panel as parameter to establish connection
     * And adds itself as ActionListener since it implements ActionListener
     */
    public UnaryCalculationButton(Operation operation, JTextField fieldFirst, JTextField fieldSecond, JLabel result, CalculatorPanel panel) {
        super(operation, fieldFirst, fieldSecond, result, panel);
        setBackground(Color.RED);
    }

    /**
     * If first text field is not empty, executes unary operation then clears second text field
     * And updates related labels on the panel
     * @param e ActionEvent
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        double result;

        // Check if needed text fields are blank, display a dialog box if so
        if (getFieldFirst().getText().isBlank()) {
            JOptionPane.showMessageDialog(getPanel(),"You can't leave first text field blank on unary operations!"
                    ,"Empty Text Field!", JOptionPane.WARNING_MESSAGE);
        }
        else {
            clearFieldSecond();

            int numFirst = Integer.parseInt(getFieldFirst().getText());
            result = getOperation().calculateResult(numFirst, 0);

            // Remove the decimal if it equals to 0
            if (result % 1 == 0) {
                this.getResult().setText(String.format("Result : %.0f", result));
            }
            else {
                this.getResult().setText(String.format("Result : %.2f", result));
            }

            getInformer().countUpdated();
        }
    }
}
