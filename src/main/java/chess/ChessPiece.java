package chess;

import br.com.guilhermetech.chesssystem.boardgame.Board;
import br.com.guilhermetech.chesssystem.boardgame.Piece;
import lombok.Getter;

public abstract class ChessPiece extends Piece {

    @Getter
    private Color color;

    public ChessPiece(Board board, Color color) {
        super(board);
        this.color = color;
    }
}
