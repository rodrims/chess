package chess;

public class King extends ChessPiece {
    private boolean firstMove = true;

    public King(boolean isWhite) {
        super("King", isWhite);
    }

	@Override
	public boolean legalMove(int oldX, int oldY, int newX, int newY) {
		int dX = newX - oldX;
		int dY = newY - oldY;
        if (dX == 0) {
            return (dY > 0 ? dY : - dY) == 1;
        } else if ((dX > 0 ? dX : -dX) == 1) {
            return (dY > 0 ? dY : -dY) <= 1;
        } else {
            return false;
        }
        // TODO: Implement castling check;
	}

    public void moved() {
        firstMove = false;
    }
}	
