package Screens;

import Engine.GamePanel;
import Engine.GraphicsHandler;
import Level.Inventory;
import Utils.Point;
import Engine.Key;
import Engine.KeyLocker;
import Engine.Keyboard;
import Engine.Screen;
import Game.ScreenCoordinator;
import GameObject.Sprite;
import GameObject.SpriteSheet;
import Engine.ImageLoader;

public class InventoryScreen extends Screen {

    protected Inventory inventory;
    protected GamePanel gamePanel;
    protected Sprite inventoryImage;
    protected KeyLocker keyLocker;
    protected boolean isInventory = false;
    // BufferedImage() = new BufferedImage("InventoryScreen.png")

    public InventoryScreen(ScreenCoordinator screenCoordinator) {
        this.keyLocker = new KeyLocker();
    }

    @Override
    public void initialize() {
    }

    @Override
    public void update() {
        if (Keyboard.isKeyDown(Key.I) && !keyLocker.isKeyLocked(Key.I)) {
            isInventory = !isInventory;
            keyLocker.lockKey(Key.I);
        }

        if (Keyboard.isKeyUp(Key.I) && keyLocker.isKeyLocked(Key.I)) {
            keyLocker.unlockKey(Key.I);
        }
    }

    @Override
    public void draw(GraphicsHandler graphicsHandler) {
        if (isInventory) {
            graphicsHandler.drawImage(ImageLoader.load("InventoryScreen.png"), 1000, 500);
        }
    }
}
