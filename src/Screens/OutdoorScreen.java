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
import Level.NPC;
import Level.Player;
import Maps.MountainviewDormOutdoor;
import NPCs.ArtThim;
import NPCs.WaterBottle;
import Players.HistoryMan;
import Utils.Direction;
import Utils.Point;

public class OutdoorScreen extends Screen{
    protected ScreenCoordinator screenCoordinator;
    protected Map map;
    protected Player player;
    protected PlayLevelScreenState playLevelScreenState;
    protected WinScreen winScreen;
    protected FlagManager flagManager;
    protected KeyLocker keyLocker = new KeyLocker();
    //public static Point outdoorDormPos;

    protected boolean showInventory;

    public OutdoorScreen(ScreenCoordinator screenCoordinator) {
        this.screenCoordinator = screenCoordinator;
    }

    public void initialize() {
        // setup state
        flagManager = new FlagManager();
        flagManager.addFlag("checkDone", false);
        flagManager.addFlag("E", false);
        flagManager.addFlag("exclaim",false);

        // define/setup map
        map = new MountainviewDormOutdoor();
        map.setFlagManager(flagManager);

        //changes player coordinates depending on where you came from
        if(screenCoordinator.getPreviousGameState()==GameState.HEATDORMEXTERIOR){
            player = new HistoryMan(ScreenCoordinator.savedPlayerPos.x,ScreenCoordinator.savedPlayerPos.y);
        }else if(screenCoordinator.getPreviousGameState()==GameState.DANADORMOUTDOOR){
            player = new HistoryMan(-3, 769);
        }else if(screenCoordinator.getPreviousGameState()==GameState.DISCO){
            player = new HistoryMan(215, 1150);
        }else if(screenCoordinator.getPreviousGameState()==GameState.DININGROOM){
            player = new HistoryMan(1060, 1150);
        }else{
            player = new HistoryMan(map.getPlayerStartPosition().x, map.getPlayerStartPosition().y);
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
                screenCoordinator.setGameState(GameState.DORM);
            }
            
            if((player.getX() <=-30.0) && ((player.getY() >= 433.0) && (player.getY() <= 1528.0))){
                screenCoordinator.setGameState(GameState.DANADORMOUTDOOR);
            }

            if(((player.getX() >= 207.0) && (player.getX() <= 222.0)) && ((player.getY() >= 1116.0) && (player.getY() <= 1146.0))){
                screenCoordinator.setGameState(GameState.DISCO);
            }
            
            if(((player.getX() >= 1050.0) && (player.getX() <= 1080.0)) && (player.getY() >= 1116.0) && (player.getY() <= 1146.0)){
                screenCoordinator.setGameState(GameState.DININGROOM);
            }
            
            if(((player.getX() >= 1388.0) && (player.getX() <= 1400.0)) && (player.getY() >= 1260.0) && (player.getY() <= 1287.0)){
                screenCoordinator.setGameState(GameState.VICTOR);
            }
            for (NPC npc : map.getNPCs()) {
            
                        if(npc instanceof ArtThim){
                            if(npc.touching(player)){
                                System.out.println("working");
                                screenCoordinator.setGameState(GameState.HEATDORMEXTERIOR);
                                
                            }
                        }
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