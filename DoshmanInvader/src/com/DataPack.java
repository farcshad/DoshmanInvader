package com;

import com.Controllers.*;

import java.io.Serializable;

public class DataPack implements Serializable {

    BulletControllerData bulletControllerData ;
    DoshmanControllerData doshmanControllerData;
    GiftControllerData giftControllerData;
    PlayerData playerData;
    TokhmeMorghControllerData tokhmeMorghControllerData;
//    WaveController waveController;

//    public DataPack(BulletController bulletController, DoshmanController doshmanController, GiftController giftController, TokhmeMorghController tokhmeMorghController ,
//                    WaveController waveController) {
//        this.bulletController = bulletController;
//        this.doshmanController = doshmanController;
//        this.giftController = giftController;
//        this.tokhmeMorghController = tokhmeMorghController;
//        this.waveController = waveController;
//    }
    public DataPack(Player player, BulletController bulletController, DoshmanController doshmanController ,
                    GiftController giftController, TokhmeMorghController tokhmeMorghController){
        this.playerData = player.getData();
        this.doshmanControllerData = doshmanController.getDoshmanControllerData();
        this.giftControllerData = giftController.getGiftControllerData();
        this.bulletControllerData = bulletController.getBulletControllerData();
        this.tokhmeMorghControllerData = tokhmeMorghController.getTokhmeMorghControllerData();
    }
    public DoshmanController getDoshmanController(Game game) {
        return doshmanControllerData.getDoshmanController(game);
    }

    public Player getPlayer(Game game){
        return playerData.getPlayer(game);
    }

    public GiftController getGiftController(Game game){
        return giftControllerData.getGiftController(game);
    }

    public BulletController getBulletController(Game game) {
        return bulletControllerData.getBulletController(game);
    }
    public TokhmeMorghController getTokhmeMorghController(Game game) {
        return tokhmeMorghControllerData.getTokhmeMorghController(game);
    }
//
//    public WaveController getWaveController() {
//        return waveController;
//    }

}
