class InvalidLoanAmountException extends Exception {
    public InvalidLoanAmountException(String message) {
        super(message);
    }
}

abstract class Loan {
    private double amount;
    private double rate;
    private int years;

    public Loan(double amount, double rate, int years) throws InvalidLoanAmountException {
        if (amount <= 0 || rate <= 0 || years <= 0) {
            throw new InvalidLoanAmountException("Loan can't be given due to incorrect variable!");
        }
        this.amount = amount;
        this.rate = rate;
        this.years = years;
    }

    public double getAmount() {
        return amount;
    }

    public double getRate() {
        return rate;
    }

    public int getYears() {
        return years;
    }

    public abstract double calculateInterest();
}

class HomeLoan extends Loan {
    public HomeLoan(double amount, double rate, int years) throws InvalidLoanAmountException {
        super(amount, rate, years);
    }

    @Override
    public double calculateInterest() {
        return getAmount() * getRate() * getYears() / 100;
    }
}

class CarLoan extends Loan {
    public CarLoan(double amount, double rate, int years) throws InvalidLoanAmountException {
        super(amount, rate, years);
    }

    @Override
    public double calculateInterest() {
        return getAmount() * getRate() * getYears() / 100;
    }
}

class EducationLoan extends Loan {
    public EducationLoan(double amount, double rate, int years) throws InvalidLoanAmountException {
        super(amount, rate, years);
    }

    @Override
    public double calculateInterest() {
        return getAmount() * getRate() * getYears() / 100;
    }
}

public class loanProcessingSystem {
    public static void main(String[] args) {
        try {
            Loan l1 = new HomeLoan(500000, 7.5, 10);
            Loan l2 = new CarLoan(800000, 9.0, 5);
            Loan l3 = new EducationLoan(300000, 5.5, 7);

            System.out.println("Home Loan Interest: " + l1.calculateInterest());
            System.out.println("Car Loan Interest: " + l2.calculateInterest());
            System.out.println("Education Loan Interest: " + l3.calculateInterest());

        } catch (InvalidLoanAmountException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}




