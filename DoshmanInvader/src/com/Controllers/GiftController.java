package com.Controllers;

import com.Game;
import com.Gift;
import com.GiftData;

import java.awt.*;
import java.io.Serializable;
import java.util.LinkedList;

public class GiftController implements Serializable {

    private LinkedList<Gift> gifts = new LinkedList<>();
    private Game game;

    public GiftController(Game game ){
        this.game = game;

    }

    public GiftControllerData getGiftControllerData(){

        GiftControllerData giftControllerData = new GiftControllerData();
        for(int i = 0 ; i<gifts.size() ; i++){
            GiftData giftData = gifts.get(i).getData();
            giftControllerData.addGiftData(giftData);
        }
        return giftControllerData;
    }

    public void render(Graphics g){
        for(int i = gifts.size()-1 ; i >=0 ; i--){
            gifts.get(i).render(g);
        }
    }

    public void tick(){
        for(int i = gifts.size()-1 ; i>= 0 ;i--){
            gifts.get(i).tick();
            if(game.getPlayer().getHittenByGift(gifts.get(i))){
                if(gifts.get(i).getLevel() == 4){
                    game.addPoint(100);
                }
                else{

                    game.setBulletLevel(gifts.get(i).getLevel());
                }
                removeGift(gifts.get(i));
            }
        }
    }

    public void addGift(Gift gift){
        gifts.add(gift);
    }
    public void removeGift(Gift gift){
        gifts.remove(gift);
    }

    public LinkedList<Gift> getGifts() {
        return gifts;
    }

    public void setGifts(LinkedList<Gift> gifts) {
        this.gifts = gifts;
    }
}
