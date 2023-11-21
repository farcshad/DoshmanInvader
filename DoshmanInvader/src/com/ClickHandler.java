package com;

import com.Controllers.BulletController;
import com.gameProject.stats.GameMode;
import com.gameProject.stats.MultiplayerMode;

import java.awt.event.MouseEvent;
import java.io.Serializable;
import java.util.ArrayList;

public class ClickHandler implements Serializable {


    Game game;

    public ClickHandler(Game game){
        this.game = game;
    }

    public boolean mouseInRect(MouseEvent e , int x, int y, int width , int height){
        boolean ret = false;
        if(e.getX()>x && e.getX()<x+width && e.getY()>y && e.getY()<y+height)
            ret = true;
        return ret;
    }

    public void inGameClickHandler(MouseEvent e){
        if(e.getButton()==MouseEvent.BUTTON3 && game.player.getRemainingAtomicBombs()>0){
            game.player.setRemainingAtomicBombs(game.player.getRemainingAtomicBombs()-1);
            game.bulletController.addAtomicBullet(new AtomicBullet(game.player));
        }
        if(e.getButton()==MouseEvent.BUTTON1){
            if(game.player.canshoot()){
                game.player.setShooting(true);
            }
        }
    }

    public void inGameSelectMenuClickHandler(MouseEvent e){
        if(mouseInRect(e,570,250,150,80)&& game.player!=null&&game.bulletController !=null){
            game.setInGameSelectMenu(false);
            game.setInGame(true);
            game.setCursorVisible(false);
        }
        if(mouseInRect(e,570,350,150,80)){
//            game.player = new Player(game,game.getWidth()/2,game.getHeight()-50);
//            game.bulletController = new BulletController(game);
            game.newGame();
            game.setInGameSelectMenu(false);
            game.setInGame(true);
            game.setCursorVisible(false);
        }
        if(mouseInRect(e,570,450,150,80)){
            game.setInGameSelectMenu(false);
            game.setInMainMenu(true);
        }
    }

    public void inMainMenuClickHandler(MouseEvent e){
        if(mouseInRect(e,570,250,150,80)){
            game.setInMainMenu(false);
            game.setInGameSelectMenu(true);
        }
        if(mouseInRect(e,570,550,150,80)){
            game.setInMainMenu(false);
            game.setInGame(false);
            System.exit(1);
        }
        if(mouseInRect(e,570,450,150,80)){
            game.setInMainMenu(false);
            game.setInMultiPlayerMenu(true);
        }
        if(mouseInRect(e,570,350,150,80)){
            game.setInMainMenu(false);
            game.setInSettingMenu(true);
        }
    }

    public void inPauseMenuClickHandler(MouseEvent e){
        if(mouseInRect(e,game.getWidth()-180,game.getHeight()-110,150,80)){
            System.exit(1);
        }
        if(mouseInRect(e,game.getWidth()-380,game.getHeight()-110,150,80)){
            game.setInPauseMenu(false);
            game.setInAdditionalContentsMenuBackground(true);
            game.setNewClassVisible(true);

        }
        else if(mouseInRect(e,570,250,150,80)){
            game.setInPauseMenu(false);
            game.setInGame(true);
            game.setCursorVisible(false);
        }
        else if(mouseInRect(e,570,350,150,80)){
            game.setInPauseMenu(false);
            game.setInMainMenu(true);
        }
    }

