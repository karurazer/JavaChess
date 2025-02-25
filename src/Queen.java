public class Queen extends Piece {
    public Queen(int locationX, int locationY, int color) {
        super(locationX, locationY, color);
    }

    public Queen(String chessLocation, int color) {
        super(chessLocation, color);
    }

    @Override
    public boolean canMove(String toChessLocation, Piece[][] board){
        return true;

    }
}

