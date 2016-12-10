package controllers;

import models.Model;
import views.View;

import java.awt.*;

/**
 * Created by apple on 12/7/16.
 */
public class BulletController extends Controller {

    public BulletController(Model model, View view) {
        super(model, view);
    }

    public void run() {
        this.model.move(0, -5);
    }
}
