package controllers.manangers;

import java.awt.*;
import controllers.EnemyController;

import java.util.Vector;

/**
 * Created by apple on 12/10/16.
 */
public class EnemyControllerManager extends ControllerManager {

    int counter;
    @Override
    public void run() {
        super.run();
        counter++;
        if (counter == 100) {
            spawn();
            counter = 0;
        }
    }

    private void spawn() {
        //1: Create enemy
        EnemyController enemyController = EnemyController.create(300, 0);

        //2: Add new enemy to vector
        this.controllers.add(enemyController);
    }
}
