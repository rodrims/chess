package chess;

public class Bishop extends Piece {
    public Bishop(boolean isWhite) {
        super("Bishop", "B", isWhite);
    }

	@Override
	protected boolean legalPosition(int oldX, int oldY, int newX, int newY) {
		int dX = newX - oldX;
		int dY = newY - oldY;

		return Math.abs(dX) == Math.abs(dY);
	}

    @Override
    public boolean validMove(int oldX, int oldY, int newX, int newY) {
        Board board = Game.getBoard();

        if (this.legalPosition(oldX, oldY, newX, newY)) {
            int dX = newX - oldX;
    		int dY = newY - oldY;

            /*
             * This variable is a counter to iterate through the number of
             * spaces moved through. dY could also be used here we just need the
             * total number of spaces the piece moved through.
             */
            int counter = Math.abs(dX);

            /*
             * Both dX and dY will have the same Math.absolute value (because of how
             * bishops move), it is only necessary to get their "direction" i.e.
             * whether they are positive or negative values in order to check
             * the correct tiles.
             */
            if (dX > 0 && dY > 0) {
                for (int i = 1; i < counter; i++) {
                    if (board.getPiece(oldX + i, oldY + i) != null) {
                        return false;
                    }
                }
            } else if (dX > 0 && dY < 0) {
                for (int i = 1; i < counter; i++) {
                    if (board.getPiece(oldX + i, oldY - i) != null) {
                        return false;
                    }
                }
            } else if (dX < 0 && dY > 0) {
                for (int i = 1; i < counter; i++) {
                    if (board.getPiece(oldX - i, oldY + i) != null) {
                        return false;
                    }
                }
            } else {
                for (int i = 1; i < counter; i++) {
                    if (board.getPiece(oldX - i, oldY - i) != null) {
                        return false;
                    }
                }
            }
        } else {
            return false;
        }

        return true;
    }
}
