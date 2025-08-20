class InvalidSoundException extends Exception{
    InvalidSoundException(String msg){
        super(msg);
    }
}
abstract class Animal{
    public abstract void makeSound();
    private String name;
    private String sound;

    public void setName(String name) {
        if(name == null || name.isEmpty()){
            name = "unknown";
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public Animal(String name,String sound) throws InvalidSoundException{
        setName(name);
        setSound(sound);
    }
    public void setSound(String sound) throws InvalidSoundException{
        if (sound == null || sound.isEmpty()){
            throw new InvalidSoundException("Specify the sound");
        }
        this.sound = sound;
    }

    public String getSound() {
        return sound;
    }
}

class Dog extends Animal{
    public void makeSound(){
        System.out.println("Type : Dog ,Name : "+getName()+" ,Sound : "+getSound());
    }
    public Dog(String name,String sound) throws InvalidSoundException{
        super(name,sound);
    }
}
class Cat extends Animal{
    public void makeSound(){
        System.out.println("Type : Cat ,Name : "+getName()+" ,Sound : "+getSound());
    }
    public Cat(String name,String sound) throws InvalidSoundException{
        super(name,sound);
    }
}class Cow extends Animal{
    public void makeSound(){
        System.out.println("Type : Cow ,Name : "+getName()+" ,Sound : "+getSound());
    }
    public Cow(String name,String sound) throws InvalidSoundException{
        super(name,sound);
    }
}


public class animalSoundSimulator {
    public static void main(String[] args) {
        try {
            Animal c = new Cat("biralo","mawo mawo");
            Animal l = new Dog("","hau hau");
            l.makeSound();
            c.makeSound();
        } catch (InvalidSoundException e) {
            System.out.println("message : "+e.getMessage());
        }
    }
}
