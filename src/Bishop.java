public class Bishop extends Piece {
    public Bishop(int locationX, int locationY, int color) {
        super(locationX, locationY, color);
    }
    public Bishop(String chessLocation, int color) {
        super(chessLocation, color);
    }

    @Override
    public boolean canMove(String toChessLocation, Piece[][] board){
        return true;

    }
}
