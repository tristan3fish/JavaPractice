import java.util.List;


public class ChessPiece implements IMoveValidation {
	
	private IMoveValidation _moveValidation;
	
	private String _name;
	public String getName(){
		return _name;
	}

	public ChessPiece(String name, IMoveValidation moveValidation) {
		_name = name;
		_moveValidation = moveValidation;
	}

	@Override
	public boolean isValidMove(Point p0, Point p1) {
		return _moveValidation.isValidMove(p0, p1);
	}
	
}
