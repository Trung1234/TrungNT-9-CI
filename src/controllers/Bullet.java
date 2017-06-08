package controllers;

import enemies.Collider;
import enemies.EnemyController;
import models.GameRect;
import views.ImageRenderer;

import java.awt.*;

/**
 * Created by My PC on 12/04/2017.
 */
public class Bullet extends Controller implements Collider{
    private int damage = 1;
    public Bullet(int x, int y, Image image) {
        super(new GameRect(x - image.getWidth(null)/2,y - image.getHeight(null),image.getWidth(null),image.getHeight(null)),
                new ImageRenderer(image));
        CollisionManager.instance.add(this);
    }
    public void getHit(){
        gameRect.setDead(true);
    }
    @Override
    public void update() {
        gameRect.move(0,-15);
    }

    @Override
    public void onCollide(Collider other) {
        // kiểm tra other là ênmycontroler
        if (other instanceof EnemyController){
            ((EnemyController)other).getHit(damage);
        }
    }

    @Override
    public String toString() {
        return "Bullet";
    }
}
