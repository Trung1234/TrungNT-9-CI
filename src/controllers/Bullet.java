package controllers;

import enemies.Collider;
import models.GameRect;
import views.ImageRenderer;

import java.awt.*;

/**
 * Created by My PC on 12/04/2017.
 */
public class Bullet extends Controller implements Collider{

    public Bullet(int x, int y, Image image) {
        super(new GameRect(x - image.getWidth(null)/2,y - image.getHeight(null),image.getWidth(null),image.getHeight(null)),
                new ImageRenderer(image));
        CollisionManager.instance.add(this);
    }

    @Override
    public void update() {
        gameRect.move(0,-15);
    }

    @Override
    public void onCollide(Collider other) {

    }
//
//    public void draw(Graphics graphics){
//        graphics.drawImage(this.image,this.x,this.y,null);
//    }
//    public void update(){
//        this.y-=15;
//    }
}
