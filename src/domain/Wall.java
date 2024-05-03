package src.domain;

public class Wall {
    private int x;
    private int y;
    private int orientation;

    public Wall(int x, int y, int orientation) {
        this.x = x;
        this.y = y;
        this.orientation = orientation;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getOrientation() {
        return this.orientation;
    }
}
