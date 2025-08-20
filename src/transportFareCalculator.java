

class InvalidFareException extends Exception {
    public InvalidFareException(String message) {
        super(message);
    }
}

class Transport {
    private double distance;

    public Transport(double distance) throws InvalidFareException {
        if (distance <= 0) {
            throw new InvalidFareException("Distance must be greater than zero!");
        }
        this.distance = distance;
    }

    public double getDistance() {
        return distance;
    }

    public double calculateFare() {
        return 0.0;
    }
}

class Bus extends Transport {
    public Bus(double distance) throws InvalidFareException {
        super(distance);
    }

    @Override
    public double calculateFare() {
        return getDistance() * 2;
    }
}

class Train extends Transport {
    public Train(double distance) throws InvalidFareException {
        super(distance);
    }

    @Override
    public double calculateFare() {
        return getDistance() * 1.5;
    }
}

class Taxi extends Transport {
    public Taxi(double distance) throws InvalidFareException {
        super(distance);
    }

    @Override
    public double calculateFare() {
        return 50 + getDistance() * 10;
    }
}

public class transportFareCalculator {
    public static void main(String[] args) {
        try {
            Transport bus = new Bus(10);
            Transport train = new Train(20);
            Transport taxi = new Taxi(5);

            System.out.println("Bus Fare: Rs. " + bus.calculateFare());
            System.out.println("Train Fare: Rs. " + train.calculateFare());
            System.out.println("Taxi Fare: Rs. " + taxi.calculateFare());


        } catch (InvalidFareException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}



