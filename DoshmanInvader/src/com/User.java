package com;

import java.io.Serializable;

public class User implements Serializable {

    private String username;
    private double x;
    private double y;
    private int heat;
    private int health;
    private int remainingLives;
    private int remainingBombs;
    private int remainingAtomicBombs;
    private int bulletLevel;
    private int pointsGained;
    private int xpGained;
    private int wave;
    private int enemyKilled;
    private int shotFired;

    public User(String username){
        this.username = username;
        this.x = 640;
        this.y = 400;
        this.heat = 0;
        this.health =100;
        this.remainingLives = 5 ;
        this.remainingBombs = 5;
        this.remainingAtomicBombs = 3;
        this.bulletLevel = 1;
        this.pointsGained = 0;
        this.xpGained = 0;
        this.wave = 0;
        this.enemyKilled = 0;
        this.shotFired = 0;

    }

    public Player getPlayer(Game game){
        return new Player(game,x,y,heat,health,remainingLives,remainingBombs,remainingAtomicBombs,bulletLevel,pointsGained,wave,xpGained,shotFired,enemyKilled);
    }

    public void syncUser(Player player){
        this.username = username;
        this.x = player.getX();
        this.y = player.getY();
        this.heat = player.getHeat();
        this.health =player.getHealth();
        this.remainingLives = player.getRemainingLives();
        this.remainingBombs = player.getRemainingBombs();
        this.remainingAtomicBombs = player.getRemainingAtomicBombs();
        this.bulletLevel = player.getBulletLevel();
        this.pointsGained = player.getPointsGained();
        this.xpGained = player.getXpGained();
        this.wave = player.getWave();
        this.enemyKilled = player.getEnemyKilled();
        this.shotFired = player.getShotFired();
    }

    public String getUsername() {
        return username;
    }

    public int getXpGained() {
        return xpGained;
    }

    public int getPointsGained() {
        return pointsGained;
    }
}
