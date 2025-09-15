package br.com.guilhermetech.chesssystem.boardgame;

import lombok.Getter;
import lombok.Setter;

public class Board {


    @Getter
    private Integer rows;
    @Getter
    private Integer columns;
    private Piece[][] pieces;

    public Board(Integer rows, Integer columns) {
        if (rows < 1 || columns < 1){
            throw new BoardException("Error creating board: There must be at least 1row and 1 column");
        }
        this.rows = rows;
        this.columns = columns;
        pieces = new Piece[rows][columns];
    }

    public Piece piece(Integer row, Integer column) {
        if (!positionExists(row, column)){
            throw new BoardException("Position does not exist");
        }
        return pieces[row][column];
    }

    public Piece piece(Position position) {
        if (!positionExists(position)){
            throw new BoardException("Position does not exist");
        }
        return piece(position.getRow(), position.getColumn());
    }

    public void placePiece(Piece piece, Position position) {
        if (thereIsPiece(position)){
            throw new BoardException("There is already a piece on position " + position);
        }
        pieces[position.getRow()][position.getColumn()] = piece;
        piece.position = position;
    }

    private boolean positionExists(int row, int column) {
        return row >= 0 && row < rows && column >= 0 && column < columns;
    }

    public boolean positionExists(Position position) {
        return positionExists(position.getRow(), position.getColumn());
    }

    private boolean thereIsPiece(Position position) {
        if (!positionExists(position)){
            throw new BoardException("Position does not exist");
        }
        return piece(position) != null;
    }


}
