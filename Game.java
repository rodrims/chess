package chess;

public class Game {
    private boolean whiteTurn = true;
	private Board board = new Board();

    private void newGame() {
        whiteTurn = true;
        board.resetBoard();
    }

    private boolean movePiece(int oldX, int oldY, int newX, int newY) {
		if (board.hasPiece(oldX, oldY)) {
			if (board.pieceIsWhite(oldX, oldY) == whiteTurn) {
				return board.movePiece(oldX, oldY, newX, newY);
			}
		}

		return false;
	}
}
