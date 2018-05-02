import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


public class PhonePad {
	private char[][] _pad = new char[3][4];
	private Map<Character, Point> _map;
	private GeometryChecks _geometry;
	
	public PhonePad(GeometryChecks gc){
		_geometry = gc;
		_map = new HashMap<Character, Point>();
		
		_pad[0][0] = '*';
		_map.put('*', new Point(0,0));
		
		_pad[1][0] = '0';
		_map.put('0', new Point(1,0));
		
		_pad[2][0] = '#';
		_map.put('#', new Point(2,0));
		
		_pad[0][1] = '7';
		_map.put('7', new Point(0,1));
		
		_pad[1][1] = '8';
		_map.put('8', new Point(1,1));
		
		_pad[2][1] = '9';
		_map.put('9', new Point(2,1));
		
		_pad[0][2] = '4';
		_map.put('4', new Point(0,2));
		
		_pad[1][2] = '5';
		_map.put('5', new Point(1,2));
		
		_pad[2][2] = '6';
		_map.put('6', new Point(2,2));
		
		_pad[0][3] = '1';
		_map.put('1', new Point(0,3));
		
		_pad[1][3] = '2';
		_map.put('2', new Point(1,3));
		
		_pad[2][3] = '3';
		_map.put('3', new Point(2,3));
		
	}
	
	public char getPadValue(Point p){
		return _pad[p.getX()][p.getY()];
	}
	
	public Point getPointOfDigit(char c){
		return _map.get(c);
	}
	
	public boolean isPointOnPad(Point p){
		return _geometry.isInRectangle(p, new Point(0,0), new Point(2,3));
	}
	
	public Collection<Point> getAllPointsOnPad(){
		return _map.values();
	}
	
	@Override
	public String toString() {
		String result = "";

		for (int y = 3; y >= 0; y--) {
			for (int x = 0; x <= 2; x++) {
				result+=this.getPadValue(new Point(x,y));
			}
		}
		
		return result;
	}
}



