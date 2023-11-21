package com;

import java.io.Serializable;

public class BulletData implements Serializable {

    double x , y , vX , vY ;
    int level , damage;

    public BulletData(double x, double y, double vX, double vY, int level, int damage) {
        this.x = x;
        this.y = y;
        this.vX = vX;
        this.vY = vY;
        this.level = level;
        this.damage = damage;
    }

    public Bullet getBullet(){
        return new Bullet(x,y,vX,vY,level,damage);
    }
}
