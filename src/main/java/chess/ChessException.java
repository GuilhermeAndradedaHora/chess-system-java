package chess;

import br.com.guilhermetech.chesssystem.boardgame.BoardException;

public class ChessException extends BoardException {
    public ChessException(String message){
        super(message);
    }
}
