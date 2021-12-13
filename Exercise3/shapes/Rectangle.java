// Class for a rectangle object
// Subclass of the AbstractShape class

// package de.ase.ima.shapes;
package shapes;

import java.awt.Color; // Java inbuilt package for using colors
import java.util.List; // Java inbuilt package for using List Data Types


public class Rectangle extends AbstractShape{

    private List<Point> points; // Point List describig the shape
    
    private Color color;

    private boolean filled;

    // Constructors for the Rectangle Object

    // Constructor 1: Upper Right and Lower Left points defined as point objects
    public Rectangle(Point lowerLeft, Point upperRight, Color color, boolean filled){

        // Using inherited method to add the point to the private point list 
        // addPoint method is defined in the superclass AbstractShape.java
        addPoint(lowerLeft);
        addPoint(upperRight);

        // Using inherited setter functions to set color and fill settings
        setColor(color);
        setFilled(filled);
    }

    // Constructor 2: X and Y coordinates of corner points defined as integers
    public Rectangle(int x1, int y1, int x2, int y2, Color color, boolean filled){

        // Since the addPoint method only takes point objects as input, we have to define
        // new point objects using the input integer coordinates

        Point p1 = new Point(x1,y1);
        Point p2 = new Point(x1,y2);
        Point p3 = new Point(x2,y2);
        Point p4 = new Point(x2,y1);

        addPoint(p1);
        addPoint(p2);
        addPoint(p3);
        addPoint(p4);

        // Using inherited setter functions to set color and fill settings
        setColor(color);
        setFilled(filled);

    }

}

