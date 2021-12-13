// Source code for Exercise 3 Task 2
// Desired Output-> Drawing of a scenery with a house
// Objects Used -> Point, Rectangle, AbstractShape (Superclass)
// Interface used -> Shape

import java.util.List;
import java.util.ArrayList;
import java.awt.Color;

// Importing the required Classes and interfaces
import shapes.Point;
import shapes.Rectangle;
import shapes.Triangle;
import shapes.Shape;
import shapes.Circle;
import shapes.AbstractShape;

public class Exercise3T2{

    public static void main(String[] args) {
		
		// a list of shapes that have to be drawn
		List<Shape> shapes = new ArrayList<>();

		// Ground
        shapes.add(new Rectangle(0,600,600,300, Color.GREEN, true));
        // Sky
        shapes.add(new Rectangle(0,300,600,0, Color.BLUE, true));
        // House Roof
		shapes.add(new Triangle(new Point(200,150), new Point(300,50), new Point(400,150), Color.RED, true));
        // House Main Structure
        shapes.add(new Rectangle(200,450,400,150, Color.YELLOW, true));
        // House Front Door
        shapes.add(new Rectangle(280,450,320,350, Color.GRAY, true));
        // Left Window
        shapes.add(new Rectangle(220,250,270,200, Color.RED, false)); // Windows are unfilled
        // Right Window
        shapes.add(new Rectangle(330,250,380,200, Color.RED, false)); // Windows are unfilled

        // Circle Object
        int radius = 50;
        Circle cir = new Circle(new Point(100,100), radius, Color.BLACK, true,1);
        double a = cir.calculatePerimeter();
        System.out.println(a);

        
        // Obtaining the points on the perimeter and prinitng them
        try{
            // cir.getPerimeterPoints(1); // 1 degree step size
            System.out.println(cir.getPerimeterPoints(2).size());
        } catch(IllegalArgumentException e){ // Detecting any undefined or invalid input arguments
            System.err.println("Perimeter Points cannot be computed. Reason: " + e.getMessage()); // Printing the exception error

        }

        // Replacing the rectangle windows with circles
        // Removing the windows (left and right) from the shape list
        int index = shapes.size() - 1;
        shapes.remove(index);

        index = shapes.size() - 1;
        shapes.remove(index);

        // Adding circle windows to shape
        // Radius of the winr=dows
        int rad = 25;
        //Left Window
        shapes.add(new Circle(new Point(245,275), rad, Color.RED, false,1));
        // Right Window
        shapes.add(new Circle(new Point(355,275), rad, Color.RED, false,1));

        // Printing the perimeter of the shapes
        for(int i = 0; i < shapes.size() - 1; i++){

            System.out.println("Shape Perimeter: "+ shapes.get(i).calculatePerimeter());

        }

		// create the frame and draw the shapes
		ShapeFrame frame = new ShapeFrame();
		frame.drawShapes(shapes);
		frame.setVisible(true); 
	}

}