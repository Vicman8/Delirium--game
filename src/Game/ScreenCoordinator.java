package Game;

import Engine.DefaultScreen;
import Engine.GraphicsHandler;
import Engine.Key;
import Engine.Keyboard;
import Engine.Screen;
import Level.NPC;
import Level.Player;
import Maps.DanaDorm;
import Maps.DanaDormHeat;
import Screens.CreditsScreen;
import Screens.DanaDormHeatScreen;
import Screens.DanaDormScreen;
import Screens.DanaOutdoorHeatScreen;
import Screens.DanaOutdoorScreen;
import Screens.DormScreen;
import Screens.HeatDormScreen;
import Screens.HeatOutdoorScreen;
import Screens.HowToPlayScreen;
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
	public GameState gameState;
	public GameState previousGameState;

	public static Key SWITCH_TO_REALITY = Key.W;
	public static Key SWITCH_TO_MEDIEVAL = Key.Q;
	//public static Key OPEN_INVENTORY = Key.I;

	public static Point savedPlayerPos;

	protected Player player;

	//protected GetWidth getWidth;
	protected NPC fan;

	protected boolean delay = false;
	
	protected long lastSwitchTime;
	protected long randomDelay; 
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
						
					// case INVENTORY:
					// 	currentScreen = new InventoryScreen(this);
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
						currentScreen = new CreditsScreen(this);
						break;
					case HOWTOPLAY:
						currentScreen = new HowToPlayScreen(this);
						break;
				}
				currentScreen.initialize();
			}
			previousGameState = gameState;

			// call the update method for the currentScreen
			currentScreen.update();
		} while (previousGameState != gameState);
	}

	// public void inventory(ScreenCoordinator screenCoordinator){
	// 	screenCoordinator = this;
	// 	if(Keyboard.isKeyDown(ScreenCoordinator.OPEN_INVENTORY)){

	// 	}
	// }
    
    public void switchWorld(ScreenCoordinator screenCoordinator){    
		Math.random();
		screenCoordinator = this;
		boolean hasSwitched = false;
		this.player = player;
		//fan = new fan();
		 //int getWidth = getWidth;

		if(!delay){
			randomDelay = (long) (Math.random()*5000)+2000;
			System.out.println(randomDelay);
			lastSwitchTime = System.currentTimeMillis();
			delay = true;
		}


		


		long currentTime = System.currentTimeMillis();
/*&& Keyboard.isKeyDown(Key.E) && fan.isNear(fan, (int) (getWidth() * 1.5))*/
		if(/*player.touching(fan.getBounds()) && */Keyboard.isKeyDown(ScreenCoordinator.SWITCH_TO_REALITY)  ){
			if(screenCoordinator.getGameState()==GameState.HEATDORM && hasSwitched == false){
				screenCoordinator.setGameState(GameState.DORM);
				hasSwitched = true;
			}

			if(screenCoordinator.getGameState()==GameState.HEATDORMEXTERIOR && hasSwitched == false){
				screenCoordinator.setGameState(GameState.DORMEXTERIOR);
				hasSwitched = true;
			}

			if(screenCoordinator.getGameState()==GameState.DANADORMHEAT && hasSwitched == false){
				screenCoordinator.setGameState(GameState.DANADORM);
				hasSwitched = true;
			}

			if(screenCoordinator.getGameState()==GameState.DANADORMOUTDOORHEAT && hasSwitched == false){
				screenCoordinator.setGameState(GameState.DANADORMOUTDOOR);
				hasSwitched = true;
			}
		}

		if(Keyboard.isKeyDown(ScreenCoordinator.SWITCH_TO_MEDIEVAL) || (currentTime - lastSwitchTime > randomDelay) ){
			if(screenCoordinator.getGameState()==GameState.DORM && hasSwitched == false ){
				screenCoordinator.setGameState(GameState.HEATDORM);
				hasSwitched = true;
			}
			


			if(screenCoordinator.getGameState()==GameState.DORMEXTERIOR && hasSwitched == false){
				screenCoordinator.setGameState(GameState.HEATDORMEXTERIOR);
				hasSwitched = true;
			}

			if(screenCoordinator.getGameState()==GameState.DANADORM && hasSwitched == false){
				screenCoordinator.setGameState(GameState.DANADORMHEAT);
				hasSwitched = true;
			}

			if(screenCoordinator.getGameState()==GameState.DANADORMOUTDOOR && hasSwitched == false){
				screenCoordinator.setGameState(GameState.DANADORMOUTDOORHEAT);
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