package com;

import java.io.Serializable;

public class GiftData implements Serializable {

    private int level;
    private int x;
    private int y;
    private int vX;
    private int vY;
    private int size;


    public GiftData(int level,int x, int y, int vX, int vY, int size) {
        this.level = level;
        this.x = x;
        this.y = y;
        this.vX = vX;
        this.vY = vY;
        this.size = size;
    }

    public Gift getGift(Game game){
        return  new Gift(game,level,x,y,vX,vY,size);
    }
}
