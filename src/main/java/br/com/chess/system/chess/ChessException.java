package br.com.chess.system.chess;

import br.com.chess.system.boardgame.BoardException;

public class ChessException extends BoardException {

    public ChessException(String msg) {
        super(msg);
    }
}
