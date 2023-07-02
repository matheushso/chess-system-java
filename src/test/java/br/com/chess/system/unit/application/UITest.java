package br.com.chess.system.unit.application;

import br.com.chess.system.application.UI;
import br.com.chess.system.chess.ChessMatch;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UITest {

    ChessMatch chessMatch = new ChessMatch();

    @Test
    public void getPieces_shouldReturnBoardWithPieces() {
        StringBuilder boardChess = new StringBuilder();
        boardChess.append("8 - - - - - - - - \n" +
                          "7 - - - - - - - - \n" +
                          "6 - - - - - - - - \n" +
                          "5 - - - - - - - - \n" +
                          "4 - - - - - - - - \n" +
                          "3 - - - - - - - - \n" +
                          "2 - - - - - - - - \n" +
                          "1 - - - - - - - - \n" +
                          "  a b c d e f g h");

        assertEquals(boardChess.toString(), UI.printBoard(chessMatch.getPieces()).toString());
    }
}
