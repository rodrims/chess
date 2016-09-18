package chess;

import java.util.Math;

public class Queen extends Piece {
    public Queen(boolean isWhite) {
        super("Queen", "Q", isWhite);
    }

    public Queen(boolean isWhite, int x, int y) {
        super("Queen", "Q", isWhite, x, y);
    }

	@Override
	public boolean legalPosition(int oldX, int oldY, int newX, int newY) {
		int dX = newX - oldX;
		int dY = newY - oldY;

		// If dX and dY are exclusively 0, then the queen is behaving like a
		// bishop, otherwise she is behaving like a rook.
        if ((dX == 0) ^ (dY == 0)) {
            return true;
        } else {
            return abs(dX) == abs(dY);
        }

		// TODO This *should* be unnecessary, but I'll keep it here for now.
		return false;
	}
}
