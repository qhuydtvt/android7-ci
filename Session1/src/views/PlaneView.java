package views;

import models.PlaneModel;

import java.awt.*;

/**
 * Created by apple on 12/3/16.
 */
public class PlaneView {
    public Image image;

    public PlaneView(Image image) {
        this.image = image;
    }

    public void draw(Graphics g, PlaneModel planeModel) {
        g.drawImage(image, planeModel.getX(), planeModel.getY(), 70, 50, null);
    }
}
