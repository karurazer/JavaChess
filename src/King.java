public class King extends Piece {
    public King(int locationX, int locationY, int color) {
        super(locationX, locationY, color);
    }

    public King(String chessLocation, int color) {
        super(chessLocation, color);
    }
    @Override
    public boolean canMove(String toChessLocation, Piece[][] board) {
        int[] from = chessLocationToXY(this.getChessLocation());
        int[] to = chessLocationToXY(toChessLocation);

        int fromX = from[0], fromY = from[1];
        int toX = to[0], toY = to[1];

        if (Math.abs(toX - fromX) > 1 || Math.abs(toY - fromY) > 1) {
            return false;
        }

        if (board[toY][toX] != null && board[toY][toX].getColor().equals(this.getColor())) {
            return false;
        }

        return true;
    }

}
