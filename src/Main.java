
public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        board.setPiece(new Pawn(1,1,1));
        board.show_board();
    }
}