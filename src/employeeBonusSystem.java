class InvalidEmployeeException extends Exception {
    InvalidEmployeeException(String msg) {
        super(msg);
    }
}
class baseEmployee{
    private String name;
    private int em_id;
    private double salary;

    public baseEmployee(int id, String name, double salary) throws InvalidEmployeeException {
        setEm_id(id);
        setName(name);
        setSalary(salary);
    }

    public void setEm_id(int em_id) throws InvalidEmployeeException {
        if (em_id <= 0) {
            throw new InvalidEmployeeException("Id invalid");
        }
        else {
            this.em_id = em_id;
        }
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            this.name = "Unknown";
        }
        else {
            this.name = name;
        }
    }

    public void setSalary(double salary) throws InvalidEmployeeException{
        if(salary<=0){
            throw new InvalidEmployeeException("Salary is invalid");
        }
        else{
            this.salary = salary;
        }
    }

    public double getSalary() {
        return salary;
    }

    public int getEm_id() {
        return em_id;
    }

    public String getName() {
        return name;
    }

    public void display(){
        System.out.println("Name : "+getName()+" ,ID : "+getEm_id()+" ,Salary : "+getSalary());
    }
}
class PermanentEmployee extends baseEmployee{
    public PermanentEmployee(int em_id, String name, double salary) throws InvalidEmployeeException {
        super(em_id, name, salary);

    }
    public void display(){
        System.out.println("Name : "+getName()+" ,ID : "+getEm_id()+" ,Salary : "+(getSalary() + getSalary()*0.1));
    }


}
class TemporaryEmployee extends baseEmployee{
    public TemporaryEmployee(int em_id, String name, double salary) throws InvalidEmployeeException {
        super(em_id, name, salary);

    }
    public void display(){
        System.out.println("Name : "+getName()+" ,ID : "+getEm_id()+" ,Salary : "+(getSalary() + getSalary()*0.05));
    }


}

public class employeeBonusSystem {
    public static void main(String[] args) {
        try{
            baseEmployee e1 = new TemporaryEmployee(-12,"",-200000);
            e1.display();

        } catch (Exception e) {
            System.out.println("message : "+e.getMessage());
        }
    }
}
