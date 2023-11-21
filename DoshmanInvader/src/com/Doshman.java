package com;

import com.doshmanGroups.CircularDoshmanSet;
import com.doshmanGroups.DoshmanSet;
import com.gameProject.stats.DoshmanBehaviour;
import com.gameProject.stats.DoshmanStatus;

import java.awt.*;
import java.io.Serializable;
import java.util.Random;

public class Doshman implements Serializable {

    private Game game;

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

    private DoshmanSet doshmanSet;




    public Doshman(Game game,int level,int fx, int fy,DoshmanBehaviour behaviour) {
        this.game = game;
        this.level = level;
        this.x = 0 ;
        this.y = 0;
        this.fx = fx;
        this.fy = fy;
        this.stable = false;
        this.behaviour = behaviour;
        this.vX = 1;
        this.vY = 0;
        status = DoshmanStatus.ALIVE;
        randomTimer = System.currentTimeMillis();
        tokhmeMorghTimer = System.currentTimeMillis();
        giftTimer = System.currentTimeMillis();

        if (level == 1){
            health = 50;
            maxHealth = health;
            size = 40;
        }
        if (level == 2){
            health = 100;
            maxHealth = health;
            size = 40;
        }
        if (level == 3){
            health = 200;
            maxHealth = health;
            size = 60;
        }
        if (level == 4){
            health = 1000;
            maxHealth = health;
            size = 80;
        }
        if (level == 5){
            health = 5000;
            maxHealth = health;
        }
        if (level == 6){
            health = 1000;
            maxHealth = health;
        }
        if (level == 7){
            health = 2000;
            maxHealth = health;
        }
    }

    public Doshman(Game game ,int level,int fx, int fy,DoshmanSet doshmanSet ){
        this.game = game;
        this.level = level;
        this.x = 0 ;
        this.y = 0;
        this.fx = fx;
        this.fy = fy;
        this.stable = false;
        this.doshmanSet = doshmanSet;
        this.behaviour = DoshmanBehaviour.SET;
        this.vX = 1;
        this.vY = 0;
        status = DoshmanStatus.ALIVE;
        randomTimer = System.currentTimeMillis();
        tokhmeMorghTimer = System.currentTimeMillis();
        giftTimer = System.currentTimeMillis();

        if (level == 1){
            health = 50;
            maxHealth = health;
            size = 40;
        }
        if (level == 2){
            health = 100;
            maxHealth = health;
            size = 40;
        }
        if (level == 3){
            health = 200;
            maxHealth = health;
            size = 60;
        }
        if (level == 4){
            health = 350;
            maxHealth = health;
            size = 80;
        }
        if (level == 5){
            health = 500;
            maxHealth = health;
        }
        if (level == 6){
            health = 1000;
            maxHealth = health;
        }
        if (level == 7){
            health = 2000;
            maxHealth = health;
        }
    }

