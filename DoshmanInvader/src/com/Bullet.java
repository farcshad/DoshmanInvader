package com;

import java.awt.*;
import java.io.Serializable;

public class Bullet implements Serializable {
    private double x;
    private double y;
    private double vY;
    private double vX;
    private int level;
    private int damage;
    public Player player;
    public Bullet(Player player){
        this.x = player.getX()-2;
        this.y = player.getY()-25;
        this.vY = -8;
        this.vX = 0;
        this.player = player;
        this.level = player.getBulletLevel();
    }

    public Bullet(double x, double y , double vX , double vY , int level , int damage){
        this.x = x;
        this.y = y;
        this.vX = vX;
        this.vY = vY;
        this.level = level;
        this.damage = damage;
    }

    public BulletData getData(){
        return new BulletData(x,y,vX,vY,level,damage);
    }

    public void render(Graphics g ){
        if(level == 1){
            g.setColor(new Color(10,200,100));
            g.fillOval((int)x,(int)y,4,30);
        }
        else if(level == 2){
            g.setColor(new Color(200,50,50));
            g.fillOval((int)x,(int)y,4,50);
        }
        else if(level == 3){
            g.setColor(new Color(50,100,200));
            g.fillOval((int)x,(int)y,4,30);
//            g.fillOval((int)x-6,(int)y,4,30);
//            g.fillOval((int)x+6,(int)y,4,30);
        }

    }

    public void tick(){
        y += vY;
        x += vX;
        if(level == 1){
            vY = -8;
            damage = 10;
        }
        if(level == 2){
            vY = -15;
            damage = 20;
        }
        if(level == 3){
            vY = -10;
            damage = 15;
        }
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setvY(double vY) {
        this.vY = vY;
    }

    public void setvX(double vX) {
        this.vX = vX;
    }

    public double getY() {
        return y;
    }

    public double getX() {
        return x;
    }

    public int getLevel() {
        return level;
    }

    public int getDamage() {
        return damage;
    }
}
