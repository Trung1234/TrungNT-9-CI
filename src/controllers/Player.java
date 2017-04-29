package controllers;

import controllers.PlaneEnemy;
import models.GameRect;
import ultils.Utils;
import views.ImageRenderer;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by My PC on 12/04/2017.
 */
public class Player {
    private GameRect gameRect;

    private ImageRenderer imageRenderer;
    private boolean enableShoot = true;
    ArrayList<PlaneEnemy> planeEnemies;
    ArrayList<Bullet> bullets;
    private int coolDownTime;
    private int dx;
    private int dy;
    public Player(int xPlane, int yPlane, Image image) {
        imageRenderer = new ImageRenderer(image);
        gameRect = new GameRect(xPlane,yPlane,70,50);
        this.enableShoot = true;
        bullets = new ArrayList<>();
        planeEnemies = new ArrayList<>();
        PlaneEnemy planeEnemy1 = new PlaneEnemy(150 , 0, Utils.loadImage("res/enemy_plane_yellow_2.png"));planeEnemies.add(planeEnemy1);
        PlaneEnemy planeEnemy2 = new PlaneEnemy(160 , 40, Utils.loadImage("res/enemy_plane_yellow_2.png"));
        planeEnemies.add(planeEnemy2);
        PlaneEnemy planeEnemy3 = new PlaneEnemy(160 , 80, Utils.loadImage("res/enemy_plane_yellow_2.png"));
        planeEnemies.add(planeEnemy3);
        PlaneEnemy planeEnemy4 = new PlaneEnemy(100 , 40, Utils.loadImage("res/enemy_plane_yellow_3.png"));
        planeEnemies.add(planeEnemy4);
        PlaneEnemy planeEnemy6 = new PlaneEnemy(100 , 0, Utils.loadImage("res/enemy_plane_yellow_3.png"));
        planeEnemies.add(planeEnemy6);
    }

    public void move(boolean  isUpPressed,boolean isDownPressed,
                     boolean isRightPressed,boolean isLeftPressed
                      ,  boolean isSpacePressed){
        dx=0;
        dy=0;
        if (isRightPressed) {
            dx += 10;
        }
        if (isLeftPressed) {
            dx -= 10;
        }
        if (isUpPressed) {
            dy -= 10;
        }
        if (isDownPressed) {
            dy += 10;
        }
        if (isSpacePressed&&enableShoot) {
                Bullet bullet = null;
                bullet = new Bullet(gameRect.getX() , gameRect.getY(), Utils.loadImage("res/bullet.png"));
                bullets.add(bullet);

                enableShoot = false;
                coolDownTime = 10;

        }
    }


    public void draw(Graphics graphics){
        imageRenderer.render(graphics,gameRect);
        //graphics.drawImage(this.image,gameRect.getX(),gameRect.getY(),50,50,null);
        for (Bullet bullet : bullets) {
            bullet.draw(graphics);
        }
        for (PlaneEnemy planeEnemy : planeEnemies){
            planeEnemy.draw(graphics);
        }
    }
    public void update(){
        gameRect.move(dx,dy);

        for (Bullet bullet : bullets) {
            bullet.update();
        }
        for (PlaneEnemy planeEnemy : planeEnemies){
            planeEnemy.update();;
        }
        if(!enableShoot){
            // cooling down
            System.out.println(coolDownTime);
            coolDownTime --;
            if (coolDownTime <= 0){
                enableShoot = true;
            }
        }
        for (Bullet bullet : bullets) {
            bullet.update();
        }
        for (PlaneEnemy planeEnemy : planeEnemies){
            planeEnemy.update();
        }
    }
}
