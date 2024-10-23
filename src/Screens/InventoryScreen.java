package Screens;

import Engine.GamePanel;
import Engine.GraphicsHandler;
import Level.Inventory;
import Utils.Point;
import Engine.Key;
import Engine.Keyboard;
import GameObject.Sprite;
import GameObject.SpriteSheet;
import Engine.ImageLoader;

public class InventoryScreen extends GamePanel{

    protected InventoryScreen inventoryScreen;
    protected Inventory inventory;
    protected GamePanel gamePanel;
    protected Sprite inventoryImage;
    protected GraphicsHandler graphicsHandler;
    
    //BufferedImage() = new BufferedImage("InventoryScreen.png")
    

    public InventoryScreen(GamePanel gamePanel){
        this.gamePanel = gamePanel;
        inventoryImage = new Sprite(ImageLoader.load("InventoryScreen.png")); 
    //    gamePanel = new GamePanel(ImageLoader.load("InventoryScreen.png"));

    }


    

    public void showInventory(){
            // graphicsHandler.drawImage("InventoryScreen.png", 2,2 ,500,150);

            if(Keyboard.isKeyDown(Key.I)){
                
            }
        }
    }
    

