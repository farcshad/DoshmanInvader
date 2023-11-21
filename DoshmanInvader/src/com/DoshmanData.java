package com;

import com.gameProject.stats.DoshmanBehaviour;
import com.gameProject.stats.DoshmanStatus;

import java.io.Serializable;

public class DoshmanData implements Serializable {

    private double x ;
    private double y ;
    private double fx;
    private double fy;
    private double vX ;
    private double vY ;
    private boolean stable;

    private int level ;
    private int health ;
    private int maxHealth;
    private int size ;
    private DoshmanStatus status;
    private DoshmanBehaviour behaviour;
    private long deathTime;
    private long randomTimer;
    private long tokhmeMorghTimer;
    private long giftTimer;

    public DoshmanData(double x, double y, double fx, double fy,
                       double vX, double vY, boolean stable,
                       int level, int health, int maxHealth, int size,
                       DoshmanStatus status, DoshmanBehaviour behaviour,
                       long deathTime, long randomTimer, long tokhmeMorghTimer, long giftTimer) {
        this.x = x;
        this.y = y;
        this.fx = fx;
        this.fy = fy;
        this.vX = vX;
        this.vY = vY;
        this.stable = stable;
        this.level = level;
        this.health = health;
        this.maxHealth = maxHealth;
        this.size = size;
        this.status = status;
        this.behaviour = behaviour;
        this.deathTime = deathTime;
        this.randomTimer = randomTimer;
        this.tokhmeMorghTimer = tokhmeMorghTimer;
        this.giftTimer = giftTimer;
    }

    public Doshman getDoshman(Game game){
        return new Doshman(game,x,y,fx,fy,vX,vY,
                stable,level,health,maxHealth,size,status,behaviour
                ,deathTime,randomTimer,tokhmeMorghTimer,giftTimer);
    }
}
