package chess;

public class King extends Piece {
    private boolean firstMove;

    public King(boolean isWhite) {
        super("King", "K", isWhite);
        this.firstMove = true;
    }

    @Override
    public void moved() {
        firstMove = false;
    }

    // TODO: Castling!!!
	@Override
	protected boolean legalPosition(int oldX, int oldY, int newX, int newY) {
		int dX = newX - oldX;
		int dY = newY - oldY;

        if (dX == 0) {
            return Math.abs(dY) == 1;
        } else if (dY == 0) {
            return Math.abs(dX) == 1;
        } else {
            return Math.abs(dX) == 1 && Math.abs(dY) == 1;
        }
	}

    // TODO: Castling!!!
    @Override
    public boolean validMove(int oldX, int oldY, int newX, int newY) {
        if (this.legalPosition(oldX, oldY, newX, newY)) {
            // There is no path needed to be checked for at the moment
            return true;
        } else {
            return false;
        }
    }
}
