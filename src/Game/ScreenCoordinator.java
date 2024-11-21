package Game;

import Engine.DefaultScreen;
import Engine.GraphicsHandler;
import Engine.Key;
import Engine.Keyboard;
import Engine.Screen;
import Engine.TimeSwitch;
import Screens.CreditsScreen;
import Screens.DanaDormHeatScreen;
import Screens.DanaDormScreen;
import Screens.DanaOutdoorHeatScreen;
import Screens.DanaOutdoorScreen;
import Screens.DiningRoomHeatScreen;
import Screens.DiningRoomScreen;
import Screens.DiscoScreen;
import Screens.DormScreen;
import Screens.GameOverScreen;
import Screens.HeatDormScreen;
import Screens.HeatOutdoorScreen;
import Screens.HowToPlayScreen;
import Screens.JailScreen;
import Screens.MenuScreen;
import Screens.OutdoorScreen;
import Screens.VictorScreen;
import Utils.Point;

/*
 * Based on the current game state, this class determines which Screen should be shown
 * There can only be one "currentScreen", although screens can have "nested" screens
 */
public class ScreenCoordinator extends Screen {
	// currently shown Screen
	protected Screen currentScreen = new DefaultScreen();

	// keep track of gameState so ScreenCoordinator knows which Screen to show
	public GameState gameState;
	public GameState previousGameState;

	public static Key SWITCH_TO_REALITY = Key.W;
	public static Key SWITCH_TO_MEDIEVAL = Key.Q;

	public static Point savedPlayerPos;

	protected TimeSwitch timeSwitch = new TimeSwitch();

	protected boolean hasSwitched = false;
	protected boolean nextSwitch = false;

	private long lastSwitchTime;    
    private long randomDelay; 
    private boolean isDelaySet = false; 

	public ScreenCoordinator getScreenCoordinator(){
		return this;
	}

	public GameState getGameState() {
		return gameState;
	}

	public GameState getPreviousGameState() {
		return previousGameState;
	}

	// Other Screens can set the gameState of this class to force it to change the currentScreen
	public void setGameState(GameState gameState) {
		this.gameState = gameState;
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
					case CREDITS:
						currentScreen = new JailScreen(this);
						break;
					case HOWTOPLAY:
						currentScreen = new DiningRoomHeatScreen(this);
						break;
					case VICTOR:
						currentScreen = new VictorScreen(this);
						break;
					case DISCO:
						currentScreen = new DiscoScreen(this);
						break;
					case DININGROOM:
						currentScreen = new DiningRoomScreen(this);
						break;
					case DININGROOMHEAT:
						currentScreen = new DiningRoomHeatScreen(this);
						break;
					case JAIL:
						currentScreen = new JailScreen(this);
						break;
					case GAMEOVER:
						currentScreen = new GameOverScreen(this);
						break;
					
				}
				currentScreen.initialize();
			}
			previousGameState = gameState;

			// call the update method for the currentScreen
			currentScreen.update();
		} while (previousGameState != gameState);
	}




    
    
    public void switchWorld(ScreenCoordinator screenCoordinator){
		screenCoordinator = this;
		
		if (!isDelaySet) {
            randomDelay = (long) (Math.random() * 5000) + 2000; // Random delay between 2 to 7 seconds (2000ms to 7000ms)
            lastSwitchTime = System.currentTimeMillis();
            isDelaySet = true;
        }

		// if ((!nextSwitch)) {
		// 	randomDelay = (long)(Math.random()*5000) +3000;
		// 	lastSwitchTime = System.currentTimeMillis();
		// }

        long currentTime = System.currentTimeMillis();

		//if(Keyboard.isKeyDown(ScreenCoordinator.SWITCH_TO_REALITY)){
		/* 
			if(screenCoordinator.getGameState()==GameState.HEATDORM && hasSwitched == false){
				screenCoordinator.setGameState(GameState.DORM);
				hasSwitched = true;
				nextSwitch = true;
			}

			if(screenCoordinator.getGameState()==GameState.HEATDORMEXTERIOR && hasSwitched == false){
				screenCoordinator.setGameState(GameState.DORMEXTERIOR);
				hasSwitched = true;
				nextSwitch = true;
			}

			if(screenCoordinator.getGameState()==GameState.DANADORMHEAT && hasSwitched == false){
				screenCoordinator.setGameState(GameState.DANADORM);
				hasSwitched = true;
				nextSwitch = true;

			}

			if(screenCoordinator.getGameState()==GameState.DANADORMOUTDOORHEAT && hasSwitched == false){
				screenCoordinator.setGameState(GameState.DANADORMOUTDOOR);
				hasSwitched = true;
				nextSwitch = true;
			}
		//}*/

	if(!hasSwitched){
		if(Keyboard.isKeyDown(ScreenCoordinator.SWITCH_TO_MEDIEVAL) || (currentTime - lastSwitchTime > randomDelay)){
			System.out.println("Activated switch world");
			if(screenCoordinator.getGameState()==GameState.DORM && hasSwitched == false){
				screenCoordinator.setGameState(GameState.HEATDORM);
				//hasSwitched = true;
				// nextSwitch = true;
				// System.out.println(nextSwitch);
			}
			
			if(screenCoordinator.getGameState()==GameState.DORMEXTERIOR && hasSwitched == false){
				screenCoordinator.setGameState(GameState.HEATDORMEXTERIOR);
				//hasSwitched = true;
				// nextSwitch = true;
				// System.out.println(nextSwitch);
			}
			
			if(screenCoordinator.getGameState()==GameState.DANADORM && hasSwitched == false){
				screenCoordinator.setGameState(GameState.DANADORMHEAT);
				//hasSwitched = true;
				// nextSwitch = true;
				// System.out.println(nextSwitch);
				
			}
			
			if(screenCoordinator.getGameState()==GameState.DANADORMOUTDOOR && hasSwitched == false){
				screenCoordinator.setGameState(GameState.DANADORMOUTDOORHEAT);
				//hasSwitched = true;
				// nextSwitch = true;
				// System.out.println(nextSwitch);
			}
			
			hasSwitched = true;
			// if(){

			// }
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