// Structure Object
// Characteristics -> Length, Height, Width and L ocation
// Behaviour -> Allows us to access the location of the structure using a getter method

public class T3Structure{
    
    // Characteristics of the Structure object are defined as Protected Instance Variables
    // Since they are protected, we can't access them from any other program file
    // We can use getter function to access/return these protected variables
    // We can also use subclasses of this object to access these characteristics

    protected double length, width, height;
    protected String location = "North";

    // Public getter method to access the protected characteristics
    public String getLocation(){
        return location;
    }

    public double getLength(){
        return length;
    }
    public double getWidth(){
        return width;
    }
    public double getHeight(){
        return height;
    }

    // Public setter methods to set the values of protected characteristics
    public void setLength(double l){
        length = l;
    }
    public void setHeight(double h){
        height = h;
    }
    public void setWidth(double w){
        width = w;
    }
}