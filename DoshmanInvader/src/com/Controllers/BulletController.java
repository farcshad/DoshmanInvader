package com.Controllers;

import com.*;

import java.awt.*;
import java.io.Serializable;
import java.util.LinkedList;

public class BulletController implements Serializable {

    private LinkedList<Bullet> bullets = new LinkedList<Bullet>();
    private LinkedList<AtomicBullet> atomicBullets = new LinkedList<>();
    private long boomTimer ;

    private Game game;


    public BulletController(Game game){
        this.game = game;
    }

    public BulletControllerData getBulletControllerData(){

        BulletControllerData bulletControllerData = new BulletControllerData();
        for(int i = 0 ; i<bullets.size() ; i++){
            BulletData bulletData = bullets.get(i).getData();
            bulletControllerData.addBulletData(bulletData);
        }
        return bulletControllerData;
    }

    public void tick(){


        for(int i = bullets.size()-1 ; i>=0 ; i--){
            bullets.get(i).tick();
            if(bullets.get(i).getY()<0) {
                removeBullet(bullets.get(i));
            }else{
                Bullet bullet = bullets.get(i);
                DoshmanController doshmanController = game.getDoshmanController();
                for(int j=doshmanController.getDoshmen().size()-1 ;j>=0 ; j--  ){
                    Doshman doshman = doshmanController.getDoshmen().get(j);
                    if(doshman.isHittenByBullet(bullet)){
                        doshman.hitByBullet(bullet);
                        removeBullet(bullet);
                    }
                }
            }
        }
        for(int i = atomicBullets.size()-1 ; i>=0 ; i--){
            AtomicBullet aBullet = atomicBullets.get(i);
            aBullet.tick();
        }
    }

    public void render(Graphics g){
        for(int i = atomicBullets.size()-1 ; i>= 0 ; i--){
            AtomicBullet aBullet = atomicBullets.get(i);
            aBullet.render(g);
            if(aBullet.getX()<640+25 && aBullet.getX()>640-25 && aBullet.getY()<360+25 && aBullet.getY()>360-25){
                removeAtomicBullet(aBullet);
                game.removeAlldoshmen();
                boomTimer = System.currentTimeMillis();
            }
        }
        if(System.currentTimeMillis()-boomTimer<400){
//            ImageDrawer imageDrawer = game.getImageDrawer();
            ImageDrawer.boomRender(g);
        }
        for(int i = bullets.size()-1 ; i>=0 ; i--){
            bullets.get(i).render(g);
        }
    }

    public synchronized void addBullet(Bullet b){
        if(b.getLevel()==1||b.getLevel()==2)
            bullets.add(b);
        else if(b.getLevel()==3){
            bullets.add(b);
            int x = (int)b.player.getX();
            Player p = b.player;
            p.setX(x+6);
            Bullet b2 = new Bullet(p);
            b2.setvX(1);
            bullets.add(b2);
            p.setX(x-6);
            Bullet b3 = new Bullet(p);
            b3.setvX(-1);
            bullets.add(b3);
            p.setX(x);
        }
    }

    public synchronized void removeBullet(Bullet b){
        bullets.remove(b);
    }

    public void addAtomicBullet(AtomicBullet b){
        atomicBullets.add(b);
    }

    public void removeAtomicBullet(AtomicBullet b){
        atomicBullets.remove(b);
    }

    public LinkedList<Bullet> getBullets() {
        return bullets;
    }
}
