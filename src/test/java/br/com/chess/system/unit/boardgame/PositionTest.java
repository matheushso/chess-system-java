package br.com.chess.system.unit.boardgame;

import br.com.chess.system.boardgame.Position;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PositionTest {

    @Test
    public void toString_shouldReturnRowAndColumn() {
        Position pos = new Position(3, 5);
        assertEquals("3, 5", pos.toString());
    }
}
