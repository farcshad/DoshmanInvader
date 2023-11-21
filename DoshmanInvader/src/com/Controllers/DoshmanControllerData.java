package com.Controllers;

import com.Doshman;
import com.DoshmanData;
import com.Game;

import java.io.Serializable;
import java.util.LinkedList;

public class DoshmanControllerData implements Serializable {

    LinkedList<DoshmanData> doshmenData = new LinkedList<>();
    LinkedList<Doshman> doshmen ;


//    public DoshmanControllerData(LinkedList<Doshman> doshmen){
//        this.doshmen = doshmen;
//    }
//
//    public DoshmanController getDoshmanController(Game game){
//        return new DoshmanController(game,doshmen);
//    }
    public DoshmanControllerData(LinkedList<Doshman> doshmen){
        this.doshmen = doshmen;

    }

    public DoshmanControllerData(){

    }

    public void addDoshmanData(DoshmanData doshmanData){
        doshmenData.add(doshmanData);
    }

    public DoshmanController getDoshmanController(Game game ){
        LinkedList<Doshman> doshmen = new LinkedList<>();
        for(int i = 0 ; i< doshmenData.size() ; i++){
            doshmen.add(doshmenData.get(i).getDoshman(game));
        }
        DoshmanController doshmanController = new DoshmanController(game,doshmen);
        return doshmanController;
    }

}
