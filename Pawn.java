package chess;

public class Pawn extends ChessPiece {
	private boolean firstMove = true;
	
	public Pawn(int x, int y, boolean isWhite) {
		super(x, y, isWhite);
	}

	@Override
	protected boolean legalMove(int x, int y) {
		// Checks if x is same and y is 1 off in correct direction.
		// TODO: Use firstMove to test for 2 squares on first move.
		return this.x == x ? (this.y + (isWhite ? 1 : -1) == y) : false;
	}
}
