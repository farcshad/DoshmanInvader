package com;

import com.Controllers.*;
import com.classLoading.DIClassLoader;
import com.doshmanGroups.CircularDoshmanSet;
import com.doshmanGroups.DoshmanSet;
import com.gameProject.stats.GameMode;
import com.gameProject.stats.MultiplayerMode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.LinkedList;

public class Game extends JPanel implements Runnable , Serializable {

    private static final int WIDTH = 640;
    private static final int HEIGHT = 360;
    private static final int SCALE = 2;

    boolean running = false;
    private Thread thread;

    private boolean inGame = false;
    private boolean inMainMenu = false;
    private boolean inPauseMenu = false;
    private boolean inSettingMenu = false;
    private boolean inSelectFighterMenu = false;
    private boolean inGameSelectMenu = false;
    private boolean inUserSelectMenu = false;
    private boolean inMultiPlayerMenu = false;
    private boolean inLobby = false;
    private boolean inAdditionalContentsMenuBackground;
    private boolean inLeaderboardMenu;

    private GameMode gameMode = GameMode.SINGLEPLAYER;
    private MultiplayerMode multiplayerMode = null;

    final private String IP = "127.0.0.1";
    private int port = 9090;

    private Server server;
    private Client client;

//    private ImageDrawer imageDrawer;
    private ClickHandler clickHandler;

    private JTextField newUsername;
    private JTextField newClass;

    Player player;
    Player inputPlayer;
    BulletController bulletController;
    DoshmanController doshmanController;
    TokhmeMorghController tokhmeMorghController;
    private WaveController waveController;
    private GiftController giftController;
    private LoadedClassesController loadedClassesController;
    private Gsoner gsoner;
    private User user;
    private int userNumber;
    private ArrayList<User> users ;

    private BufferedImage cursorImage = new BufferedImage(16,16,BufferedImage.TYPE_INT_ARGB);

    private boolean mouseControl = true;
    private boolean keyboardControl = false;
    private boolean cheat = false;

    public static void main(String[] args){
        JFrame gameFrame = new JFrame("Game");
        gameFrame.setPreferredSize(new Dimension(WIDTH * SCALE , HEIGHT * SCALE));
        gameFrame.setMaximumSize(new Dimension(WIDTH * SCALE , HEIGHT * SCALE));
        gameFrame.setMinimumSize(new Dimension(WIDTH * SCALE , HEIGHT * SCALE));
        gameFrame.setUndecorated(true);
        gameFrame.setVisible(true);
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Game game = new Game();
        game.setFocusable(true);
        gameFrame.addMouseMotionListener(new Mouser(game));
        gameFrame.add(game);
        gameFrame.pack();
        gameFrame.addKeyListener(new Keyer(game));
        game.addMouseMotionListener(new Mouser(game));
        game.addKeyListener(new Keyer(game));
        game.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
        game.start();
        System.out.println(game.getHeight()+" "+ game.getWidth());

    }

