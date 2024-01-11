package operations;

/**
 * Multiplication is a subclass of Operation, it is used for mathematical multiplication
 *
 * @author 	Arda Iynem
 * @version 1.00 15.11.2021
 */
public class Multiplication extends Operation{
    // Constructor
    /**
     * Constructs a Multiplication operation
     */
    public Multiplication() {
        super();
        nameOperation = "Multiplication";
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
        return a * b;
    }
}
