package controllers.enemies;

import controllers.BulletController;

/**
 * Created by apple on 12/21/16.
 */
public class ShotStraightBehavior implements ShotBehavior {

    @Override
    public void doShot(EnemyController enemyController) {
        int x = enemyController.getModel().getMidX() - 5;
        int y = enemyController.getModel().getY() + 30;
        EnemyBulletController enemyBulletController = EnemyBulletController.create(x,y);
        enemyController.add(enemyBulletController);
    }
}
