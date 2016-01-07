package chess;

public class Queen extends ChessPiece {
	public Queen(int x, int y, boolean isWhite) {
		super(x, y, isWhite);
	}

	@Override
	protected boolean legalMove(int x, int y) {
		int dx = this.x - x >= 0 ? this.x - x : -(this.x - x);
		int dy = this.y - y >= 0 ? this.y - y : -(this.y - y);
		return dx == 0 ? true : (dy == 0 ? true : dx == dy);
	}
}
