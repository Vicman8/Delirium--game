package Game;
import java.applet.AudioClip;
import  java.io.*;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;

public class Audio {
    /*public Music() {
        
    }*/

    public static void playMusic(String filePath){
       try{
        //establishes that we will be bringing in a file based on a file path
        File music = new File(filePath);

        if(music.exists()){
            //brings the music file into the program
            AudioInputStream audioInput = AudioSystem.getAudioInputStream(music);

            //gets the audio file from the input above
            Clip clip = AudioSystem.getClip();
            clip.open(audioInput);
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);

            //supposedly stops the song thread from self-destructing
            //JOptionPane.showMessageDialog(null, clip, "", 0);
        } else {
            System.out.println("Erm, like, there is no music lmao");
        }

       } catch(Exception e){
        e.printStackTrace();
        //System.out.println("I couldn't read your sound file, dummy! :)");
       }
    }

    public static void playSoundEffect(String filePath){
        try{
         //establishes that we will be bringing in a file based on a file path
         File music = new File(filePath);
 
         if(music.exists()){
             //brings the sound file into the program
             AudioInputStream audioInput = AudioSystem.getAudioInputStream(music);
 
             //gets the audio file from the input above
             Clip clip = AudioSystem.getClip();
             clip.open(audioInput);
             //clip.start();
         } else {
             System.out.println("Erm, like, there is no music lmao");
         }
 
        } catch(Exception e){
         e.printStackTrace();
         //System.out.println("I couldn't read your sound file, dummy! :)");
        }
     }
}
