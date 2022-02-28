import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Hotel {


    // Array List to store the rooms
    private ArrayList<Room> roomList = new ArrayList<>();
    // H Map -> Key: Employee, Value: Salary
    private HashMap<Employee,Integer> employeeList = new HashMap<>();



    // Number of rooms in the hotel
    private int nRooms;


    // Number of Employees
    private int nEmp;

    // Adding Room
    // Hotel has a strong dependence on the rooms (composition)
    public void addRoom(int capacity){
        // Adding the room to the array list of room objects
        roomList.add(new Room(capacity));
    }

    // Adding employee to the employee list
    // Hotel has a weak dependence on the employees (aggregation)
    public void addEmployee(Employee employee){
        employeeList.put(employee, employee.getSalary());
    }

    // Method for cleaning the rooms
    // When the method is executed, each employee cleans the rooms alloted to them
    public void cleanRooms(){
        // Varaible for iterating over rooms
        int count = 0;
        // Looping over the employee list
        for(Map.Entry<Employee,Integer> entry: employeeList.entrySet()){
            // Looping over the rooms
            for(int ii = count; ii < count + (nRooms/nEmp); ii ++){ // Number of Rooms cleaned by each employee -> (Number of Rooms/Number of Employees)
                entry.getKey().cleanRoom(roomList.get(ii).getCapacity()); // The salaries of the employees will keep getting updated as the clean the rooms
            }

            count = count + (nRooms/nEmp); // Updating count variable for the next employee
        }
            
    }

    // Method to print the salary list of all the employees
    void printSalaryList(){
        // The values in the employee list is printed
        ArrayList<Integer> salaryList = new ArrayList<>();
        for(Map.Entry<Employee,Integer> entry: employeeList.entrySet()){
            salaryList.add(entry.getKey().getSalary()); // salaryList.add(entry.getValue()) won't work since the old non updated salaries of the emploee objects have been saved as values
        }
        System.out.println(salaryList);
    }

    // Setter Methods
    void setnRooms(int nRooms){
        this.nRooms  = nRooms;
    }

    void setnEmp(int nEmp){
        this.nEmp  = nEmp;
    }
}


    
