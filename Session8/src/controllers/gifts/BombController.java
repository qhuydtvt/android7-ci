package controllers.gifts;

import controllers.Body;
import controllers.Controller;
import controllers.PlaneController;
import controllers.manangers.BodyManager;
import controllers.notifications.EventType;
import controllers.notifications.NotificationCenter;
import models.Model;
import utils.Utils;
import views.SingleView;
import views.View;

import java.awt.*;

/**
 * Created by apple on 12/28/16.
 */
public class BombController extends Controller implements Body {

    private BombController(Model model, View view) {
        super(model, view);
        BodyManager.instance.register(this);
    }

    @Override
    public void run() {
        super.run();
        model.move(0, 1);
    }

    public static BombController create(int x, int y) {
        return new BombController(
                new Model(x, y, 30, 30),
                new SingleView(Utils.loadImageRes("bomb.png"))
        );
    }

    @Override
    public void onContact(Body other) {
        System.out.println("Contacted");
        System.out.println(String.format("%s", other.getClass().toString()));
        if(other instanceof PlaneController) {
            System.out.println("Contacted with plane controller");
            NotificationCenter.instance.onEvent(EventType.BOMB_EXPLOSION, model);
            this.destroy();
        }
    }
}
