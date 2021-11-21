// Building Object
// This object is a subclass of the Structure Object
// Thus it will inherit all the protected characteristics (Height, width, length, location) of the Structure Object

// Specialised characteristics of Building object:
// Number of Rooms
// Number of Floors

// Specialised methods of Building Objects
// Calculating floor space (area of the building) -> #floors*length*width
// Computing average room size -> total area/#rooms

public class T3Building extends T3Structure{

    // Protected specialised characteristics
    protected int rooms, floors;


    // Getter Method for accesing rooms and floors
    public int getRooms(){
        return rooms;
    }

    public int getFloors(){
        return floors;
    }

    // Setter Methods for setting number of rooms and floors
    public void setFloors(int f){
        floors = f;
    }

    public void setRooms(int r){
        rooms = r;
    }


    // Method for computing floor space
    public double computeFloorSpace(){
        return floors*length*width; // Since int can be implicitly typecast into double, the multiplication of int and double will be double only
    }

    // Method for computing room size
    public double getRoomSize(){
        return computeFloorSpace()/rooms; // Since int can be implicitly typecast into double, the division of int and double will be double only
    }

}