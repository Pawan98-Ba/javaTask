//exception
class InvalidSalaryException extends Exception {
    InvalidSalaryException(String msg) {
        super(msg);
    }
}

//abstract
abstract class Employee{
    private String name;
    private int em_id;
    private double salary;

    //construct
    public Employee(int id, String name, double salary) throws InvalidSalaryException {
        setEm_id(id);
        setName(name);
        setSalary(salary);
    }

    //setter

    public void setEm_id(int em_id) {
        if (em_id <= 0) {
            this.em_id = 0;
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

    public void setSalary(double salary) throws InvalidSalaryException{
        if(salary<=0){
            throw new InvalidSalaryException("Salary is invalid");
        }
        else{
            this.salary = salary;
        }
    }

    //getter

    public double getSalary() {
        return salary;
    }

    public int getEm_id() {
        return em_id;
    }

    public String getName() {
        return name;
    }

    //abstract method
    public abstract double calculateSalary();
}

class Manager extends Employee{
    public Manager(int em_id, String name, double salary) throws InvalidSalaryException {
        super(em_id, name, salary);
    }

    @Override
    public double calculateSalary(){
        return getSalary() * 1.2;
    }
}
class Developer extends Employee {
    public Developer(int em_id, String name, double salary) throws InvalidSalaryException {
        super(em_id, name, salary);
    }

    @Override
    public double calculateSalary(){
        return getSalary() * 1.1;
    }
}

public class employeeManagementSystem {
    public static void main(String[] args) {
        try {
            Employee e1 = new Manager(101, "Pawan", 50000);
            System.out.println("ID: " + e1.getEm_id() + ", Name: " + e1.getName() +
                    ", Salary: " + e1.calculateSalary());
            Employee e2 = new Developer(103, "Karan", -30000);
        }
        catch (InvalidSalaryException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

