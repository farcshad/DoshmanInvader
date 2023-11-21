package com.Controllers;

import com.DoshmanGroup;
import com.Game;
import com.doshmanGroups.CircularDoshmanSet;
import com.doshmanGroups.ClockwiseDoshmanSet;
import com.doshmanGroups.DoubleCircularDoshmanSet;
import com.doshmanGroups.RegularDoshmanSet;

import java.awt.*;
import java.io.Serializable;

public class WaveController implements Serializable {

    private Game game;
//    private Player player;
    private int wave;
    private long waveChangeTimer;

    public WaveController(Game game){
        this.game = game;
//        player = game.getPlayer();
//        player.setWave(0);
//        wave = player.getWave();
        wave = 0;
    }

    public void render(Graphics g){
        if(System.currentTimeMillis()-waveChangeTimer<2000){
            g.setColor(new Color(100,250,10));
            g.setFont(new Font("ArcadeClassic",Font.PLAIN,50));
            g.drawString("Wave "+wave,200,200);
        }
        if(wave == 9){
            g.drawString("you won "+wave,200,200);
        }
    }

    public void tick(){

    }

    public void increaseWave(){
        if(System.currentTimeMillis()-waveChangeTimer>2000 || wave ==0){
            wave++;
            if(wave == 1){
                spawnWave1Doshmen();
            }
            if(wave == 2){
                spawnWave2Doshmen();
            }
            if(wave == 3){
                spawnWave3Doshmen();
            }
            if(wave == 4){
                spawnWave4Doshmen();
            }
            if(wave == 5){
                spawnWave5Doshmen();
            }
            if(wave == 6){
                spawnWave6Doshmen();
            }
            if(wave == 7){
                spawnWave7Doshmen();
            }
            if(wave == 8){
                spawnWave8Doshmen();
            }
            if(wave == 9){
                game.setInMainMenu(true);
                game.setInGame(false);
            }
            waveChangeTimer = System.currentTimeMillis();
        }

    }

    public void spawnWave1Doshmen(){
        DoshmanGroup doshmanGroup = new DoshmanGroup(game,1);
        game.setDoshmen(doshmanGroup.getDoshmen(40,1));
//        game.setDoshmanSet(new CircularDoshmanSet(game,6,100));
//        ClockwiseDoshmanSet set = new ClockwiseDoshmanSet();
//        set.addDoshmenToGame(game,5,2);
//        DoubleCircularDoshmanSet  set = new DoubleCircularDoshmanSet();
//        set.addDoshmenToGame(game,12,1);

    }

    public void spawnWave2Doshmen(){
        DoshmanGroup doshmanGroup = new DoshmanGroup(game,1);
        game.setDoshmen(doshmanGroup.getDoshmen(40,2));
    }

    public void spawnWave3Doshmen(){
        DoshmanGroup doshmanGroup = new DoshmanGroup(game,1);
        game.setDoshmen(doshmanGroup.getDoshmen(3,3));
    }

    public void spawnWave4Doshmen(){
//        DoshmanGroup doshmanGroup = new DoshmanGroup(game,1);
//        game.setDoshmanSet(new CircularDoshmanSet(game,6,100));
        RegularDoshmanSet regularDoshmanSet = new RegularDoshmanSet();
        regularDoshmanSet.addDoshmenToGame(game,50,2);

    }
    public void spawnWave5Doshmen(){
//        DoshmanGroup doshmanGroup = new DoshmanGroup(game,1);
//        game.setDoshmen(doshmanGroup.getDoshmen(80,1));
        DoubleCircularDoshmanSet  set = new DoubleCircularDoshmanSet();
        set.addDoshmenToGame(game,12,1);
    }
    public void spawnWave6Doshmen(){
        RegularDoshmanSet regularDoshmanSet = new RegularDoshmanSet();
        regularDoshmanSet.addDoshmenToGame(game,30,3);
    }
    public void spawnWave7Doshmen(){
        DoubleCircularDoshmanSet  set = new DoubleCircularDoshmanSet();
        set.addDoshmenToGame(game,12,2);
    }
    public void spawnWave8Doshmen(){
        DoshmanGroup doshmanGroup = new DoshmanGroup(game,1);
        game.setDoshmen(doshmanGroup.getDoshmen(40,1));
    }






}
