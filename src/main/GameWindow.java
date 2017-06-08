package main;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import controllers.CollisionManager;
import controllers.ControllerManager;
import controllers.Player;
import scenes.Level1Scene;
import ultils.Utils;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author My PC
 */
public class GameWindow extends Frame {


    BufferedImage backbufferedImage;
    Graphics backBufferedgraphics;
    int coundowntime;
    Level1Scene currentScence;
    private boolean creatNewEnemyEnable = true;


    public GameWindow() {

        backbufferedImage = new BufferedImage(600, 800, BufferedImage.TYPE_INT_ARGB);
        currentScence = new Level1Scene();
        backBufferedgraphics = backbufferedImage.getGraphics();

        setVisible(true);
        setSize(600, 800);
        // listener: 
        addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
                //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void windowClosing(WindowEvent e) {
                //To change body of generated methods, choose Tools | Templates.
                //System.exit(0);
                dispose();
                System.out.println("closing");
            }

            @Override
            public void windowClosed(WindowEvent e) {
                System.out.println("close");
                //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void windowIconified(WindowEvent e) {
                //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
                //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void windowActivated(WindowEvent e) {
                //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
                //To change body of generated methods, choose Tools | Templates.
            }
        });
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyPressed(KeyEvent e) {
                currentScence.keyPressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                currentScence.keyReleased(e);
            }
        });
//


        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {// chay lien tuc
                    try {

                        //To change body of generated methods, choose Tools | Templates.
                        Thread.sleep(17);

                    } catch (InterruptedException ex) {
                        Logger.getLogger(GameWindow.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    if (creatNewEnemyEnable=true){

                        coundowntime++;
                    }
                    currentScence.update();
                    ControllerManager.instance.update();


                    CollisionManager.instance.update();


                    //draw
                    repaint();
                }
            }

        });
        thread.start();
    }




    @Override
    public void update(Graphics g) {

        ControllerManager.instance.draw(backBufferedgraphics);
        currentScence.draw(backBufferedgraphics);
        g.drawImage(backbufferedImage, 0, 0, this);// draw backbuffer on game window
    }

}
