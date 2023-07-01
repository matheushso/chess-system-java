package br.com.chess.system.unit.boardgame;

import br.com.chess.system.boardgame.Position;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PositionTest {

    private Position pos = new Position(3, 5);


    @Test
    public void getRow_shouldReturnRow() {
        assertEquals(3, pos.getRow());
    }

    @Test
    public void setRow_shouldModifyRow() {
        pos.setRow(5);
        assertEquals(5, pos.getRow());
    }

    @Test
    public void getColumn_shouldReturnColumn() {
        assertEquals(5, pos.getColumn());
    }

    @Test
    public void setColumn_shouldModifyColumn() {
        pos.setColumn(7);
        assertEquals(7, pos.getColumn());
    }

    @Test
    public void toString_shouldReturnRowAndColumn() {
        assertEquals("3, 5", pos.toString());
    }
}
