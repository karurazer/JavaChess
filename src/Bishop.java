public class Bishop extends Piece {
    public Bishop(int locationX, int locationY, int color) {
        super(locationX, locationY, color);
    }
    public Bishop(String chessLocation, int color) {
        super(chessLocation, color);
    }

    @Override
    public boolean canMove(String toChessLocation, Piece[][] board) {
        int[] from = chessLocationToXY(this.getChessLocation());
        int[] to = chessLocationToXY(toChessLocation);

        int fromX = from[0], fromY = from[1];
        int toX = to[0], toY = to[1];

        if (Math.abs(toX - fromX) != Math.abs(toY - fromY)) {
            return false;
        }


        int stepX = (toX > fromX) ? 1 : -1;
        int stepY = (toY > fromY) ? 1 : -1;

        int x = fromX + stepX;
        int y = fromY + stepY;
        while (x != toX && y != toY) {
            if (board[y][x] != null) return false;
            x += stepX;
            y += stepY;
        }

        if (board[toY][toX] != null && board[toY][toX].getColor().equals(this.getColor())) {
            return false;
        }

        return true;
    }

}
