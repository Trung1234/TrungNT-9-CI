package enemies;

import models.GameRect;
import views.ImageRenderer;

import java.awt.*;

/**
 * Created by My PC on 26/04/2017.
 */
public class EnemyControler {
    private ImageRenderer imageRenderer;
    private GameRect gameRect;
    public EnemyControler(int x, int y, Image image){
        imageRenderer = new ImageRenderer(image);
        gameRect = new GameRect(x,y,image.getWidth(null),image.getHeight(null));

    }
    public void update(){
        gameRect.move(0,3);
    }
    public void draw(Graphics graphics) {
        imageRenderer.render(graphics, gameRect);
    }
}
