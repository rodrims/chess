package chess;

public class Queen extends Piece {
    public Queen(boolean isWhite) {
        super("Queen", "Q", isWhite);
    }

	@Override
	protected boolean legalPosition(int oldX, int oldY, int newX, int newY) {
		int dX = newX - oldX;
		int dY = newY - oldY;

        /*
         * If only one of dX or dY are zero then the queen is behaving like a
         * rook, if they are both non-zero then it is behaving like a bishop.
         */
        if ((dX == 0) ^ (dY == 0)) {
            return true;
        } else {
            return Math.abs(dX) == Math.abs(dY);
        }
	}

    @Override
    public boolean validMove(int oldX, int oldY, int newX, int newY) {
        Board board = Game.getBoard();

        if (legalPosition(oldX, oldY, newX, newY)) {
            int dX = newX - oldX;
            int dY = newY - oldY;

            int counter = dX != 0 ? Math.abs(dX) : Math.abs(dY);

            if ((dX == 0) ^ (dY == 0)) {
                if (dX > 0) {
                    for (int i = 1; i < counter; i++) {
                        if (board.getPiece(oldX + i, oldY) != null) {
                            return false;
                        }
                    }
                } else if (dX < 0) {
                    for (int i = 1; i < counter; i++) {
                        if (board.getPiece(oldX - i, oldY) != null) {
                            return false;
                        }
                    }
                } else if (dY > 0) {
                    for (int i = 1; i < counter; i++) {
                        if (board.getPiece(oldX, oldY + i) != null) {
                            return false;
                        }
                    }
                } else {
                    for (int i = 1; i < counter; i++) {
                        if (board.getPiece(oldX, oldY - i) != null) {
                            return false;
                        }
                    }
                }
            } else {
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
            }
        } else {
            return false;
        }

        return true;
    }
}
