package com.doshmanGroups;

import com.Doshman;
import com.Game;
import com.gameProject.stats.DoshmanBehaviour;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class CircularDoshmanSet extends DoshmanSet{
    Game game;

    LinkedList<Doshman> doshmen;

    int size;
    int radius ;
    int alpha;

    int x ;
    int y;
    int t = 0 ;

    public CircularDoshmanSet(Game game,int size , int radius){
        this.game = game;
        this.radius = radius;
        this.alpha = 0;
        int teta = alpha;
        this.size = size;
        int dif = 360/size;
        doshmen = new LinkedList<>();
        x=-100;
        y=200;

        Doshman d = new Doshman(game,1,100,100,DoshmanBehaviour.STANDARD);
        for(int i = 0 ; i<size ; i++){
            Doshman doshman = new Doshman(game,3,x+(int)(radius*Math.cos(teta)), y+(int)(radius*Math.sin(teta)), DoshmanBehaviour.STANDARD);
            doshmen.add(doshman);
            teta += dif;
        }
        System.out.println(doshmen.get(0).getFx());

    }

    @Override
    public void tick(){
        if(t>=4){
            alpha++;
            t=0;
        }
        t++;
        x++;
        doshmen = new LinkedList<>();
        int teta = alpha;
        int dif = 360/size;
        for(int i = 0 ; i<size ; i++){

            Doshman doshman = new Doshman(game,3,x+(int)(radius*Math.cos(teta)), y+(int)(radius*Math.sin(teta)), DoshmanBehaviour.STANDARD);
            doshman.setX(doshman.getFx());
            doshman.setY(doshman.getFy());
            doshmen.add(doshman);

            teta += dif;



        }
    }
    @Override
    public void render(Graphics g){
        for(int i = 0 ; i<size ; i++){
            doshmen.get(i).render(g);
        }
    }

    @Override
    public LinkedList<Doshman> getDoshmen() {
        return doshmen;
    }
}
