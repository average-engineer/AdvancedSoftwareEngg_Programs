// package de.ase.ima.shapes;
package shapes;

import java.awt.Color;
import java.util.List;

public interface Shape {

	/**
	 * @return color of the shape
	 */
	public Color getColor();
	
	/**
	 * @return fill status of shape
	 */
	public boolean isFilled();
	
	/**
	 * @return points that define the shape (in drawing order)
	 */
	public List<Point> getPoints();

	// Method for computing the perimeter
	public double calculatePerimeter();
	
}
