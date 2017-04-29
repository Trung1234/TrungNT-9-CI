package controllers;

import models.GameRect;
import views.ImageRenderer;

import java.awt.*;

/**
 * Created by My PC on 29/04/2017.
 */
public class Controller  {
    protected GameRect gameRect;
    protected ImageRenderer imageRenderer;

    public Controller() {
    }

    public Controller(GameRect gameRect, ImageRenderer imageRenderer) {
        this.gameRect = gameRect;
        this.imageRenderer = imageRenderer;
    }

    public GameRect getGameRect() {
        return gameRect;
    }

    public void draw(Graphics graphics){
        if (gameRect.isInvisible()) return;
        imageRenderer.render(graphics,gameRect);
    }
    public void update(){

    }
}
