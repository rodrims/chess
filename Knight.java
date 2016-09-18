package chess;

import java.lang.Math;

public class Knight extends Piece {
    public Knight(boolean isWhite) {
        super("Knight", "N", isWhite);
    }

    public Knight(boolean isWhite, int x, int y) {
        super("Knight", "N", isWhite, x, y);
    }

	@Override
	public int[][] path(int newX, int newY) {
		return null;
	}

	@Override
	public boolean legalPosition(int newX, int newY) {
        int dX = newX - oldX;
        int dY = newY - oldY;

		if (abs(dX) == 1) {
			return abs(dY) == 2;
		} else if (abs(dY) == 1) {
			return abs(dX) == 2;
		}

		return false;
	}
}
