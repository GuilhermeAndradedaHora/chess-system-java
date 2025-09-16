package br.com.guilhermetech.chesssystem.application;

import br.com.guilhermetech.chesssystem.chess.ChessException;
import br.com.guilhermetech.chesssystem.chess.ChessMatch;
import br.com.guilhermetech.chesssystem.chess.ChessPiece;
import br.com.guilhermetech.chesssystem.chess.ChessPosition;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class ChessSystemApplication {

    public static void main(String[] args) {

        var sc = new Scanner(System.in);
        var chessMatch = new ChessMatch();
        var captured = new ArrayList<ChessPiece>();

        while(!chessMatch.getCheckMate()){
            try {
                UI.clearScreen();
                UI.printMatch(chessMatch, captured);
                System.out.println();
                System.out.print("Source: ");
                ChessPosition source = UI.readChessPosition(sc);

                boolean[][] possibleMoves = chessMatch.possibleMoves(source);
                UI.clearScreen();
                UI.printBoard(chessMatch.getPieces(), possibleMoves);

                System.out.println();
                System.out.print("Target: ");
                ChessPosition target = UI.readChessPosition(sc);

                var capturedPiece = chessMatch.performChessMove(source, target);

                if(capturedPiece == null){
                    captured.add(capturedPiece);
                }
            }catch (ChessException e){
                System.out.println(e.getMessage());
                sc.nextLine();
            }catch (InputMismatchException e){
                System.out.println(e.getMessage());
                sc.nextLine();
            }

        }
        UI.clearScreen();
        UI.printMatch(chessMatch, captured);


    }
}
