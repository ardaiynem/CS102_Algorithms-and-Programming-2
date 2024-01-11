package operations;

/**
 * Square is a subclass of Operation, it is used for mathematical squaring
 *
 * @author 	Arda Iynem
 * @version 1.00 15.11.2021
 */
public class Square extends Operation{
    // Constructor
    /**
     * Constructs a Square operation
     */
    public Square() {
        super();
        nameOperation = "Square";
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
        return a * a;
    }
}
