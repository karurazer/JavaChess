import java.util.Scanner;

public class Game {
    private Board chessboard = new Board();

    public Game() {
        chessboard.setPiece(new Pawn("A2", 1));
        chessboard.setPiece(new Pawn("B2", 1));
        chessboard.setPiece(new Pawn("C2", 1));
        chessboard.setPiece(new Pawn(3, 1, 1));
        chessboard.setPiece(new Pawn(4, 1, 1));
        chessboard.setPiece(new Pawn(5, 1, 1));
        chessboard.setPiece(new Pawn(6, 1, 1));
        chessboard.setPiece(new Pawn(7, 1, 1));

        chessboard.setPiece(new Rook("A1", 1));
        chessboard.setPiece(new Knight(1, 0, 1));
        chessboard.setPiece(new Bishop(2, 0, 1));
        chessboard.setPiece(new Queen(3, 0, 1));
        chessboard.setPiece(new King("E1", 1));
        chessboard.setPiece(new Bishop(5, 0, 1));
        chessboard.setPiece(new Knight(6, 0, 1));
        chessboard.setPiece(new Rook(7, 0, 1));
    }

    public void game_loop() {
        Scanner myObj = new Scanner(System.in);
        while (true) {
            chessboard.show_board();
            try {
                System.out.println("Enter yours move in format like D2 D4");
                String[] move = myObj.nextLine().trim().split(" ");
                chessboard.movePiece(move);

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
    }
}
