package br.com.chess.system.application;

import br.com.chess.system.chess.ChessMatch;

public class Program {

    public static void main(String[] args) {
        ChessMatch chessMatch = new ChessMatch();
        UI.printBoard(chessMatch.getPieces());
    }
}
