package com.doshmanGroups;

import com.Doshman;
import com.Game;
import com.gameProject.stats.DoshmanBehaviour;

import java.util.LinkedList;

public class DoubleCircularDoshmanSet extends DoshmanSet{
    LinkedList<Doshman> doshmen = new LinkedList<>();
    int v ;
    int r ;
    int x ;
    int y ;
    double teta;
    int index = 0;
    double dif;
    public DoubleCircularDoshmanSet(){
        teta = 0;
        this.v = 1;
        this.r = 150;
        this.x = 200;
        this.y = 200;
    }

    public void addDoshmenToGame(Game game , int numbers , int level){
        dif = 360/numbers;
        for ( int i = 0 ; i<numbers ; i++){
            Doshman doshman = new Doshman(game,level,x+(int)(r*Math.cos(Math.toRadians(teta))), y+(int)(r*Math.sin(Math.toRadians(teta))), this);
            doshmen.add(doshman);
            teta += dif;
        }
        game.setDoshmen(doshmen);
    }
    //
    public void tick(Game game , Doshman doshman){
//        doshman.setX(doshman.getX()+v);
        if(index > 4){
            doshman.setX(x+(int)(r*Math.cos(Math.toRadians(teta))));
            doshman.setY(y+(int)(r*Math.sin(Math.toRadians(teta))));
            teta =(double)teta+  (double)dif + (double)(40.0/360);
            x+=v;
            index = 0;
//
        }
        index ++;




        if(x>game.getWidth()){
//            doshman.setvX(-doshman.getvX());
            v = -v;
        }
        if(x<0){
//            doshman.setvX(-doshman.getvX());
            v = -v;
        }
    }
}
