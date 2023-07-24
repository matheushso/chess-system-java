package br.com.chess.system.application;

import br.com.chess.system.chess.ChessMatch;
import br.com.chess.system.chess.ChessPiece;
import br.com.chess.system.chess.ChessPosition;
import br.com.chess.system.chess.Color;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UI {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static ChessPosition readChessPosition(Scanner sc) {
        try {
            String s = sc.nextLine();
            char column = s.charAt(0);
            int row = Integer.parseInt(s.substring(1));

            return new ChessPosition(column, row);
        } catch (RuntimeException e) {
            throw new InputMismatchException("Error reading chess position. Valid values are from a1 to h8.");
        }
    }

    public static StringBuilder printMatch(ChessMatch chessMatch) {
        StringBuilder match = new StringBuilder();

        match.append(printBoard(chessMatch.getPieces()))
                .append('\n')
                .append('\n')
                .append("Turn : ")
                .append(chessMatch.getTurn())
                .append('\n')
                .append("Waiting player: ")
                .append(chessMatch.getCurrentPlayer());

        return match;
    }

    public static StringBuilder printBoard(ChessPiece[][] pieces) {
        StringBuilder board = new StringBuilder();

        for (int i = 0; i < pieces.length; i++) {
            board.append((8 - i))
                    .append(" ");

            for (int j = 0; j < pieces.length; j++) {
                board.append(printPiece(pieces[i][j], false));
            }

            board.append('\n');
        }

        board.append("  a b c d e f g h");

        return board;
    }

    public static StringBuilder printBoard(ChessPiece[][] pieces, boolean[][] possibleMoves) {
        StringBuilder board = new StringBuilder();

        for (int i = 0; i < pieces.length; i++) {
            board.append((8 - i))
                    .append(" ");

            for (int j = 0; j < pieces.length; j++) {
                board.append(printPiece(pieces[i][j], possibleMoves[i][j]));
            }

            board.append('\n');
        }

        board.append("  a b c d e f g h");

        return board;
    }

    private static StringBuilder printPiece(ChessPiece piece, boolean background) {
        StringBuilder boardPiece = new StringBuilder();

        if (background) {
            boardPiece.append(ANSI_BLUE_BACKGROUND);
        }

        if (piece == null) {
            boardPiece.append("-" + ANSI_RESET);
        } else {
            if (piece.getColor() == Color.WHITE) {
                boardPiece.append(piece)
                        .append(ANSI_RESET);
            } else {
                boardPiece.append(ANSI_YELLOW)
                        .append(piece)
                        .append(ANSI_RESET);
            }
        }
        boardPiece.append(" ");

        return boardPiece;
    }
}
