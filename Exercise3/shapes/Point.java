// package de.ase.ima.shapes;
package shapes;

public class Point {

	private int x;

	private int y;

	public Point(int x, int y) {
		setX(x);
		setY(y);
	}

	public int getX() {
		return x;
	}

	private void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	private void setY(int y) {
		this.y = y;
	}

	public double distance(Point p) {
		return Math.sqrt(Math.pow(x - p.x, 2.0) + Math.pow(y - p.y, 2.0)); // new Point(x1,y1).distance(new Point(x2,y2)) computes the distance between (x1,y1) and (x2,y2)
	}

}
