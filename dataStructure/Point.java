package dataStructure;

class Point {
	
	public int ix;
	public int iy;
	
	public Point(int x, int y) {
		ix = x;
		iy = y;
	}
	
	public String toString() {
		return "<" + ix + ", " + iy + ">";
	}
	
	public int getX() {
		return ix;
	}
	
	public int getY() {
		return iy;
	}
	
	public void setX(int x) {
		ix = x;
	}
	
	public void setY(int y) {
		iy = y;
	}
}