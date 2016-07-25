package chess;

public class Knight extends Piece {
    public Knight(boolean isWhite) {
        super("Knight", "N", isWhite);
    }

	@Override
	protected boolean legalPosition(int oldX, int oldY, int newX, int newY) {
        int dX = newX - oldX;
        int dY = newY - oldY;

		if (Math.abs(dX) == 1) {
			return Math.abs(dY) == 2;
		} else if (Math.abs(dY) == 1) {
			return Math.abs(dX) == 2;
		} else {
			return false;
		}
	}

    @Override
    public boolean validMove(int oldX, int oldY, int newX, int newY) {
        if (this.legalPosition(oldX, oldY, newX, newY)) {
            // Knights can "jump" over other pieces no matter the color
            return true;
        } else {
            return false;
        }
    }
}
