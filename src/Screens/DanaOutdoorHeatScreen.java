
package Screens;

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
import Maps.DanaOutdoor;
import Maps.DanaOutdoorHeat;
import Players.HistoryMan;
import Players.MedievalHistoryMan;
import Utils.Direction;
import Utils.Point;

public class DanaOutdoorHeatScreen extends Screen{
    protected ScreenCoordinator screenCoordinator;
    protected Map map;
    public Player player;
    protected PlayLevelScreenState playLevelScreenState;
    protected WinScreen winScreen;
    protected FlagManager flagManager;
    protected KeyLocker keyLocker = new KeyLocker();
    

    public DanaOutdoorHeatScreen(ScreenCoordinator screenCoordinator) {
        this.screenCoordinator = screenCoordinator;
    }

    public void initialize() {
        // setup state
        flagManager = new FlagManager();

        // define/setup map
        map = new DanaOutdoorHeat();
        map.setFlagManager(flagManager);

        //if you have not come here from it's other version, use this maps default start position instead
        if(screenCoordinator.getPreviousGameState()==GameState.DANADORMOUTDOOR){
            player = new MedievalHistoryMan(ScreenCoordinator.savedPlayerPos.x,ScreenCoordinator.savedPlayerPos.y);
        } else if(screenCoordinator.getPreviousGameState()==GameState.DANADORMHEAT){
            player = new MedievalHistoryMan(416, 219);
        }else{
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
        switch (playLevelScreenState) {
            // if level is "running" update player and map to keep game logic for the platformer level going
            case RUNNING:
                player.update();
                map.update(player);
                break;
        }

        //if(Keyboard.isKeyDown(ScreenCoordinator.SWITCH_TO_MEDIEVAL)){
            ScreenCoordinator.savedPlayerPos = new Point(player.getX(), player.getY());
            ScreenCoordinator.switchWorld();
        //}

        if (Keyboard.isKeyUp(Key.ESC)) {
            keyLocker.unlockKey(Key.ESC);
        }
        if (!keyLocker.isKeyLocked(Key.ESC) && Keyboard.isKeyDown(Key.ESC)) {

            ScreenCoordinator.setGameState(GameState.MENU);
        }

        // System.out.println(player.getX());
        // System.out.println(player.getY());

        if(((player.getX() >= 400.0) && (player.getX() <= 440.0)) && (player.getY() >= 200.0) && (player.getY() <= 215.0)){
            ScreenCoordinator.setGameState(GameState.DANADORMHEAT);
        }

        if(((player.getX() >= 870.0)) && (player.getY() >= 200.0) && (player.getY() <= 900.0)){
            ScreenCoordinator.setGameState(GameState.HEATDORMEXTERIOR);
        }
        if((player.getX() == 365.0) && (player.getY() == 567.0)){
            ScreenCoordinator.setGameState(GameState.DORMEXTERIOR);
        }
        
        if (Keyboard.isKeyUp(Key.L)) {
            keyLocker.unlockKey(Key.L);
        }
        if (!keyLocker.isKeyLocked(Key.L) && Keyboard.isKeyDown(Key.L)) {

            ScreenCoordinator.setGameState(GameState.DORMEXTERIOR);
        }

        
    }

    public void draw(GraphicsHandler graphicsHandler) {
        // based on screen state, draw appropriate graphics
        switch (playLevelScreenState) {
            case RUNNING:
                map.draw(player, graphicsHandler);
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
        ScreenCoordinator.setGameState(GameState.MENU);
    }

    // This enum represents the different states this screen can be in
    private enum PlayLevelScreenState {
        RUNNING, LEVEL_COMPLETED
    }
}