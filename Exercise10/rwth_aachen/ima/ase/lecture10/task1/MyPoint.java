package rwth_aachen.ima.ase.lecture10.task1;

public class MyPoint {

	private int x = 0;

	private int y = 0;

	public MyPoint() {
	}

	public MyPoint(int x, int y) {
		setX(x);
		setY(y);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setXY(int x, int y) {
		setX(x);
		setY(y);
	}

	public String toString() {
		return "(" + getX() + "," + getY() + ")";
	}

	public double distance(int x, int y) {
		return Math.sqrt(Math.pow(x - getX(), 2.0) + Math.pow(y - getY(), 2.0));
	}

	public double distance(MyPoint another) {
		return distance(another.getX(), another.getY());
	}
	
}
