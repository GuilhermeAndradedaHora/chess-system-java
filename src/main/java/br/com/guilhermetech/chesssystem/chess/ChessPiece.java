package br.com.guilhermetech.chesssystem.chess;

import br.com.guilhermetech.chesssystem.boardgame.Board;
import br.com.guilhermetech.chesssystem.boardgame.Piece;
import br.com.guilhermetech.chesssystem.boardgame.Position;
import lombok.Getter;

public abstract class ChessPiece extends Piece {

    @Getter
    private Color color;

    public ChessPiece(Board board, Color color) {
        super(board);
        this.color = color;
    }

    protected boolean isThereOpponentPiece(Position position){
        var p = (ChessPiece) getBoard().piece(position);
        return p != null && p.getColor() != color;
    }
}
