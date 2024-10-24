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
    GraphicsHandler graphicsHandler;
    
    //BufferedImage() = new BufferedImage("InventoryScreen.png")
    

    public InventoryScreen(){
       // super(new SpriteSheet(ImageLoader.load("InventoryScreen.png"), 16, 16), x, y);
        this.gamePanel = gamePanel;
        //inventoryImage = new Sprite(ImageLoader.load("InventoryScreen.png")); 
    //    gamePanel = new GamePanel(ImageLoader.load("InventoryScreen.png"));

    }


    

    public void showInventoryScreen(GraphicsHandler graphicsHandler){
            // graphicsHandler.drawImage("InventoryScreen.png", 2,2 ,500,150);

             if(Keyboard.isKeyDown(Key.I)){
                System.out.println("Inventory");
                graphicsHandler.drawImage(ImageLoader.load("InventoryScreen.png"), getWidth(), getHeight());
                
            }
        }
    }
    

