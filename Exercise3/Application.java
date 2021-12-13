// package de.ase.ima;

import java.util.ArrayList;
import java.util.List;
import java.awt.Color;

import shapes.Shape; // Importing Shape interface
import shapes.Rectangle; // Importing Rectangle object Class
import shapes.Triangle; // Importing Triangle object class
import shapes.Point; // Importing Point object class

public class Application {

	public static void main(String[] args) {
		
		// a list of shapes that have to be drawn
		List<Shape> shapes = new ArrayList<>();

		shapes.add(new Rectangle(100,100,300,300, Color.RED, true)); // Rectangle which needs to be drawn
		shapes.add(new Triangle(new Point(100,300), new Point(200,100), new Point(300,300), Color.YELLOW, true));

		// create the frame and draw the shapes
		ShapeFrame frame = new ShapeFrame();
		frame.drawShapes(shapes);
		frame.setVisible(true);
	}

}
