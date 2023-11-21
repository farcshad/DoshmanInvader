package com;

import com.google.gson.Gson;

import java.io.File;
import java.io.PrintStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Gsoner implements Serializable {

    private Gson gson;
    private File file;
    private Scanner scan;
    private PrintStream ps;

    public Gsoner(){
        try{
           gson = new Gson();
           file = new File("D:\\GameProject\\src\\game.data");
           scan = new Scanner(file);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void save(ArrayList<User> users){
        file = new File("D:\\GameProject\\src\\game.data");
        try{
            ps = new PrintStream("D:\\GameProject\\src\\game.data");

        }catch (Exception e){
            e.printStackTrace();
        }
        for(int i=0 ; i<users.size() ; i++){
            ps.println(gson.toJson(users.get(i)));
        }
    }

    public ArrayList<User> load(){
        ArrayList<User> users = new ArrayList<>();
        try {
            File file = new File("D:\\GameProject\\src\\game.data");
            Scanner scan = new Scanner(file);
            while(scan.hasNextLine()){
                String st = scan.nextLine();
                users.add(gson.fromJson(st,User.class));
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return users;
    }
}
