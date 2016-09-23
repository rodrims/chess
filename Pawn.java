package chess;

import static java.lang.Math.abs;

public class Pawn extends Piece {
	private boolean firstMove;

	public Pawn(boolean isWhite) {
        super("Pawn", "P", isWhite);
		this.firstMove = true;
    }

	public Pawn(boolean isWhite, int x, int y) {
		super("Pawn", "P", isWhite, x, y);
		this.firstMove = true;
	}

	@Override
	public void moveTo(int newX, int newY) {
		this.x = newX;
		this.y = newY;
		firstMove = false;
	}

	@Override
	public boolean captureAt(int newX, int newY) {
        int dX = newX - x;
        int dY = newY - y;

		if (abs(dX) == 1) {
			return isWhite ? dY == 1 : dY == -1; 
		}

		return false;
	}

	@Override
	public boolean legalPosition(int newX, int newY) {
		int dX = newX - x;
        int dY = newY - y;

		if (dX == 0) {
			if (firstMove) {
				return isWhite ? (dY == 1 || dY == 2) : (dY == -1 || dY == -2);
			} else {
				return isWhite ? dY == 1 : dY == -1;
			}
		}

		return false;
	}
}
