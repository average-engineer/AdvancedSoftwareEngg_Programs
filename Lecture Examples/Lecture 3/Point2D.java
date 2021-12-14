// Class for Point 2D object

public class Point2D{

    // Fields of the point object
    // X-Coordinate
    // Y-Coordinate
    private double x;
    private double y;

    // Class Constructor
    // The object needs to be called in the following manner:
    // Point2D(x,y)

    public Point2D(double x, double y){ // Here, the x and y in the arguments of the class will be local instance variables
        // The private instance variables/fields of thw class need to be assigned to the local variables 
        // this. is used since the local variables and the instance variables have the same name
        this.x = x;
        this.y = y;
    }

    // Getter functions to access private X and Y coordinates
    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    // Method to move the Point 2D object on 2D plane
    public void move(double deltaX, double deltaY){
        // The private variables are modified using this function
        x = x + deltaX;
        y = y + deltaY;
    }
}
