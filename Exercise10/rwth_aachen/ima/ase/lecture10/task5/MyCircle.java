package rwth_aachen.ima.ase.lecture10.task5;

import rwth_aachen.ima.ase.lecture10.task1.MyPoint;

public class MyCircle {

	private int radius = 1;

	private MyPoint center;

	public MyCircle(int x, int y, int radius) {
		this(new MyPoint(x, y), radius);
	}

	public MyCircle(MyPoint center, int radius) {
		setCenter(center);
		setRadius(radius);
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public MyPoint getCenter() {
		return center;
	}

	public void setCenter(MyPoint center) {
		if (center == null) {
			throw new IllegalArgumentException("Center of circle cannot be null");
		}
		this.center = center;
	}

	public int getCenterX() {
		return getCenter().getX();
	}

	public int getCenterY() {
		return getCenter().getY();
	}

	public void setCenterXY(int x, int y) {
		getCenter().setX(x);
		getCenter().setY(y);
	}

	public double getArea() {
		return Math.pow(getRadius(), 2.0) * Math.PI;
	}
	
	public String toString() {
		return "Circle @ " + getCenter() + " radius=" + getRadius();
	}

}
