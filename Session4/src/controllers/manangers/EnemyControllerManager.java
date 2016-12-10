package controllers.manangers;

import java.awt.*;
import controllers.EnemyController;

import java.util.Vector;

/**
 * Created by apple on 12/10/16.
 */
public class EnemyControllerManager extends ControllerManager {

    @Override
    public void run() {
        super.run();
        spawn();
    }

    private void spawn() {
        //1: Create enemy
        EnemyController enemyController = EnemyController.create(300, 0);

        //2: Add new enemy to vector
        this.controllers.add(enemyController);
    }
}
