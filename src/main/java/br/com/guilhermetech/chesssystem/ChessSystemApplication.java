package br.com.guilhermetech.chesssystem;

import application.UI;
import chess.ChessMatch;


public class ChessSystemApplication {

    public static void main(String[] args) {
        ChessMatch chessMatch = new ChessMatch();
        UI.printBoard(chessMatch.getPieces());
    }
}
