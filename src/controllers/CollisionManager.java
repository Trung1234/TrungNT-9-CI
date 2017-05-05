package controllers;

import enemies.Collider;
import models.GameRect;

import java.util.ArrayList;

/**
 * Created by My PC on 29/04/2017.
 */
public class CollisionManager {
    public static final CollisionManager instance = new CollisionManager();
    private ArrayList<Collider> colliders;
    public  CollisionManager(){
        colliders = new ArrayList<>();
    }
    public void update(){
        for(int i=0;i<colliders.size()-1;i++){
            for(int j=i+1;j<colliders.size();j++){
                Collider ci= colliders.get(i);
                Collider cj = colliders.get(j);
                GameRect recti = ci.getGameRect();
                GameRect rectj = cj.getGameRect();

                if (recti == null) {
                    System.out.println(ci.toString() + "null rect");
                }

                if (rectj == null) {
                    System.out.println(cj.toString() + "null rect");
                }

                if(recti.intersects(rectj)){
                    ci.onCollide(cj);
                    cj.onCollide(ci);
                    //System.out.println("Boom");
                }
            }
        }
    }
    public void add(Collider collider){
        colliders.add(collider);
    }
    public void remove(Collider collider){
        if(collider.getGameRect().isDead()){
            colliders.remove(collider);
        }
    }
}