    public void inSettingMenuClickHandler(MouseEvent e){
        if(mouseInRect(e,game.getWidth()-180,game.getHeight()-110,150,80)){
            game.setInSettingMenu(false);
            System.exit(1);
        }
        if(mouseInRect(e,570,250,150,80)){
            game.setInSettingMenu(false);
            game.setInMainMenu(true);
        }
        if(mouseInRect(e,570,350,150,80)){
            game.setInSettingMenu(false);
            game.setInUserSelectMenu(true);
            game.setNewUsernameVisible(true);
        }
        if(mouseInRect(e,570,450,150,80) && game.player!=null){
            game.setInSettingMenu(false);
            game.setInSelectFighterMenu(true);
        }
        if(mouseInRect(e,game.getWidth()-90,game.getHeight()-200,60,60)){
            game.setMouseControl();
        }
        if(mouseInRect(e,game.getWidth()-90,game.getHeight()-280,60,60)){
            game.setKeyboardControl();
        }
    }
    public void inMultiPlayerMenuClickHandler(MouseEvent e){
        if(mouseInRect(e,game.getWidth()-180,game.getHeight()-110,150,80)){
            System.exit(1);
        }
        if(mouseInRect(e,570,250,150,80)){
            game.setInSettingMenu(false);
            game.setInMainMenu(true);
        }
        if(mouseInRect(e,570,350,150,80)){
//            HOST
            game.setGameMode(GameMode.MULTIPLAYER);
            game.setMultiplayerMode(MultiplayerMode.SERVER);
            game.setServer(new Server(game,"127.0.0.1",9090));
            game.setInMultiPlayerMenu(false);
//            game.setInLobby(true);
            game.newGame();
            game.setInGame(true);
            game.setCursorVisible(false);
            game.serverStart();

        }
        if(mouseInRect(e,570,450,150,80) ){
            game.setGameMode(GameMode.MULTIPLAYER);
            game.setMultiplayerMode(MultiplayerMode.CLIENT);
            game.setClient(new Client(game,"127.0.0.1",9090));
            game.setInMultiPlayerMenu(false);
//            game.setInLobby(true);
            game.newGame();
            game.setInGame(true);
            game.clientStart();
        }
    }

    public void  inLobbyClickHandler(MouseEvent e){


    }

    public void inAdditionalContentsClickHandler(MouseEvent e){
        if(mouseInRect(e,game.getWidth()-180,game.getHeight()-110,150,80)){
            game.setInAdditionalContentsMenuBackground(false);
            game.setInPauseMenu(true);
            game.setNewClassVisible(false);
        }
        if(mouseInRect(e,200,270,150,80)){
            game.addClass();
        }
    }
    public void inSelectFighterMenuClickHandler(MouseEvent e){
        if(mouseInRect(e,420,350,80,100)){
            game.player.setPlayerImage(1);
            game.setInSelectFighterMenu(false);
            game.setInSettingMenu(true);
        }
        if(mouseInRect(e,520,350,80,100)){
            game.player.setPlayerImage(2);
            game.setInSelectFighterMenu(false);
            game.setInSettingMenu(true);
        }
        if(mouseInRect(e,620,350,80,100)){
            game.player.setPlayerImage(3);
            game.setInSelectFighterMenu(false);
            game.setInSettingMenu(true);
        }
        if(mouseInRect(e,720,350,80,100)){
            game.player.setPlayerImage(4);
            game.setInSelectFighterMenu(false);
            game.setInSettingMenu(true);
        }
    }

    public void inUserSelectMenuClickHandler(MouseEvent e){
        if(mouseInRect(e,game.getWidth()-180,game.getHeight()-110,150,80)){
            game.setInUserSelectMenu(false);
            game.setInMainMenu(true);
            game.setNewUsernameVisible(false);
            game.save();
        }
        if(mouseInRect(e,200,270,150,80)){
            game.addUser();
        }
        if(mouseInRect(e,200,370,150,80)){
            game.setUsers(new ArrayList<>());
        }
        for(int i = 0 ; i<game.getUsers().size() ; i++){
            if(mouseInRect(e,700,160+40*i,250,40)){
                game.setUser(game.getUsers().get(i));
                game.setInUserSelectMenu(false);
                game.setInSettingMenu(true);
                game.setNewUsernameVisible(false);
                game.save();
                game.setUser(game.getUsers().get(i));
                game.setPlayer(game.getUser().getPlayer(game));
                game.setBulletController(new BulletController(game));
            }
        }
    }
}
