package com;

import com.Controllers.DoshmanController;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread implements Serializable {

    private Game game;
    private String IP;
    private int port;

    Player alterPlayer;

    public Server(Game game , String IP , int port){
        this.game = game;
        this.IP = IP;
        this.port = port;
    }
    @Override
    public void run() {
        try{

            ServerSocket serverSocket = new ServerSocket(port);
            while(true){

                Socket socket = serverSocket.accept();

                ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());

                DataPack dataPack = game.createDataPack();

//                Player player = game.getPlayer();
//                PlayerData playerData = player.getData();
                objectOutputStream.writeObject(dataPack);
//                DataPack inputDataPack = (DataPack)objectInputStream.readObject();


//                PlayerData inputPlayerData = (PlayerData) objectInputStream.readObject();
//                alterPlayer = inputPlayerData.getPlayer(game);

//                DataPack inputDataPack = (DataPack)objectInputStream.readObject();
//                game.syncServerInputData(dataPack);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public Player getPlayerFromServer(){
        if (alterPlayer != null)
            return alterPlayer;
        else {
            System.out.println("PlayerFromServerIsNull");
            return null;
        }
    }

}
