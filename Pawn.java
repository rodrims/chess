package chess;

public class Pawn extends Piece {
	private boolean firstMove;

	public Pawn(boolean isWhite) {
        super("Pawn", " ", isWhite);
		this.firstMove = true;
    }

	public void moved() {
		firstMove = false;
	}

	@Override
	protected boolean legalPosition(int oldX, int oldY, int newX, int newY) {
		int dX = newX - oldX;
        int dY = newY - oldY;

		// TODO Can this be made more uniform?
		if (dX == 0) {
			if (firstMove) {
				if (this.isWhite()) {
					return dY == 1 || dY == 2;
				} else {
					return dY == -1 || dY == -2;
				}
			} else {
				return this.isWhite() ? dY == 1 : dY == -1;
			}
		} else if (Math.abs(dX) == 1) {
			return this.isWhite() ? dY == 1 : dY == -1;
		} else {
			return false;
		}
	}

	@Override
	public boolean validMove(int oldX, int oldY, int newX, int newY) {
		Board board = Game.getBoard();

		if (this.legalPosition(oldX, oldY, newX, newY)) {
			/*
			 * Pawns will only have to check for a valid path if they move
			 * forward 2 spaces; There is no need for a dX.
			 */
			int dY = newY - oldY;

			if (Math.abs(dY) == 2) {
				int checkY = this.isWhite() ? oldY + 1 : oldY - 1;

				if (board.getPiece(oldX, checkY) != null) {
					return false;
				} else {
					return true;
				}
			} else {
				return true;
			}
		} else {
			return false;
		}
	}
}
