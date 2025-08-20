class InvalidApplienceException extends Exception {
    InvalidApplienceException(String msg) {
        super(msg);
    }
}
abstract class Appliance{
    abstract void turnOn();
    abstract void turnOff();
    private String action;

    public String getAction() {
        return action;
    }

    public void setAction(String action) throws InvalidApplienceException {
        if(action == null || action.isEmpty()){
          throw new InvalidApplienceException("Include the action of applience");
        }
        this.action = action;
    }
    public Appliance(String action) throws InvalidApplienceException{
        setAction(action);
    }

}
class Fan extends Appliance{
    public Fan(String action) throws InvalidApplienceException{
        super(action);
    }
    void turnOn(){
        System.out.println("Fan is On so : "+getAction());
    }
    void turnOff(){
        System.out.println("Fan is Off so, no : "+getAction());
    }
}
class Light extends Appliance{
    public Light(String action) throws InvalidApplienceException{
        super(action);
    }
    void turnOn(){
        System.out.println("Light is On so : "+getAction());
    }
    void turnOff(){
        System.out.println("Light is Off so, no : "+getAction());
    }
}
class AC extends Appliance{
    public AC(String action) throws InvalidApplienceException{
        super(action);
    }
    void turnOn(){
        System.out.println("AC is On so change in : "+getAction());
    }
    void turnOff(){
        System.out.println("AC is Off so, no change in : "+getAction());
    }
}
public class applianceControlSystem {
    public static void main(String[] args) {
        try {
            Appliance[] appliances = {
                    new Fan("Wind"),
            new AC("Temperature"),
            new Light("bright")
        };
            System.out.println("Turning ON all appliances:");
            for (Appliance a : appliances) {
                a.turnOn();
            }


            System.out.println("\nTurning OFF all appliances:");
            for (Appliance a : appliances) {
                a.turnOff();
            }

        } catch (InvalidApplienceException e) {
            System.out.println(e.getMessage());
        }
    }
}
