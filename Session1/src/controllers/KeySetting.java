package controllers;

/**
 * Created by apple on 12/3/16.
 */
public class KeySetting {
    public int keyUp;
    public int keyDown;
    public int keyLeft;
    public int keyRight;

    public KeySetting(int keyUp, int keyDown, int keyLeft, int keyRight) {
        this.keyUp = keyUp;
        this.keyDown = keyDown;
        this.keyLeft = keyLeft;
        this.keyRight = keyRight;
    }
}
