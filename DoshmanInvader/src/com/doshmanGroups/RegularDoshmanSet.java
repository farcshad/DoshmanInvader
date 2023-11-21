package com.doshmanGroups;

import com.Doshman;
import com.Game;
import com.gameProject.stats.DoshmanBehaviour;

import java.util.LinkedList;

public class RegularDoshmanSet extends DoshmanSet {
    LinkedList<Doshman> doshmen = new LinkedList<>();
    int v ;
    public RegularDoshmanSet(){
        this.v = 2;

    }

    public void addDoshmenToGame(Game game , int numbers , int level){
        int rows = numbers/10;
        int cols = 10;
        for(int i = 0 ; i<rows ; i++){
            for(int j = 0 ; j<10 ; j++){
                Doshman doshman = new Doshman(game,level,200+(j*70),150+(i*70), this);
                doshman.setvX(v);
                doshmen.add(doshman);
            }
        }
        game.setDoshmen(doshmen);
    }
    //
    public void tick(Game game , Doshman doshman){
        doshman.setX(doshman.getX()+v);
        if(doshman.getX()>game.getWidth()){
//            doshman.setvX(-doshman.getvX());
            doshman.setX(game.getWidth());
            v = -v;
        }
        if(doshman.getX()<0){
//            doshman.setvX(-doshman.getvX());
            doshman.setX(0);
            v = -v;
        }
    }
}
