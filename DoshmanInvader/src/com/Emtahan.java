package com;

import com.classLoading.DIClassLoader;
import com.doshmanGroups.DoshmanSet;

import java.lang.reflect.Constructor;

public class Emtahan {
    public static void main(String[] args) {
//        try{
////            Socket socket = new Socket("127.0.0.1",9090);
////            InputStream in;
////            ObjectInputStream objectInputStream= new ObjectInputStream(socket.getInputStream());
//////            String object = (String)objectInputStream.readObject();
//////            System.out.println(object);
////
////
////            PlayerData playerData = (PlayerData)objectInputStream.readObject();
//////            DataPack dataPack = (DataPack) objectInputStream.readObject();
//////            DoshmanController doshmanController = dataPack.getDoshmanController();
//////            Doshman doshman = doshmanController.getDoshmen().get(0);
//////            System.out.println(doshman.getX());
////
//////            Player player = playerData.getPlayer(game);
//
//            Thread thread1 = new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    try{
//                        int i = 1;
//                        long time = System.currentTimeMillis();
//
//                        while(true){
//
//                            ServerSocket serverSocket = new ServerSocket(9090);
//                            Socket socket = serverSocket.accept();
//                            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
//                            Game game = new Game();
////            Thread thread = new Thread();
//
//                            DoshmanController doshmanController = new DoshmanController(game);
//                            doshmanController.addDoshman(new Doshman(game,1,1,1, DoshmanBehaviour.STANDARD));
//                            game.doshmanController = doshmanController;
//                            Player player = new Player(game,100,100);
//                            game.setPlayer(player);
//
//                            objectOutputStream.writeObject(game);
//                            System.out.println(i);
//                            i++;
//                    }
//
//                    }catch (IOException e){
//
//                    }
//
//                }
//            });
//
//
//
//
//            Thread thread2 = new Thread(new Runnable() {
//                Game game;
//                @Override
//                public void run() {
//                    while (true){
//                        try{
//                            String dstName;
//                            Socket socket = new Socket("127.0.0.1", 9090);
//
//                            File file = new File("D:\\GameProject\\HAHA2");
//                            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
//
//
//                            Game game = (Game) objectInputStream.readObject();
//                            this.game = game;
//
//                            System.out.println("montabeghshod");
//                            System.out.println(game.player.getX());
//
//
//
//                        }catch (Exception e){
//                            e.printStackTrace();
//                        }
//                    }
//                }
//            });
//
//
////            thread1.start();
////            thread2.start();
////            String pathname;
////            File f = new File("D:\\GameProject\\HAHA2");
////            ObjectInputStream objectInputStream = new ObjectInputStream();
////            Object object = objectInputStream.readObject();
//            Game game = new Game();
//            Player player= new Player(game,100,100);
//            DoshmanController doshmanController = new DoshmanController(game);
//            doshmanController.addDoshman(new Doshman(game,1,1,1,DoshmanBehaviour.STANDARD));
//            System.out.println(doshmanController.getDoshmen().size());
//            GiftController giftController = new GiftController(game);
//            TokhmeMorghController tokhmeMorghController = new TokhmeMorghController(game);
//            BulletController bulletController = new BulletController(game);
//            DataPack dataPack = new DataPack(player,bulletController,doshmanController,giftController,tokhmeMorghController);
//
//
//
//
//            Thread server = new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    ServerSocket serverSocket;
//                    try {
//
//                        serverSocket = new ServerSocket(9090);
//                        while (true) {
//
//                            DoshmanControllerData data = doshmanController.getDoshmanControllerData();
//
//                            Socket socket = serverSocket.accept();
//
//                            OutputStream out;
//                            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
//                            objectOutputStream.writeObject(dataPack);
//                        }
//                    }catch (Exception e){
//                        e.printStackTrace();
//                    }
//                }
//            });
//
//
//            Thread client = new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    while (true){
//                        try{
//                            Socket socket = new Socket("127.0.0.1",9090);
//                            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
//
////                            DoshmanControllerData data = (DoshmanControllerData) objectInputStream.readObject();
////                            System.out.println("gereft");
////                            DoshmanController doshmanController1 = data.getDoshmanController(game);
////                            System.out.println("doshcon sakht");
////                            System.out.println(doshmanController1.getDoshmen().size());
////                            Doshman doshman = doshmanController1.getDoshmen().get(0);
////                            System.out.println(doshman.getHealth());
//
//                            DataPack dataPack1 = (DataPack) objectInputStream.readObject();
//                            Player player1 = dataPack1.getPlayer(game);
//                            DoshmanController doshmanController1 = dataPack1.getDoshmanController(game);
//
//                            System.out.println("HAHA \n \n");
//
//                            System.out.println(player1.getX());
//                            System.out.println(doshmanController1.getDoshmen().get(0).getSize());
//
//
//
//
//                        }catch (IOException e){
//                            e.printStackTrace();
//                        }catch (ClassNotFoundException e){
//                            e.printStackTrace();
//                        }
//
//                    }
//                }
//            });
//
//            server.start();
//            client.start();
//
//
//        }catch (Exception e){
//            e.printStackTrace();
//        }
        Class loadClass = DIClassLoader.loadClass("com.doshmanGroups.CircularDoshmanSet");
        try {
            Constructor constructor = loadClass.getConstructor(null);
            DoshmanSet doshmanSet =(DoshmanSet) constructor.newInstance(null);
        }catch (Exception e){e.printStackTrace();}
    }
}
