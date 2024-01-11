package operations;

/**
 * Addition is a subclass of Operation, it is used for mathematical addition
 *
 * @author 	Arda Iynem
 * @version 1.00 15.11.2021
 */
public class Addition extends Operation{
    // Constructor
    /**
     * Constructs an Addition operation
     */
    public Addition() {
        super();
        nameOperation = "Add";
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
        return a + b;
    }
}
