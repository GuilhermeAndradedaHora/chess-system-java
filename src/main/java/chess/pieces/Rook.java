package chess.pieces;

import br.com.guilhermetech.chesssystem.boardgame.Board;
import br.com.guilhermetech.chesssystem.boardgame.Piece;
import chess.ChessPiece;
import chess.Color;

public class Rook extends ChessPiece {

    public Rook(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "R";
    }
}
