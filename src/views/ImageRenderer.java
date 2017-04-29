package views;

import models.GameRect;
import ultils.Utils;

import java.awt.*;

/**
 * Created by My PC on 26/04/2017.
 */
public class ImageRenderer {
    private Image image;

    public ImageRenderer(Image image) {
        this.image = image;
    }
    public ImageRenderer(String path) {
        this(Utils.loadImage(path));
    }
    public void render(Graphics graphics, GameRect gameRect){
        graphics.drawImage(image,gameRect.getX(),gameRect.getY(),
                gameRect.getWidth(),gameRect.getHeight(),null);
    }
}
