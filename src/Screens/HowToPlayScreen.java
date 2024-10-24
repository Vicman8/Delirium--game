package Screens;

import Engine.*;
import Game.GameState;
import Game.ScreenCoordinator;
import Level.Map;
import Maps.MenuMap;
import SpriteFont.SpriteFont;

import java.awt.*;

// This class is for the credits screen
public class HowToPlayScreen extends Screen {
    protected ScreenCoordinator screenCoordinator;
    protected Map background;
    protected KeyLocker keyLocker = new KeyLocker();
    protected SpriteFont creditsLabel;
    protected SpriteFont createdByLabel;
    protected SpriteFont createdByLabel2;
    protected SpriteFont createdByLabel3;
    protected SpriteFont createdByLabel4;
    protected SpriteFont createdByLabel5;
    protected SpriteFont returnInstructionsLabel;

    public HowToPlayScreen(ScreenCoordinator screenCoordinator) {
        this.screenCoordinator = screenCoordinator;
    }

    @Override
    public void initialize() {
        // setup graphics on screen (background map, spritefont text)
        background = new MenuMap();
        background.setAdjustCamera(false);
        creditsLabel = new SpriteFont("In this short demo of Medievirium, your goal is to locate 1 of the AC parts", 130, 150, "Times New Roman", 20, Color.white);
        createdByLabel = new SpriteFont("required to create the AC unit needed to cool down your dorm room", 130, 200, "Times New Roman", 20, Color.white);
        createdByLabel2 = new SpriteFont("Use the arrow keys to move and the space button to interact with people/objects", 130, 250, "Times New Roman", 20, Color.white);
        createdByLabel3 = new SpriteFont("Use the I button to bring up the inventory, but that isn't used much in this demo", 130, 300, "Times New Roman", 20, Color.white);
        createdByLabel4 = new SpriteFont("Hint: The AC part can be found held by someone in Dana", 130, 450, "Times New Roman", 20, Color.white);
        createdByLabel5 = new SpriteFont("Dana is accessed by going to the left once out of your dorm", 130, 500, "Times New Roman", 20, Color.white);
        returnInstructionsLabel = new SpriteFont("Press Space to return to the menu", 0, 532, "Times New Roman", 30, Color.white);
        keyLocker.lockKey(Key.SPACE);
    }

    public void update() {
        background.update(null);

        if (Keyboard.isKeyUp(Key.SPACE)) {
            keyLocker.unlockKey(Key.SPACE);
        }

        // if space is pressed, go back to main menu
        if (!keyLocker.isKeyLocked(Key.SPACE) && Keyboard.isKeyDown(Key.SPACE)) {
            screenCoordinator.setGameState(GameState.MENU);
        }
    }

    public void draw(GraphicsHandler graphicsHandler) {
        background.draw(graphicsHandler);
        creditsLabel.draw(graphicsHandler);
        createdByLabel.draw(graphicsHandler);
        createdByLabel2.draw(graphicsHandler);
        createdByLabel3.draw(graphicsHandler);
        createdByLabel4.draw(graphicsHandler);
        createdByLabel5.draw(graphicsHandler);
        returnInstructionsLabel.draw(graphicsHandler);
    }
}
