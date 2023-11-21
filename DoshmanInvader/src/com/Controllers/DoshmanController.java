package com.Controllers;

import com.Doshman;
import com.DoshmanData;
import com.Game;
import com.doshmanGroups.CircularDoshmanSet;
import com.gameProject.stats.DoshmanStatus;

import java.awt.*;
import java.io.Serializable;
import java.util.LinkedList;

public class DoshmanController implements Serializable {

    LinkedList<Doshman> doshmen = new LinkedList<>();

    Game game;

    CircularDoshmanSet doshmanSet;

    private boolean doshmanSetBehavior;
    public DoshmanController(Game game){
        this.game = game;
    }

    public DoshmanController(Game game , LinkedList<Doshman> doshmen){
        this.game = game;
        this.doshmen = doshmen;
    }

    public void tick(){
        if(doshmanSetBehavior ){
            doshmanSet.tick();
//            doshmanSet = new CircularDoshmanSet(game,4,100);
//            System.out.println(doshmanSet.getDoshmen().get(0).getX());;
            setDoshmen(doshmanSet.getDoshmen());
            doshmen = doshmanSet.getDoshmen();
            game.setDoshmen(doshmanSet.getDoshmen());
        }


//        else{

            for(int i = doshmen.size()-1 ; i>=0 ; i--){
                if(!doshmanSetBehavior){
                    Doshman d = doshmen.get(i);
                    d.tick();

                }
//                if(d.getX()-d.getSize()/2<0 || d.getX()+d.getSize()/2>game.getWidth()){
//                    for(int j = doshmen.size()-1 ; i>=0 ; i--) {
//                        doshmen.get(i).setvX(-doshmen.get(i).getvX());
//                        doshmen.get(i).tick();
//                    }
//                }
//                if(d.getY()-d.getSize()/2<0 || d.getY()+d.getSize()/2>game.getHeight()){
//                    for(int j = doshmen.size()-1 ; i>=0 ; i--) {
//                        doshmen.get(j).setvY(-doshmen.get(j).getvY());
//                        doshmen.get(j).
//                    }
//                }
                if(game.getPlayer().getHittenByDoshman(doshmen.get(i))){
                    game.playerDie();

                }
                if(doshmen.get(i).getStatus() == DoshmanStatus.DEAD){
                    doshmen.remove(doshmen.get(i));
                }
            }

            if(doshmen.size()==0){
                game.increaseWave();
            }
//        }

    }

    public void render(Graphics g){

        for(int i = doshmen.size()-1 ; i>=0 ; i--){
            doshmen.get(i).render(g);
        }
    }

    public synchronized void addDoshman(Doshman d){
        doshmen.add(d);
    }

    public synchronized void removeDoshman(Doshman d){
        doshmen.remove(d);
    }

    public LinkedList<Doshman> getDoshmen() {
        return doshmen;
    }

    public void setDoshmen(LinkedList<Doshman> doshmen) {
        this.doshmen = doshmen;
    }

//    public DoshmanControllerData getData(){
//        DoshmanControllerData doshmanControllerData = new DoshmanControllerData(doshmen);
//        return doshmanControllerData;
//    }

    public void setDoshmanSetBehavior(boolean doshmanSetBehavior) {
        this.doshmanSetBehavior = doshmanSetBehavior;
    }

    public void setDoshmanSet(CircularDoshmanSet doshmanSet) {
        this.doshmanSet = doshmanSet;
    }

    public DoshmanControllerData getDoshmanControllerData(){
        DoshmanControllerData doshmanControllerData = new DoshmanControllerData();
        for(int i = 0 ; i< doshmen.size() ; i++){
            DoshmanData doshmanData = doshmen.get(i).getDoshmanData();
            doshmanControllerData.addDoshmanData(doshmanData);
        }
        return doshmanControllerData;
    }
}
