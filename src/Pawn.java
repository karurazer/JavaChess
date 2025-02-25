import java.awt.*;
import java.util.Objects;

public class Pawn extends Piece {
    public Pawn(String chessLocation, int color) {
        super(chessLocation, color);
    }

    public Pawn(int locationX, int locationY, int color) {
        super(locationX, locationY, color);
    }

    @Override
    public boolean canMove(String toChessLocation, Piece[][] board) {
        int[] from = chessLocationToXY(this.getChessLocation());
        int[] to = chessLocationToXY(toChessLocation);

        int fromX = from[0], fromY = from[1];
        int toX = to[0], toY = to[1];
        int direction = (Objects.equals(this.getColor(), "WHITE")) ? 1: -1;

        if (toX == fromX && toY == fromY + direction && board[toY][toX] == null) {
            return true;
        }

        if (toX == fromX && toY == fromY + (direction * 2) && board[toY][toX] == null && board[toY - direction][toX] == null && this.getPrevChessLocation() == null) {
            return true;
        }


        return false;
    }
}