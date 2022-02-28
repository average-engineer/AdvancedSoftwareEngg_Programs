// package de.ase.ima.shapes;
package shapes;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractShape implements Shape {

	private List<Point> points; // Point List describing the shape
	
	private Color color;
	
	private boolean filled;
	
	/**
	 * Standard constructor for shape
	 */
	public AbstractShape() {
		points = new ArrayList<>();
		
		// set default color
		setColor(Color.BLACK);
	}
	
	/**
	 * Constructor to create a new shape and to initialize instance variables 
	 * 
	 * @param color color of shape
	 * @param filled is shape filled
	 */
	public AbstractShape(Color color, boolean filled) {
		this();
		setColor(color);
		setFilled(filled);
	}
	
	/**
	 * Adds a new point to the shape.
	 * @param point the point that has to be added
	 */
	protected void addPoint(Point point) {
		points.add(point);
	}

	/**
	 * @return line and fill color of shape
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * Sets the line and fill color of shape
	 * @param color the used color
	 */
	public void setColor(Color color) {
		this.color = color;
	}

	/**
	 * @return true if the shape is filled
	 */
	public boolean isFilled() {
		return filled;
	}

	/**
	 * Change value of filled
	 * @param filled new value of filled
	 */
	public void setFilled(boolean filled) {
		this.filled = filled;
	}

	/**
	 * @return list of points of the shape
	 */
	public List<Point> getPoints() {
		return points;
	}

	// Method for computing the perimeter
	public double calculatePerimeter(){
		double perimeter = 0; // variable storing the perimeter value
		for(int i = 0; i < points.size() - 1; i++){

			perimeter = perimeter + points.get(i).distance(points.get(i+1)); // Distance between ith and i+1st points in the point list of the shape

		}

		// adding the first and last points to complete the perimeter
		perimeter = perimeter + points.get(0).distance(points.get(points.size() - 1));

		return perimeter;
	}
	
}
