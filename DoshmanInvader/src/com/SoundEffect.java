package com;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.io.Serializable;

public class SoundEffect implements Serializable {

    Clip clip;

    public SoundEffect(String filePath){
        try{
            File file = new File(filePath);
            AudioInputStream sound = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
            clip.open(sound);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void play(){
        clip.setFramePosition(0);
        clip.start();
    }
}
