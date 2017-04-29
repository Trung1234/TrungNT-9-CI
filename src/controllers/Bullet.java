package controllers;

import models.GameRect;
import views.ImageRenderer;

import java.awt.*;

/**
 * Created by My PC on 12/04/2017.
 */
public class Bullet extends Controller {

    public Bullet(int x, int y, Image image) {
        super(new GameRect(x - image.getWidth(null)/2,y - image.getHeight(null),image.getWidth(null),image.getHeight(null)),
                new ImageRenderer(image));
    }

    @Override
    public void update() {
        gameRect.move(0,-15);
    }
//
//    public void draw(Graphics graphics){
//        graphics.drawImage(this.image,this.x,this.y,null);
//    }
//    public void update(){
//        this.y-=15;
//    }
}
