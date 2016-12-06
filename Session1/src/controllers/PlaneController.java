package controllers;

import models.PlaneModel;
import views.PlaneView;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by apple on 12/3/16.
 */
public class PlaneController {
    public PlaneModel planeModel;
    public PlaneView planeView;
    public KeySetting keySetting;

    public PlaneController(PlaneModel planeModel, PlaneView planeView) {
        this.planeModel = planeModel;
        this.planeView = planeView;
    }

    public void keyPressed(KeyEvent e) {
        if(keySetting != null) {
            int keyCode = e.getKeyCode();
            if(keyCode == keySetting.keyUp) {
                planeModel.move(0, -5);
            } else if (keyCode == keySetting.keyDown) {
                planeModel.move(0, 5);
            } else if (keyCode == keySetting.keyLeft) {
                planeModel.move(-5, 0);
            } else if (keyCode == keySetting.keyRight) {
                planeModel.move(5, 0);
            }
        }
    }

    public void draw(Graphics g) {
        planeView.draw(g, planeModel);
    }

    public void run() {

    }
}
