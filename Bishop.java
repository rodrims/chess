package chess;

public class Bishop extends ChessPiece {
	public Bishop (int x, int y, boolean isWhite) {
		super(x, y, isWhite);
	}

	@Override
	protected boolean legalMove(int x, int y) {
		int dx = this.x - x >= 0 ? this.x - x : -(this.x - x);
		int dy = this.y - x >= 0 ? this.y - y : -(this.y - y);
		return dx == dy;
	}
}
