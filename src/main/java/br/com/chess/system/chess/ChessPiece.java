package br.com.chess.system.chess;

import br.com.chess.system.boardgame.Board;
import br.com.chess.system.boardgame.Piece;

public class ChessPiece extends Piece {

    private Color color;


    public ChessPiece(Board board, Color color) {
        super(board);
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}