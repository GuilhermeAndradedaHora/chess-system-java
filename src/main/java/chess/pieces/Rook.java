package chess.pieces;

import br.com.guilhermetech.chesssystem.boardgame.Board;
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

    @Override
    public boolean[][] possibleMove() {
        return new boolean[0][];
    }
}
