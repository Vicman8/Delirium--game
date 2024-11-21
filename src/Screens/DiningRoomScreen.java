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
import Level.*;
import Maps.DiningRoom;
import Maps.Disco;
import Maps.OutskirtsMap;
import Maps.Victor;
import Players.Cat;
import Players.HistoryMan;
import Players.MedievalHistoryMan;
import Utils.Direction;

public class DiningRoomScreen extends Screen{
    protected ScreenCoordinator screenCoordinator;
    protected Map map;
    protected Player player;
    protected PlayLevelScreenState playLevelScreenState;
    protected WinScreen winScreen;
    protected FlagManager flagManager;
    protected KeyLocker keyLocker = new KeyLocker();
    protected boolean showInventory;


    public DiningRoomScreen(ScreenCoordinator screenCoordinator) {
        this.screenCoordinator = screenCoordinator;
    }

    public void initialize() {
        // setup state
        flagManager = new FlagManager();
        //flagManager.addFlag("hasTalkedToWalrus", false);

        // define/setup map
        map = new DiningRoom();
        map.setFlagManager(flagManager);

        // setup player
        player = new HistoryMan(map.getPlayerStartPosition().x, map.getPlayerStartPosition().y);
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
        switch (playLevelScreenState) {
            // if level is "running" update player and map to keep game logic for the platformer level going
            case RUNNING:
                player.update();
                map.update(player);
                break;
                
                /*
                * case LEVEL_COMPLETED:
                winScreen.update();
                break;
                */
            }
            if(Keyboard.isKeyDown(Key.I)){
                showInventory = !showInventory;
            }

        if (Keyboard.isKeyUp(Key.ESC)) {
            keyLocker.unlockKey(Key.ESC);
        }
        if (!keyLocker.isKeyLocked(Key.ESC) && Keyboard.isKeyDown(Key.ESC)) {

            screenCoordinator.setGameState(GameState.MENU);
        }

        // if flag is set at any point during gameplay, game is "won"
        /*
        *if (map.getFlagManager().isFlagSet("hasFoundBall")) {
            playLevelScreenState = PlayLevelScreenState.LEVEL_COMPLETED;
        }
        */

        if(((player.getX() >= 457.0) && (player.getX() <= 462.0)) && (player.getY() >= 420.0) && (player.getY() <= 423.0)){
            screenCoordinator.setGameState(GameState.DORMEXTERIOR);
        }
    }

    public void draw(GraphicsHandler graphicsHandler) {
        // based on screen state, draw appropriate graphics
        switch (playLevelScreenState) {
            case RUNNING:
                map.draw(player, graphicsHandler);
                if (showInventory) {
                    graphicsHandler.drawStringWithOutline("Inventory", 0, 50, new Font("Algerian", 0, 25), Color.RED, Color.black, 2);
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
