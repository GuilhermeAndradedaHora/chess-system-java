package br.com.guilhermetech.chesssystem.chess.pieces;

import br.com.guilhermetech.chesssystem.boardgame.Board;
import br.com.guilhermetech.chesssystem.boardgame.Position;
import br.com.guilhermetech.chesssystem.chess.ChessMatch;
import br.com.guilhermetech.chesssystem.chess.ChessPiece;
import br.com.guilhermetech.chesssystem.chess.Color;

public class King extends ChessPiece {

    private ChessMatch chessMatch;

    public King(Board board, Color color, ChessMatch chessMatch) {
        super(board, color);
        this.chessMatch = chessMatch;
    }

    @Override
    public String toString() {
        return "K";
    }

    private boolean canMove(Position position){
        var p = (ChessPiece)getBoard().piece(position);
        return p == null || p.getColor() != getColor();

    }

    private boolean testRookCastling(Position position){
        var p = (ChessPiece)getBoard().piece(position);
        return p != null && p instanceof Rook &&p.getColor() == getColor() && p.getMoveCount() == 0;
    }


    @Override
    public boolean[][] possibleMove() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        var p = new Position(0,0);

        // above
        p.setValues(position.getRow() - 1, position.getColumn());
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // below
        p.setValues(position.getRow() + 1, position.getColumn());
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // left
        p.setValues(position.getRow(), position.getColumn()- 1);
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // right
        p.setValues(position.getRow(), position.getColumn() + 1);
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // nw
        p.setValues(position.getRow() - 1, position.getColumn() - 1);
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // ne
        p.setValues(position.getRow() - 1, position.getColumn() + 1);
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // sw
        p.setValues(position.getRow() + 1, position.getColumn() - 1);
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // se
        p.setValues(position.getRow() + 1, position.getColumn() + 1);
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // #specialmove castling
        if (getMoveCount() == 0 && !chessMatch.getCheck()){
            // #specialmomve castling kingside rook
            var positionTowerOne = new Position(position.getRow(), position.getColumn() + 3);
            if (testRookCastling(positionTowerOne)) {
                var p1 = new Position(position.getRow(), position.getColumn() + 1);
                var p2 = new Position(position.getRow(), position.getColumn() + 2);
                if (getBoard().piece(p1) == null && getBoard().piece(p2) == null){
                    mat[p1.getRow()][p1.getColumn() + 2] = true;
                }
            }
            // #specialmomve castling queenside rook
            var positionTowerTwo = new Position(position.getRow(), position.getColumn() - 4);
            if (testRookCastling(positionTowerTwo)) {
                var p1 = new Position(position.getRow(), position.getColumn() - 1);
                var p2 = new Position(position.getRow(), position.getColumn() - 2);
                var p3 = new Position(position.getRow(), position.getColumn() - 3);
                if (getBoard().piece(p1) == null && getBoard().piece(p2) == null && getBoard().piece(p3) == null){
                    mat[p1.getRow()][p1.getColumn() - 2] = true;
                }
            }
        }



        return mat;
    }
}
