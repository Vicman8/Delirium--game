package Game;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import Engine.Key;
import Engine.Keyboard;
import Game.ScreenCoordinator;
import Level.FlagManager;
import Level.Player;
import Players.HistoryMan;
import Utils.Point;
import Level.FlagManager;

//IMPORTANT: you have to erase data manually!
//https://www.youtube.com/watch?v=dHZaqMmQNO4

//has two parts: inputting game data into the save file, and outputting the save file data into the game
public class SaveIO{
    //sets save file data to match that of the current variables (does not apply them yet)
    public static void SaveToFile(ScreenCoordinator screenCoordinator) throws IOException{
        //System.out.println("Executing SaveToFile method");
        if(Keyboard.isKeyDown(Key.S)){
            String line; //the current line being looked at
            Scanner fileInput; //the tool that allows you to open files
            int lineNum = 1;
            //ScreenCoordinator screenCoordinator = new ScreenCoordinator();
    
            System.out.println("Locating files");
            File saveFile = new File("src/Game/SaveData.csv");
            System.out.println("Opening file");

            ArrayList<String> fileData = new ArrayList<>();
            fileData.add("true");
            fileData.add(""+FlagManager.isFlagSet("EvaporatorCoil")+"");
            fileData.add(""+FlagManager.isFlagSet("CirculatingFan")+"");
            fileData.add(""+FlagManager.isFlagSet("Compressor")+"");
            fileData.add(""+FlagManager.isFlagSet("Condensing")+"");

            try{
                //BufferedReader is for reading the file more efficiently
                //BufferedReader reader = new BufferedReader(new FileReader(saveFile));

                //sets up the tool used for writing to a file
                PrintWriter writer = new PrintWriter(new FileWriter(saveFile));
                System.out.println("Reading file");
                fileInput = new Scanner(saveFile);
                
                for(String data : fileData){
                    writer.println(fileData.get(lineNum-1));
                    System.out.println("Line Number: " + lineNum);
                    lineNum++;
                } //end while
                writer.close();
                System.out.println("File modified.");
            } catch (FileNotFoundException e){
                System.out.println("Sowwy! C-could not find the s-save file >w<!");
            }
            System.out.println("save successful");
        }//end if
    }//end SaveToFile

    //sets game variables to be what they are in the save file. Should do this automatically after pressing play on the main menu
    public static void ApplySaveFile(/*Player player, ScreenCoordinator screenCoordinator*/) throws IOException{
        System.out.println("Activating ApplySaveFile method");
        String line; //the current line being looked at
        Scanner fileInput; //the tool that allows the file to be opened
        int lineNum = 1;
        Boolean hasReturned = false; //tied to the first number, acts as a barrier to applying the other variables

        //System.out.println("Locating files for ApplySaveFile");
        File saveFile = new File("src/Game/SaveData.csv");
        //System.out.println("Opening file for ApplySaveFile");
        
        try{
            //BufferedReader is for reading the file more efficiently
            BufferedReader reader = new BufferedReader(new FileReader(saveFile));

            //sets up the tool used for writing a new file that will replace the old one
            //System.out.println("Reading file for ApplySaveFile");
            //fileInput = new Scanner(saveFile);
            
            while ((line = reader.readLine() ) != null){
                //System.out.println("Entering check for line one for ApplySaveFile");
                if(lineNum == 1 && line.equals("true")){ //if on the first line and that line is a 1
                    hasReturned = true; //essentially for the program to remember that the player is returning
                    System.out.println("hasReturned set to true for ApplySaveFile");
                    FlagManager.setFlag("EvaporatorCoil");
                    System.out.println("Evaporator Coil flag has been set");
                }
                if(hasReturned == true){
                    if(lineNum == 2 && line.equals("true")){
                        FlagManager.setFlag("EvaporatorCoil");
                        System.out.println("Evaporator Coil flag set to true");
                    }
                    if(lineNum == 3 && line.equals("true")){
                        FlagManager.setFlag("CirculatingFan");
                        System.out.println("Circulating Fan flag set to true");
                    }
                    if(lineNum == 4 && line.equals("true")){
                        FlagManager.setFlag("Compressor");
                    }
                    if(lineNum == 5 && line.equals("true")){
                        FlagManager.setFlag("Condensing");
                    }
                    System.out.println(line);
                }//end if hasRetured
                lineNum++;
                System.out.println(line);
            }//end while
            reader.close();
            } catch (FileNotFoundException e){
                System.out.println("Sowwy! C-could not find the s-save file >w<!");
            }
        }
    }