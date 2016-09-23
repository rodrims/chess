package chess;

import static java.lang.Math.abs;

public class Rook extends Piece {
	private boolean firstMove = true;

    public Rook(boolean isWhite) {
        super("Rook", "R", isWhite);
    }

    public Rook(boolean isWhite, int x, int y) {
        super("Rook", "R", isWhite, x, y);
    }

	@Override
	public void moveTo(int newX, int newY) {
		this.x = newX;
		this.y = newY;
		firstMove = false;
	}

	@Override
	public boolean legalPosition(int newX, int newY) {
        int dX = newX - x;
        int dY = newY - y;

        /*
         * A rook moves either vertically or horizontally at one time. So dX and
		 * dY must be exclusively zero. 
         */
        return (dX == 0) ^ (dY == 0);
	}
}
