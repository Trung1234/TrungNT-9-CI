package scenes;

import controllers.Bullet;
import controllers.ControllerManager;
import controllers.Player;
import enemies.EnemyController;
import enemies.HorizMoveBehavior;

import ultils.Utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by My PC on 03/05/2017.
 */
public class Level1Scene {
    Image backgroundImage;
    Player playerController;
    boolean isUpPressed;
    boolean isDownPressed;
    boolean isLeftPressed;
    boolean isRightPressed;
    boolean isSpacePressed;
    ArrayList<Bullet> playerBulletControllers;
    ArrayList<EnemyController> enemyControllers;
    public Level1Scene() {
        playerController = new Player(200 - 17, 500 - 25, Utils.loadImage("res/plane3.png")) ;
        enemyControllers = new ArrayList<>();
        for (int x = 0; x < 600; x += 100) {
            EnemyController enemyController = new EnemyController(x, 0, Utils.loadImage("res/enemy-green-3.png"));
            if(x < 300)
                enemyController.setMoveBehavior(new HorizMoveBehavior());
            ControllerManager.instance.add(enemyController);
        }
        //1 Load image
        try {
            backgroundImage = ImageIO.read(new File("res/background.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void update(){
        playerController.processInput(isUpPressed,isDownPressed,isLeftPressed,isRightPressed,isSpacePressed);
        playerController.update();
    }
    public void draw(Graphics graphics){
        graphics.drawImage(backgroundImage,0,0,null);
        playerController.draw(graphics);
    }
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_RIGHT:
                isRightPressed = true;
                break;
            case KeyEvent.VK_LEFT:
                isLeftPressed = true;
                break;
            case KeyEvent.VK_UP:
                isUpPressed = true;
                break;
            case KeyEvent.VK_DOWN:
                isDownPressed = true;
                break;
            case KeyEvent.VK_SPACE:
                isSpacePressed = true;
                break;
        }
    }


    public void keyReleased(KeyEvent e) {

        switch (e.getKeyCode()) {
            case KeyEvent.VK_RIGHT:
                isRightPressed = false;
                break;
            case KeyEvent.VK_LEFT:
                isLeftPressed = false;
                break;
            case KeyEvent.VK_UP:
                isUpPressed = false;
                break;
            case KeyEvent.VK_DOWN:
                isDownPressed = false;
                break;
            case KeyEvent.VK_SPACE:
                isSpacePressed = false;
                break;
        }
    }
}
