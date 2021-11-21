// Exercise 2 Task 3

public class T3CityManager{

    // Main Method
    public static void main(String[] args){

        // 2 buildings as building objects
        T3Building building1 = new T3Building();
        T3Building building2 = new T3Building(); // T3Building building2 = new T3Hotel() will work too due to polymorphism

        // Number of rooms in building 1
        building1.setRooms(5);
        // Number of floors in building 1
        building1.setFloors(2);

        // Length, width and height of Building 1 rooms
        building1.setLength(25.0);
        building1.setWidth(100.0);
        building1.setHeight(8.0);

        // Number of rooms in building 2
        building2.setRooms(2);
        // Number of floors in building 2
        building2.setFloors(1);


        // Length, width and height of Building 2 rooms
        building2.setLength(100.0);
        building2.setWidth(50.0);
        building2.setHeight(6.0);

        // Hotel
        // Hotel Name: ASE Gloria
        // Number of Rooms in the hotel = 500
        T3Hotel hotel = new T3Hotel("ASE Gloria",500);
        // Number of floors in hotel
        hotel.setFloors(5);
        // Since the hotel name is a private field in the T3Hotel objewct, we need to use the getter method to access it here
        // Length, width and height of Hotel rooms
        hotel.setLength(100.0);
        hotel.setWidth(40.0);
        hotel.setHeight(50.0);


        // Code Ouptut:
        System.out.println("Our city has the following buildings:");
        System.out.println("\tBuilding 1 with "+building1.getFloors()+" floors and "+building1.getRooms()+" rooms. It offers a floor space of "+building1.computeFloorSpace());
        System.out.println("\tBuilding 2 with "+building2.getFloors()+" floors and "+building2.getRooms()+" rooms. It offers a floor space of "+building2.computeFloorSpace());
        System.out.println("Further, we have a hotel:");
        System.out.println("\t"+hotel.getName()+"with "+hotel.getFloors()+" floors and "+hotel.getRooms()+" rooms. It has a rating of "+hotel.computeRating()+" stars.");

        /* building.length = 10;
        building.height = 100;
        building.width = 5; */ 
        // The above will not work since all instance variables are protected

        /* String location = building.getLocation();
        System.out.println(location);

        double length = building.getLength();
        double width = building.getWidth();
        int rooms = building.getRooms();
        int floors = building.getFloors();


        // System.out.println(length*width*floors); */



    }
}