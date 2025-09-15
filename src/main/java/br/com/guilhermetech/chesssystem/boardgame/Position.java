package br.com.guilhermetech.chesssystem.boardgame;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Position {

    private Integer row;
    private Integer column;

    public Position() {
    }

    public Position(Integer row, Integer column) {
        this.row = row;
        this.column = column;
    }

    @Override
    public String toString() {
        return row + ", " + column;
    }

    public void setValues(Integer row, Integer column) {
        this.row = row;
        this.column = column;
    }
}
