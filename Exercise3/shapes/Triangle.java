// Class for Triangle object
// Triangle object is a subclass of AbstractShape class (object)

package shapes;

import java.awt.Color; // Java inbuilt package for using colors
import java.util.List; // Java inbuilt package for using List Data Types

public class Triangle extends AbstractShape{

    private List<Point> points; // Point List describig the shape
    
    private Color color;

    private boolean filled;

    // Constructor
    public Triangle(Point p1, Point p2, Point p3, Color color, boolean filled){

        // Adding the point objects to the shape point list
        addPoint(p1);
        addPoint(p2);
        addPoint(p3);

        // Setting shape color and fill status
        setColor(color);
        setFilled(filled);

    }

}