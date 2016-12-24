package views;

import models.Model;

import java.awt.*;

/**
 * Created by apple on 12/7/16.
 */
public class View {
    public Image image;

    public View(Image image) {
        this.image = image;
    }

    public void draw(Graphics g, Model model) {
        g.drawImage(image, model.getX(), model.getY(), model.getWidth(), model.getHeight(), null);
    }
}
