package br.com.chess.system.chess.pieces;

import br.com.chess.system.boardgame.Board;
import br.com.chess.system.boardgame.Position;
import br.com.chess.system.chess.ChessPiece;
import br.com.chess.system.chess.Color;

public class Knight extends ChessPiece {

    public Knight(Board board, Color color) {
        super(board, color);
    }

    private boolean canMove(Position position) {
        ChessPiece p = (ChessPiece)getBoard().piece(position);
        return p == null || p.getColor() != getColor();
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position position = new Position(0, 0);

        position.setValues(this.position.getRow() - 1, this.position.getColumn() - 2);
        if (getBoard().positionExists(position) && canMove(position)) {
            mat[position.getRow()][position.getColumn()] = true;
        }

        position.setValues(this.position.getRow() - 2, this.position.getColumn() - 1);
        if (getBoard().positionExists(position) && canMove(position)) {
            mat[position.getRow()][position.getColumn()] = true;
        }

        position.setValues(this.position.getRow() - 2, this.position.getColumn() + 1);
        if (getBoard().positionExists(position) && canMove(position)) {
            mat[position.getRow()][position.getColumn()] = true;
        }

        position.setValues(this.position.getRow() - 1, this.position.getColumn() + 2);
        if (getBoard().positionExists(position) && canMove(position)) {
            mat[position.getRow()][position.getColumn()] = true;
        }

        position.setValues(this.position.getRow() + 1, this.position.getColumn() + 2);
        if (getBoard().positionExists(position) && canMove(position)) {
            mat[position.getRow()][position.getColumn()] = true;
        }

        position.setValues(this.position.getRow() + 2, this.position.getColumn() + 1);
        if (getBoard().positionExists(position) && canMove(position)) {
            mat[position.getRow()][position.getColumn()] = true;
        }

        position.setValues(this.position.getRow() + 2, this.position.getColumn() - 1);
        if (getBoard().positionExists(position) && canMove(position)) {
            mat[position.getRow()][position.getColumn()] = true;
        }

        position.setValues(this.position.getRow() + 1, this.position.getColumn() - 2);
        if (getBoard().positionExists(position) && canMove(position)) {
            mat[position.getRow()][position.getColumn()] = true;
        }

        return mat;
    }

    @Override
    public String toString() {
        return "N";
    }
}
