package com.Controllers;

import com.Game;
import com.TokhmeMorgh;
import com.TokhmeMorghData;

import java.awt.*;
import java.io.Serializable;
import java.util.LinkedList;

public class TokhmeMorghController implements Serializable {
    LinkedList<TokhmeMorgh> tokhmeMorghs = new LinkedList<>();

    Game game;

    public TokhmeMorghController(Game game){
        this.game = game;
    }

    public void tick(){

        for(int i = tokhmeMorghs.size()-1 ; i>=0 ; i--){
            tokhmeMorghs.get(i).tick();
            if(game.getPlayer().getHittenByTokhmeMorgh(tokhmeMorghs.get(i))){
                game.playerTakeDamage(50);
                removeTokhmeMorgh(tokhmeMorghs.get(i));
//
            }
            if(tokhmeMorghs.get(i).getY()>game.getHeight()){
                removeTokhmeMorgh(tokhmeMorghs.get(i));

            }
        }
    }
    public TokhmeMorghControllerData getTokhmeMorghControllerData(){

        TokhmeMorghControllerData tokhmeMorghControllerData = new TokhmeMorghControllerData();
        for(int i = 0 ; i<tokhmeMorghs.size() ; i++){
            TokhmeMorghData tokhmeMorghData = tokhmeMorghs.get(i).getData();
            tokhmeMorghControllerData.addTokhmeMorghData(tokhmeMorghData);
        }
        return tokhmeMorghControllerData;
    }

    public void render(Graphics g){
        for(int i = tokhmeMorghs.size()-1 ; i>=0 ; i--){
            tokhmeMorghs.get(i).render(g);
        }
    }

    public synchronized void addTokhmeMorgh(TokhmeMorgh d){
        tokhmeMorghs.add(d);
    }

    public synchronized void removeTokhmeMorgh(TokhmeMorgh d){
        tokhmeMorghs.remove(d);
    }

    public LinkedList<TokhmeMorgh> getTokhmemorghs() {
        return tokhmeMorghs;
    }

    public void setTokhmeMorghs(LinkedList<TokhmeMorgh> tokhmeMorghs) {
        this.tokhmeMorghs = tokhmeMorghs;
    }

//    private LinkedList<TokhmeMorgh> tokhmeMorghs ;
//    private Game game;
//
//    public TokhmeMorghController(Game game){
//        this.game = game;
//        tokhmeMorghs = new LinkedList<>();
//    }
//
//    public void addTokhmeMorgh(TokhmeMorgh tokhmeMorgh){
//        tokhmeMorghs.add(tokhmeMorgh);
//    }
//
//    public void removeTokhmeMorgh(TokhmeMorgh tokhmeMorgh){
//        tokhmeMorghs.remove(tokhmeMorgh);
//    }
//
//    public void render(Graphics g){
//        for(int i = tokhmeMorghs.size()-1; i>=0;i--){
//            if(tokhmeMorghs.get(i)!=null){
//                tokhmeMorghs.get(i).render(g);
//            }
//
//        }
//    }
//
//    public void tick(){
//        for(int i = tokhmeMorghs.size()-1; i>=0;i--){
//            tokhmeMorghs.get(i).tick();
//        }
//    }

}
