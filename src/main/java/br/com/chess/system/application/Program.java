package br.com.chess.system.application;

import br.com.chess.system.chess.ChessException;
import br.com.chess.system.chess.ChessMatch;
import br.com.chess.system.chess.ChessPiece;
import br.com.chess.system.chess.ChessPosition;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ChessMatch chessMatch = new ChessMatch();
        List<ChessPiece> captured = new ArrayList<>();

        while (!chessMatch.isCheckMate()) {
            try {
                System.out.println(UI.printMatch(chessMatch, captured));
                System.out.println();
                System.out.print("Source: ");
                ChessPosition source = UI.readChessPosition(sc);

                boolean[][] possibleMoves = chessMatch.possibleMoves(source);
                System.out.println();
                System.out.println(UI.printBoard(chessMatch.getPieces(), possibleMoves));

                System.out.println();
                System.out.print("Target: ");
                ChessPosition target = UI.readChessPosition(sc);
                System.out.println();

                ChessPiece capturedPiece = chessMatch.performChessMove(source, target);

                if (capturedPiece != null) {
                    captured.add(capturedPiece);
                }

                if (chessMatch.getPromoted() != null) {
                    System.out.print("Enter piece for promotion (B/N/R/Q): ");
                    String type = sc.nextLine().toUpperCase();

                    while (!type.equals("B") && !type.equals("N") && !type.equals("R") && !type.equals("Q")) {
                        System.out.print("Invalid value! Enter piece for promotion (B/N/R/Q): ");
                        type = sc.nextLine().toUpperCase();
                    }

                    chessMatch.replacePromotedPiece(type);
                }
            } catch (ChessException | InputMismatchException ex) {
                System.out.println(ex.getMessage());
                sc.nextLine();
            }
        }
        System.out.println(UI.clearScreen());
        System.out.println(UI.printMatch(chessMatch, captured));
    }
}
