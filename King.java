package chess;

public class King extends ChessPiece {
	public King(int x, int y, boolean isWhite) {
		super(x, y, isWhite);
	}

	@Override
	protected boolean legalMove(int x, int y) {
		int dx = this.x - x >= 0 ? this.x - x : -(this.x - x);
		int dy = this.y - y >= 0 ? this.y - y : -(this.y - y);
		return dx <= 1 ? dy <= 1 : false;
	}
}	
