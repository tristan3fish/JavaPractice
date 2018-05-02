import java.util.HashMap;
import java.util.Map;


public class ChessPieceFactory {
	private Map<String, ChessPiece> _map;
	private GeometryChecks _geometry;
	
	public ChessPieceFactory(GeometryChecks gc){
		_geometry = gc;
		
		_map = new HashMap<String, ChessPiece>();
		_map.put("King",	new ChessPiece("King",null));
		_map.put("Queen",	new ChessPiece("Queen",new QueenMoveValidation()));
		_map.put("Bishop",	new ChessPiece("Bishop",null));
		_map.put("Knight",	new ChessPiece("Knight",null));
		_map.put("Rook",	new ChessPiece("Rook",null));
		_map.put("Pawn",	new ChessPiece("Pawn",null));
	}
	
	public ChessPiece getChessPiece(String chessPieceName){
		return _map.get(chessPieceName);
	}
	
	private class QueenMoveValidation implements IMoveValidation {
		@Override
		public boolean isValidMove(Point p0, Point p1) {
			return _geometry.isDiagonal(p0, p1) || _geometry.isVerticalOrHorizontal(p0, p1);
		}
	}
	
}
