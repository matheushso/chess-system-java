package br.com.chess.system.application;

import br.com.chess.system.chess.ChessPiece;
import br.com.chess.system.chess.Color;

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

    public static StringBuilder printBoard(ChessPiece[][] pieces) {
        StringBuilder board = new StringBuilder();

        for (int i = 0; i < pieces.length; i++) {
            board.append((8 - i) + " ");

            for (int j = 0; j < pieces.length; j++) {
                board.append(printPiece(pieces[i][j]));
            }

            board.append('\n');
        }

        board.append("  a b c d e f g h");

        return board;
    }

    private static StringBuilder printPiece(ChessPiece piece) {
        StringBuilder boardPiece = new StringBuilder();

        if (piece == null) {
            boardPiece.append("-");
        } else {
            if (piece.getColor() == Color.WHITE) {
                boardPiece.append(piece);
            } else {
                boardPiece.append(ANSI_YELLOW + piece + ANSI_RESET);
            }
        }
        boardPiece.append(" ");

        return boardPiece;
    }
}
