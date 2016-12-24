package controllers.manangers;

import controllers.enemies.EnemyController;
import controllers.enemies.EnemyType;

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

    private int enemyCount;

    private void spawn() {
        //1: Create enemy
        enemyCount++;
        EnemyController enemyController = null;
        if(enemyCount%2 == 0) {
            enemyController = EnemyController.create(300, 0, EnemyType.WHITE);
        }else {
            enemyController = EnemyController.create(300, 0, EnemyType.BROWN);
        }
            //2: Add new enemy to vector
        this.controllers.add(enemyController);
    }
}
