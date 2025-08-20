

abstract class baseShape{
    abstract void draw();
}
class baseCircle extends baseShape{
    int radius;

    public void setRadius(int radius) throws InvalidMeasurementException {
        if(radius<=0){
            throw new InvalidMeasurementException("circle's radius less or equal to zero is dot");
        }
        this.radius = radius;
    }
    void draw(){
        System.out.println("Circle with radius : "+radius);
    }
    public baseCircle(int radius) throws InvalidMeasurementException{
        setRadius(radius);
    }
}
class baseSquare extends baseShape{
    int square;

    public void setlength(int square) throws InvalidMeasurementException {
        if(square<=0){
            throw new InvalidMeasurementException("Square's length less or equal to zero is dot");
        }
        this.square = square;
    }
    void draw(){
        System.out.println("Square with length : "+square);
    }
    public baseSquare(int square) throws InvalidMeasurementException{
        setlength(square);
    }
}
class baseTriangle extends baseShape{
    int side1;
    int side2;
    int side3;


    public void setSide1(int side1) throws InvalidMeasurementException {
        if(side1<=0){
            throw new InvalidMeasurementException("Triangle's side cannot be zero");
        }
        this.side1 = side1;
    }
    public void setSide2(int side2) throws InvalidMeasurementException {
        if(side2<=0){
            throw new InvalidMeasurementException("Triangle's side cannot be zero");
        }
        this.side2 = side2;
    }public void setSide3(int side3) throws InvalidMeasurementException {
        if(side3<=0){
            throw new InvalidMeasurementException("Triangle's side cannot be zero");
        }
        this.side3 = side3;
    }
    void draw() {

            System.out.println("Triangle with side : "+side1+","+side2+","+side3);

    }
    public baseTriangle(int side1,int side2,int side3) throws InvalidMeasurementException{
        setSide1(side1);
        setSide2(side2);
        setSide3(side3);
        if(!(((side1+side2)>side3) && ((side3+side2)>side1) && ((side1+side3)>side2))){
            throw new InvalidMeasurementException("the side of triangle is invalid");
        }
    }
}


public class shapeDrawer {
    public static void main(String[] args) {
        try {
            baseShape c = new baseCircle(2);
            c.draw();
            baseShape t = new baseTriangle(2,2,2);
            t.draw();

        }  catch (Exception e){
            System.out.println("Message : "+ e.getMessage());
        }
    }
}
