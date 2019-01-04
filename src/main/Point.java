package main;

public class Point {

	private int x;
	private int y;
	final int INI_X = 25;
	final int INI_Y = 25;

	public Point() {
		this.x = INI_X;
		this.y = INI_Y;
	}

	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
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

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	public double distance(Point point) {
		return Math.sqrt(Math.pow(x - point.getX(), 2) + Math.pow(y - point.getY(), 2));
	}
	
	public double distanceOrigine() {
		return Math.sqrt(Math.pow(x - this.INI_X, 2) + Math.pow(y - this.INI_Y, 2));
	}

}
