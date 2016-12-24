package controllers.enemies;

import com.sun.org.glassfish.gmbal.GmbalException;
import controllers.Body;
import controllers.Controller;
import controllers.GameVector;
import controllers.PlaneController;
import models.Model;
import utils.Utils;
import views.View;

/**
 * Created by apple on 12/10/16.
 */
public class EnemyBulletController extends Controller implements Body {

    private static final int SPEED = 7;
    public static final int WIDTH = 8;
    public static final int HEIGHT = 8;

    private GameVector moveVector;

    public EnemyBulletController(Model model, View view) {
        this(model, view, new GameVector(0, SPEED));
    }

    public EnemyBulletController(Model model, View view, GameVector moveVector) {
        super(model, view);
        this.moveVector = moveVector;
    }

    @Override
    public void run() {
        model.move(moveVector);
    }

    public static EnemyBulletController create(int x, int y) {
        return new EnemyBulletController(
                new Model(x, y, WIDTH, HEIGHT),
                new View(Utils.loadImage("resources/bullet-round.png"))
        );
    }

    public static EnemyBulletController create(int x, int y, GameVector gameVector) {
        return new EnemyBulletController(
                new Model(x, y, WIDTH, HEIGHT),
                new View(Utils.loadImage("resources/bullet-round.png")),
                gameVector
        );
    }

    @Override
    public void onContact(Body other) {
        if(other instanceof PlaneController) {
            System.out.println("EB:)");
        }
    }
}
