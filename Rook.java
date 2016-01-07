package chess;

public class Rook extends ChessPiece {
	public Rook(int x, int y, boolean isWhite) {
		super(x, y, isWhite);
	}

	@Override
	protected boolean legalMove(int x, int y) {
		return this.x == x || this.y == y;
	}
}
