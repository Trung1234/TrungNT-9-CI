package enemies;

import controllers.CollisionManager;
import controllers.Controller;
import models.GameRect;
import views.ImageRenderer;

import java.awt.*;

/**
 * Created by My PC on 26/04/2017.
 */
public class EnemyControler extends Controller implements Collider{
    private MoveBehavior moveBehavior;
    public EnemyControler(int x, int y, Image image){
        gameRect = new GameRect(x,y,image.getWidth(null),image.getHeight(null));
        imageRenderer = new ImageRenderer(image);
        CollisionManager.instance.add(this);
    }

    public void setMoveBehavior(MoveBehavior moveBehavior) {
        this.moveBehavior = moveBehavior;
    }

    public void update(){
        if(moveBehavior!=null){
            moveBehavior.move(gameRect);

        }
    }
    public void getHit(int damage){
        gameRect.setDead(true);
        //System.out.println(String.format("Get hit %s",damage));
    }
//    public void draw(Graphics graphics) {
//        imageRenderer.render(graphics, gameRect);
//    }

    @Override
    public void onCollide(Collider other) {

    }
}
