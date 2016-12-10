package controllers;

import java.awt.*;
import models.Model;
import views.View;

/**
 * Created by apple on 12/7/16.
 */
public class Controller {
    protected Model model;
    protected View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void run() {

    }

    public void draw(Graphics g) {
        view.draw(g, model);
    }
}
