package chess;

import java.lang.Math;

public class Bishop extends Piece {
    public Bishop(boolean isWhite) {
        super("Bishop", "B", isWhite);
    }

    public Bishop(boolean isWhite, int x, int y) {
        super("Bishop", "B", isWhite, x, y);
    }

	@Override
	public boolean legalPosition(int oldX, int oldY, int newX, int newY) {
		int dX = newX - oldX;
		int dY = newY - oldY;

		return abs(dX) == abs(dY);
	}
}
