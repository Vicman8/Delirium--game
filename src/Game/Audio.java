package Game;
import  java.io.*;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class Audio {

    public static Clip currentMusic;

    public static void playAudio(String filePath, boolean isMusic){
       try{
        //establishes that we will be bringing in a file based on a file path
        File music = new File(filePath);

            if(music.exists()){
                //brings the music file into the program
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(music);

                //gets the audio file from the input above
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);

                //lowers volume
                FloatControl volume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
                volume.setValue(-10.0f);

                //if there is music already playing, stop it
                if(Audio.currentMusic != null){
                    System.out.println("Entered current music null check");
                    Audio.currentMusic.stop();
                }
                
                clip.start();

                //this is here because playAudio is for both SFX and music
                if(isMusic = true){
                    System.out.println("Entered isMusic block");
                    Audio.currentMusic=clip; //set current music to be this music
                    clip.loop(Clip.LOOP_CONTINUOUSLY);
                }

                //TODO: check for the previous gamestate and current game state to know when to continue using music
            
                
            }else{
                System.out.println("Erm, like, there is no music lmao");
            }
        }catch(Exception e){e.printStackTrace();}
    }
}

