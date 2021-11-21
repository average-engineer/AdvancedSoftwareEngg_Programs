// Hotel Object
// This is a subclass of the Building Object
// This object also implements the Rating interface
// This object class also has a constructor 

public class T3Hotel extends T3Building implements T3Rating{

    // Name of the hotel stored as a private field
    private String name;
    
    // Constructor
    public T3Hotel(String hotelName, int hotelRooms){
        name = hotelName;
        rooms = hotelRooms; // Since T3Building is a superclass, rooms is already a field belong to T3Hotel
    }

    // Getter method to access the hotel name
    public String getName(){
        return name;
    }

    // Compute Rating Method (from T3Rating interace)
    public int computeRating(){
        if(getRoomSize() < 20){
            return 1;
        }
        else if(getRoomSize() > 20 && getRoomSize() < 50){
            return 2;
        }
        else{
            return 3;
        }
    }
}