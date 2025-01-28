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
        for (Piece[] row : chessboard) {
            for (Piece column : row) {
                switch (column) {
                    case Pawn pawn -> System.out.print("p");
                    case Knight knight -> System.out.print("k");
                    case Queen queen -> System.out.print("q");
                    case King king -> System.out.print("K");
                    case Rook rook -> System.out.print("r");
                    case Bishop bishop -> System.out.print("b");
                    case null, default -> System.out.print(".");
                    }
                }
            System.out.println();
            }

        }


    public void setPiece(Piece piece) {
        chessboard[piece.getLocationY()][piece.getLocationX()] = piece;
    }

}
