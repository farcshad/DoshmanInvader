package com;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.Serializable;

public class Keyer extends KeyAdapter implements Serializable {
    Game game;

    public Keyer(Game game){
        this.game = game;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        game.keyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e){
        game.keyReleased(e);
    }

}

