package br.com.guilhermetech.chesssystem.chess;

import br.com.guilhermetech.chesssystem.boardgame.Board;
import br.com.guilhermetech.chesssystem.boardgame.Piece;
import br.com.guilhermetech.chesssystem.boardgame.Position;
import lombok.Getter;

public abstract class ChessPiece extends Piece {

    private Color color;
    private int moveCount;

    public ChessPiece(Board board, Color color) {
        super(board);
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public void setMoveCount(Integer moveCount) {}

    protected void increaseMoveCount(){
        moveCount++;
    }

    protected void decreaseMoveCount(){
        moveCount--;
    }

    public ChessPosition getChessPosition(){
        return ChessPosition.fromPosition(position);
    }

    protected boolean isThereOpponentPiece(Position position){
        var p = (ChessPiece)getBoard().piece(position);
        return p != null && p.getColor() != color;
    }

}
