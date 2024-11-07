package Screens;

import java.rmi.server.RemoteObjectInvocationHandler;

import Engine.GraphicsHandler;
import Engine.Key;
import Engine.KeyLocker;
import Engine.Keyboard;
import Engine.Screen;
import Game.GameState;
import Game.ScreenCoordinator;
import Level.FlagManager;
import Level.Map;
import Level.MapEntity;
import Level.MapEntityStatus;
import Level.NPC;
import Level.Player;
import Maps.MountainviewDormHeat;
import NPCs.Fan;
import NPCs.WaterBottle;
import Players.HistoryMan;
import Players.MedievalHistoryMan;
import Utils.Direction;
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
    protected Point playerCurrPosition;



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
        if(screenCoordinator.getPreviousGameState()==GameState.DORM){
            player = new MedievalHistoryMan(ScreenCoordinator.savedPlayerPos.x,ScreenCoordinator.savedPlayerPos.y);
        } else{
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

        for (NPC npc : map.getNPCs()) {

            if(npc instanceof WaterBottle){
                if(npc.touching(player) && Keyboard.isKeyDown(Key.E)){
                    System.out.println("working");
                    screenCoordinator.setGameState(GameState.DORM);;
                    
                }
            }
            if (npc instanceof Fan ) {
                if (npc.touching(player)) {
                      System.out.println("working");
                    //screenCoordinator.hasSwitched = true;
                    screenCoordinator.setGameState(GameState.DORM);
                }
            }
        }

        if(((player.getX() >= 360.0) && (player.getX() <= 370.0)) && (player.getY() >= 560.0) && (player.getY() <= 570.0)  ){
            screenCoordinator.setGameState(GameState.HEATDORMEXTERIOR);
        }

        

        // based on screen state, perform specific actions
        switch (playLevelScreenState) {
            // if level is "running" update player and map to keep game logic for the platformer level going
            case RUNNING:
                player.update();
                map.update(player);
                break;
        }

        if (Keyboard.isKeyUp(Key.ESC)) {
            keyLocker.unlockKey(Key.ESC);
        }
        if (!keyLocker.isKeyLocked(Key.ESC) && Keyboard.isKeyDown(Key.ESC)) {

            screenCoordinator.setGameState(GameState.MENU);
        }

        playerCurrPosition = new Point(player.getX(), player.getY());
        
        
            ScreenCoordinator.savedPlayerPos = new Point(player.getX(), player.getY());
            screenCoordinator.switchWorld(screenCoordinator);

            if (Keyboard.isKeyUp(Key.L)) {
                keyLocker.unlockKey(Key.L);
            }
            if (!keyLocker.isKeyLocked(Key.L) && Keyboard.isKeyDown(Key.L)) {
    
                screenCoordinator.setGameState(GameState.HEATDORMEXTERIOR);
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