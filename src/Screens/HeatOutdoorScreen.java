package Screens;

import Engine.GraphicsHandler;
<<<<<<< HEAD
=======
import Engine.Keyboard;
>>>>>>> 4cb609805493e00c95acd5e3ee739a85fc313fc6
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
<<<<<<< HEAD
=======
import Utils.Point;
>>>>>>> 4cb609805493e00c95acd5e3ee739a85fc313fc6

public class HeatOutdoorScreen extends Screen{
    protected ScreenCoordinator screenCoordinator;
    protected Map map;
    protected Player player;
    protected PlayLevelScreenState playLevelScreenState;
    protected WinScreen winScreen;
    protected FlagManager flagManager;

    public HeatOutdoorScreen(ScreenCoordinator screenCoordinator) {
        this.screenCoordinator = screenCoordinator;
    }

    public void initialize() {
        // setup state
        flagManager = new FlagManager();
<<<<<<< HEAD
        flagManager.addFlag("scaryBear", false);
        flagManager.addFlag("Flee!", false);
        flagManager.addFlag("Bear!", false);

=======
        flagManager.addFlag("bearFought", false);
        flagManager.addFlag("scaryBear", false);
        flagManager.addFlag("Flee!", false);
        flagManager.addFlag("Bear!", false);
        
>>>>>>> 4cb609805493e00c95acd5e3ee739a85fc313fc6
        // define/setup map
        map = new MountainviewDormOutdoorHeat();
        map.setFlagManager(flagManager);

<<<<<<< HEAD
        // setup player
        player = new MedievalHistoryMan(map.getPlayerStartPosition().x, map.getPlayerStartPosition().y);
=======
        //if you have not come here from it's other version, use this maps default start position instead
        if(ScreenCoordinator.savedPlayerPos == null){
            ScreenCoordinator.savedPlayerPos = new Point(map.getPlayerStartPosition().x, map.getPlayerStartPosition().y);
        }


        // setup player
        player = new MedievalHistoryMan(ScreenCoordinator.savedPlayerPos.x, ScreenCoordinator.savedPlayerPos.y);
>>>>>>> 4cb609805493e00c95acd5e3ee739a85fc313fc6
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
<<<<<<< HEAD
=======
            ScreenCoordinator.savedPlayerPos = new Point(player.getX(), player.getY());
            screenCoordinator.switchWorld(screenCoordinator);
>>>>>>> 4cb609805493e00c95acd5e3ee739a85fc313fc6
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