package br.com.guilhermetech.chesssystem.boardgame;

import lombok.Getter;
import lombok.Setter;

public class Piece {

    protected Position position;
    private Board board;

    public Piece(Board board) {
        this.board = board;
    }

    protected Board getBoard() {
        return board;
    }
}
