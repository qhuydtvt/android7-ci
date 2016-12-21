/**
 * Created by apple on 12/21/16.
 */
public class Program {
    public static void main(String[] args) {
        STDuck stDuck = new STDuck(new NormalFlyBehavior());

        stDuck.fly();
        stDuck.quack();
        stDuck.swim();

        stDuck.getShot();

        stDuck.fly();

//        RubberDuck rubberDuck = new RubberDuck(null);
//
//        rubberDuck.fly();
//        rubberDuck.quack();
//        rubberDuck.swim();
    }
}
