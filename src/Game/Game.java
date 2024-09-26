package Game;

import Engine.GameWindow;
import Engine.ScreenManager;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import Game.ScreenCoordinator;

/*
 * The game starts here
 * This class just starts up a GameWindow and attaches the ScreenCoordinator to the ScreenManager instance in the GameWindow
 * From this point on the ScreenCoordinator class will dictate what the game does
 */
public class Game {

    public static void main(String[] args) {
        new Game();
    }

    public Game() {
        GameWindow gameWindow = new GameWindow();
        ScreenManager screenManager = gameWindow.getScreenManager();
        screenManager.setCurrentScreen(new ScreenCoordinator());
        gameWindow.startGame();
        
        //this is to run the heat mechanic on a new thread (the rest of the game would not run otherwise)
        ExecutorService heatExecutor = Executors.newSingleThreadExecutor();
        heatExecutor.submit(() -> {
            
            
            int heatLevel = 0;

            for(heatLevel = 0; heatLevel <= 100; heatLevel += 1){
                /* TODO: if statement that only runs the rest of the loop is the gamestate is LEVEL
                 * if (getGameState() == GameState.LEVEL){
                 *      code below in here
                 * }
                */
                    System.out.println("Heat Level = " + heatLevel);
                    try {
                        Thread.sleep(300);
                    } catch (Exception e) {
                        System.out.println("Sleep error!");
                    }
            }//end for
        }); //end heatExecutor
    }
}