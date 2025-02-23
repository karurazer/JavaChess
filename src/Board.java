public class Board {
    private Piece[][] chessboard;
    private final int rows;
    private final int columns;

    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.chessboard = new Piece[rows][columns];
    }

    public Board() {
        this.chessboard = new Piece[8][8];
        this.rows = 8;
        this.columns = 8;
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

    private Piece getPiece(int[] location) {
        return chessboard[location[1]][location[0]];
    }

    private Piece getPiece(String chessLocation) {
        int[] location = Piece.chessLocationToXY(chessLocation);
        return chessboard[location[1]][location[0]];
    }

    private void setPiece(Piece piece, String chessLocation) {
        int[] location = Piece.chessLocationToXY(chessLocation);
        if (piece == null) {
            chessboard[location[1]][location[0]] = null;
            return;
        }
        piece.setLocation(location[1], location[0]);
        chessboard[location[1]][location[0]] = piece;
    }

    public void setPiece(Piece piece) {
        try {
            chessboard[piece.getLocationY()][piece.getLocationX()] = piece;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void movePiece(String[] move) {
        String fmove = move[0];
        String smove = move[1];
        Piece piece = getPiece(fmove);
        if (piece == null) {
            System.out.println("Error: on " + move[0] + " no figure for move.");
            return;
        }
        setPiece(piece, smove);
        setPiece(null, fmove);
        System.out.println(piece.getColor() + " " + piece.getPieceType()  + " from " + piece.getPreCheessLocation() + " to " + piece.getChessLocation() + " cost: " + piece.getCost());
    }

}
