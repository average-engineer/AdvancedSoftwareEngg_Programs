// Class for a Bicycle Object

public class Bicycle {

    // Instance Variables (Non Static)
    // These variables can have different values in different Bicycle Objects
    private int cadence, gear, speed, id;

    // Static class variable
    // Variable for keeping a count on the number of Bicycle Objects created
    // Variable has to be updated after everytime the instance of the object is called (i.e. everytime a Bicycle Object is created)
    private static int numberOfBicycles = 0; // Initialising with 0
    
    // Class Constructor
    // numberOfBicycles variable has to be increased by 1 everytime a new instance of the Bicycle class is called
    // The first instance should have the ID 1
    public Bicycle(int cadence,int gear,int speed){
        // As soon as the Bicycle class is called, the numberOfBicycle variable increments by 1
        numberOfBicycles = numberOfBicycles + 1;

        // Setter methods for initialising the instance variables
        setCadence(cadence);
        setGear(gear);
        setSpeed(speed);
        // ID is equal to the current value of the numberOfBicycles
        setID();
    }

    // Setter Methods for setting the values of the Instance non static variables
    private void setCadence(int cadence){
        this.cadence = cadence;
    }

    private void setGear(int gear){
        this.gear = gear;
    }

    private void setSpeed(int speed){
        this.speed = speed;
    }

    private void setID(){
        this.id = numberOfBicycles;
    }

    // Getter Methods for obtaining the instance variables 
    public int getCadence(){
        return this.cadence;
    }

    public int getGear(){
        return this.gear;
    }


    public int getSpeed(){
        return this.speed;
    }

    public int getID(){
        return this.id;
    }

    // Overriding the toString() method
    // toString() is a public method since it is used for console printout in the main method outside the class
    public String toString(){
        return "A Bicycle (ID: " + getID() + ") was created.";
    }


}
