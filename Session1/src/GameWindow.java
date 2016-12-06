import com.sun.prism.*;
import controllers.KeySetting;
import controllers.PlaneController;
import models.PlaneModel;
import views.PlaneView;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

// Data abstraction

/**
 * Created by apple on 11/30/16.
 */
public class GameWindow extends Frame implements Runnable {
    Image background;

    PlaneController planeController;

    Vector<Bullet> bulletVector;
    BufferedImage backBuffer;

    public GameWindow() {
        bulletVector = new Vector<>();

        planeController = new PlaneController(
                new PlaneModel(300, 300),
                new PlaneView(loadImage("resources/plane3.png")));
        planeController.keySetting = new KeySetting(
                KeyEvent.VK_UP,
                KeyEvent.VK_DOWN,
                KeyEvent.VK_LEFT,
                KeyEvent.VK_RIGHT);

        setVisible(true);
        setSize(600, 400);

        backBuffer = new BufferedImage(600, 400, BufferedImage.TYPE_INT_ARGB);

        addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
                System.out.println("windowOpened");
            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("windowClosing");
                System.exit(0);
            }

            @Override
            public void windowClosed(WindowEvent e) {
                System.out.println("windowClosed");

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });
        background = loadImage("resources/background.png");

        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                System.out.println( " keyTyped");
            }

            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println("keyPressed");
                planeController.keyPressed(e);

                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    int bulletX = planeController.planeModel.getX() + 35 - 6;
                    int bulletY = planeController.planeModel.getY() - 30;
                    planeController.planeModel.setX(-1);
                    Bullet bullet = new Bullet(bulletX, bulletY, loadImage("resources/bullet.png"));
                    bulletVector.add(bullet);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                System.out.println("keyReleased");

            }
        });
    }

    private Image loadImage(String path) {
        try {
            Image image = ImageIO.read(new File(path));
            return image;
        } catch (IOException e) {
            e.printStackTrace();
            return  null;
        }
    }

    @Override
    public void update(Graphics g) {
        // Prepare backbuffer
        Graphics backBufferGraphics = backBuffer.getGraphics();
        backBufferGraphics.drawImage(background, 0, 0, 600, 400, null);
        planeController.draw(backBufferGraphics);
        for(Bullet bullet : bulletVector)
            bullet.draw(backBufferGraphics);

        // Update window
        g.drawImage(backBuffer, 0, 0, 600, 400, null);
    }

    @Override
    public void run() {
        while (true) {
            try {
                this.repaint();
                Thread.sleep(17);
                for(Bullet bullet : bulletVector)
                    bullet.move(0, -5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
