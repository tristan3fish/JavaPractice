
public class GeometryChecks {
	
	public boolean isVerticalOrHorizontal(Point p0, Point p1){
		return isHorizontal(p0,p1) || isVertical(p0, p1);
	}
	
	public boolean isDiagonal(Point p0, Point p1){
		
		int dx = Math.abs(p0.getX()-p1.getX());
		int dy = Math.abs(p0.getY()-p1.getY());
		
		return dy == dx;
	}
	
	public boolean isp0InRangeOfp1(Point p0, Point p1, int range){
		
		int dx = Math.abs(p0.getX()-p1.getX());
		int dy = Math.abs(p0.getY()-p1.getY());
		
		return dy<=range && dx <= range;
	}
	
	public boolean isInRectangle(Point p, Point bottomLeft, Point topRight){
		
		int x = p.getX();
		int y = p.getY();

		return bottomLeft.getX()<=x && x<=topRight.getX() && bottomLeft.getY()<=y && y<=topRight.getY();
	}
	
	
	public boolean isHorizontal(Point p0, Point p1){
		return p0.getX() == p1.getX();
	}
	
	public boolean isVertical(Point p0, Point p1){
		return p0.getY() == p1.getY();
	}
}
