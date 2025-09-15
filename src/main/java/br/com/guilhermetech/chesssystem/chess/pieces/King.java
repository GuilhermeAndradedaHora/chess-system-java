package br.com.guilhermetech.chesssystem.chess.pieces;

import br.com.guilhermetech.chesssystem.boardgame.Board;
import br.com.guilhermetech.chesssystem.chess.ChessPiece;
import br.com.guilhermetech.chesssystem.chess.Color;

public class King extends ChessPiece {

    public King(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "K";
    }

    @Override
    public boolean[][] possibleMove() {
        return new boolean[0][];
    }
}
