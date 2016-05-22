package chess;

public class Pawn extends ChessPiece {
	private boolean firstMove = true;

    public Pawn(boolean isWhite) {
        super("Pawn", isWhite);
    }
	
	@Override
	public boolean legalMove(int oldX, int oldY, int newX, int newY) {
		// Checks if x is same and y is 1 off in correct direction.
        int dY = newY - oldY;

        if (oldX != newX) {
            return false;
        } else if (firstMove) {
            return isWhite ? dY == 1 || dY == 2 : dY == -1 || dY == -2;
        } else {
            return isWhite ? dY == 1 : dY == -1;
        }
	}

    public void moved() {
        firstMove = false;
    }
}
