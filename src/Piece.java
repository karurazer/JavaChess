abstract public class Piece {
    public static final int BLACK = 0;
    public static final int WHITE = 1;
    private final int color;

    private int locationX = -1;
    private int locationY = -1;
    private String chessLocation;

    private int prevLocationX;
    private int prevLocationY;
    private String prevChessLocation;

    private int cost;
    private String pieceType;

    public abstract boolean canMove(String toChessLocation, Piece[][] board);

    public Piece(String chessLocation, int color) {
        this.color = color;
        int[] move = chessLocationToXY(chessLocation);
        this.chessLocation = chessLocation;
        setPrevLocation(move[0], move[1]);
        setLocation(move[0], move[1]);
        setCost();
        setPieceType();
    }

    public Piece(int locationX, int locationY, int color) {
        this.color = color;
        this.chessLocation = XYToChessLocation(locationX, locationY);
        setPrevLocation(locationX, locationY);
        setLocation(locationX, locationY);
        setCost();
        setPieceType();
    }

    public int getLocationX() {
        return locationX;
    }

    public int getLocationY() {
        return locationY;
    }

    public String getColor() {
        return switch (this.color) {
            case BLACK -> "BLACK";
            case WHITE -> "WHITE";
            default -> null;
        };
    }

    public String getChessLocation() {
        return chessLocation;
    }

    public int getCost() {
        return cost;
    }

    public String getPieceType() {
        return pieceType;
    }

    public String getPrevChessLocation() {
        return prevChessLocation;
    }
    private void setPrevLocation(String prevChessLocation) {
        this.prevChessLocation = prevChessLocation;
        int[] prevLoc = chessLocationToXY(prevChessLocation);
        this.prevLocationX = prevLoc[0];
        this.prevLocationY = prevLoc[1];
    }

    private void setPrevLocation(int locationX, int locationY) {
        this.prevLocationX = locationX;
        this.prevLocationY = locationY;
        this.prevChessLocation = XYToChessLocation(locationX, locationY);
    }

    private void setCost() {
        switch (this) {
            case Pawn pawn -> this.cost = 1;
            case Knight knight -> this.cost = 3;
            case Queen queen -> this.cost = 9;
            case King king -> this.cost = -999;
            case Rook rook -> this.cost = 5;
            case Bishop bishop -> this.cost = 3;
            case null, default -> throw new IllegalArgumentException("Invalid figure");
        }
    }

    private void setPieceType() {
        switch (this) {
            case Pawn pawn -> this.pieceType = "Pawn";
            case Knight knight -> this.pieceType = "Knight";
            case Queen queen -> this.pieceType = "Queen";
            case King king -> this.pieceType = "King";
            case Rook rook -> this.pieceType = "Rook";
            case Bishop bishop -> this.pieceType = "Bishop";
            case null, default -> throw new IllegalArgumentException("Invalid figure");
        }
    }

    public static void checkLocation(String chessLocation) {
        if (chessLocation == null || chessLocation.length() != 2) {
            throw new IllegalArgumentException("Incorrect coordinates: " + chessLocation);
        }

        char file = chessLocation.charAt(0);
        char rank = chessLocation.charAt(1);

        if (file < 'A' || file > 'H' || rank < '1' || rank > '8') {
            throw new IllegalArgumentException("Incorrect coordinates: " + chessLocation);
        }
    }

    public static void checkLocation(int locationX, int locationY) {
        if (locationX < 0 || locationX > 7 || locationY < 0 || locationY > 7) {
            throw new IllegalArgumentException("Coordinates out of bounds: " + locationX + ", " + locationY);
        }
    }

    public void setLocation(int locationX, int locationY) {
        checkLocation(locationX, locationY);
        if (this.locationX != -1 && this.locationY != -1) {
            this.setPrevLocation(this.locationX, this.locationY);
        }
        this.locationX = locationX;
        this.locationY = locationY;
        this.chessLocation = XYToChessLocation(this.locationX, this.locationY);
    }

    public void setLocation(String chessLocation) {
        checkLocation(chessLocation);

        if (this.locationX != -1 && this.locationY != -1) {
            this.setPrevLocation(this.chessLocation);
        }
        this.chessLocation = chessLocation;
        int[] location = chessLocationToXY(chessLocation);
        this.locationX = location[0];
        this.locationY = location[1];
    }

    public static String XYToChessLocation(int x, int y) {
        if (x < 0 || x > 7 || y < 0 || y > 7) {
            return null;
        }
        return (char) ('A' + x) + String.valueOf(y + 1);
    }

    public static int[] chessLocationToXY(String chessLocation) {
        checkLocation(chessLocation);

        char file = chessLocation.charAt(0);
        char rank = chessLocation.charAt(1);

        return new int[]{file - 'A', rank - '1'};
    }

    public int getPrevLocationY() {
        return prevLocationY;
    }

    public int getPrevLocationX() {
        return prevLocationX;
    }
}