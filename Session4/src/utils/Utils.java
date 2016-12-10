package utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by apple on 12/7/16.
 */
public class Utils {

    public static Image loadImage(String path) {
        try {
            Image image = ImageIO.read(new File(path));
            return image;
        } catch (IOException e) {
            e.printStackTrace();
            return  null;
        }
    }
}
