import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class Main {
	private GeometryChecks _gc;
	private PhonePad _pad;
	private ChessPieceFactory _cpf;
	private PhoneNumberValidator _numberValidator;
	
	public Main(){
		_numberValidator = new PhoneNumberValidator();
		_gc = new GeometryChecks();
		_pad = new PhonePad(_gc);
		_cpf = new ChessPieceFactory(_gc);
	}
	
	public static void main(String[] args) {
		
		String chessPieceName = "Queen";
		char startingDigit = '5';

		int result = new Main().countValidPhoneNumbers(chessPieceName, startingDigit);
		
	}

	private int countValidPhoneNumbers(String chessPieceName, char startingDigit) {
		if(!_numberValidator.isValidDigit(startingDigit)){
			return 0;
		}
		
		ChessPiece cp = _cpf.getChessPiece(chessPieceName);
		System.out.println(cp.getName());
		
		Point p = _pad.getPointOfDigit(startingDigit); 
		
/*		OUT of memory!  :(
 
  		List<Point> points = new ArrayList<Point>();
		points.add(p);
		
		for(int i=1; i<=10; i++){
			List<Point> tmpPoints = new ArrayList<Point>();
			for (Point point : points) {
				List<Point> nextValidPoints = getNextValidPositions(cp, point);
				
				tmpPoints.addAll(nextValidPoints);
				
			}

			points = tmpPoints;
			
			System.out.println(i);
		}*/
		
		List<Point> points = new ArrayList<Point>();
		points.add(p);
		
		for(int i=1; i<=10; i++){
			List<Point> tmpPoints = new ArrayList<Point>();
			for (Point point : points) {
				List<Point> nextValidPoints = getNextValidPositions(cp, point);
				
				tmpPoints.addAll(nextValidPoints);
				
			}

			points = tmpPoints;
			//make uniqe. think i want to do a 'select pointId, count(*) from tmpPoints group by pointId' 
			//multiply the count by a previously cashed count then cash this as the new value
			//finnally sum over all items in the cash to get the answer
			
			
			System.out.println(i);
		}
		
		
		return 0;
	}
	
	private List<Point> getNextValidPositions(ChessPiece cp, Point p){
		
		List<Point> results = new ArrayList<Point>();
		//get all moves that are on the pad and are valid for the peice		
		for (Point p1 : _pad.getAllPointsOnPad()) {
			if(cp.isValidMove(p, p1) && _numberValidator.isValidDigit(_pad.getPadValue(p1))){
				results.add(p1);
			}
		}
		
		return results;
	}
	

}












/*		//System.out.println(new PhonePad());

PhonePad pp = new PhonePad(gc);
System.out.println(new PhonePad(gc).isPointOnPad(new Point(-1,0)));
System.out.println(new PhonePad(gc).isPointOnPad(new Point(0,0)));
System.out.println(new PhonePad(gc).isPointOnPad(new Point(3,3)));

boolean di = new GeometryChecks().isP1InRangeOfP2(new Point(0, 1), new Point(1, -1), 1);

System.out.println(di);*/
/*for (int y = 3; y >= 0; y--) {
	for (int x = 0; x <= 2; x++) {
		System.out.print(pp.getPadValue(new Point(x,y)));
	}
}*/

/*System.out.println("helloj");*/
/*		Scanner s = new Scanner(System.in);
System.out.println(s.nextInt());*/