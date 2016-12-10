package controllers;

import models.Model;
import utils.Utils;
import views.View;

import java.awt.*;
import java.util.Vector;

/**
 * Created by apple on 12/10/16.
 */
public class EnemyController extends Controller {

    private static final int SPEED = 2;
    private static final int WIDTH = 35;
    private static final int HEIGHT = 30;
    private int timeCounter;

    private Vector<EnemyBulletController> enemyBulletControllers;

    public EnemyController(Model model, View view) {
        super(model, view);
        enemyBulletControllers = new Vector<>();
        timeCounter = 0;
    }

    @Override
    public void run() {
        //Move
        this.model.move(0, SPEED);

        timeCounter++;
        if (timeCounter > 30) {
            shoot();
            timeCounter = 0;
        }

        for (EnemyBulletController enemyBulletController : this.enemyBulletControllers) {
            enemyBulletController.run();
        }
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);

        for (EnemyBulletController enemyBulletController : this.enemyBulletControllers) {
            enemyBulletController.draw(g);
        }
    }

    private void shoot() {
        // Create a new bullet
        EnemyBulletController enemyBulletController = EnemyBulletController.create (
                this.model.getMidX() - EnemyBulletController.WIDTH / 2, //getMidX
                this.model.getBottom()
        );

        // Add bullet to vector
        this.enemyBulletControllers.add(enemyBulletController);
    }

    public static EnemyController create(int x, int y) {
        return new EnemyController(
                new Model(x, y, WIDTH, HEIGHT),
                new View(Utils.loadImage("resources/plane1.png"))
        );
    }
}
