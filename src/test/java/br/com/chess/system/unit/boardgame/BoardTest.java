package br.com.chess.system.unit.boardgame;

import br.com.chess.system.boardgame.Board;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardTest {

    private Board board = new Board(3, 5);

    @Test
    public void getRow_shouldReturnRow() {
        assertEquals(3, board.getRows());
    }

    @Test
    public void getColumn_shouldReturnColumn() {
        assertEquals(5, board.getColumns());
    }
}
