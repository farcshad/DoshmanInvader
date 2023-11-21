package com;

import java.io.Serializable;

public class TokhmeMorghData implements Serializable {
    private int x;
    private int y;

    private int vX;
    private int vY;

    private int size;

    public TokhmeMorghData(int x, int y, int vX, int vY, int size) {
        this.x = x;
        this.y = y;
        this.vX = vX;
        this.vY = vY;
        this.size = size;
    }

    public TokhmeMorgh getTokhmeMorgh(Game game){
        return new TokhmeMorgh(game,x,y,vX, vY,size);
    }
}
