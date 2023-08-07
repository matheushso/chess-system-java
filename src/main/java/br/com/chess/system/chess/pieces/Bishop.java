package br.com.chess.system.chess.pieces;

import br.com.chess.system.boardgame.Board;
import br.com.chess.system.boardgame.Position;
import br.com.chess.system.chess.ChessPiece;
import br.com.chess.system.chess.Color;

public class Bishop extends ChessPiece {

    public Bishop(Board board, Color color) {
        super(board, color);
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position position = new Position(0, 0);

        // nw
        position.setValues(this.position.getRow() - 1, this.position.getColumn() - 1);

        while (getBoard().positionExists(position) && !getBoard().thereIsAPiece(position)) {
            mat[position.getRow()][position.getColumn()] = true;
            position.setValues(position.getRow() - 1, position.getColumn() - 1);
        }

        if (getBoard().positionExists(position) && isThereOpponentPiece(position)) {
            mat[position.getRow()][position.getColumn()] = true;
        }

        // ne
        position.setValues(this.position.getRow() - 1, this.position.getColumn() + 1);

        while (getBoard().positionExists(position) && !getBoard().thereIsAPiece(position)) {
            mat[position.getRow()][position.getColumn()] = true;
            position.setValues(position.getRow() - 1, position.getColumn() + 1);
        }

        if (getBoard().positionExists(position) && isThereOpponentPiece(position)) {
            mat[position.getRow()][position.getColumn()] = true;
        }

        // se
        position.setValues(this.position.getRow() + 1, this.position.getColumn() + 1);

        while (getBoard().positionExists(position) && !getBoard().thereIsAPiece(position)) {
            mat[position.getRow()][position.getColumn()] = true;
            position.setValues(position.getRow() + 1, position.getColumn() + 1);
        }

        if (getBoard().positionExists(position) && isThereOpponentPiece(position)) {
            mat[position.getRow()][position.getColumn()] = true;
        }

        // sw
        position.setValues(this.position.getRow() + 1, this.position.getColumn() - 1);

        while (getBoard().positionExists(position) && !getBoard().thereIsAPiece(position)) {
            mat[position.getRow()][position.getColumn()] = true;
            position.setValues(position.getRow() + 1, position.getColumn() - 1);
        }

        if (getBoard().positionExists(position) && isThereOpponentPiece(position)) {
            mat[position.getRow()][position.getColumn()] = true;
        }

        return mat;
    }

    @Override
    public String toString() {
        return "B";
    }
}
