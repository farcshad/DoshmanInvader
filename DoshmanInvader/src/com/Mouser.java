package com;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Serializable;

public class Mouser extends MouseAdapter implements Serializable {
    Game game;

    public Mouser(Game game){
        this.game = game;

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        game.mouseMoved(e);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        game.mousePressed(e);
    }

    @Override
    public void mouseReleased(MouseEvent e){
        game.mouseReleased(e);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        game.mouseDragged(e);

    }
}
