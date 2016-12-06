package models;

/**
 * Created by qhuydtvt on 12/3/16.
 */
public class PlaneModel {
    private int x;
    private int y;

    public PlaneModel(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void move(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        if (x < 0) {
            throw  new RuntimeException("Do khon nan");
        }
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
