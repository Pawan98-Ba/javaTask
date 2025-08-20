class InvalidHospitalException extends Exception{
    InvalidHospitalException(String msg){
        super(msg);
    }
}
abstract class Person{
    private String name;
    private int age;

    public void setName(String name) throws InvalidHospitalException{
        if(name == null || name.isEmpty()){
            throw new InvalidHospitalException("name is invalid");
        }
        this.name = name;
    }

    public void setAge(int age) throws InvalidHospitalException{
        if(age<=0){
            throw new InvalidHospitalException("Age must be greater then zero");
        }
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
    public Person(String name,int age) throws InvalidHospitalException{
        setAge(age);
        setName(name);
    }
    public abstract void display();

}

class Doctor extends Person{
    private String doc;

    public void setDoc(String doc) throws InvalidHospitalException{
        if(doc == null || doc.isEmpty()){
            throw new InvalidHospitalException("Enter the specialization of doctor");
        }
        this.doc = doc;
    }

    public String getDoc() {
        return doc;
    }
    public Doctor(String name,String doc,int age) throws InvalidHospitalException{
        super(name, age);
        setDoc(doc);
    }

    public void display(){
        System.out.println("Name : "+getName() + ", Age : "+getAge()+", Specialization : "+doc);
    }
}

class Patient extends Person{
    private String disease;

    public void setDisease(String disease) throws InvalidHospitalException{
        if (disease==null || disease.isEmpty()){
            throw new InvalidHospitalException("mention the disease of the patient");
        }
        this.disease = disease;
    }

    public String getDisease() {
        return disease;
    }

    public Patient(String name,String disease,int age) throws InvalidHospitalException{
        super(name, age);
        setDisease(disease);
    }
    public void display(){
        System.out.println("Name : "+getName() + ", Age : "+getAge()+", Specialization : "+disease);
    }
}

public class hospitalManagementSystem {
    public static void main(String[] args) {
        try {
            Person d = new Doctor("pawan","neuro",18);
            d.display();
            Person p = new Patient("Kapor","testicular cancer",18);
            p.display();
            Person pp = new Patient("","",19);
            pp.display();
        }
        catch (InvalidHospitalException e){
            System.out.println("Message : "+e.getMessage());
        }
    }
}
