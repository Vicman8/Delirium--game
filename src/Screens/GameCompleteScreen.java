

package Screens;

import Engine.*;
import Game.GameState;
import Game.ScreenCoordinator;
import Level.Map;
import Maps.GameCompleteMap;
import Maps.GameOverMap;
import Maps.MenuMap;
import SpriteFont.SpriteFont;

import java.awt.*;

// This is the class for the main menu screen
public class GameCompleteScreen extends Screen {
    protected ScreenCoordinator screenCoordinator;
    protected int currentGameOverItemHovered = 0; // current menu item being "hovered" over
    protected int menuItemSelected = -1;
    protected SpriteFont menu;
    protected SpriteFont congrats;
    protected Map background;
    protected int keyPressTimer;
    protected int pointerLocationX, pointerLocationY;
    protected KeyLocker keyLocker = new KeyLocker();

    public GameCompleteScreen(ScreenCoordinator screenCoordinator) {
        this.screenCoordinator = screenCoordinator;
    }

    @Override
    public void initialize() {
        menu = new SpriteFont("RETURN TO MENU", 450, 375, "Algerian", 30, new Color(49, 207, 240));
        menu.setOutlineColor(Color.black);
        menu.setOutlineThickness(3);
        congrats = new SpriteFont("CONGRATS! YOU WIN! YOU GOT YOUR AIR CONDITIONING BACK!", 100, 250, "Algerian", 20, new Color(49, 207, 240));
        congrats.setOutlineColor(Color.black);
        congrats.setOutlineThickness(3);
        background = new GameCompleteMap();
        background.setAdjustCamera(false);
        keyPressTimer = 0;
        menuItemSelected = 0;
        keyLocker.lockKey(Key.SPACE);
    }

    public void update() {
        // update background map (to play tile animations)
        background.update(null);

        // if down or up is pressed, change menu item "hovered" over (blue square in front of text will move along with currentMenuItemHovered changing)
        if (Keyboard.isKeyDown(Key.DOWN) && keyPressTimer == 0) {
            keyPressTimer = 14;
            currentGameOverItemHovered++;
        } else if (Keyboard.isKeyDown(Key.UP) && keyPressTimer == 0) {
            keyPressTimer = 14;
            currentGameOverItemHovered--;
        } else {
            if (keyPressTimer > 0) {
                keyPressTimer--;
            }
        }

        // if down is pressed on last menu item or up is pressed on first menu item, "loop" the selection back around to the beginning/end
        if (currentGameOverItemHovered > 1) {
            currentGameOverItemHovered = 0;
        } else if (currentGameOverItemHovered < 0) {
            currentGameOverItemHovered = 1;
        }

        // sets location for blue square in front of text (pointerLocation) and also sets color of spritefont text based on which menu item is being hovered
        if (currentGameOverItemHovered == 0) {
            menu.setColor(new Color(255, 215, 0));
            pointerLocationX = 390;
            pointerLocationY = 382;
        } else if (currentGameOverItemHovered == 1) {
            menu.setColor(new Color(255, 215, 0));
            pointerLocationX = 390;
            pointerLocationY = 382;
        }

        // if space is pressed on menu item, change to appropriate screen based on which menu item was chosen
        if (Keyboard.isKeyUp(Key.SPACE)) {
            keyLocker.unlockKey(Key.SPACE);
        }
        if (!keyLocker.isKeyLocked(Key.SPACE) && Keyboard.isKeyDown(Key.SPACE)) {
            menuItemSelected = currentGameOverItemHovered;
            if (menuItemSelected == 0) {
                screenCoordinator.setGameState(GameState.MENU);
            } else if (menuItemSelected == 1) {
                screenCoordinator.setGameState(GameState.MENU);
            }
        }
    }
    

    public void draw(GraphicsHandler graphicsHandler) {
        background.draw(graphicsHandler);
        menu.draw(graphicsHandler);
        congrats.draw(graphicsHandler);
        graphicsHandler.drawFilledRectangleWithBorder(pointerLocationX, pointerLocationY, 20, 20, new Color(49, 207, 240), Color.black, 2);
    }
}