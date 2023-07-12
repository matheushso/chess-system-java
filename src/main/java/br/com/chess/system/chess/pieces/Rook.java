package br.com.chess.system.chess.pieces;

import br.com.chess.system.boardgame.Board;
import br.com.chess.system.chess.ChessPiece;
import br.com.chess.system.chess.Color;

public class Rook extends ChessPiece {

    public Rook(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "R";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
        return mat;
    }
}
