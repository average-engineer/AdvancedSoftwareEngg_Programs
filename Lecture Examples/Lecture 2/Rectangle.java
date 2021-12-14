// Object defining a rectangle
// This object will be a subclass of the Shape Object
// It will have both the characteristics defined by the Shape Object : Color and Filled/Unfilled

// Other Characteristics of Rectangle object
//-> Lengths of the rectangle 
//-> Area of the Rectangle
public class Rectangle extends Shape{

    // Lengths of the rectangle object are defined as instance variables
    public int l1;
    public int l2;

    // Area of the rectangle can be calculated via a method
    public int AreaRec(){
        return l1*l2;
    }

}