    private synchronized void start(){
        if(running)
            return;
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    private synchronized void stop(){
        if(!running)
            return;
        running = false;
        try {
            thread.join();
        }catch (Exception e){
            e.printStackTrace();
        }
        System.exit(1);
    }

    private void init(){
        gsoner = new Gsoner();
        users = gsoner.load();
        newUsername = new JTextField("Username");
        newUsername.setBackground(new Color(100,100,100));
        newUsername.setBounds(200,200,200,50);
        newUsername.setVisible(false);
        newClass = new JTextField("TYPE HERE");
        newClass.setBackground(new Color(100,100,100));
        newClass.setBounds(200,220,200,40);
        newClass.setVisible(false);
        add(newUsername);
        add(newClass);
        inMainMenu = true;
        ImageDrawer imageDrawer = new ImageDrawer(this);
        clickHandler = new ClickHandler(this);
        player = null;
        bulletController = null;
        loadedClassesController = new LoadedClassesController();
        if(user != null){
            player = user.getPlayer(this);
//            bulletController = new BulletController(this);
            newGame();
        }
//        doshmanController = new DoshmanController(this);
//        tokhmeMorghController = new TokhmeMorghController(this);
//        giftController = new GiftController(this);
//
//
////        DoshmanGroup doshmanGroup = new DoshmanGroup(this,1);
////        doshmanController.setDoshmen(doshmanGroup.getDoshmen(0,1));
//        waveController = new WaveController(this);
//        waveController.increaseWave();
        addKeyListener(new Keyer(this));
        addMouseListener(new Mouser(this));

    }

    @Override
    public void run() {
        init();
        long lastTime = System.nanoTime();
        final double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0 ;
        int updates = 0 ;
        int frames = 0 ;
        long timer = System.currentTimeMillis();
        try{
            while(running){
                long now = System.nanoTime();
                delta += (now - lastTime) / ns;
                lastTime = now;
                if(delta >= 1){
                    tick();
                    updates++;
                    delta --;
                }
                    render();
                frames++;
                if(System.currentTimeMillis() - timer > 1000){
                    timer += 1000;
                    System.out.println(updates + "ticks, Fps " +frames);
                    updates = 0;
                    frames = 0;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        stop();
    }

    public void render() {
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        try{
            if(inGame){
                gameRender(g);
            }
            else if(inGameSelectMenu){
                ImageDrawer.gameSelectMenuRender(g);
            }
            else if(inMainMenu){
                ImageDrawer.mainMenuRender(g);
                ImageDrawer.userStateRender(g,user);
            }
            else if(inPauseMenu){
                pauseMenuRender(g);
            }
            else if(inSettingMenu){
                ImageDrawer.settingMenuRender(g);
            }
            else if(inSelectFighterMenu){
                ImageDrawer.selectFighterMenuRender(g);
            }
            else if(inUserSelectMenu){
                ImageDrawer.userSelectMenuRender(g);
                g.setColor(new Color(187,187,182));
                g.setFont(new Font("ArcadeClassic",Font.PLAIN,40));
                for(int i = 0 ; i<users.size() ; i++){
                    g.drawString(users.get(i).getUsername() + "  "+users.get(i).getXpGained() ,700,200+40*i);
                }
            }
            else if(inLeaderboardMenu){
                ImageDrawer.userSelectMenuRender(g);
                g.setColor(new Color(187,187,181));
                g.setFont(new Font("ArcadeClassic",Font.PLAIN,40));
                for(int i = 0 ; i<users.size() ; i++){
                    g.drawString(users.get(i).getUsername()+" "+users.get(i).getXpGained(),600,200+40*i);
                }
            }
            else if(inMultiPlayerMenu){
                ImageDrawer.multiPlayerMenuRender(g);
            }
            else if(inAdditionalContentsMenuBackground){
                ImageDrawer.additionalContentsMenuRender(g);
                g.setColor(new Color(187,187,182));
                g.setFont(new Font("ArcadeClassic",Font.PLAIN,30));
                for(int i = 0 ; i<loadedClassesController.getClasses().size() ; i++){
                    g.drawString(loadedClassesController.getClasses().get(i).getName(),550,300+40*i);
                }
            }
        }catch (Exception exc){
        }
    }

    public void gameRender(Graphics g){
        ImageDrawer.backgroundRender(g);
        tokhmeMorghController.render(g);
        doshmanController.render(g);
        bulletController.render(g);
        giftController.render(g);
        if(inputPlayer != null){
            inputPlayer.render(g);
        }
        player.render(g);
        player.renderStats(g);
        waveController.render(g);
    }

    public void pauseMenuRender(Graphics g){
        ImageDrawer.backgroundRender(g);
        player.render(g);
        bulletController.render(g);
        doshmanController.render(g);
        tokhmeMorghController.render(g);
        giftController.render(g);
        player.renderStats(g);
        ImageDrawer.pauseMenuRender(g);
    }

    public void tick(){
        if(inGame){
            try{
                if(gameMode == GameMode.SINGLEPLAYER){
                    update();
                }





                if(gameMode == GameMode.MULTIPLAYER){
                    if(multiplayerMode == MultiplayerMode.SERVER){
//                        ServerSocket serverSocket = new ServerSocket(port);
//                        Socket socket = serverSocket.accept();
//                        ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
//                        DataPack dataPack = createDataPack();
//                        objectOutputStream.writeObject(dataPack);
                        update();
                    }
                    if(multiplayerMode == MultiplayerMode.CLIENT){

                    }
                }

            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public void update(){
        bulletController.tick();
        doshmanController.tick();
        player.tick();
        tokhmeMorghController.tick();
        giftController.tick();
    }

    public void mouseMoved(MouseEvent e) {
        if(inGame && isMouseControl()){
            player.setX(e.getX());
            player.setY(e.getY());
        }
    }

    public void mousePressed(MouseEvent e){
        try{
            if(inGame){
                clickHandler.inGameClickHandler(e);
            }

            else if(inGameSelectMenu){
                clickHandler.inGameSelectMenuClickHandler(e);
            }

            else if(inMainMenu){
                clickHandler.inMainMenuClickHandler(e);
            }

            else if(inPauseMenu){
                clickHandler.inPauseMenuClickHandler(e);
            }

            else if(inSettingMenu){
                clickHandler.inSettingMenuClickHandler(e);
            }

            else if(inSelectFighterMenu){
                clickHandler.inSelectFighterMenuClickHandler(e);
            }
            else if(inUserSelectMenu){
                clickHandler.inUserSelectMenuClickHandler(e);
            }
            else if(inMultiPlayerMenu){
                clickHandler.inMultiPlayerMenuClickHandler(e);
            }
            else if(inAdditionalContentsMenuBackground){
                clickHandler.inAdditionalContentsClickHandler(e);
            }

        }catch (Exception exc){
        }
    }

    public void mouseReleased(MouseEvent e){
        try{
            if(inGame){
                player.setShooting(false);
            }
        }catch (Exception exc){
        }
    }

    public void mouseDragged(MouseEvent e){
        if(inGame && isMouseControl()){
            player.setX(e.getX());
            player.setY(e.getY());
        }
    }

    public void keyPressed(KeyEvent e){
        if(inGame){
            int key = e.getKeyCode() ;
            if(key == KeyEvent.VK_ESCAPE){
                inGame = false;
                inPauseMenu = true;
                setCursorVisible(true);
                if(user != null){
                    user.syncUser(player);
                    gsoner.save(users);
                }
            }
            if(key == KeyEvent.VK_ESCAPE && cheat){
                inGame = false;
                inPauseMenu = true;
                setCursorVisible(true);
                if(user != null){
                    user.syncUser(player);
                    gsoner.save(users);
                }
            }
            if(key == KeyEvent.VK_ENTER){
                inGame = false;
                inPauseMenu = true;
                setCursorVisible(true);
                if(user != null){
                    user.syncUser(player);
                    gsoner.save(users);
                }
            }
            if(key == KeyEvent.VK_SPACE ){
//                player.shootBullet();
                player.setShooting(true);
            }
            if(key == KeyEvent.VK_UP)
                player.setvY(-5);
            else if(key == KeyEvent.VK_DOWN)
                player.setvY(5);
            else if(key == KeyEvent.VK_LEFT)
                player.setvX(-5);
            else if(key == KeyEvent.VK_RIGHT)
                player.setvX(5);
            if(key == KeyEvent.VK_SHIFT)
                cheat = true;
            if(cheat && key==KeyEvent.VK_I)
                player.setBulletLevel(1);
            else if(cheat && key==KeyEvent.VK_O)
                player.setBulletLevel(2);
            else if(cheat && key==KeyEvent.VK_P)
                player.setBulletLevel(3);
            if (cheat && key == KeyEvent.VK_U)
                player.setRemainingAtomicBombs(player.getRemainingAtomicBombs()+3);

        }
        else if(inPauseMenu){
            if(e.getKeyCode()== KeyEvent.VK_ESCAPE){
                inPauseMenu = false;
                inGame =true;
                setCursorVisible(false);

            }
        }
    }

    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_SPACE){
            player.setShooting(false);
        }
        if(key == KeyEvent.VK_UP)
            player.setvY(0);
        else if(key == KeyEvent.VK_DOWN)
            player.setvY(0);
        else if(key == KeyEvent.VK_LEFT)
            player.setvX(0);
        else if(key == KeyEvent.VK_RIGHT)
            player.setvX(0);
        if(key == KeyEvent.VK_SHIFT)
            cheat = false;
    }

    public void shootBullet(){
        bulletController.addBullet(new Bullet(player));
    }

//    Setters

    public void setInGame(boolean inGame) {
        this.inGame = inGame;
    }

    public void setInGameSelectMenu(boolean inGameSelectMenu) {
        this.inGameSelectMenu = inGameSelectMenu;
    }

    public void setInMainMenu(boolean inMainMenu) {
        this.inMainMenu = inMainMenu;
    }

    public void setInPauseMenu(boolean inPauseMenu) {
        this.inPauseMenu = inPauseMenu;
    }

    public void setInSelectFighterMenu(boolean inSelectFighterMenu) {
        this.inSelectFighterMenu = inSelectFighterMenu;
    }

    public void setInSettingMenu(boolean inSettingMenu) {
        this.inSettingMenu = inSettingMenu;
    }

    public void setInUserSelectMenu(boolean inUserSelectMenu) {
        this.inUserSelectMenu = inUserSelectMenu;
    }

    public void setInMultiPlayerMenu(boolean inMultiPlayerMenu){this.inMultiPlayerMenu = inMultiPlayerMenu;}

    public void setInLobby(boolean inLobby) {
        this.inLobby = inLobby;
    }

    public void setMouseControl(){
        this.keyboardControl = false;
        this.mouseControl = true;
    }

    public void setKeyboardControl() {
        this.mouseControl = false;
        this.keyboardControl = true;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setBulletController(BulletController bulletController) {
        this.bulletController = bulletController;
    }

    public void setUser(User a) {
        user = a;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public void setNewUsernameVisible(boolean b){
        newUsername.setVisible(b);
    }

    public void setNewClassVisible(boolean b) {
        newClass.setVisible(b);
    }

    public void setCursorVisible(boolean b){
        if(b){
            setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
        }
        if(!b){
            Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(new BufferedImage(16,16,BufferedImage.TYPE_INT_ARGB), new Point(0,0) , "blank cursor");
            setCursor(blankCursor);
        }
    }

//    Getters

//    public ImageDrawer getImageDrawer() {
//        return imageDrawer;
//    }

    public boolean isKeyboardControl() {
        return keyboardControl;
    }

    public boolean isMouseControl() {
        return mouseControl;
    }

    public boolean isInGame() {
        return inGame;
    }

    public User getUser() {
        return user;
    }

    public ArrayList<User> getUsers(){
        return users;
    }

    public void addUser(){
        users.add(new User(newUsername.getText()));
    }

    public void save(){
        gsoner.save(users);
    }

    public DoshmanController getDoshmanController() {
        return doshmanController;
    }
    public void removeDoshman(Doshman doshman){
        doshmanController.removeDoshman(doshman);
    }

    public void enemyKilled(){
        player.setEnemyKilled(player.getEnemyKilled()+1);
    }

    public Player getPlayer() {
        return player;
    }

    public void playerDie(){
        player.die();
    }

    public void playerTakeDamage(int damage){
        player.takeDamage(damage);
    }

    public void addTokhmemorgh(TokhmeMorgh tokhmeMorgh){
        tokhmeMorghController.addTokhmeMorgh(tokhmeMorgh);
    }

    public void setDoshmen(LinkedList<Doshman> doshmen){
        doshmanController.setDoshmanSetBehavior(false);
        doshmanController.setDoshmen(doshmen);
    }

    public void setDoshmanSet(CircularDoshmanSet doshmanSet){
        doshmanController.setDoshmanSetBehavior(true);
        doshmanController.setDoshmanSet(doshmanSet);
    }

    public void increaseWave(){
        waveController.increaseWave();
    }


    public void addGift(Gift gift){
        giftController.addGift(gift);
    }

    public void setBulletLevel(int level){
        player.setBulletLevel(level);
    }

    public DataPack createDataPack(){
        DataPack dataPack = new DataPack(player,bulletController,doshmanController,giftController,tokhmeMorghController);
        return dataPack;
    }

    public void removeAlldoshmen() {
        for(int i = 0 ; i<doshmanController.getDoshmen().size() ; i++){
            doshmanController.removeDoshman(doshmanController.getDoshmen().get(i));
        }
    }


    public void syncClientInputData(DataPack dataPack){
        bulletController = dataPack.getBulletController(this);
        doshmanController = dataPack.getDoshmanController(this);
        giftController = dataPack.getGiftController(this);
        tokhmeMorghController = dataPack.getTokhmeMorghController(this);
        inputPlayer = dataPack.getPlayer(this);

    }
    public void syncServerInputData(DataPack dataPack){
        BulletController bulletController = dataPack.getBulletController(this);
        for(int i = 0 ; i<bulletController.getBullets().size() ; i++){
            this.bulletController.addBullet(bulletController.getBullets().get(i));
        }

    }

    public void setServer(Server server) {
        this.server = server;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void serverStart() {
        if(server != null){
            server.start();
        }
    }

    public void clientStart() {
        if (client != null){
            client.start();
        }
    }

    public void  newGame(){
        player = new Player(this,this.getWidth()/2,this.getHeight()-50);
        bulletController = new BulletController(this);
        doshmanController = new DoshmanController(this);
        giftController = new GiftController(this);
        tokhmeMorghController = new TokhmeMorghController(this);
        waveController = new WaveController(this);
        waveController.increaseWave();
    }

    public void setMultiplayerMode(MultiplayerMode multiplayerMode) {
        this.multiplayerMode = multiplayerMode;
    }

    public void setGameMode(GameMode gameMode) {
        this.gameMode = gameMode;
    }

    public void setInAdditionalContentsMenuBackground(boolean inAdditionalContentsMenuBackground) {
        this.inAdditionalContentsMenuBackground = inAdditionalContentsMenuBackground;
    }

    public void addClass(){
        Class c = DIClassLoader.loadClass(newClass.getText());
        loadedClassesController.addClass(c);
        try{

            Constructor constructor = c.getConstructor();
            DoshmanSet doshmanSet =(DoshmanSet) constructor.newInstance();
            System.out.println(1);
            doshmanSet.addDoshmenToGame(this,20,1);
            System.out.println(2);
        }catch (Exception e){
            e.printStackTrace();
        }


    }
    public void addPoint(int point){
        player.setPointsGained(player.getPointsGained() + point);
    }
}
