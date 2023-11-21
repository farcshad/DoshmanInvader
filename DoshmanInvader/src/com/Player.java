package com;

import com.gameProject.stats.PlayerStat;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.Serializable;

public class Player implements Serializable {
    private Game game;

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


//    private BufferedImage playerImage1;
//    private BufferedImage playerImage2;
//    private BufferedImage playerImage3;
//    private BufferedImage playerImage4;
//    private BufferedImage atomicBullet ;
//    private BufferedImage statBarImage ;
//    private BufferedImage statBarImage2 ;
//    private BufferedImage playerImage;

//    ImageDrawer imageDrawer ;
    int imageIndex;

    public Player(Game game,double x,double y){
        this.game = game;
        this.x = x;
        this.y = y;
        this.heat = 0;
        this.health =100;
        this.remainingBombs = 5;
        this.remainingAtomicBombs = 3;
        this.bulletLevel = 1;
        this.pointsGained = 0;
        this.xpGained = 0;
        this.wave = 1;
        this.enemyKilled = 0;
        this.shotFired = 0;
        this.remainingLives = 5 ;
        timer = System.currentTimeMillis();
        shootTimer = System.currentTimeMillis();
        lastRespawn = System.currentTimeMillis();
//        imageDrawer = game.getImageDrawer();
        playerStat =PlayerStat.ALIVE;
        size = 50;
//        try{
//            playerImage1 = ImageIO.read(new File("D:\\GameProject\\res\\game\\xwing.png"));
//            playerImage2 = ImageIO.read(new File("D:\\GameProject\\res\\game\\fighter 1.png"));
//            playerImage3 = ImageIO.read(new File("D:\\GameProject\\res\\game\\fighter 2.png"));
//            playerImage4 = ImageIO.read(new File("D:\\GameProject\\res\\game\\fighter 3.png"));
//            atomicBullet = ImageIO.read(new File("D:\\GameProject\\res\\game\\atomicBullet.png"));
//            statBarImage = ImageIO.read(new File("D:\\GameProject\\res\\game\\statBarImage.png"));
//            statBarImage2 = ImageIO.read(new File("D:\\GameProject\\res\\game\\statBarImage2.png"));
//        }catch(Exception e){
//            e.printStackTrace();
//        }

//        playerImage = playerImage1;
        imageIndex =1 ;
    }

    public Player(Game game, double x, double y,
                  int heat, int health, int remainingLives,
                  int remainingBombs, int remainingAtomicBombs,
                  int bulletLevel, int pointsGained,
                  int wave, int xpGained, int shotFired, int enemyKilled) {
        this.game = game;
        this.x = x;
        this.y = y;
        this.size = 50;
        this.heat = heat;
        this.health = health;
        this.remainingBombs = remainingBombs;
        this.remainingAtomicBombs = remainingAtomicBombs;
        this.bulletLevel = bulletLevel;
        this.pointsGained = pointsGained;
        this.xpGained = xpGained;
        this.wave = wave;
//        wave ghablan 1 bood inja
        this.enemyKilled = enemyKilled;
        this.shotFired = shotFired;
        this.remainingLives = remainingLives;
        playerStat = PlayerStat.ALIVE;
        timer = System.currentTimeMillis();
        shootTimer = System.currentTimeMillis();
        lastRespawn = System.currentTimeMillis();
//        try{
//            playerImage1 = ImageIO.read(new File("D:\\GameProject\\res\\game\\xwing.png"));
//            playerImage2 = ImageIO.read(new File("D:\\GameProject\\res\\game\\fighter 1.png"));
//            playerImage3 = ImageIO.read(new File("D:\\GameProject\\res\\game\\fighter 2.png"));
//            playerImage4 = ImageIO.read(new File("D:\\GameProject\\res\\game\\fighter 3.png"));
//            atomicBullet = ImageIO.read(new File("D:\\GameProject\\res\\game\\atomicBullet.png"));
//            statBarImage = ImageIO.read(new File("D:\\GameProject\\res\\game\\statBarImage.png"));
//            statBarImage2 = ImageIO.read(new File("D:\\GameProject\\res\\game\\statBarImage2.png"));
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//        playerImage = playerImage1;
    }

