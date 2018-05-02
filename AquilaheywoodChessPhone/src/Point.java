
public class Point {

	private int _x;
	public int getX(){
		return _x;
	}

	private int _y;
	public int getY(){
		return _y;
	}
	
	public Point(int x, int y) {
		_x = x;
		_y = y;
	}
	
	@Override
	public String toString() {
		return "Point: (" + _x + ", " + _y + ")";
	}
}
