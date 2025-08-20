//exception
class InvalidVechicleException extends Exception {
    InvalidVechicleException(String msg) {
        super(msg);
    }
}

//superclass
class Vchicle{
    private String brandName;
    private int speed;

    public Vchicle(String brandName,int speed) throws InvalidVechicleException{
    setSpeed(speed);
    setBrandName(brandName);
    }

    //setter

    public void setBrandName(String brandName) {
        if(brandName == null || brandName.isEmpty()){
            this.brandName = "unknown";
        }
        else{
            this.brandName = brandName;
        }
    }

    public void setSpeed(int speed) throws InvalidVechicleException{
        if(speed<0){
            throw new InvalidVechicleException("Speed is Invalid");
        }
        this.speed = speed;

    }

    //getter

    public String getBrandName() {
        return brandName;
    }

    public int getSpeed() {
        return speed;
    }

    public void displayInfo() {
        System.out.println("Brand: " + brandName + ", Speed: " + speed + " km/h");
    }

}

class Car extends Vchicle{
    private String engine;

    public Car(String brandName,int speed,String engine) throws InvalidVechicleException{
        super(brandName,speed);
        setEngine(engine);
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) throws InvalidVechicleException {
        if(engine == null || engine.isEmpty()){
            throw new InvalidVechicleException("name the engine of car !");
        }
        this.engine = engine;
    }
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Engine: " + engine);
    }
}
class Bike extends Vchicle{
    private String cc;

    public Bike(String brandName,int speed,String cc) throws InvalidVechicleException{
        super(brandName,speed);
        setCc(cc);
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) throws InvalidVechicleException {
        if(cc == null || cc.isEmpty()){
            throw new InvalidVechicleException("name the cc of bike !");
        }
        this.cc = cc;
    }
    public void displayInfo() {
        super.displayInfo();
        System.out.println("CC: " + cc);
    }
}



public class vechicleInheritanceExample {
    public static void main(String[] args) {
        try {
            Vchicle v1 = new Car("Ferrari",200,"V12");
            Vchicle v2 = new Bike("H2R",300,"1000");
            v1.displayInfo();
            v2.displayInfo();
            Vchicle v3 = new Car("hondacivic",200,"");
            v3.displayInfo();
        }
        catch (InvalidVechicleException e){
            System.out.println("message : "+ e.getMessage());
        }

    }
}
