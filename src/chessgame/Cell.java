package chessgame;

import chessgame.piece.Piece;

public class Cell {

    private final int row,col;
    private Piece piece;

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public Piece getPiece() {
        return this.piece;
    }

    public void setPiece(Piece piece) {
        this.piece=piece;
    }
}
