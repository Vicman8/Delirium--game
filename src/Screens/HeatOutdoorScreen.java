package Screens;

import java.awt.Color;
import java.awt.Font;

import Engine.GraphicsHandler;
import Engine.Key;
import Engine.KeyLocker;
import Engine.Keyboard;
import Engine.Screen;
import Game.GameState;
import Game.ScreenCoordinator;
import Level.FlagManager;
import Level.Map;
import Level.Player;
import Maps.MountainviewDormOutdoor;
import Maps.MountainviewDormOutdoorHeat;
import Players.HistoryMan;
import Players.MedievalHistoryMan;
import Utils.Direction;
import Utils.Point;

public class HeatOutdoorScreen extends Screen{
    protected ScreenCoordinator screenCoordinator;
    protected Map map;
    protected Player player;
    protected PlayLevelScreenState playLevelScreenState;
    protected WinScreen winScreen;
    protected FlagManager flagManager;
    protected KeyLocker keyLocker = new KeyLocker();
    protected boolean showInventory;


    public HeatOutdoorScreen(ScreenCoordinator screenCoordinator) {
        this.screenCoordinator = screenCoordinator;
    }

    public void initialize() {
        // setup state
        flagManager = new FlagManager();
        flagManager.addFlag("bearFought", false);
        flagManager.addFlag("scaryBear", false);
        flagManager.addFlag("Flee!", false);
        flagManager.addFlag("Bear!", false);
        
        // define/setup map
        map = new MountainviewDormOutdoorHeat();
        map.setFlagManager(flagManager);

        //if you have not come here from it's other version, use this maps default start position instead
        if(screenCoordinator.getPreviousGameState()==GameState.DORMEXTERIOR){
            player = new MedievalHistoryMan(ScreenCoordinator.savedPlayerPos.x,ScreenCoordinator.savedPlayerPos.y);
        }else if(screenCoordinator.getPreviousGameState()==GameState.DANADORMOUTDOORHEAT){
            player = new MedievalHistoryMan(-3, 769);
        }else if(screenCoordinator.getPreviousGameState()==GameState.JAIL){
            player = new MedievalHistoryMan(1140, 740);
        }else if(screenCoordinator.getPreviousGameState()==GameState.DININGROOMHEAT){
            player = new MedievalHistoryMan(1060, 1150);
        }else if(screenCoordinator.getPreviousGameState()==GameState.BOSSARENA){
            player = new MedievalHistoryMan(685, 1320);
        } 
        else{
            player = new MedievalHistoryMan(map.getPlayerStartPosition().x, map.getPlayerStartPosition().y);
        }
        player.setMap(map);
        playLevelScreenState = PlayLevelScreenState.RUNNING;
        player.setFacingDirection(Direction.LEFT);

        map.setPlayer(player);

        // let pieces of map know which button to listen for as the "interact" button
        map.getTextbox().setInteractKey(player.getInteractKey());

        // preloads all scripts ahead of time rather than loading them dynamically
        // both are supported, however preloading is recommended
        map.preloadScripts();

        //winScreen = new WinScreen(this);
    }

    public void update() {
        // based on screen state, perform specific actions
        if (Keyboard.isKeyDown(Key.ESC)) {

            screenCoordinator.setGameState(GameState.MENU);
        }
        if(Keyboard.isKeyDown(Key.I)){
            showInventory = !showInventory;
        }
        
        switch (playLevelScreenState) {
            // if level is "running" update player and map to keep game logic for the platformer level going
            case RUNNING:
                player.update();
                map.update(player);
                break;
        }
            ScreenCoordinator.savedPlayerPos = new Point(player.getX(), player.getY());
            screenCoordinator.switchWorld(screenCoordinator);

            if(((player.getX() >= 400.0) && (player.getX() <= 410.0)) && (player.getY() >= 340.0) && (player.getY() <= 350.0)){
                screenCoordinator.setGameState(GameState.HEATDORM);
            }
            
            if((player.getX() <=-30.0) && ((player.getY() >= 433.0) && (player.getY() <= 1528.0))){
                screenCoordinator.setGameState(GameState.DANADORMOUTDOORHEAT);
            }

            if(((player.getX() >= 1120.0) && (player.getX() <= 1160.0)) && ((player.getY() >= 732.0) && (player.getY() <= 737.0))){
                screenCoordinator.setGameState(GameState.JAIL);
            }

            if(((player.getX() >= 1050.0) && (player.getX() <= 1080.0)) && (player.getY() >= 1116.0) && (player.getY() <= 1146.0)){
                screenCoordinator.setGameState(GameState.DININGROOMHEAT);
            }

            if(((player.getX() >= 74.0) && (player.getX() <= 1164.0)) && (player.getY() >= 1360.0) && (player.getY() <= 1380.0)){
                screenCoordinator.setGameState(GameState.BOSSARENA);
            }

        
    }

    public void draw(GraphicsHandler graphicsHandler) {
        // based on screen state, draw appropriate graphics
        switch (playLevelScreenState) {
            case RUNNING:
                map.draw(player, graphicsHandler);
                if (showInventory) {
                    graphicsHandler.drawStringWithOutline("Inventory", 0, 50, new Font("Algerian", 0, 25), Color.RED, Color.black, 2);
                    if(ScreenCoordinator.compressor == true){
                        graphicsHandler.drawStringWithOutline("Compressor", 0, 80, new Font("Algerian", 0, 25), Color.RED, Color.black, 2);


                    }
                    if(ScreenCoordinator.evaporator == true){
                        graphicsHandler.drawStringWithOutline("Evaporator Coil", 0, 100, new Font("Algerian", 0, 25), Color.RED, Color.black, 2);

                    }
                    if (ScreenCoordinator.condensing == true) {
                        graphicsHandler.drawStringWithOutline("Condensing Coil", 0, 120, new Font("Algerian", 0, 25), Color.RED, Color.black, 2);
                    }
                    if (ScreenCoordinator.circulating == true) {
                        graphicsHandler.drawStringWithOutline("Circulating Fan", 0, 140, new Font("Algerian", 0, 25), Color.RED, Color.black, 2);

                    }
            }
                break;
            case LEVEL_COMPLETED:
                winScreen.draw(graphicsHandler);
                break;
        }
    }

    public PlayLevelScreenState getPlayLevelScreenState() {
        return playLevelScreenState;
    }


    public void resetLevel() {
        initialize();
    }

    public void goBackToMenu() {
        screenCoordinator.setGameState(GameState.MENU);
    }

    // This enum represents the different states this screen can be in
    private enum PlayLevelScreenState {
        RUNNING, LEVEL_COMPLETED
    }
}
