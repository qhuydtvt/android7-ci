/**
 * Created by apple on 12/21/16.
 */
public class Duck {
    //changed & unchanged
    //properties & methods
    // Strategy Pattern
    // State (State Machine) Pattern

    protected FlyBehavior flyBehavior;

    public Duck(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public void quack() {
        System.out.println("Quack quack");
    }

    public void fly() {
        if (flyBehavior != null) {
            flyBehavior.doFly();
        } else {
            System.out.println(":'(");
        }
    }

    public void swim() {
        System.out.println("Swim");
    }

    public void getShot() {
        System.out.println("Oops");
    }
}
