package br.com.chess.system.chess.pieces;

import br.com.chess.system.boardgame.Board;
import br.com.chess.system.boardgame.Position;
import br.com.chess.system.chess.ChessMatch;
import br.com.chess.system.chess.ChessPiece;
import br.com.chess.system.chess.Color;

public class King extends ChessPiece {

    private ChessMatch chessMatch;

    public King(Board board, Color color, ChessMatch chessMatch) {
        super(board, color);
        this.chessMatch = chessMatch;
    }

    private boolean canMove(Position position) {
        ChessPiece p = (ChessPiece) getBoard().piece(position);
        return p == null || p.getColor() != getColor();
    }

    private boolean testRookCastling(Position position) {
        ChessPiece p = (ChessPiece)getBoard().piece(position);
        return p != null && p instanceof Rook && p.getColor() == getColor() && p.getMoveCount() == 0;
    }

    @Override
    public String toString() {
        return "K";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position p = new Position(0, 0);

        // above
        p.setValues(position.getRow() - 1, position.getColumn());

        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // below
        p.setValues(position.getRow() + 1, position.getColumn());

        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // left
        p.setValues(position.getRow(), position.getColumn() - 1);

        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // right
        p.setValues(position.getRow(), position.getColumn() + 1);

        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // nw
        p.setValues(position.getRow() - 1, position.getColumn() - 1);

        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // ne
        p.setValues(position.getRow() - 1, position.getColumn() + 1);

        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // sw
        p.setValues(position.getRow() + 1, position.getColumn() - 1);

        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // se
        p.setValues(position.getRow() + 1, position.getColumn() + 1);

        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // #specialmove castling
        if (getMoveCount() == 0 && !chessMatch.isCheck()) {

            // #specialmove castling kingside rook
            Position positionRook1 = new Position(position.getRow(), position.getColumn() + 3);

            if (testRookCastling(positionRook1)) {
                Position position1 = new Position(position.getRow(), position.getColumn() + 1);
                Position position2 = new Position(position.getRow(), position.getColumn() + 2);
                if (getBoard().piece(position1) == null && getBoard().piece(position2) == null) {
                    mat[position.getRow()][position.getColumn() + 2] = true;
                }
            }

            // #specialmove castling queenside rook
            Position positionRook2 = new Position(position.getRow(), position.getColumn() - 4);

            if (testRookCastling(positionRook2)) {
                Position position1 = new Position(position.getRow(), position.getColumn() - 1);
                Position position2 = new Position(position.getRow(), position.getColumn() - 2);
                Position position3 = new Position(position.getRow(), position.getColumn() - 3);
                if (getBoard().piece(position1) == null && getBoard().piece(position2) == null && getBoard().piece(position3) == null) {
                    mat[position.getRow()][position.getColumn() - 2] = true;
                }
            }
        }

        return mat;
    }
}
