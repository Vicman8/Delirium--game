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
import Maps.BossArena;
import Maps.MountainviewDormOutdoor;
import Maps.MountainviewDormOutdoorHeat;
import Players.HistoryMan;
import Players.MedievalHistoryMan;
import Utils.Direction;
import Utils.Point;

public class BossArenaScreen extends Screen{
    protected ScreenCoordinator screenCoordinator;
    protected Map map;
    protected Player player;
    protected PlayLevelScreenState playLevelScreenState;
    protected WinScreen winScreen;
    protected FlagManager flagManager;
    protected KeyLocker keyLocker = new KeyLocker();
    protected boolean showInventory;


    public BossArenaScreen(ScreenCoordinator screenCoordinator) {
        this.screenCoordinator = screenCoordinator;
    }

    public void initialize() {
        // setup state
        flagManager = new FlagManager();
        
        // define/setup map
        map = new BossArena();
        map.setFlagManager(flagManager);

        //if you have not come here from it's other version, use this maps default start position instead
        player = new MedievalHistoryMan(50, 200);
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

        if (Keyboard.isKeyUp(Key.ESC)) {
            keyLocker.unlockKey(Key.ESC);
        }
        if (!keyLocker.isKeyLocked(Key.ESC) && Keyboard.isKeyDown(Key.ESC)) {

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

            if(((player.getX() >= -40.0) && (player.getX() <= -2.0)) && (player.getY() >= -1.0) && (player.getY() <= 863.0)){
                screenCoordinator.setGameState(GameState.HEATDORMEXTERIOR);
            }

            if(((player.getX() >= 830.0) && (player.getX() <= 850.0)) && (player.getY() >= 8.0) && (player.getY() <= 805.0)){
                screenCoordinator.setGameState(GameState.WIN);
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
