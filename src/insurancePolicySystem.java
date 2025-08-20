class InvalidInsuranceException extends Exception {
    public InvalidInsuranceException(String message) {
        super(message);
    }
}

abstract class InsurancePolicy {
    private int age;
    private double coverageAmount;

    public InsurancePolicy(int age, double coverageAmount) throws InvalidInsuranceException {
        if (age <= 0) {
            throw new InvalidInsuranceException("Age must be greater than zero!");
        }
        if (coverageAmount <= 0) {
            throw new InvalidInsuranceException("Coverage amount must be greater than zero!");
        }
        this.age = age;
        this.coverageAmount = coverageAmount;
    }

    public int getAge() {
        return age;
    }

    public double getCoverageAmount() {
        return coverageAmount;
    }

    public abstract double calculatePremium();
}

class HealthInsurance extends InsurancePolicy {
    public HealthInsurance(int age, double coverageAmount) throws InvalidInsuranceException {
        super(age, coverageAmount);
    }

    @Override
    public double calculatePremium() {
        return getCoverageAmount() * 0.05 + getAge() * 2; // Example formula
    }
}

class LifeInsurance extends InsurancePolicy {
    public LifeInsurance(int age, double coverageAmount) throws InvalidInsuranceException {
        super(age, coverageAmount);
    }

    @Override
    public double calculatePremium() {
        return getCoverageAmount() * 0.03 + getAge() * 1.5; // Example formula
    }
}

class TravelInsurance extends InsurancePolicy {
    public TravelInsurance(int age, double coverageAmount) throws InvalidInsuranceException {
        super(age, coverageAmount);
    }

    @Override
    public double calculatePremium() {
        return getCoverageAmount() * 0.02 + getAge() * 1; // Example formula
    }
}

public class insurancePolicySystem {
    public static void main(String[] args) {
        try {
            InsurancePolicy health = new HealthInsurance(30, 100000);
            InsurancePolicy life = new LifeInsurance(40, 500000);
            InsurancePolicy travel = new TravelInsurance(25, 50000);

            System.out.println("Health Insurance Premium: Rs. " + health.calculatePremium());
            System.out.println("Life Insurance Premium: Rs. " + life.calculatePremium());
            System.out.println("Travel Insurance Premium: Rs. " + travel.calculatePremium());



        } catch (InvalidInsuranceException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}


