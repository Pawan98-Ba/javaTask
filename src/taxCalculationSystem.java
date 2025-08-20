class InvalidIncomeException extends Exception {
    public InvalidIncomeException(String message) {
        super(message);
    }
}

abstract class TaxPayer {
    private double income;

    public TaxPayer(double income) throws InvalidIncomeException {
        if (income < 0) {
            throw new InvalidIncomeException("Income cannot be negative!");
        }
        this.income = income;
    }

    public double getIncome() {
        return income;
    }

    public abstract double calculateTax();
}

class Individual extends TaxPayer {
    public Individual(double income) throws InvalidIncomeException {
        super(income);
    }

    @Override
    public double calculateTax() {
        return getIncome() * 0.1; // 10% tax
    }
}

class Business extends TaxPayer {
    public Business(double income) throws InvalidIncomeException {
        super(income);
    }

    @Override
    public double calculateTax() {
        return getIncome() * 0.25; // 25% tax
    }
}

class Freelancer extends TaxPayer {
    public Freelancer(double income) throws InvalidIncomeException {
        super(income);
    }

    @Override
    public double calculateTax() {
        return getIncome() * 0.15; // 15% tax
    }
}

public class taxCalculationSystem {
    public static void main(String[] args) {
        try {
            TaxPayer t1 = new Individual(50000);
            TaxPayer t2 = new Business(200000);
            TaxPayer t3 = new Freelancer(80000);

            System.out.println("Individual Tax: " + t1.calculateTax());
            System.out.println("Business Tax: " + t2.calculateTax());
            System.out.println("Freelancer Tax: " + t3.calculateTax());

            // Uncomment to test exception
            // TaxPayer invalid = new Individual(-5000);

        } catch (InvalidIncomeException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

