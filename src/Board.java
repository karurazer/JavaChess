public class Board {
    private Piece[][] chessboard;
    private final int rows;
    private final int columns;

    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        chessboard = new Piece[rows][columns];
    }

    public Board() {
        chessboard = new Piece[8][8];
        rows = 8;
        columns = 8;
    }

    public void show_board() {
        int i = 0;
        for (Piece[] row : chessboard) {
            i++;
            System.out.print(i + " ");
            for (Piece figure : row) {
                switch (figure) {
                    case Pawn pawn -> System.out.print("p");
                    case Knight knight -> System.out.print("k");
                    case Queen queen -> System.out.print("q");
                    case King king -> System.out.print("K");
                    case Rook rook -> System.out.print("r");
                    case Bishop bishop -> System.out.print("b");
                    case null, default -> System.out.print(".");
                }
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println("  A B C D E F G H");

    }


    public void setPiece(Piece piece) {
        chessboard[piece.getLocationY()][piece.getLocationX()] = piece;
    }


}
