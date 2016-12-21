/**
 * Created by apple on 12/21/16.
 */
public class STDuck extends Duck {

    public STDuck(FlyBehavior flyBehavior) {
        super(flyBehavior);
    }

    @Override
    public void getShot() {
        this.flyBehavior = new OneWingFlyBehavior();
    }
}
