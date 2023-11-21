package com.Controllers;

import com.BulletData;
import com.Game;

import java.io.Serializable;
import java.util.LinkedList;

public class BulletControllerData implements Serializable {
    private LinkedList<BulletData> bulletsData = new LinkedList<>();

    public void addBulletData(BulletData data){
        bulletsData.add(data);
    }

    public BulletController getBulletController(Game game){
        BulletController bulletController = new BulletController(game);
        for(int i = 0 ; i< bulletsData.size() ; i++){
            bulletController.addBullet(bulletsData.get(i).getBullet());
        }
        return bulletController;

    }
}
