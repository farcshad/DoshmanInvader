package com;

import java.awt.*;
import java.io.Serializable;
import java.util.LinkedList;

public class AtomicBullet implements Serializable {
    private Game game;
    private double x;
    private double y;
    private double xo;
    private double yo;
    private double vY;
    private double vX;
    private LinkedList<AtomicBullet> atomicBullets = new LinkedList<>();

    Player player;
    public AtomicBullet(Player player ){
        this.game = game;
        this.player = player;
        this.x = player.getX()-20;
        this.y = player.getY()-25;
        this.xo = x;
        this.yo = y;
        this.vY = -2;

//        calculateV();
        double deltaY = (player.getY()-(360));
        double deltaX = ((640)-player.getX());
        double ybex = deltaY/deltaX;

        vX = Math.sqrt(4/(1+(ybex*ybex)));
        vY = Math.sqrt(4-vX*vX);

        if(x<640&&y<360){
            vX = vX;
            vY = vY;
        }
        else if(x<640&&y>360){
            vX = vX;
            vY = -vY;
        }
        else if(x>640&&y<360){
            vX = -vX;
            vY = vY;
        }
        else if(x>640&&y>360){
            vX = -vX;
            vY = -vY;
        }
    }

    public void render(Graphics g ){
        ImageDrawer.atomicBulletRender(g,(int)x,(int)y);
    }

    public void tick(){
        y += vY;
        x += vX;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public double getX() {
        return x;
    }

    public void calculateV(){
        double deltaY = (player.getY()-(game.getHeight()/2));
        double deltaX = ((game.getWidth()/2)-player.getX());

    }

}
