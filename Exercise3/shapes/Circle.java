// Class for a Circle Object
// It is a subclass of AbstractShape

package shapes;

import java.awt.Color; // Java inbuilt package for using colors
import java.util.List; // Java inbuilt package for using List Data Types
import java.util.ArrayList; // Java inbuilt package for using Array List Data Types

public class Circle extends AbstractShape{

    private List<Point> points; // Point List describing the shape

    private Point centre;

    private int radius;

    private Color color;

    private boolean filled;

    // Class Constructor
    public Circle(Point centre, int radius, Color color, boolean filled, int stepSize){

        this.centre = centre;
        this.radius = radius;

        // Using inherited method to add the point to the private point list 
        // addPoint method is defined in the superclass AbstractShape.java

        // Using inherited setter functions to set color and fill settings
        setColor(color);
        setFilled(filled);
        // Alternatively: this.color = color, this.filled = filled (that is what setColor and setFilled are basically doing)

        
        // Obtaining the perimeter points for the given step size
        for(int theta = 0; theta <= 360; theta = theta + stepSize){

            int x = centre.getX() + (int)(radius*Math.cos(Math.toRadians(theta))); // Explicitly typecasting to integer type since the point object takes only integer input
            int y = centre.getY() + (int)(radius*Math.sin(Math.toRadians(theta)));// Explicitly typecasting to integer type since the point object takes only integer input

            // Very Important-> Since we are using shape frame, we need the points on the perimeter to decribe the circular shape, adding the centre point to the point list won't
            // do us any good

            // Using inherited method to add the perimeter point to the private point list 
            // addPoint method is defined in the superclass AbstractShape.java
            addPoint(new Point(x,y));
            
        }



    }

    // Method for computing points on the perimeter
    // The points are returned as point objects
    public ArrayList<Point> getPerimeterPoints(int stepSize){ // Stepsize determines how far apart the points are placed, step size is measured in degrees


        // The step size should be such that a whole number of points is achieved and the step size remains constant throughout
        // If the stepsize doesn't divide 360 degrees into finite number of equal parts, then an illegal argument exception is returned
        // Ideally, number of points = (360/StepSize) + 1
        if(360%stepSize != 0){
            throw new IllegalArgumentException("Invalid Step Size. Step Size should divide the points equally");
        }

        // Array List for storing the obtained perimeter point objects
        ArrayList<Point> periPoints = new ArrayList<>();

        for(int theta = 0; theta <= 360; theta = theta + stepSize){

            int x = centre.getX() + (int)(radius*Math.cos(Math.toRadians(theta))); // Explicitly typecasting to integer type since the point object takes only integer input
            int y = centre.getY() + (int)(radius*Math.sin(Math.toRadians(theta)));// Explicitly typecasting to integer type since the point object takes only integer input

            periPoints.add(new Point(x,y)); // Storing the x and y coordinates of the points as point objects and appending to the array list
            
        }

        return periPoints;

    }


}