package controllers;

import controllers.enemies.EnemyBulletController;
import controllers.manangers.ControllerManager;
import models.Model;
import utils.Utils;
import views.View;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by apple on 12/3/16.
 */
public class PlaneController extends Controller implements Body {

    private static final int SPEED = 5;

    public KeySetting keySetting;

    private ControllerManager bulletManager;

    public PlaneController(Model model, View view) {
        super(model, view);
        bulletManager = new ControllerManager();
    }

    public void keyPressed(KeyEvent e) {
        if(keySetting != null) {
            int keyCode = e.getKeyCode();
            if(keyCode == keySetting.keyUp) {
                model.move(0, -SPEED);
            } else if (keyCode == keySetting.keyDown) {
                model.move(0, SPEED);
            } else if (keyCode == keySetting.keyLeft) {
                model.move(-SPEED, 0);
            } else if (keyCode == keySetting.keyRight) {
                model.move(SPEED, 0);
            } else  if(keyCode == keySetting.keyShoot) {
                shoot();
            }
        }
    }

    @Override
    public void run() {
        super.run();
        bulletManager.run();
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        bulletManager.draw(g);
    }

    private void shoot() {
        BulletController bulletController = BulletController.create(this.model.getMidX() - BulletController.WIDTH/ 2,
                this.model.getY() - BulletController.HEIGHT);
        bulletManager.add(bulletController);
    }

    // Design pattern
    // Factory
    public static PlaneController createPlane(int x, int y) {
        PlaneController planeController = new PlaneController(
                new Model(x, y, 70, 50),
                new View(Utils.loadImage("resources/plane3.png"))
        );
        return planeController;
    }

    @Override
    public void onContact(Body other) {
        if (other instanceof EnemyBulletController) {
            System.out.println("Plane:'(");
        }
    }
}
