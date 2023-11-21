package com.doshmanGroups;

import com.Doshman;
import com.Game;
import com.gameProject.stats.DoshmanBehaviour;

import java.util.LinkedList;

public class ClockwiseDoshmanSet extends DoshmanSet{

    int v;
    LinkedList<Doshman> doshmen = new LinkedList<>();
    public ClockwiseDoshmanSet(){
        this.v = 2;

    }

    public void addDoshmenToGame(Game game , int numbers , int level){
        for(int i = 0 ; i<numbers ; i++){

            Doshman doshman = new Doshman(game ,level,(100+i*(game.getWidth()-100)/numbers),100,this);
            doshman.setvX(v);
            doshmen.add(doshman);
        }
        game.setDoshmen(doshmen);
    }
//
    public void tick(Game game , Doshman doshman){
        doshman.move();
        if(doshman.getX() > game.getWidth() ){
            doshman.setX(game.getWidth()-30);
            doshman.setvX(0);
            doshman.setvY(v);
        }
        if(doshman.getY() > game.getHeight() ){
            doshman.setY(game.getHeight()-30);
            doshman.setvX(-v);
            doshman.setvY(0);
        }
        if(doshman.getX() < 30 ){
            doshman.setX(50);
            doshman.setvX(0);
            doshman.setvY(-v);
        }
        if(doshman.getY() < 30 ){
            doshman.setY(50);
            doshman.setvX(v);
            doshman.setvY(0);
        }
    }

}