    public Doshman(Game game,double x, double y, double fx, double fy, double vX, double vY,
                   boolean stable, int level, int health, int maxHealth, int size, DoshmanStatus status,
                   DoshmanBehaviour behaviour, long deathTime, long randomTimer, long tokhmeMorghTimer,
                   long giftTimer) {
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

    public DoshmanData getDoshmanData(){
        return  new DoshmanData(x,y,fx,fy,vX,vY,stable,level,health,maxHealth,
                size,status,behaviour,deathTime,randomTimer,tokhmeMorghTimer,giftTimer);
    }
    public void render(Graphics g){
//        ImageDrawer imageDrawer = game.getImageDrawer();
        ImageDrawer.doshmanRender(g,level,(int)x,(int)y,size);

        if(getHealthInHundred()>80){
            g.setColor(new Color(100,200,100));
        }
        else if(getHealthInHundred()>50){
            g.setColor(new Color(200,100,80));
        }
        else{
            g.setColor(new Color(250,50,50));
        }
        g.fillRect((int)x-size/2,(int)y+size/2+5,getHealthInHundred()*size/100,3);
    }
    public void tick(){
        if(health<=0){
            die();
        }
        if(!stable){
            goToPosition();
        }
        else{

            if(System.currentTimeMillis()-tokhmeMorghTimer>1000){
                createTokhmeMorgh(5);
                tokhmeMorghTimer = System.currentTimeMillis();
            }


            if(behaviour == DoshmanBehaviour.STANDARD){
                move();
            }

            if(behaviour == DoshmanBehaviour.RANDOM){
                Random random = new Random();
                if(System.currentTimeMillis()-randomTimer>500){
                    if (random.nextInt()%2==0){
                        vX = random.nextInt(2);
                    }
                    else
                        vX = -random.nextInt(2);

                    if (random.nextInt()%2==0){
                        vY = random.nextInt(2);
                    }
                    else
                        vY = -random.nextInt(2);

                    randomTimer = System.currentTimeMillis();
                }
                move();

            }
            if(behaviour == DoshmanBehaviour.SET){
                doshmanSet.tick(game,this);
            }

        }
    }

    public void move(){
        x += vX;
        y += vY;
        if(behaviour!= DoshmanBehaviour.SET){

            int r = size/2;
            if(x-r<0 || x+r>game.getWidth()){
                vX = -vX;
            }
            if(y-r<0 || y+r>game.getHeight()){
                vY = -vY;
            }
        }
    }

    public void hitByBullet(Bullet bullet){
        health -= bullet.getDamage();
    }

    public boolean isHittenByBullet(Bullet bullet){
        boolean b = false;
        if((bullet.getY() < this.y+size/2 && bullet.getY() > this.y-size/2)&&(bullet.getX() <this.x+size/2 && bullet.getX() > this.x-size/2)){
            b = true;
        }
        return b;
    }
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setFx(double fx) {
        this.fx = fx;
    }

    public void setFy(double fy) {
        this.fy = fy;
    }

    public double getFx() {
        return fx;
    }

    public double getFy() {
        return fy;
    }

    public double getvX() {
        return vX;
    }

    public void setvX(double vX) {
        this.vX = vX;
    }

    public double getvY() {
        return vY;
    }

    public void setvY(double vY) {
        this.vY = vY;
    }

    public int getSize() {
        return size;
    }

    public int getLevel() {
        return level;
    }



    public void setHealth(int health) {
        this.health = health;
    }

    public int getHealth() {
        return health;
    }
    public int getHealthInHundred(){
        return (health*100/maxHealth);
    }

    public void die(){
        status = DoshmanStatus.DEAD;
        deathTime = System.currentTimeMillis();
        if(level == 4){
            createGift(100);createGift(100);createGift(100);
        }
        createGift(18);
        game.addPoint(25);
        game.enemyKilled();
    }

    public DoshmanStatus getStatus() {
        return status;
    }

    public void createTokhmeMorgh(int percent){
        Random random = new Random();
        int n = random.nextInt(100);
        if(n<percent ){
            TokhmeMorgh tokhmeMorgh = new TokhmeMorgh(game,(int)x,(int)y,0,2,20);
            game.addTokhmemorgh(tokhmeMorgh);
//            System.out.println("TOKHM KARD");
        }
    }
    public void createGift(int percent){
        Random random = new Random();
        int n = random.nextInt(100);
        if(n<percent ){
            Gift gift = new Gift(game,random.nextInt(4)+1,(int)x,(int)y);

            game.addGift(gift);
//            System.out.println("GIFT DAD");
        }
    }

    public void goToPosition(){
        double arc = Math.atan(fx/fy);
//        System.out.println(arc);
        double sin = Math.sin(arc);
        double cos = Math.cos(arc);
        x += 4*sin;
        y += 4*cos;
        if(x<fx+5 && x>fx-5){
            x = fx;
        }
        if(y<fy+5 && y>fy-5){
            y = fy;
        }
        if(x == fx && y == fy){
            stable = true;
        }
    }

    public boolean isStable() {
        return stable;
    }
}
