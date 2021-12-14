// Object defining a Triangle
// This object will be a subclass of the Shape Object
// It will have both the characteristics defined by the Shape Object : Color and Filled/Unfilled

// Other Characteristics of Rectangle object
//-> Coordinates of the triangle edges 
//-> Area of the Rectangle
public class Triangle extends Shape{

    // Coordinates of the traingle object edges are defined as instance variables
    public int x1;
    public int x2;
    public int x3;
    public int y1;
    public int y2;
    public int y3;

    // Area of the rectangle can be calculated via a method
    // Heron's Formula
    public double SideA(){ // Double since we will be returning a square root value
        // Using Math module
        return Math.sqrt(Math.pow(x2 - x1,2) + Math.pow(y2 - y1,2));
    }

    public double SideB(){ // Double since we will be returning a square root value
        // Using Math module
        return Math.sqrt(Math.pow(x3 - x1,2) + Math.pow(y3 - y1,2));
    }

    public double SideC(){ // Double since we will be returning a square root value
        // Using Math module
        return Math.sqrt(Math.pow(x3 - x2,2) + Math.pow(y3 - y2,2));
    }

    public double TriangleArea(){
        double s = 0.5*(SideA() + SideB() + SideC());
        return Math.sqrt(s*(s - SideA())*(s - SideB())*(s - SideC()));    
    }

}