public class Piece {
    public static final int BLACK = 0;
    public static final int WHITE = 1;
    private final int color;
    private int locationX;
    private int locationY;
    private boolean isAlive=true;

    public Piece(int locationX, int locationY, int color) {
        this.locationX = locationX;
        this.locationY = locationY;
        this.color = color;
    }

    public int getLocationX() {
        return locationX;
    }
    public void setLocationX(int locationX) {
        this.locationX = locationX;
    }

    public int getLocationY() {
        return locationY;
    }
    public void setLocationY(int locationY) {
        this.locationY = locationY;
    }
    public int getColor() {
        return color;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setDead() {
        isAlive = false;
    }
}
