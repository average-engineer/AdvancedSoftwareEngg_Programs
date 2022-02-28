import java.util.ArrayList;
public class Ex9T4 {
    public static void main(String[] args) {
        /*ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        System.out.println(list.get(0));*/

        // Creating a new hotel
        Hotel hotel = new Hotel();

        // Number of Rooms
        hotel.setnRooms(50);
        // Number of employees
        hotel.setnEmp(5);


        // Number of rooms with capacity 1
        int nCap1 = 20;
        // Number of rooms with capacity 2
        int nCap2 = 15;
        // Number of rooms with capacity 4
        int nCap4 = 10;
        // Number of rooms with capacity 6
        int nCap6 = 5;

        // Adding rooms to hotel according to the given capacities
        for(int i = 0; i < 50; i ++){

            // First 20 rooms are of capacity 1
            if(i < nCap1){
                hotel.addRoom(1);
            }

            // Next 15 rooms are of capacity 2
            else if(i>=nCap1 && i<(nCap1 + nCap2)){

                hotel.addRoom(2);

            }

            // Next 10 rooms are of capacity 4
            else if(i>=(nCap1 + nCap2) && i<(nCap1 + nCap2 + nCap4)){

                hotel.addRoom(4);

            }

            // Next 5 rooms are of capacity 6
            else if(i>=(nCap1 + nCap2 + nCap4)){

                hotel.addRoom(6);

            }
        }

        // Adding employees to the hotel
        for(int j = 0; j < 5; j++){
            hotel.addEmployee(new Employee());
        }

        // Cleaning the rooms
        hotel.cleanRooms();

        // Printing the salary list
        hotel.printSalaryList();

    }
}
