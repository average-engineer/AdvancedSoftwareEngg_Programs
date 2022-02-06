// Class for Building object

public class Building extends Construction {
    // Instance Variables
    protected int numberOfRooms;
    protected int numberOfFloors;

    //Public Methods
    public int getNumberOfRooms(){
        return numberOfRooms;
    }

    public double getFloorArea(){
        return numberOfFloors*length*width; // Since length and width are protected variables of Construction, they are inherited by subclass Building
    }
}
