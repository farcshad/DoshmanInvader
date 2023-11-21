package com;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

public class ImageDrawer {

    private static Game game;

    private static BufferedImage backGroundImage;
    private static BufferedImage backGroundImage2;
    private static BufferedImage backGroundImage3;
    private static BufferedImage boom;
    private static BufferedImage atomicBulletImage ;

    private static int i = 0;


//    GAME STUFF

    //    Main Menu Stuff
    private static BufferedImage mainMenuBackground ;
    private static BufferedImage mainMenuStartButton ;
    private static BufferedImage mainMenuSettingButton ;
    private static BufferedImage mainMenuExitButton ;
    private static BufferedImage mainMenuMultiplayerButton ;

    //    Game Select Menu Stuff
    private static BufferedImage selectGameMenuContinueButton ;
    private static BufferedImage selectGameMenuNewGameButton ;


    //    Pause Menu Stuff
    private static BufferedImage pauseMenuResumeButton ;
    private static BufferedImage pauseMenuMainMenuButton ;


    //    Setting Menu Stuff
    private static BufferedImage settingMenuBackground ;
    private static BufferedImage settingMenuMainMenuButton ;
    private static BufferedImage settingMenuSelectFighterButton ;
    private static BufferedImage settingMenuUsersButton ;
    private static BufferedImage mouse1 ;
    private static BufferedImage mouse2 ;
    private static BufferedImage keyboard1 ;
    private static BufferedImage keyboard2 ;

    //    MultiPlayer Menu Stuff
    private static BufferedImage multiPlayerMenuBackGround ;
    private static BufferedImage multiPlayerMenuJoinButton ;
    private static BufferedImage multiPlayerMenuHostButton ;


    //    Player Stuff
    private static BufferedImage playerImage1;
    private static BufferedImage playerImage2;
    private static BufferedImage playerImage3;
    private static BufferedImage playerImage4;
    private static BufferedImage atomicBullet ;
    private static BufferedImage statBarImage ;
    private static BufferedImage statBarImage2 ;
    private static BufferedImage playerImage;


    //    Select Fighter Menu Stuff
    private static BufferedImage selectFighterMenuBackground;
    private static BufferedImage selectFighter1;
    private static BufferedImage selectFighter2;
    private static BufferedImage selectFighter3;
    private static BufferedImage selectFighter4;
    private static BufferedImage selectFighterPanel;

    //    user Select Menu Stuff
    private static BufferedImage userSelectMenuBackground ;
    private static BufferedImage userSelectMenuMainMenuButton ;
    private static BufferedImage userSelectMenuNewUserButton ;
    private static BufferedImage userSelectMenuDeleteUsersButton ;


    //    Doshmans Stuff
    private static BufferedImage doshamanLVL1;
    private static BufferedImage doshamanLVL2;
    private static BufferedImage doshamanLVL3;
    private static BufferedImage doshamanLVL4;

//    Gifts Stuff
    private static BufferedImage bulletLvl1Gift;
    private static BufferedImage bulletLvl2Gift;
    private static BufferedImage bulletLvl3Gift;

//    AdditionalMenu Stuff
    private static BufferedImage additionalContentMenuBackground;


    public ImageDrawer(Game game){
        this.game = game;
        try{
            getImages();
        }catch (Exception e){
        }
    }

