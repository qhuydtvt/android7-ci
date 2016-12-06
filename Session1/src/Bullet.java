import java.awt.*;

/**
 * Created by apple on 12/3/16.
 */
public class Bullet {
    // Properties or Attributes

    public int x;
    public int y;

    public Image image;

    public Bullet(int x, int y, Image image) {
        this.x = x;
        this.y = y;
        this.image = image;
    }

    public void draw(Graphics g) {
        g.drawImage(image, x, y, 12, 30, null);
    }

    public void move(int dx, int dy) {
        x += dx;
        y += dy;
    }
}
