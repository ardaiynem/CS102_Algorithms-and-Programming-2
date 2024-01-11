package operations;

/**
 * Factorial is a subclass of Operation, it is used for mathematical factorial
 *
 * @author 	Arda Iynem
 * @version 1.00 15.11.2021
 */
public class Factorial extends Operation{
    // Constructor
    /**
     * Constructs a Factorial operation
     */
    public Factorial() {
        super();
        nameOperation = "Factorial";
        isUnary = true;
    }

    /**
     * Calculates and returns the result of the operation
     * @param a Number 1
     * @param b Number 2
     * @return Result
     */
    @Override
    public double calculateResult(double a, double b) {
        double calculation;

        numberOfTimesCalled++;
        calculation = a;
        for (double i = a - 1; i > 0; i--) {
            calculation *= i;
        }

        return calculation;
    }
}
