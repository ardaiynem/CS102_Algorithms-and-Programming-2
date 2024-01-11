package operations;

/**
 * Operation is an abstract superclass for mathematical operations to be used in program
 *
 * @author 	Arda Iynem
 * @version 1.00 15.11.2021
 */
public abstract class Operation {
    // Variables
    protected int numberOfTimesCalled;
    protected boolean isUnary;
    protected String nameOperation;

    // Constructor
    /**
     * Constructs an Operation
     */
    public Operation() {
        numberOfTimesCalled = 0;
        isUnary = false;
    }

    // Accessors
    /**
     * Accessor for the number of times the operation called
     * @return Number of times the operation called
     */
    public int getNumberOfTimesCalled() {
        return numberOfTimesCalled;
    }

    /**
     * Accessor for the name of operation
     * @return Name of operation
     */
    public String getNameOperation() {
        return nameOperation;
    }

    /**
     * Accessor for the type of operation
     * @return Type of operation
     */
    public boolean getIsUnary() {
        return isUnary;
    }

    // Methods
    /**
     * Calculates the given numbers in with the operation's calculateResult method
     * @param a Number 1
     * @param b Number 2
     * @return Result
     */
    public abstract double calculateResult(double a, double b);
}
