class InvalidMeasurementException extends Exception{
    InvalidMeasurementException(String msg){
        super(msg);
    }
}

abstract class Shape {
    public abstract double calculateArea();
}
class Circle extends Shape{
    private double radius;

    public double getRadius() {
        return radius;
    }

    public Circle(double radius) throws  InvalidMeasurementException{
        setRadius(radius);
    }

    public void setRadius(double radius) throws InvalidMeasurementException {
        if(radius<=0){
            throw new InvalidMeasurementException("Radius must be of some length");
        }
        else this.radius = radius;
    }
    public double calculateArea(){
        return (radius * radius * 3.14);
    }
}

class Rectangle extends Shape{
    private double length;
    private double breadth;

    public double getBreadth() {
        return breadth;
    }

    public double getLength() {
        return length;
    }

    public Rectangle(double length,double breadth) throws  InvalidMeasurementException{
        setBreadth(breadth);
        setLength(length);
    }

    public void setLength(double length) throws InvalidMeasurementException {
        if(length<=0){
            throw new InvalidMeasurementException("length must be of some long");
        }
        else this.length = length;
    }
    public void setBreadth(double breadth) throws InvalidMeasurementException {
        if(breadth<=0){
            throw new InvalidMeasurementException("breadth must be of some long");
        }
        else this.breadth = breadth;
    }
    public double calculateArea(){
        return (length * breadth);
    }
}

public class abstractShapeClass {
    public static void main(String[] args) {
        try {
            Shape c = new Circle(5);
            Shape r = new Rectangle(4,2);
            System.out.println("Area of Rectangle : "+ r.calculateArea());
            System.out.println("Area of Circle : "+ c.calculateArea());
            Shape cc = new Circle(0);
        }
        catch (InvalidMeasurementException e){
            System.out.println("Message : "+ e.getMessage());
        }
    }
}
