package operations;

/**
 * SquareRoot is a subclass of Operation, it is used for mathematical square rooting
 *
 * @author 	Arda Iynem
 * @version 1.00 15.11.2021
 */
public class SquareRoot extends Operation{
    // Constructor
    /**
     * Constructs a Square Root operation
     */
    public SquareRoot() {
        super();
        nameOperation = "Square Root";
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
        numberOfTimesCalled++;
        return Math.sqrt(a);
    }
}
