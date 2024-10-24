package Engine;

import GameObject.Rectangle;
import Level.Inventory;
import Screens.InventoryScreen;
import SpriteFont.SpriteFont;
import Utils.Colors;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/*
 * This is where the game loop process and render back buffer is setup
 */
public class GamePanel extends JPanel {
	// loads Screens on to the JPanel
	// each screen has its own update and draw methods defined to handle a "section" of the game.
	private ScreenManager screenManager;

	// used to draw graphics to the panel
	private GraphicsHandler graphicsHandler;
	protected InventoryScreen inventory;

	private boolean isGamePaused = false;
	protected boolean isInInventory = false;
	private SpriteFont pauseLabel;
	private KeyLocker keyLocker = new KeyLocker();
	private final Key pauseKey = Key.P;
	private Thread gameLoopProcess;

	private Key showFPSKey = Key.G;
	private SpriteFont fpsDisplayLabel;
	private boolean showFPS = false;
	private int currentFPS;
	private boolean doPaint;

	protected SpriteFont creditsLabel;
    protected SpriteFont createdByLabel;
    protected SpriteFont createdByLabel2;
    protected SpriteFont createdByLabel3;
    protected SpriteFont createdByLabel4;
    protected SpriteFont createdByLabel5;

	// The JPanel and various important class instances are setup here
	public GamePanel() {
		super();
		this.setDoubleBuffered(true);

		// attaches Keyboard class's keyListener to this JPanel
		this.addKeyListener(Keyboard.getKeyListener());

		graphicsHandler = new GraphicsHandler();

		screenManager = new ScreenManager();

		pauseLabel = new SpriteFont("The game is now paused!", 100, 100, "Times New Roman", 20, Color.white);
		createdByLabel2 = new SpriteFont("Use the arrow keys to move and the space button to interact with people/objects", 100, 250, "Times New Roman", 20, Color.white);
        createdByLabel3 = new SpriteFont("Use the I button to bring up the inventory, but that isn't used much in this demo", 100, 300, "Times New Roman", 20, Color.white);
        createdByLabel4 = new SpriteFont("Hint: The AC part can be found held by someone in Dana", 100, 450, "Times New Roman", 20, Color.white);
        createdByLabel5 = new SpriteFont("Dana is accessed by going to the left once out of your dorm", 100, 500, "Times New Roman", 20, Color.white);

		fpsDisplayLabel = new SpriteFont("FPS", 4, 3, "Arial", 12, Color.black);

		currentFPS = Config.TARGET_FPS;
		//inventory = new InventoryScreen();

		// this game loop code will run in a separate thread from the rest of the program
		// will continually update the game's logic and repaint the game's graphics
		GameLoop gameLoop = new GameLoop(this);
		gameLoopProcess = new Thread(gameLoop.getGameLoopProcess());
	}

	// this is called later after instantiation, and will initialize screenManager
	public void setupGame() {
		setBackground(Colors.CORNFLOWER_BLUE);
		screenManager.initialize(new Rectangle(getX(), getY(), getWidth(), getHeight()));
	}

	// this starts the timer (the game loop is started here)
	public void startGame() {
		gameLoopProcess.start();
	}

	public ScreenManager getScreenManager() {
		return screenManager;
	}

	public void setCurrentFPS(int currentFPS) {
		this.currentFPS = currentFPS;
	}

	public void setDoPaint(boolean doPaint) {
		this.doPaint = doPaint;
	}

	public void update() {
		updatePauseState();
		updateShowFPSState();

		if (!isGamePaused) {
			screenManager.update();
		}

		if(Keyboard.isKeyDown(Key.I) && !keyLocker.isKeyLocked(Key.I)){
			keyLocker.lockKey(Key.I);

			isInInventory = !isInInventory;
		}

		if (Keyboard.isKeyUp(Key.I)) {
			keyLocker.unlockKey(Key.I);
		}
	}

	private void updatePauseState() {
		if (Keyboard.isKeyDown(pauseKey) && !keyLocker.isKeyLocked(pauseKey)) {
			isGamePaused = !isGamePaused;
			keyLocker.lockKey(pauseKey);
		}

		if (Keyboard.isKeyUp(pauseKey)) {
			keyLocker.unlockKey(pauseKey);
		}
	}

	private void updateShowFPSState() {
		if (Keyboard.isKeyDown(showFPSKey) && !keyLocker.isKeyLocked(showFPSKey)) {
			showFPS = !showFPS;
			keyLocker.lockKey(showFPSKey);
		}

		if (Keyboard.isKeyUp(showFPSKey)) {
			keyLocker.unlockKey(showFPSKey);
		}

		fpsDisplayLabel.setText("FPS: " + currentFPS);
	}

	public void draw() {		
		
		//InventoryScreen() = new BufferedImage();
		// draw current game state
		screenManager.draw(graphicsHandler);

		// if game is paused, draw pause gfx over Screen gfx
		if (isGamePaused) {
			pauseLabel.draw(graphicsHandler);
			createdByLabel2.draw(graphicsHandler);
			createdByLabel3.draw(graphicsHandler);
			createdByLabel4.draw(graphicsHandler);
			createdByLabel5.draw(graphicsHandler);
			graphicsHandler.drawFilledRectangle(0, 0, ScreenManager.getScreenWidth(), ScreenManager.getScreenHeight(), new Color(0, 0, 0, 100));
		}

		//Opens the invetory screen and shows the inventory
		if (isInInventory) {
			//graphicsHandler.drawFilledRectangle(ScreenManager.getScreenWidth() / 2 - 250, ScreenManager.getScreenHeight() / 2 - 75, 500, 150, new Color(255, 255, 255, 200));
			//graphicsHandler.drawImage(inventory, ALLBITS, ABORT);
			//graphicsHandler.drawImage("InventoryScreen.png", ALLBITS, ABORT, WIDTH, HEIGHT);
			//System.out.println(showInventory);
		}

		if (showFPS) {
			fpsDisplayLabel.draw(graphicsHandler);
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (doPaint) {
			// every repaint call will schedule this method to be called
			// when called, it will setup the graphics handler and then call this class's draw method
			graphicsHandler.setGraphics((Graphics2D) g);
			draw();
		}
	}
}
