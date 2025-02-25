public class King extends Piece {
    public King(int locationX, int locationY, int color) {
        super(locationX, locationY, color);
    }

    public King(String chessLocation, int color) {
        super(chessLocation, color);
    }
    @Override
    public boolean canMove(String toChessLocation, Piece[][] board){
        return true;

    }
}
