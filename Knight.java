package chess;

public class Knight extends ChessPiece {
	public Knight(int x, int y, boolean isWhite) {
		super(x, y, isWhite);
	}

	@Override
	protected boolean legalMove(int x, int y) {
		if (x == this.x - 1 || x == this.x + 1) {
			if (y == this.y - 2 || y == this.y + 2) {
				return true;
			} else {
				return false;
			}
		} else if (x == this.x - 2 || x == this.x + 2) {
			if (y == this.y - 1 || y == this.y + 2) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
}
