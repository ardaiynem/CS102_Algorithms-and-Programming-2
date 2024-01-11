package operations;

/**
 * Division is a subclass of Operation, it is used for mathematical division
 *
 * @author 	Arda Iynem
 * @version 1.00 15.11.2021
 */
public class Division extends Operation{
    // Constructor
    /**
     * Constructs a Division operation
     */
    public Division() {
        super();
        nameOperation = "Division";
    }

    /**
     * Calculates and returns the result of the operation
     * @param a Number 1
     * @param b Number 2
     * @return Result
     */
    @Override
    public double calculateResult(double a, double b) {
        numberOfTimesCalled++;
        return a / b;
    }
}
