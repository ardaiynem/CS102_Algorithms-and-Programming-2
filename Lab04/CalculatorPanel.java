import operations.*;

import javax.swing.*;
import java.awt.*;

/**
 * CalculatorPanel inherits JPanel to create a specific panel object to be run in main method
 *
 * @author 	Arda Iynem
 * @version 1.00 15.11.2021
 */
public class CalculatorPanel extends JPanel implements CountInformer {
    // Variables
    Operation[] operations;
    CalculationButton[] operationButtons;
    JLabel[] operationLabels;

    // Main Method
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        CalculatorPanel calculatorPanel = new CalculatorPanel();

        frame.add(calculatorPanel);
        frame.setTitle("Calculator");
        frame.setLocation(500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,200);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    // Constructor
    /**
     * Constructs a Calculator Panel
     */
    public CalculatorPanel() {
        createComponents();
        setLayout(new GridLayout(3,0));
    }

    // Methods
    /**
     * Creates all components to be added to main panel
     */
    void createComponents() {
        JTextField fieldFirst = new JTextField(10);
        JTextField fieldSecond = new JTextField(10);
        JLabel numFirst = new JLabel("Number 1:");
        JLabel numSecond = new JLabel("Number 2:");
        JLabel result = new JLabel("Result :");

        // Initialize component and operation arrays
        operations = new Operation[8];
        operationButtons = new CalculationButton[operations.length];
        operationLabels = new JLabel[operations.length];

        // Add operations to array
        operations[0] = new Addition();
        operations[1] = new Subtraction();
        operations[2] = new Multiplication();
        operations[3] = new Division();
        operations[4] = new Square();
        operations[5] = new SquareRoot();
        operations[6] = new Factorial();
        operations[7] = new Logarithm();

        for (int i = 0; i < operations.length; i++) {
            // Label Array Initialization
            operationLabels[i] = new JLabel(operations[i].getNameOperation() + " : " + operations[i].getNumberOfTimesCalled());

            // Button Array Initialization
            if (operations[i].getIsUnary()) {
                operationButtons[i] = new UnaryCalculationButton(operations[i], fieldFirst, fieldSecond, result, this);
            }
            else {
                operationButtons[i] = new CalculationButton(operations[i], fieldFirst, fieldSecond, result, this);
            }
        }

        // Create Panels
        JPanel panelTexts = new JPanel();
        JPanel panelButtons = new JPanel();
        JPanel panelLabels = new JPanel();

        // Add components of first panel
        panelTexts.add(numFirst);
        panelTexts.add(fieldFirst);
        panelTexts.add(numSecond);
        panelTexts.add(fieldSecond);
        panelTexts.add(result);

        // Add components of second and third panel
        for (int i = 0; i < operations.length; i++) {
            panelButtons.add(operationButtons[i]);
            panelLabels.add(operationLabels[i]);
        }

        // Add panels to the main panel
        add(panelTexts);
        add(panelButtons);
        add(panelLabels);
    }

    /**
     * Updates all labels which count how many times each operation has been called
     */
    private void calculateAndUpdateCountMessage() {
        for (int i = 0; i < operations.length; i++) {
            operationLabels[i].setText(operations[i].getNameOperation() + " : " + operations[i].getNumberOfTimesCalled());
        }
    }

    // Interface Methods
    /**
     * Invokes calculateAndUpdateCountMessage method from public visibility
     */
    @Override
    public void countUpdated() {
        calculateAndUpdateCountMessage();
    }
}
