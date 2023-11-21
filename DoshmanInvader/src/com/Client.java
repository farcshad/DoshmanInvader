package com;

import java.io.*;
import java.net.Socket;

public class Client extends Thread implements Serializable {

    Game game;
    String IP;
    int port;


    public Client(Game game , String IP , int port){
        this.game = game;
        this.IP = IP;
        this.port = port;
    }



    @Override
    public void run() {

        while (true){
            try{
                Socket socket = new Socket(IP,port);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());

                DataPack dataPack = game.createDataPack();
                DataPack inputDataPack = (DataPack) objectInputStream.readObject();
//                objectOutputStream.writeObject(dataPack);
//                game.syncClientInputData(dataPack);
                game.syncClientInputData(inputDataPack);





//                objectOutputStream.writeObject(dataPack);
            }catch (IOException e){
                e.printStackTrace();
            }catch (ClassNotFoundException e){
                e.printStackTrace();
//                game.setInGame(false);
//                game.setInMainMenu(true);
//                break;
            }



        }
    }


}
