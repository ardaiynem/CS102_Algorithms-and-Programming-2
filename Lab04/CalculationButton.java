import operations.Operation;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * CalculationButton inherits JButton to create a specific button object
 * and implements ActionListener to behave also as a listener for binary operations
 *
 * @author 	Arda Iynem
 * @version 1.00 15.11.2021
 */
public class CalculationButton extends JButton implements ActionListener {
    // Variables
    private final Operation operation;
    private final JTextField fieldFirst;
    private final JTextField fieldSecond;
    private final JLabel result;
    private final CalculatorPanel panel;
    private final CountInformer informer;

    // Constructor
    /**
     * Constructs a CalculationButton by passing panel objects and panel as parameter to establish connection
     * And adds itself as ActionListener since it implements ActionListener
     */
    public CalculationButton(Operation operation, JTextField fieldFirst, JTextField fieldSecond, JLabel result, CalculatorPanel panel) {
        this.operation = operation;
        this.fieldFirst = fieldFirst;
        this.fieldSecond = fieldSecond;
        this.result = result;
        this.panel = panel;
        informer = panel;
        addActionListener(this);

        this.setText(operation.getNameOperation());
    }

    // Accessors
    /**
     * Accessor for operation
     * @return Operation
     */
    public Operation getOperation() {
        return operation;
    }

    /**
     * Accessor for first text field
     * @return Text field
     */
    public JTextField getFieldFirst() {
        return fieldFirst;
    }

    /**
     * Accessor for result label
     * @return Result label
     */
    public JLabel getResult() {
        return result;
    }

    /**
     * Accessor for informer object
     * @return CountInformer object
     */
    public CountInformer getInformer() {
        return informer;
    }

    /**
     * Accessor for calculator panel
     * @return Calculator panel
     */
    public CalculatorPanel getPanel() {
        return panel;
    }

    // Methods
    /**
     * Clears second text field
     */
    public void clearFieldSecond() {
        fieldSecond.setText("");
    }

    /**
     * If none of text fields are empty, executes binary operation and updates related labels on the panel
     * @param e ActionEvent
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        double result;

        // Check if needed text fields are blank, display a dialog box if so
        if (fieldFirst.getText().isBlank() || fieldSecond.getText().isBlank()) {
            JOptionPane.showMessageDialog(panel,"You can't leave each space blank on binary operations!"
                    ,"Empty Text Field!", JOptionPane.WARNING_MESSAGE);
        }
        else {
            int numFirst = Integer.parseInt(fieldFirst.getText());
            int numSecond = Integer.parseInt(fieldSecond.getText());
            result = operation.calculateResult(numFirst, numSecond);

            // Remove the decimal if it equals to 0
            if (result % 1 == 0) {
                this.result.setText(String.format("Result : %.0f", result));
            }
            else {
                this.result.setText(String.format("Result : %.2f", result));
            }

            informer.countUpdated();
        }
    }
}
