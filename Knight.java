package chess;

public class Knight extends ChessPiece {
    public Knight(boolean isWhite) {
        super("Knight", isWhite);
    }
    
	@Override
	public boolean legalMove(int oldX, int oldY, int newX, int newY) {
        int dX = newX - oldX;
        int dY = newY - oldY;
		if (dX == -1 || dX == 1) {
			if (dY == -2 || dY == 2) {
				return true;
			} else {
				return false;
			}
		} else if (dX == -2 || dX == 2) {
			if (dY == -1 || dY == 1) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
}
