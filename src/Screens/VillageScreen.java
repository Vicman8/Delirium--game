//tied to dorm
package Screens;

import Engine.GraphicsHandler;
import Engine.Screen;
import Game.GameState;
import Game.ScreenCoordinator;
<<<<<<<< HEAD:src/Screens/OutdoorDormScreen.java
import Level.FlagManager;
import Level.Map;
import Level.Player;
import Maps.MountainviewDormOutdoor;
========
import Level.*;
import Maps.VillageMap;
>>>>>>>> 4cb609805493e00c95acd5e3ee739a85fc313fc6:src/Screens/VillageScreen.java
import Players.HistoryMan;
import Utils.Direction;

<<<<<<<< HEAD:src/Screens/OutdoorDormScreen.java
public class OutdoorDormScreen extends Screen{
========
// This class is for when the RPG game is actually being played
public class VillageScreen extends Screen {
>>>>>>>> 4cb609805493e00c95acd5e3ee739a85fc313fc6:src/Screens/VillageScreen.java
    protected ScreenCoordinator screenCoordinator;
    protected Map map;
    protected Player player;
    protected PlayLevelScreenState playLevelScreenState;
    protected WinScreen winScreen;
    protected FlagManager flagManager;

<<<<<<<< HEAD:src/Screens/OutdoorDormScreen.java
    public OutdoorDormScreen(ScreenCoordinator screenCoordinator) {
========
    public VillageScreen(ScreenCoordinator screenCoordinator) {
>>>>>>>> 4cb609805493e00c95acd5e3ee739a85fc313fc6:src/Screens/VillageScreen.java
        this.screenCoordinator = screenCoordinator;
    }

    public void initialize() {
        // setup state
        flagManager = new FlagManager();
<<<<<<<< HEAD:src/Screens/OutdoorDormScreen.java

        // define/setup map
        map = new MountainviewDormOutdoor();
========
        flagManager.addFlag("hasTalkedToWalrus", false);
        flagManager.addFlag("hasTalkedToStudent", false);
        flagManager.addFlag("introStarted", false);
        flagManager.addFlag("fanHasDied", false);
        
        // define/setup map
        map = new VillageMap(/*screenCoordinator*/);
>>>>>>>> 4cb609805493e00c95acd5e3ee739a85fc313fc6:src/Screens/VillageScreen.java
        map.setFlagManager(flagManager);

        //if you have not come here from it's other version, use this maps default start position instead
        if(ScreenCoordinator.savedPlayerPos == null){
            ScreenCoordinator.savedPlayerPos = new Point(map.getPlayerStartPosition().x, map.getPlayerStartPosition().y);
        }

        // setup player
        //start at the coords from the previous world
        player = new HistoryMan(ScreenCoordinator.savedPlayerPos.x,ScreenCoordinator.savedPlayerPos.y);
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
<<<<<<<< HEAD:src/Screens/OutdoorDormScreen.java
========

        // if flag is set at any point during gameplay, game is "won"
        /*
        *if (map.getFlagManager().isFlagSet("hasFoundBall")) {
            playLevelScreenState = PlayLevelScreenState.LEVEL_COMPLETED;
        }
        */
        ScreenCoordinator.savedPlayerPos = new Point(player.getX(), player.getY());
>>>>>>>> 4cb609805493e00c95acd5e3ee739a85fc313fc6:src/Screens/VillageScreen.java
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
