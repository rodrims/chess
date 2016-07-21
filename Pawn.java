package chess;

import java.util.LinkedList;

public class Pawn extends Piece {
	private String name = "Pawn";
	private String initial = " ";
	private boolean firstMove = true;

	public Pawn(boolean isWhite) {
        super(isWhite);
    }

	public void moved() {
		firstMove = false;
	}

	@Override
	public boolean legalMove(int oldX, int oldY, int newX, int newY) {
		// Checks if x is same and y is 1 off in correct direction.
		int dX = newX - oldX;
        int dY = newY - oldY;

		if (dX == 0) { // TODO Make this more uniform ?
			if (firstMove) {
				if (this.isWhite()) {
					return dY == 1 || dY == 2;
				} else {
					return dY == -1 || dY == -2;
				}
			} else {
				return this.isWhite() ? dY == 1 : dY == -1;
			}
		} else if (dX == 1 || dX == -1) {
			return this.isWhite() ? dY == 1 : dY == -1;
		} else {
			return false;
		}
	}

	@Override
	public LinkedList<Piece> path(int oldX, int oldY, int newX, int newY) {
		Board board = Game.getBoard();
		LinkedList<Piece> lList = new LinkedList<>();

		if (!legalMove(oldX, oldY, newX, newY)) {
			throw new IllegalArgumentException("The move is not legal.");
		} else {
			int dY = newY - oldY;

			if (this.isWhite() ? dY == 2 : dY == -2) {
				int checkY = this.isWhite() ? oldY + 1 : oldY - 1;

				if (board.getPiece(oldX, checkY) != null) {
					lList.add(board.getPiece(oldX, checkY));
				}
			}
		}

		return lList;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getInitial() {
		return initial;
	}
}
