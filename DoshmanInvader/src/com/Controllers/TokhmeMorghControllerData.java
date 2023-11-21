package com.Controllers;

import com.Game;
import com.TokhmeMorghData;

import java.io.Serializable;
import java.util.LinkedList;

public class TokhmeMorghControllerData implements Serializable {
    private LinkedList<TokhmeMorghData> tokhmeMorghsData = new LinkedList<>();

    public void addTokhmeMorghData(TokhmeMorghData data){
        tokhmeMorghsData.add(data);
    }

    public TokhmeMorghController getTokhmeMorghController(Game game){
        TokhmeMorghController tokhmeMorghController = new TokhmeMorghController(game);
        for(int i = 0 ; i< tokhmeMorghsData.size() ; i++){
            tokhmeMorghController.addTokhmeMorgh(tokhmeMorghsData.get(i).getTokhmeMorgh(game));
        }
        return tokhmeMorghController;

    }
}
