package com.Controllers;

import com.Game;
import com.GiftData;

import java.io.Serializable;
import java.util.LinkedList;

public class GiftControllerData implements Serializable {

    private LinkedList<GiftData> giftsData = new LinkedList<>();

    public void addGiftData(GiftData data){
        giftsData.add(data);
    }

    public GiftController getGiftController(Game game){
        GiftController giftController = new GiftController(game);
        for(int i = 0 ; i< giftsData.size() ; i++){
            giftController.addGift(giftsData.get(i).getGift(game));
        }
        return giftController;

    }
}
