package com;

import com.gameProject.stats.DoshmanBehaviour;

import java.io.Serializable;
import java.util.LinkedList;

public class DoshmanGroup implements Serializable {

    private Game game;
    private int level;

    private int size;
    private int rowsNum;
    private int columnsNum;

    public DoshmanGroup(Game game,int level){
        this.game = game;
        this.level = level;
    }

    public LinkedList<Doshman> getDoshmen(int size,int level){
        LinkedList<Doshman> doshmen = new LinkedList<>();
        if(level == 1){
            size = 40;
            columnsNum = 10;
            rowsNum = 4;
            int y = 200;
            for(int row = 0 ; row<rowsNum ; row++){
                int x = 400;
                for (int column = 0 ; column < columnsNum ; column++){
                    Doshman doshman = new Doshman(game,level,x,y, DoshmanBehaviour.STANDARD);
                    doshman.setvX(1);
                    doshman.setvY(0);
                    doshmen.add(doshman);
                    x += 60;
                }
                y+=60;
            }
        }
        if (level == 2){
            size = 40;
            columnsNum = 10;
            rowsNum = 4;
            int y = 200;
            for(int row = 0 ; row<rowsNum ; row++){
                int x = 400;
                for (int column = 0 ; column < columnsNum ; column++){
                    Doshman doshman = new Doshman(game,level,x,y, DoshmanBehaviour.RANDOM);
                    doshman.setvX(1);
                    doshman.setvY(1);
                    doshmen.add(doshman);
                    x += 60;
                }
                y+=60;
            }
        }
        if(level ==3){
            Doshman doshman1 = new Doshman(game,4,200,200, DoshmanBehaviour.RANDOM);
            Doshman doshman2 = new Doshman(game,4,450,200, DoshmanBehaviour.RANDOM);
            Doshman doshman3 = new Doshman(game,4,700,200, DoshmanBehaviour.RANDOM);
            doshmen.add(doshman1);
            doshmen.add(doshman2);
            doshmen.add(doshman3);


        }
        return doshmen;
    }
}
