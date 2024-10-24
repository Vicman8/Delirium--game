package Game;

import Engine.DefaultScreen;
import Engine.GraphicsHandler;
import Engine.Key;
import Engine.Keyboard;
import Engine.Screen;
import Maps.DanaDorm;
import Maps.DanaDormHeat;
import Screens.DanaDormHeatScreen;
import Screens.DanaDormScreen;
import Screens.DanaOutdoorHeatScreen;
import Screens.DanaOutdoorScreen;
import Screens.DormScreen;
import Screens.HeatDormScreen;
import Screens.HeatOutdoorScreen;
import Screens.MenuScreen;
import Screens.OutdoorScreen;
import Utils.Point;

/*
 * Based on the current game state, this class determines which Screen should be shown
 * There can only be one "currentScreen", although screens can have "nested" screens
 */
public class ScreenCoordinator extends Screen {
	// currently shown Screen
	protected Screen currentScreen = new DefaultScreen();

	// keep track of gameState so ScreenCoordinator knows which Screen to show
	public static GameState gameState;
	public GameState previousGameState;

	public static Key SWITCH_TO_REALITY = Key.W;
	public static Key SWITCH_TO_MEDIEVAL = Key.Q;

	public static Point savedPlayerPos;

	public static GameState getGameState() {
		return gameState;
	}

	public GameState getPreviousGameState() {
		return previousGameState;
	}

	// Other Screens can set the gameState of this class to force it to change the currentScreen
	public static void setGameState(GameState newGameState) {
		gameState = newGameState;
	}

	@Override
	public void initialize() {
		// start game off with Menu Screen
		gameState = GameState.MENU;
	}

	@Override
	public void update() {
		do {
			// if previousGameState does not equal gameState, it means there was a change in gameState
			// this triggers ScreenCoordinator to bring up a new Screen based on what the gameState is
			if (previousGameState != gameState) {
				switch(gameState) {
					case MENU:
						System.out.println("Game state is now "+gameState);
						currentScreen = new MenuScreen(this);
						break;
					case DORM:
						System.out.println("Game state is now "+gameState);	
						currentScreen = new DormScreen(this);
						break;
					case DORMEXTERIOR:
						currentScreen = new OutdoorScreen(this);
						break;
					case HEATDORM:
						System.out.println("Game state is now "+gameState);
						currentScreen = new HeatDormScreen(this);
						break;
					case HEATDORMEXTERIOR:
						currentScreen = new HeatOutdoorScreen(this);
						break;
					case DANADORM:
						currentScreen = new DanaDormScreen(this);
						break;
					case DANADORMHEAT:
						currentScreen = new DanaDormHeatScreen(this);
						break;
					case DANADORMOUTDOOR:
						currentScreen = new DanaOutdoorScreen(this);
						break;
					case DANADORMOUTDOORHEAT:
						currentScreen = new DanaOutdoorHeatScreen(this);
						break;
				}
				currentScreen.initialize();
			}
			previousGameState = gameState;

			// call the update method for the currentScreen
			currentScreen.update();
		} while (previousGameState != gameState);
	}
    
    public static void switchWorld(/*ScreenCoordinator screenCoordinator*/){    
		//screenCoordinator = this;
		boolean hasSwitched = false;

		if(Keyboard.isKeyDown(ScreenCoordinator.SWITCH_TO_REALITY)){
			if(ScreenCoordinator.getGameState()==GameState.HEATDORM && hasSwitched == false){
				ScreenCoordinator.setGameState(GameState.DORM);
				hasSwitched = true;
			}

			if(ScreenCoordinator.getGameState()==GameState.HEATDORMEXTERIOR && hasSwitched == false){
				ScreenCoordinator.setGameState(GameState.DORMEXTERIOR);
				hasSwitched = true;
			}

			if(ScreenCoordinator.getGameState()==GameState.DANADORMHEAT && hasSwitched == false){
				ScreenCoordinator.setGameState(GameState.DANADORM);
				hasSwitched = true;
			}

			if(ScreenCoordinator.getGameState()==GameState.DANADORMOUTDOORHEAT && hasSwitched == false){
				ScreenCoordinator.setGameState(GameState.DANADORMOUTDOOR);
				hasSwitched = true;
			}
		}

		if(Keyboard.isKeyDown(ScreenCoordinator.SWITCH_TO_MEDIEVAL)){
			if(ScreenCoordinator.getGameState()==GameState.DORM && hasSwitched == false){
				ScreenCoordinator.setGameState(GameState.HEATDORM);
				hasSwitched = true;
			}
			
			if(ScreenCoordinator.getGameState()==GameState.DORMEXTERIOR && hasSwitched == false){
				ScreenCoordinator.setGameState(GameState.HEATDORMEXTERIOR);
				hasSwitched = true;
			}

			if(ScreenCoordinator.getGameState()==GameState.DANADORM && hasSwitched == false){
				ScreenCoordinator.setGameState(GameState.DANADORMHEAT);
				hasSwitched = true;
			}

			if(ScreenCoordinator.getGameState()==GameState.DANADORMOUTDOOR && hasSwitched == false){
				ScreenCoordinator.setGameState(GameState.DANADORMOUTDOORHEAT);
				hasSwitched = true;
			}
		}
	}

	//updates the static variable
	public static void setSavedPlayerPosition(int playerX, int playerY){
		savedPlayerPos = new Point(playerX, playerX);
	}

	@Override
	public void draw(GraphicsHandler graphicsHandler) {
		// call the draw method for the currentScreen
		currentScreen.draw(graphicsHandler);
	}
}