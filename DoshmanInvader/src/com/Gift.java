package com;

import java.awt.*;
import java.io.Serializable;

public class Gift implements Serializable {

    private Game game ;
    private int level ;
    private int x,y;
    private int vX,vY;
    private int size;


    public Gift(Game game, int level, int x, int y, int vX, int vY, int size) {
        this.game = game;
        this.level = level;
        this.x = x;
        this.y = y;
        this.vX = vX;
        this.vY = vY;
        this.size = size;
    }

    public Gift(Game game, int level, int x , int y ){

        this.game = game;
        this.level = level;
        this.x = x;
        this.y = y;
        this.vX = 0;
        this.vY = 1;
        this.size = 20;


    }

    public void render(Graphics g){
//        ImageDrawer imageDrawer = game.getImageDrawer();
        if(level <= 3){

            ImageDrawer.giftRender(g,level,x,y,40);
        }
        if (level ==4 ){
            g.setColor(new Color(200,150,00));
            g.fillOval(x-5,y-5,10,10);
        }

    }

    public void tick(){
        x += vX;
        y += vY;
    }
    public int getLevel() {
        return level;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getSize() {
        return size;
    }

    public GiftData getData(){
        return new GiftData(level,x,y,vX,vY,size);
    }


}
