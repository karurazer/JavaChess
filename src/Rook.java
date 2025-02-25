public class Rook extends Piece {
    public Rook(int locationX, int locationY, int color) {
        super(locationX, locationY, color);
    }

    public Rook(String chessLocation, int color) {
        super(chessLocation, color);
    }

    @Override
    public boolean canMove(String toChessLocation, Piece[][] board) {
        int[] from = chessLocationToXY(this.getChessLocation());
        int[] to = chessLocationToXY(toChessLocation);

        int fromX = from[0], fromY = from[1];
        int toX = to[0], toY = to[1];

        if (fromX != toX && fromY != toY) {
            return false;
        }

        if (fromX == toX) {
            int step = (toY > fromY) ? 1 : -1;
            for (int y = fromY + step; y != toY; y += step) {
                if (board[y][fromX] != null) return false;
            }
        } else {
            int step = (toX > fromX) ? 1 : -1;
            for (int x = fromX + step; x != toX; x += step) {
                if (board[fromY][x] != null) return false;
            }
        }

        if (board[toY][toX] != null && board[toY][toX].getColor().equals(this.getColor())) {
            return false;
        }

        return true;
    }
}


