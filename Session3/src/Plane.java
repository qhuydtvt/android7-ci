import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by apple on 12/3/16.
 */
public class Plane {

    // Properties or Attributes
    public int x;
    public int y;

    public Image image;

    public int keyUp;
    public int keyDown;
    public int keyLeft;
    public int keyRight;

    public Plane(int x, int y, Image image, int keyUp, int keyDown, int keyLeft, int keyRight) {
        this.x = x;
        this.y = y;
        this.image = image;
        this.keyUp = keyUp;
        this.keyDown = keyDown;
        this.keyLeft = keyLeft;
        this.keyRight = keyRight;
    }

    public void draw(Graphics g) {
        g.drawImage(image, x, y, 70, 50, null);
    }

    public void move(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }

    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();

        if (keyCode == keyUp) {
            this.move(0, -5);
        } else if (keyCode == keyDown) {
            this.move(0, 5);
        } else if (keyCode == keyLeft) {
            this.move(-5, 0);
        } else if (keyCode == keyRight) {
            this.move(5, 0);
        }
    }

}
