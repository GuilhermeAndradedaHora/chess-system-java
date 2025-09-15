package br.com.guilhermetech.chesssystem.boardgame;

import lombok.Getter;
import lombok.Setter;

public class Board {


    @Getter
    @Setter
    private Integer rows;
    @Getter
    @Setter
    private Integer columns;
    private Piece[][] pieces;

    public Board(Integer rows, Integer columns) {
        this.rows = rows;
        this.columns = columns;
        pieces = new Piece[rows][columns];
    }

}
