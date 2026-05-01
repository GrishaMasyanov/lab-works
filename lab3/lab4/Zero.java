public class Zero {
    public static void main(String[] args) {
        int numerator = 10;
        int denominator = 0;

        try {
            double result = divide(numerator, denominator);
            System.out.println("Result: " + result);
        } catch (exception e) {
            System.out.println("Handled custom exception: " + e.getMessage());
            logger.log(e);
        }
    }
    public static double divide(int a, int b) throws exception {
        if (b == 0) {
            throw new exception("Attempted to divide by zero.");
        }
        return (double) a / b;
    }
}
