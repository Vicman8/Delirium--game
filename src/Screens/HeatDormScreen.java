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
import Maps.MountainviewDormHeat;
import Players.MedievalHistoryMan;
import Utils.Direction;
import Utils.Point;
import Utils.Point;

public class HeatDormScreen extends Screen{
    protected ScreenCoordinator screenCoordinator;
    protected Map map;
    protected Player player;
    protected PlayLevelScreenState playLevelScreenState;
    protected WinScreen winScreen;
    protected FlagManager flagManager;
    protected KeyLocker keyLocker = new KeyLocker();
    public static Point heatDormPos;
    public static Point heatDormPos;

    public HeatDormScreen(ScreenCoordinator screenCoordinator) {
        this.screenCoordinator = screenCoordinator;
    }

    public void initialize() {
        // setup state
        flagManager = new FlagManager();
        flagManager.addFlag("hasTalkedToStudent", false);
        flagManager.addFlag("introStarted", false);
        flagManager.addFlag("fanHasDied", false);
        flagManager.addFlag("mcUnfainted", false);
        flagManager.addFlag("bearFought", false);

        // define/setup map
        map = new MountainviewDormHeat(/*screenCoordinator*/);
        //map = new MountainviewDormHeat(screenCoordinator);
        map = new MountainviewDormHeat();
        map.setFlagManager(flagManager);

        //if you have not come here from it's other version, use this maps default start position instead
        if(DormScreen.dormPos == null){
            DormScreen.dormPos = new Point(map.getPlayerStartPosition().x, map.getPlayerStartPosition().y);
        }
        
        // setup player
        player = new MedievalHistoryMan(DormScreen.dormPos.x,DormScreen.dormPos.y);
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
        
        if(Keyboard.isKeyDown(ScreenCoordinator.SWITCH_TO_REALITY)){
            heatDormPos = new Point(player.getX(), player.getY());
            screenCoordinator.switchWorld(screenCoordinator);
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
        screenCoordinator.setGameState(GameState.MENU);
    }

    // This enum represents the different states this screen can be in
    private enum PlayLevelScreenState {
        RUNNING, LEVEL_COMPLETED
    }
}