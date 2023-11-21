package com;

import com.gameProject.stats.PlayerStat;

import java.io.Serializable;

public class PlayerData implements Serializable {
    private double x;
    private double y;
    private double vX = 0;
    private double vY = 0;
    private int size;

    private int heat;
    private int health;
    private int remainingLives ;
    private int remainingBombs ;
    private int remainingAtomicBombs;
    private int bulletLevel ;
    private int pointsGained ;
    private int wave ;
    private int xpGained ;
    private int shotFired ;
    private int enemyKilled ;

    private boolean shooting;
    private boolean overheated = false;
    private boolean canshoot = true;
    private boolean shield = true;
    private PlayerStat playerStat;

    private long timer ;
    private long shootTimer;
    private long respawnTimer;
    private long lastRespawn;

    private int imageIndex;

    public PlayerData( double x, double y, double vX, double vY,
                  int size, int heat, int health, int remainingLives, int remainingBombs,
                  int remainingAtomicBombs, int bulletLevel, int pointsGained, int wave, int xpGained,
                  int shotFired, int enemyKilled, boolean shooting, boolean overheated, boolean canshoot, boolean shield,
                  PlayerStat playerStat, long timer, long shootTimer,
                  long respawnTimer, long lastRespawn, int imageIndex) {
        this.x = x;
        this.y = y;
        this.vX = vX;
        this.vY = vY;
        this.size = size;
        this.heat = heat;
        this.health = health;
        this.remainingLives = remainingLives;
        this.remainingBombs = remainingBombs;
        this.remainingAtomicBombs = remainingAtomicBombs;
        this.bulletLevel = bulletLevel;
        this.pointsGained = pointsGained;
        this.wave = wave;
        this.xpGained = xpGained;
        this.shotFired = shotFired;
        this.enemyKilled = enemyKilled;
        this.shooting = shooting;
        this.overheated = overheated;
        this.canshoot = canshoot;
        this.shield = shield;
        this.playerStat = playerStat;
        this.timer = timer;
        this.shootTimer = shootTimer;
        this.respawnTimer = respawnTimer;
        this.lastRespawn = lastRespawn;
        this.imageIndex = imageIndex;
    }
    public Player getPlayer(Game game){
        return new Player(game,  x,  y,  vX,  vY, size,  heat,  health,  remainingLives,  remainingBombs,
         remainingAtomicBombs,  bulletLevel,  pointsGained,  wave,  xpGained, shotFired,  enemyKilled,  shooting,  overheated,  canshoot,  shield,
         playerStat,  timer,  shootTimer, respawnTimer,  lastRespawn,  imageIndex);
    }
}
