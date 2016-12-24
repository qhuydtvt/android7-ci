package controllers.enemies;

import controllers.Body;
import controllers.BulletController;
import controllers.Controller;
import controllers.manangers.BodyManager;
import models.Model;
import utils.Utils;
import views.View;

import java.awt.*;
import java.util.Vector;

/**
 * Created by apple on 12/10/16.
 */

public class EnemyController extends Controller implements Body {


    private static final int WIDTH = 35;
    private static final int HEIGHT = 30;
    private int timeCounter;

    private Vector<EnemyBulletController> enemyBulletControllers;

    private MoveBehavior moveBehavior;
    private ShootBehavior shootBehavior;
    public void add(EnemyBulletController enemyBulletController) {
        this.enemyBulletControllers.add(enemyBulletController);
    }

    public EnemyController(Model model, View view, MoveBehavior moveBehavior, ShootBehavior shootBehavior) {
        super(model, view);
        enemyBulletControllers = new Vector<>();
        timeCounter = 0;
        this.moveBehavior = moveBehavior;
        BodyManager.instance.register(this);

        this.shootBehavior = shootBehavior;
    }

    @Override
    public void run() {
        //Move

        if(moveBehavior != null) {
            moveBehavior.doMove(this);
        }

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
//        EnemyBulletController enemyBulletController = EnemyBulletController.create (
//                this.model.getMidX() - EnemyBulletController.WIDTH / 2, //getMidX
//                this.model.getBottom()
//        );
//
//        // Add bullet to vector
//        this.enemyBulletControllers.add(enemyBulletController);
        if (shootBehavior != null){
            shootBehavior.doShot(this);
        }
    }

    public static EnemyController create(int x, int y, EnemyType type) {
        switch (type) {
            case BROWN:
                return new EnemyController(
                        new Model(x, y, WIDTH, HEIGHT),
                        new View(Utils.loadImage("resources/plane1.png")),
                        new MoveStraightDownBehavior(),
                        new ShootStraightBehavior()
                );
            case GREEN:
                return new EnemyController(
                        new Model(x, y, WIDTH, HEIGHT),
                        new View(Utils.loadImage("resources/enemy-green-3.png")),
                        new MoveZigZagBehavior(),
                        new ShootOnTargetBehavior()
                );
        }
        return null;
    }

    @Override
    public void onContact(Body other) {
        if (other instanceof BulletController) {
            System.out.println("Huhu");
            this.model.setAlive(false);
        }
    }
}
