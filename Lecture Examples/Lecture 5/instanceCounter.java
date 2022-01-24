// Method to count the number of times an object (concrete instance of a class) is created from a class

public class instanceCounter{
    public static int count = 0;
    //private int count = 0;

    // Class Constructor
    public instanceCounter(){
        count = count + 1;
    }

    // toString() method
    public String toString(){
        return count + " number of times an object has been created";
    }

}