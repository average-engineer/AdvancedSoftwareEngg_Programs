public class Employee {

    // Instance Variable
    private int salary;

    // Methods
    // Cleaning Room
    public void cleanRoom(int capacity){
        // Once a room is cleaned, the salary gained by the employee is: capacity*5€
        salary = salary + (5*capacity);

    }

    // Getting salary
    public int getSalary(){
        return salary;
    }
    
}