    public Player(Game game, double x, double y, double vX, double vY,
                  int size, int heat, int health, int remainingLives, int remainingBombs,
                  int remainingAtomicBombs, int bulletLevel, int pointsGained, int wave, int xpGained,
                  int shotFired, int enemyKilled, boolean shooting, boolean overheated, boolean canshoot, boolean shield,
                  PlayerStat playerStat, long timer, long shootTimer,
                  long respawnTimer, long lastRespawn, int imageIndex) {
        this.game = game;
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

    public void render(Graphics g){
        g = (Graphics2D)g;
        if(playerStat == PlayerStat.ALIVE){
            BufferedImage playerImage = ImageDrawer.getPlayerImage(imageIndex);
            g.drawImage(playerImage,(int)x-25,(int)y-25,50,50,null);
            if(shield){
                g.setColor(new Color(150,250,150));
                g.drawOval((int)x-30,(int)y-30,60,60);
                g.setFont(new Font("ArcadeClassic",Font.PLAIN,15));
                g.drawString("shield    "+remainingShieldTimer(),(int)x-32,(int)y-35);
            }

        }
    }

    public void tick(){
        if(game.isKeyboardControl()){
            x +=vX;
            if(x>game.getWidth() )
                x= game.getWidth();
            if(x<0)
                x=0;
            y +=vY;
            if(y>game.getHeight())
                y = game.getHeight();
            if(y<0)
                y = 0;

            Robot r;
            try{
                r = new Robot();
                r.mouseMove((int)x,(int)y);
            }catch (Exception eee){

            }
        }
        if(System.currentTimeMillis()-timer>75){
            decreaseHeat();
            timer = System.currentTimeMillis();
        }
        if(shooting && playerStat == PlayerStat.ALIVE){
            shootBullet();
        }
        if(System.currentTimeMillis()-lastRespawn>3000){
            shield = false;
        }
        if(health<=0){
            die();
        }
    }

    public void renderStats(Graphics g){
        Graphics gg = g;
        ImageDrawer.statRender(gg);
        gg.setFont(new Font("ArcadeClassic",Font.PLAIN,15));
        gg.setColor(new Color(100,200,100));
        gg.fillRect(game.getWidth()-120,0,health,20);
        gg.setColor(new Color(250,10,100));
        gg.drawString("Damage "+health,game.getWidth()-210,17);
        gg.fillRect(20,0,heat,20);
        if(!isOverheated()) {
            gg.drawString("Heat "+heat,130,17);
        }
        else if(isOverheated()) {
            gg.drawString("Heat " + heat + "  OverHeated", 130, 17);
        }
        gg.setColor(new Color(100,100,100));
        gg.setFont(new Font("ArcadeClassic",Font.PLAIN,30));
        gg.drawString(""+ remainingLives,45,game.getHeight()-20);
        gg.drawString(""+ remainingAtomicBombs,125,game.getHeight()-20);
        gg.drawString(""+ bulletLevel,205,game.getHeight()-20);
        gg.drawString(""+ xpGained,285,game.getHeight()-20);
//        gg.drawImage(statBarImage,10,game.getHeight()-50,300,40,null);
//        gg.drawImage(statBarImage2,game.getWidth()-60,40,40,300,null);
        gg.setColor(new Color(187,187,182));
        gg.setFont(new Font("ArcadeClassic",Font.PLAIN,17));
        gg.drawString(""+pointsGained,game.getWidth()-45,85);
        gg.drawString(""+wave,game.getWidth()-45,155);
        gg.drawString(""+enemyKilled,game.getWidth()-45,230);
        gg.drawString(""+shotFired,game.getWidth()-55,305);
        respawnTimerRender(gg);
    }

    public void respawnTimerRender(Graphics g){
        g.setFont(new Font("ArcadeClassic",Font.PLAIN,250));
        g.setColor(new Color(250,10,100));
        if(playerStat == PlayerStat.DEAD && remainingLives >0 ){
            if(System.currentTimeMillis()-respawnTimer<1000){
                g.drawString(""+3,game.getWidth()/2-100,game.getHeight()/2);
            }
            else if(System.currentTimeMillis()-respawnTimer<2000){
                g.drawString(""+2,game.getWidth()/2-100,game.getHeight()/2);
            }
            else if(System.currentTimeMillis()-respawnTimer<2500){
                g.drawString(""+1,game.getWidth()/2-100,game.getHeight()/2);
            }
            else if(System.currentTimeMillis()-respawnTimer<3000){
                g.drawString("RESPAWN",game.getWidth()/2-450,game.getHeight()/2);
            }
        }
    }

    public double getvX() {
        return vX;
    }

    public void setPlayerImage(int i){
//        if(i == 1){
//            playerImage = playerImage1;
//        }
//        else if(i==2){
//            playerImage = playerImage2;
//        }
//        else if(i==3){
//            playerImage = playerImage3;
//        }
//        else if(i==4){
//            playerImage = playerImage4;
//        }
        imageIndex = i;
    }

    public double getvY() {
        return vY;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setvX(double vX) {
        this.vX = vX;
    }

    public void setvY(double vY) {
        this.vY = vY;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setShooting(boolean shooting) {
        this.shooting = shooting;
    }

    public void setRemainingAtomicBombs(int remainingAtomicBombs) {
        this.remainingAtomicBombs = remainingAtomicBombs;
    }

    public int getRemainingAtomicBombs() {
        return remainingAtomicBombs;
    }

    public int getBulletLevel() {
        return bulletLevel;
    }

    public void setBulletLevel(int bulletLevel) {
        this.bulletLevel = bulletLevel;
    }

    public int getHealth() {
        return health;
    }

    public int getRemainingLives() {
        return remainingLives;
    }

    public int getHeat() {
        return heat;
    }

    public int getEnemyKilled() {
        return enemyKilled;
    }

    public int getPointsGained() {
        return pointsGained;
    }

    public int getRemainingBombs() {
        return remainingBombs;
    }

    public int getShotFired() {
        return shotFired;
    }

    public int getWave() {
        return wave;
    }

    public int getXpGained() {
        return xpGained;
    }

    public void setEnemyKilled(int enemyKilled) {
        this.enemyKilled = enemyKilled;
    }

    public void setWave(int wave) {
        this.wave = wave;
    }

    public void increaseHeat(){
        if(bulletLevel==1)
            heat += 7;
        else if(bulletLevel == 2)
            heat += 5;
        else if(bulletLevel == 3)
            heat +=4;
        if(heat>=100){
            canshoot = false;
            overheated = true;
        }
    }

    public void decreaseHeat(){
        if(heat>0)
            heat -= 1;
        else {
            heat = 0;
            canshoot = true;
            overheated = false;
        }

    }

    public boolean canshoot() {
        return canshoot;
    }

    public boolean isOverheated() {
        return overheated;
    }

    public void shootBullet(){
        if(System.currentTimeMillis()-shootTimer>200 && canshoot){
            shootTimer = System.currentTimeMillis();
            game.shootBullet();
            increaseHeat();
            shotFired++;
            SoundEffect s = new SoundEffect("D:\\GameProject\\res\\shootSound.wav");
            s.play();
        }

    }

    public void respawn(long millis){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(millis);
                }catch (Exception e){

                }
                playerStat = PlayerStat.ALIVE;
                lastRespawn = System.currentTimeMillis();
                shield = true;
                health = 100;
            }
        });
        if (remainingLives>0){
            thread.start();
        }

    }
    public void die(){
        if (playerStat == PlayerStat.ALIVE && !shield){
            respawnTimer = System.currentTimeMillis();
            playerStat = PlayerStat.DEAD;
            remainingLives -=1;
            bulletLevel = 1;
            try{
                Robot robot = new Robot();
                robot.mouseMove(game.getWidth()/2,game.getHeight()-30);
                setX(game.getWidth()/2);
                setY(game.getHeight()-30);
            }catch (Exception e){
            }
            respawn(3000);
        }
    }

    public int remainingShieldTimer(){
        if(shield){
            if(System.currentTimeMillis()-lastRespawn < 1000){
                return 2;
            }
            else if(System.currentTimeMillis()-lastRespawn < 2000){
                return 1;
            }
            else if(System.currentTimeMillis()-lastRespawn < 3000){
                return 0;
            }
            else return 0;
        }
        else
            return 0;
    }
    public boolean getHittenByDoshman(Doshman doshman){
        boolean b = false;
        if(!shield){
            if(doshman.getX()+doshman.getSize()/2>x-size/2 && doshman.getX()-doshman.getSize()/2<x+size/2){
                if(doshman.getY()+doshman.getSize()/2>y-size/2 && doshman.getY()-doshman.getSize()/2<y+size/2){
                    if(doshman.getLevel() == 4){
                        doshman.setHealth(doshman.getHealth() - 120);
                    }
                    b = true;
                }
            }

        }
        return b;
    }

    public boolean getHittenByTokhmeMorgh(TokhmeMorgh tokhmeMorgh){
        boolean b = false;
        if(!shield){
            if((x-tokhmeMorgh.getX()<=size/2 && x-tokhmeMorgh.getX()>0 )|| (tokhmeMorgh.getX()-x<size/2 && tokhmeMorgh.getX()-x>0)){
                if((y-tokhmeMorgh.getY()<=size/2 && y-tokhmeMorgh.getY()>0 )|| (tokhmeMorgh.getY()-y<size/2 && tokhmeMorgh.getY()-y>0)){
                    b = true;
//                    System.out.println("KHORD BEHESH");
                }
            }
        }
        return b;
    }

    public boolean getHittenByGift(Gift gift){
        boolean b = false;
        if(gift.getX()+gift.getSize()/2>x-size/2 && gift.getX()-gift.getSize()/2<x+size/2){
            if(gift.getY()+gift.getSize()/2>y-size/2 && gift.getY()-gift.getSize()/2<y+size/2){
                b = true;
//                System.out.println("GIFTO GEREFTESH");
            }
        }
        return b;
    }

    public void takeDamage(int damage){
        if(!shield){
            health -= damage;

        }

    }
    public PlayerData getData(){
        return new PlayerData(x,y,vX,vY,size,heat,health,remainingLives,
                remainingBombs,remainingAtomicBombs,bulletLevel,pointsGained,wave,xpGained,
                shotFired,enemyKilled,shooting,overheated,canshoot,shield,playerStat,shootTimer,respawnTimer,lastRespawn,imageIndex,imageIndex
                );
    }

    public void addPoint(int point){
        pointsGained += point;
    }

    public void setPointsGained(int pointsGained) {
        this.pointsGained = pointsGained;
    }

    public void setXpGained(int xpGained) {
        this.xpGained = xpGained;
    }

}
