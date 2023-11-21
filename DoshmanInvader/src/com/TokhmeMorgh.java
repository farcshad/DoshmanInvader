package com;

import java.awt.*;
import java.io.Serializable;

public class TokhmeMorgh implements Serializable {

    private Game game;

    private int x;
    private int y;

    private int vX;
    private int vY;

    private int size;

//    private ImageDrawer imageDrawer;


    public TokhmeMorgh(Game game , int x , int y , int vX , int vY , int size){
        this.game = game;

        this.x = x;
        this.y = y;
        this.vY = vY;
        this.vX = vX;
        this.size = size;

//        this.imageDrawer = game.getImageDrawer();

    }

    public TokhmeMorghData getData(){
        return new TokhmeMorghData(x,y,vX,vY,size);
    }

    public void render(Graphics g){
        g.setColor(new Color(200,200,200));
        g.fillOval(x-size/2,y-size/2,size,size);
    }

    public void tick(){
        x += vX;
        y += vY;
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
