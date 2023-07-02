package br.com.chess.system.application;

import br.com.chess.system.chess.ChessPiece;

public class UI {

    public static StringBuilder printBoard(ChessPiece[][] pieces) {
        StringBuilder board = new StringBuilder();

        for (int i=0; i < pieces.length; i++) {
            board.append((8 - i) + " ");

            for (int j=0; j < pieces.length; j++) {
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
            boardPiece.append(piece);
        }

        boardPiece.append(" ");

        return boardPiece;
    }
}