    public void getImages(){
        try{
            additionalContentMenuBackground = ImageIO.read(new File("D:\\intellij19Projects\\DoshmanInvaderVII\\res\\additionalContentsMenu\\menuBackground.png"));
            atomicBulletImage = ImageIO.read(new File("D:\\GameProject\\res\\game\\atomicBullet.png"));
            backGroundImage = ImageIO.read(new File("D:\\GameProject\\res\\game\\background3.png"));
            mainMenuBackground = ImageIO.read(new File("D:\\GameProject\\res\\mainMenu\\menuBackground.jpg"));
            mainMenuStartButton = ImageIO.read(new File("D:\\GameProject\\res\\mainMenu\\startButton.png"));
            mainMenuSettingButton = ImageIO.read(new File("D:\\GameProject\\res\\mainMenu\\settingButton.png"));
            mainMenuMultiplayerButton = ImageIO.read(new File("D:\\GameProject\\res\\mainMenu\\multiPlayerButton.png"));
            mainMenuExitButton = ImageIO.read(new File("D:\\GameProject\\res\\mainMenu\\exitButton.png"));
            selectGameMenuContinueButton = ImageIO.read(new File("D:\\GameProject\\res\\gameSelectMenu\\gameSelectMenuContinueButton.png"));
            selectGameMenuNewGameButton = ImageIO.read(new File("D:\\GameProject\\res\\gameSelectMenu\\gameSelectMenuNewGameButton.png"));
            pauseMenuResumeButton = ImageIO.read(new File("D:\\GameProject\\res\\pauseMenu\\resumeButton.png"));
            pauseMenuMainMenuButton = ImageIO.read(new File("D:\\GameProject\\res\\pauseMenu\\mainMenuButton.png"));
            settingMenuBackground = ImageIO.read(new File("D:\\GameProject\\res\\settingMenu\\settingMenuBackground.jpg"));
            settingMenuMainMenuButton = ImageIO.read(new File("D:\\GameProject\\res\\settingMenu\\settingMenuMainMenuButton.png"));
            settingMenuSelectFighterButton = ImageIO.read(new File("D:\\GameProject\\res\\settingMenu\\settingMenuSelectFighterButton.png"));
            settingMenuUsersButton = ImageIO.read(new File("D:\\GameProject\\res\\settingMenu\\settingMenuUsersButton.png"));
            mouse1 = ImageIO.read(new File("D:\\GameProject\\res\\settingMenu\\mouse1.png"));
            mouse2 = ImageIO.read(new File("D:\\GameProject\\res\\settingMenu\\mouse2.png"));
            keyboard1 = ImageIO.read(new File("D:\\GameProject\\res\\settingMenu\\keyboard1.png"));
            keyboard2 = ImageIO.read(new File("D:\\GameProject\\res\\settingMenu\\keyboard2.png"));
            selectFighterMenuBackground = ImageIO.read(new File("D:\\GameProject\\res\\selectFighterMenu\\selectFighteMenuBackground.jpg"));
            selectFighter1 = ImageIO.read(new File("D:\\GameProject\\res\\game\\xwing.png"));
            selectFighter2 = ImageIO.read(new File("D:\\GameProject\\res\\game\\fighter 1.png"));
            selectFighter3 = ImageIO.read(new File("D:\\GameProject\\res\\game\\fighter 2.png"));
            selectFighter4 = ImageIO.read(new File("D:\\GameProject\\res\\game\\fighter 3.png"));
            selectFighterPanel = ImageIO.read(new File("D:\\GameProject\\res\\selectFighterMenu\\selectFighterPanel.png"));
            boom = ImageIO.read(new File("D:\\GameProject\\res\\game\\boom.png"));
            userSelectMenuBackground = ImageIO.read(new File("D:\\GameProject\\res\\userSelectMenu\\userSelectMenuBackground.jpg"));
            userSelectMenuMainMenuButton = ImageIO.read(new File("D:\\GameProject\\res\\userSelectMenu\\userSelectMenuMainMenuButton.png"));
            userSelectMenuNewUserButton = ImageIO.read(new File("D:\\GameProject\\res\\userSelectMenu\\userSelectMenuNewUserButton.png"));
            userSelectMenuDeleteUsersButton = ImageIO.read(new File("D:\\GameProject\\res\\userSelectMenu\\userSelectMenuDeleteUsersButton.png"));
            doshamanLVL1 = ImageIO.read(new File("D:\\GameProject\\res\\game\\doshman1.png"));
            doshamanLVL2 = ImageIO.read(new File("D:\\GameProject\\res\\game\\doshman2.png"));
            doshamanLVL3 = ImageIO.read(new File("D:\\GameProject\\res\\game\\doshman3.png"));
            doshamanLVL4 = ImageIO.read(new File("D:\\GameProject\\res\\game\\doshman4.png"));
            bulletLvl1Gift = ImageIO.read(new File("D:\\GameProject\\res\\gifts\\bulletLvl1Gift.png"));
            bulletLvl2Gift = ImageIO.read(new File("D:\\GameProject\\res\\gifts\\bulletLvl2Gift.png"));
            bulletLvl3Gift = ImageIO.read(new File("D:\\GameProject\\res\\gifts\\bulletLvl3Gift.png"));
            multiPlayerMenuBackGround = ImageIO.read(new File("D:\\GameProject\\res\\MultiPlayerMenu\\MultiPlayerMenuBackground.png"));
            multiPlayerMenuHostButton = ImageIO.read(new File("D:\\GameProject\\res\\MultiPlayerMenu\\MultiPlayerMenuHostButton.png"));
            multiPlayerMenuJoinButton = ImageIO.read(new File("D:\\GameProject\\res\\MultiPlayerMenu\\MultiPlayerMenuJoinButton.png"));
            playerImage1 = ImageIO.read(new File("D:\\GameProject\\res\\game\\xwing.png"));
            playerImage2 = ImageIO.read(new File("D:\\GameProject\\res\\game\\fighter 1.png"));
            playerImage3 = ImageIO.read(new File("D:\\GameProject\\res\\game\\fighter 2.png"));
            playerImage4 = ImageIO.read(new File("D:\\GameProject\\res\\game\\fighter 3.png"));
            atomicBullet = ImageIO.read(new File("D:\\GameProject\\res\\game\\atomicBullet.png"));
            statBarImage = ImageIO.read(new File("D:\\GameProject\\res\\game\\statBarImage.png"));
            statBarImage2 = ImageIO.read(new File("D:\\GameProject\\res\\game\\statBarImage2.png"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void backgroundRender(Graphics g){
        g.drawImage(backGroundImage,0,i,game.getWidth(),game.getHeight(),null);
        g.drawImage(backGroundImage,0,i-game.getHeight(),game.getWidth(),game.getHeight(),null);
        if(game.isInGame())
            i++;
        if(i == game.getHeight()){
            i=0;
        }
    }

    public static void gameSelectMenuRender(Graphics g){
        g.drawImage(mainMenuBackground,0,0,game.getWidth(),game.getHeight(),null);
        g.drawImage(selectGameMenuContinueButton,570,250,150,80,null);
        g.drawImage(selectGameMenuNewGameButton,570,350,150,80,null);
        g.drawImage(settingMenuMainMenuButton,570,450,150,80,null);
    }

    public static void mainMenuRender(Graphics g){
        g.drawImage(mainMenuBackground,0,0,game.getWidth(),game.getHeight(),null);
        g.drawImage(mainMenuStartButton,570,250,150,80,null);
        g.drawImage(mainMenuSettingButton,570,350,150,80,null);
        g.drawImage(mainMenuMultiplayerButton,570,450,150,80,null);
        g.drawImage(mainMenuExitButton,570,550,150,80,null);

    }

    public static void pauseMenuRender(Graphics g){
        g.drawImage(pauseMenuResumeButton,570,250,150,80,null);
        g.drawImage(pauseMenuMainMenuButton,570,350,150,80,null);
        g.drawImage(mainMenuExitButton,game.getWidth()-180,game.getHeight()-110,150,80,null);
        g.drawImage(pauseMenuMainMenuButton,game.getWidth()-380,game.getHeight()-110,150,80,null);

    }

    public static void settingMenuRender(Graphics g){
        g.drawImage(settingMenuBackground,0,0,game.getWidth(),game.getHeight(),null);
        g.drawImage(mainMenuExitButton,game.getWidth()-180,game.getHeight()-110,150,80,null);
        g.drawImage(settingMenuMainMenuButton,570,250,150,80,null);
        g.drawImage(settingMenuUsersButton,570,350,150,80,null);
        g.drawImage(settingMenuSelectFighterButton,570,450,150,80,null);

        if(game.isMouseControl() ){
            g.drawImage(mouse2,game.getWidth()-90,game.getHeight()-200,60,60,null);
            g.drawImage(keyboard1,game.getWidth()-90,game.getHeight()-280,60,60,null);
        }
        else if(game.isKeyboardControl()){
            g.drawImage(mouse1,game.getWidth()-90,game.getHeight()-200,60,60,null);
            g.drawImage(keyboard2,game.getWidth()-90,game.getHeight()-280,60,60,null);
        }


    }

    public static void multiPlayerMenuRender(Graphics g){
        g.drawImage(multiPlayerMenuBackGround,0,0,game.getWidth(),game.getHeight(),null);
        g.drawImage(mainMenuExitButton,game.getWidth()-180,game.getHeight()-110,150,80,null);
        g.drawImage(settingMenuMainMenuButton,570,250,150,80,null);
        g.drawImage(multiPlayerMenuHostButton,570,350,150,80,null);
        g.drawImage(multiPlayerMenuJoinButton,570,450,150,80,null);
    }

    public static void selectFighterMenuRender(Graphics g){
        g.drawImage(selectFighterMenuBackground,0,0,game.getWidth(),game.getHeight(),null);
        g.drawImage(selectFighterPanel,400,330,440,140,null);
        g.drawImage(selectFighter1,420,350,80,100,null);
        g.drawImage(selectFighter2,520,350,80,100,null);
        g.drawImage(selectFighter3,620,350,80,100,null);
        g.drawImage(selectFighter4,720,350,80,100,null);
    }

    public static void userSelectMenuRender(Graphics g){
        g.drawImage(userSelectMenuBackground,0,0,game.getWidth(),game.getHeight(),null);
        g.drawImage(userSelectMenuMainMenuButton,game.getWidth()-180,game.getHeight()-110,150,80,null);
        g.drawImage(userSelectMenuNewUserButton,200,270,150,80,null);
        g.drawImage(userSelectMenuDeleteUsersButton,200,370,150,80,null);
    }

    public static void userStateRender(Graphics g,User user){
        if(user == null){
            g.setColor(new Color(187,187,182));
            g.setFont(new Font("ArcadeClassic",Font.PLAIN,20));
            g.drawString("Not Logged in",1020,710);
        }
        else{
            g.setColor(new Color(187,187,182));
            g.setFont(new Font("ArcadeClassic",Font.PLAIN,20));
            g.drawString( user.getUsername(),1080,710);
        }
    }

    public static void MultiplayerMenuRender(Graphics g){
        g.drawImage(userSelectMenuBackground,0,0,game.getWidth(),game.getHeight(),null);

    }

    public static void additionalContentsMenuRender(Graphics g){
        g.drawImage(additionalContentMenuBackground,0,0,game.getWidth(),game.getHeight(),null);
        g.drawImage(userSelectMenuNewUserButton,200,270,150,80,null);
        g.drawImage(userSelectMenuMainMenuButton,game.getWidth()-180,game.getHeight()-110,150,80,null);

    }





    public static void boomRender(Graphics g){
        g.drawImage(boom,360,80,560,560,null);
    }

    public static void atomicBulletRender(Graphics g , int x, int y){
        g.drawImage(atomicBulletImage,x,y,40,40,null);
    }
    public static void doshmanRender(Graphics g ,int level, int x , int y , int size){
        if(level == 1){
            g.drawImage(doshamanLVL1,x-size/2,y-size/2,size,size,null);
        }
        if(level == 2){
            g.drawImage(doshamanLVL2,x-size/2,y-size/2,size,size,null);
        }
        if(level == 3){
            g.drawImage(doshamanLVL3,x-size/2,y-size/2,size,size,null);
        }
        if(level == 4){
            g.drawImage(doshamanLVL4,x-size/2,y-size/2,size,size,null);
        }
    }

    public static void giftRender(Graphics g , int level,int x , int y , int size){
        if(level == 1){
            g.drawImage(bulletLvl1Gift,x-size/2,y-size/2,size,size,null);
        }
        if(level == 2){
            g.drawImage(bulletLvl2Gift,x-size/2,y-size/2,size,size,null);
        }

        if(level == 3) {
            g.drawImage(bulletLvl3Gift, x - size / 2, y - size / 2, size, size, null);
        }
    }
    public static void statRender(Graphics g){
        g.drawImage(statBarImage,10,game.getHeight()-50,300,40,null);
        g.drawImage(statBarImage2,game.getWidth()-60,40,40,300,null);
    }

    public static BufferedImage getPlayerImage(int i ){
        if(i == 1){
            return playerImage1;
        }
        if(i == 2){
            return playerImage2;
        }
        if(i == 3){
            return playerImage3;
        }
        if(i == 4){
            return playerImage4;
        }
        else return null;
    }
}
