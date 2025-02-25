public class Rook extends Piece {
    public Rook(int locationX, int locationY, int color) {
        super(locationX, locationY, color);
    }

    public Rook(String chessLocation, int color) {
        super(chessLocation, color);
    }

    @Override
    public boolean canMove(String toChessLocation, Piece[][] board){
        return true;

    }
}
