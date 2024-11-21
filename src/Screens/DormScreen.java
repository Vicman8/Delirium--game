//tied to VILLAGE

package Screens;

import java.io.IOException;

import java.awt.Color;
import java.awt.Font;

import Engine.GraphicsHandler;
import Engine.Key;
import Engine.KeyLocker;
import Engine.Keyboard;
import Engine.Screen;
import Game.GameState;
import Game.SaveIO;
import Game.ScreenCoordinator;
import Level.FlagManager;
import Level.Map;
import Level.NPC;
import Level.Player;
import Maps.DanaDorm;
import Maps.DanaOutdoor;
import Maps.MoutainviewDorm;
import NPCs.Fan;
import Players.HistoryMan;
import Utils.Direction;
import Utils.Point;

public class DormScreen extends Screen{
    protected ScreenCoordinator screenCoordinator;
    protected Map map;
    public Player player;
    protected PlayLevelScreenState playLevelScreenState;
    protected WinScreen winScreen;
    protected FlagManager flagManager;
    protected KeyLocker keyLocker = new KeyLocker();
    

    public DormScreen(ScreenCoordinator screenCoordinator) {
        this.screenCoordinator = screenCoordinator;
    }

    public void initialize() {
        // setup state
        flagManager = new FlagManager();
        flagManager.addFlag("hasTalkedToStudent", false);
        flagManager.addFlag("introStarted", false);
        flagManager.addFlag("fanHasDied", false);

        // define/setup map
        map = new MoutainviewDorm();
        map.setFlagManager(flagManager);

        //if you have not come here from it's other version, use this maps default start position instead

        if(screenCoordinator.getPreviousGameState()==GameState.HEATDORM){
            player = new HistoryMan(ScreenCoordinator.savedPlayerPos.x,ScreenCoordinator.savedPlayerPos.y);
        } else{
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

        try {
            SaveIO.ApplySaveFile(/*player, screenCoordinator*/);
        } catch (Exception e) {
            System.out.println("Your player instance is probably false numbnuts");
        }
        
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

        // for (NPC npc : map.getNPCs()) {
        //     if (npc instanceof Fan) {
        //         System.out.println(npc.touching(player));
        //         if (npc.touching(player)) {
        //             screenCoordinator.setGameState(GameState.DORM);
        //             return;
        //         }
        //     }
        // }

        //if(Keyboard.isKeyDown(ScreenCoordinator.SWITCH_TO_MEDIEVAL)){
            ScreenCoordinator.savedPlayerPos = new Point(player.getX(), player.getY());
            screenCoordinator.switchWorld(screenCoordinator);
        //}

        if (Keyboard.isKeyDown(Key.ESC)) {
            screenCoordinator.setGameState(GameState.MENU);
        }

        if(((player.getX() >= 360.0) && (player.getX() <= 370.0)) && (player.getY() >= 560.0) && (player.getY() <= 570.0)){
            screenCoordinator.setGameState(GameState.DORMEXTERIOR);
        }

        if (Keyboard.isKeyDown(Key.M)) {
            screenCoordinator.setGameState(GameState.DANADORMHEAT);
        }

        if (Keyboard.isKeyUp(Key.N)) {
            keyLocker.unlockKey(Key.N);
        }
        if (!keyLocker.isKeyLocked(Key.N) && Keyboard.isKeyDown(Key.N)) {

            screenCoordinator.setGameState(GameState.DANADORM);
        }

        if (Keyboard.isKeyUp(Key.L)) {
            keyLocker.unlockKey(Key.L);
        }
        if (!keyLocker.isKeyLocked(Key.L) && Keyboard.isKeyDown(Key.L)) {

            screenCoordinator.setGameState(GameState.DORMEXTERIOR);
        }

        try {
            SaveIO.SaveToFile(screenCoordinator);
        } catch (IOException e) {
            System.out.println("Sorry. Looks like some IDIOT developer FUCKED UP the save function");
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