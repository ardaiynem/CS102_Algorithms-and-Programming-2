package operations;

/**
 * Logarithm is a subclass of Operation, it is used for mathematical logarithm
 *
 * @author 	Arda Iynem
 * @version 1.00 15.11.2021
 */
public class Logarithm extends Operation{
    // Constructor
    /**
     * Constructs a Logarithm operation
     */
    public Logarithm() {
        super();
        nameOperation = "Logarithm";
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
        return Math.log(a);
    }
}
