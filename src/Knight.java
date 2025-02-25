public class Knight extends Piece {
    public Knight(int locationX, int locationY, int color) {
        super(locationX, locationY, color);
    }

    public Knight(String chessLocation, int color) {
        super(chessLocation, color);
    }

    @Override
    public boolean canMove(String toChessLocation, Piece[][] board) {
        int[] from = chessLocationToXY(this.getChessLocation());
        int[] to = chessLocationToXY(toChessLocation);

        int fromX = from[0], fromY = from[1];
        int toX = to[0], toY = to[1];

        int[][] possibleMoves = {
                {fromX + 2, fromY + 1}, {fromX + 2, fromY - 1},
                {fromX - 2, fromY + 1}, {fromX - 2, fromY - 1},
                {fromX + 1, fromY + 2}, {fromX + 1, fromY - 2},
                {fromX - 1, fromY + 2}, {fromX - 1, fromY - 2}
        };

        boolean validMove = false;
        for (int[] move : possibleMoves) {
            if (move[0] == toX && move[1] == toY) {
                validMove = true;
                break;
            }
        }
        if (!validMove) return false;

        return board[toY][toX] == null || !board[toY][toX].getColor().equals(this.getColor());
    }

}
