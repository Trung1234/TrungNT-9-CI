package enemies;

import controllers.Bullet;
import controllers.CollisionManager;
import controllers.Controller;
import controllers.Player;
import models.GameRect;
import views.ImageRenderer;

import java.awt.*;

/**
 * Created by My PC on 26/04/2017.
 */
public class EnemyController extends Controller implements Collider{
    private MoveBehavior moveBehavior;
    private boolean shootEnableEnemy;
    private int damage=1;
    public EnemyController(int x, int y, Image image){
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
        gameRect.setInvisible(true);
        gameRect.setDead(true);
        CollisionManager.instance.remove(this);
        //System.out.println(String.format("Get hit %s",damage));
    }
//    public void draw(Graphics graphics) {
//        imageRenderer.render(graphics, gameRect);
//    }

    @Override
    public void onCollide(Collider other) {
        if(other instanceof Player){
            ((Player) other).getHit(damage);
        }
        if(other instanceof Bullet){
            ((Bullet)other).getHit();
        }
    }

    @Override
    public String toString() {
        return "EnemyController";
    }
}
