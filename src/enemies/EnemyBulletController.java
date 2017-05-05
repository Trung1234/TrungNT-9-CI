package enemies;

import controllers.CollisionManager;
import controllers.Controller;
import controllers.Player;
import models.GameRect;
import views.ImageRenderer;

import java.awt.*;

/**
 * Created by My PC on 03/05/2017.
 */
public class EnemyBulletController extends Controller implements Collider {
    private int damage = 1;

    public EnemyBulletController(int x, int y, Image image) {
        gameRect = new GameRect(x, y, image.getWidth(null), image.getHeight(null));
        imageRenderer = new ImageRenderer(image);
        CollisionManager.instance.add(this);
    }

    public void getHit(int damage) {
        gameRect.setDead(true);
        CollisionManager.instance.remove(this);
    }

    public int getDamage() {
        return damage;
    }


    public void update() {
        gameRect.move(0, 5);
    }

    @Override
    public void onCollide(Collider other) {
        if (other instanceof Player) {
            ((Player) other).getHit(damage);
        }
    }
}
