package enemies;

import controllers.Controller;
import models.GameRect;
import views.ImageRenderer;

import java.awt.*;

/**
 * Created by My PC on 26/04/2017.
 */
public class EnemyControler extends Controller {
    private MoveBehavior moveBehavior;
    public EnemyControler(int x, int y, Image image){
        gameRect = new GameRect(x,y,image.getWidth(null),image.getHeight(null));
        imageRenderer = new ImageRenderer(image);
    }

    public void setMoveBehavior(MoveBehavior moveBehavior) {
        this.moveBehavior = moveBehavior;
    }

    public void update(){
        if(moveBehavior!=null){
            moveBehavior.move(gameRect);

        }
    }
    public void draw(Graphics graphics) {
        imageRenderer.render(graphics, gameRect);
    }
}
