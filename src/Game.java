import java.lang.reflect.Array;
import java.util.Scanner;

public class Game {
    private Board chessboard = new Board();

    public Game() {
        chessboard.setPiece(new Pawn("A2", 1));
        chessboard.setPiece(new Pawn(1, 1, 1));
        chessboard.setPiece(new Pawn(2, 1, 1));
        chessboard.setPiece(new Pawn(3, 1, 1));
        chessboard.setPiece(new Pawn(4, 1, 1));
        chessboard.setPiece(new Pawn(5, 1, 1));
        chessboard.setPiece(new Pawn(6, 1, 1));
        chessboard.setPiece(new Pawn(7, 1, 1));

        chessboard.setPiece(new Rook(0, 0, 1));
        chessboard.setPiece(new Knight(1, 0, 1));
        chessboard.setPiece(new Bishop(2, 0, 1));
        chessboard.setPiece(new Queen(3, 0, 1));
        chessboard.setPiece(new King(4, 0, 1));
        chessboard.setPiece(new Bishop(5, 0, 1));
        chessboard.setPiece(new Knight(6, 0, 1));
        chessboard.setPiece(new Rook(7, 0, 1));
    }

    public void game_loop() {
        Scanner myObj = new Scanner(System.in);
        while (true) {
            chessboard.show_board();
            try {
                System.out.println("Enter yours move in format like A1 B4");

                String[] move = myObj.nextLine().trim().split(" ");


            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
    }
}
