package br.com.chess.system.application;

import br.com.chess.system.chess.ChessException;
import br.com.chess.system.chess.ChessMatch;
import br.com.chess.system.chess.ChessPiece;
import br.com.chess.system.chess.ChessPosition;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ChessMatch chessMatch = new ChessMatch();

        while (true) {
            try {
                System.out.println(UI.printBoard(chessMatch.getPieces()));
                System.out.println();
                System.out.print("Source: ");
                ChessPosition source = UI.readChessPosition(sc);

                System.out.println();
                System.out.print("Target: ");
                ChessPosition target = UI.readChessPosition(sc);

                ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
            } catch (ChessException | InputMismatchException ex) {
                System.out.println(ex.getMessage());
                sc.nextLine();
            }
        }
    }
}
