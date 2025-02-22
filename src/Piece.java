public class Piece {
    public static final int BLACK = 0;
    public static final int WHITE = 1;
    private final int color;
    private int locationX;
    private int locationY;
    private String chessLocation;
    private boolean isAlive = true;

    public Piece(String chessLocation, int color) {
        this.color = color;
        setChessLocation(chessLocation);
    }

    public Piece(int locationX, int locationY, int color) {
        this.color = color;
        setLocation(locationX, locationY);
        this.chessLocation = XYToChessLocation(locationX, locationY);
    }

    public int getLocationX() {
        return locationX;
    }

    public int getLocationY() {
        return locationY;
    }

    public int getColor() {
        return color;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setDeath() {
        isAlive = false;
    }

    public String getChessLocation() {
        return chessLocation;
    }

    public void setChessLocation(String chessLocation) {
        if (chessLocation == null || chessLocation.length() != 2) {
            throw new IllegalArgumentException("Incorrect coordinates: " + chessLocation);
        }

        char file = chessLocation.charAt(0);
        char rank = chessLocation.charAt(1);

        if (file < 'A' || file > 'H' || rank < '1' || rank > '8') {
            throw new IllegalArgumentException("Incorrect coordinates: " + chessLocation);
        }

        this.chessLocation = chessLocation;
        this.locationX = file - 'A';
        this.locationY = Character.getNumericValue(rank) - 1;
    }

    public void setLocation(int locationX, int locationY) {
        if (locationX < 0 || locationX > 7 || locationY < 0 || locationY > 7) {
            throw new IllegalArgumentException("Coordinates out of bounds: " + locationX + ", " + locationY);
        }
        this.locationX = locationX;
        this.locationY = locationY;
    }

    private String XYToChessLocation(int x, int y) {
        if (x < 0 || x > 7 || y < 0 || y > 7) {
            return null;
        }
        return (char) ('A' + x) + String.valueOf(y + 1);
    }
}




