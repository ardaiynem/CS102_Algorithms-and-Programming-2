public class ExceptionDemo extends RuntimeException {
    public ExceptionDemo() {}

    public ExceptionDemo(String message) {
        super(message);
    }
}
