package chess;

import static java.lang.Math.abs;

public class King extends Piece {
    private boolean firstMove;

    public King(boolean isWhite) {
        super("King", "K", isWhite);
        this.firstMove = true;
    }

    public King(boolean isWhite, int x, int y) {
        super("King", "K", isWhite, x, y);
        this.firstMove = true;
    }

	@Override
	public void moveTo(int newX, int newY) {
		this.x = newX;
		this.y = newY;
		firstMove = false;
	}

    // TODO: Castling!!!
	@Override
	public boolean legalPosition(int newX, int newY) {
		int dX = newX - x;
		int dY = newY - y;

        if (dX == 0) {
            return Math.abs(dY) == 1;
        } else if (dY == 0) {
            return Math.abs(dX) == 1;
        } else {
            return Math.abs(dX) == 1 && Math.abs(dY) == 1;
        }
	}
}
