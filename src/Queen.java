public class Queen extends Piece {
    public Queen(int locationX, int locationY, int color) {
        super(locationX, locationY, color);
    }

    public Queen(String chessLocation, int color) {
        super(chessLocation, color);
    }

    @Override
    public boolean canMove(String toChessLocation, Piece[][] board) {
        int[] from = chessLocationToXY(this.getChessLocation());
        int[] to = chessLocationToXY(toChessLocation);

        int fromX = from[0], fromY = from[1];
        int toX = to[0], toY = to[1];

        boolean isStraightMove = (fromX == toX || fromY == toY);
        boolean isDiagonalMove = (Math.abs(fromX - toX) == Math.abs(fromY - toY));

        if (!(isStraightMove || isDiagonalMove)) {
            return false;
        }

        int stepX = Integer.compare(toX, fromX);
        int stepY = Integer.compare(toY, fromY);
        int x = fromX + stepX;
        int y = fromY + stepY;

        while (x != toX || y != toY) {
            if (board[y][x] != null) {
                return false;
            }
            x += stepX;
            y += stepY;
        }

        if (board[toY][toX] != null && board[toY][toX].getColor().equals(this.getColor())) {
            return false;
        }

        return true;
    }

}

