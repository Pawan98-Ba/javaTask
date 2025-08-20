class Calculator {
    public int add(int a, int b) {
        return a + b;
    }

    public double add(double a, double b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public double subtract(double a, double b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public int divide(int a, int b) throws ArithmeticException {
        if (b == 0) throw new ArithmeticException("Division by zero!");
        return a / b;
    }

    public double divide(double a, double b) throws ArithmeticException {
        if (b == 0.0) throw new ArithmeticException("Division by zero!");
        return a / b;
    }
}

public class calculatorOverloading {
    public static void main(String[] args) {
        Calculator calc = new Calculator();

        System.out.println("Int Add: " + calc.add(10, 5));
        System.out.println("Double Add: " + calc.add(10.5, 5.2));
        System.out.println("Int Divide: " + calc.divide(10, 2));
        System.out.println("Double Divide: " + calc.divide(10.0, 3.0));

    }
}
