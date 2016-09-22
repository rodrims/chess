package chess;

import static java.lang.Math.abs;

public class Bishop extends Piece {
    public Bishop(boolean isWhite) {
        super("Bishop", "B", isWhite);
    }

    public Bishop(boolean isWhite, int x, int y) {
        super("Bishop", "B", isWhite, x, y);
    }

	@Override
	public boolean legalPosition(int newX, int newY) {
		int dX = newX - x;
		int dY = newY - y;

		return abs(dX) == abs(dY);
	}
}
