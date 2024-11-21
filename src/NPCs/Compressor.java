package NPCs;

import Builders.FrameBuilder;
import Engine.GraphicsHandler;
import Engine.ImageLoader;
import Engine.Key;
import Engine.Keyboard;
import GameObject.Frame;
import GameObject.ImageEffect;
import GameObject.SpriteSheet;
import Utils.Point;
import Level.InventoryItems;
import Level.MapEntityStatus;
import Level.NPC;
import Level.Player;
import Scripts.ACParts.CompressorScript;
import Game.ScreenCoordinator;

import java.util.HashMap;

public class Compressor extends NPC {
    //public ScreenCoordinator screenCoordinator = new ScreenCoordinator();
    
    public Compressor(int id, Point location) {
        super(id, location.x, location.y, new SpriteSheet(ImageLoader.load("Compressor_1.png"), 30, 30), "STAND_LEFT");
        //this.screenCoordinator = screenCoordinator;
    }

    @Override
    public HashMap<String, Frame[]> loadAnimations(SpriteSheet spriteSheet) {
        return new HashMap<String, Frame[]>() {{
            put("STAND_LEFT", new Frame[] {
                    new FrameBuilder(spriteSheet.getSprite(0, 0))
                            .withScale(2)
                            .withBounds(7, 13, 11, 7)
                            .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                            .build()
            });
            put("STAND_RIGHT", new Frame[] {
                   new FrameBuilder(spriteSheet.getSprite(0, 0))
                           .withScale(2)
                           .withBounds(7, 13, 11, 7)
                           .build()
           });
           //screenCoordinator.switchWorld(screenCoordinator);
        }};
    }


    public InventoryItems toInventoryItem(){
        Point location = new Point((int)this.getX(),(int)this.getY());
        Frame frame = this.getCurrentFrame();
        return new InventoryItems(location, frame, this);
    }
    //Makes the fan addable to the inventory
    @Override
    public void update(Player player) {
        super.update(player);

        double distance = Math.sqrt(Math.pow(this.getX() - player.getX(), 2) + Math.pow(this.getY() - player.getY(), 2));
        if (distance <= 55 && Keyboard.isKeyDown(Key.E)) {
            this.setInteractScript(new CompressorScript());
            System.out.println("Interact key pressed for Compressor with ID: " + this.id);
            InventoryItems item = InventoryItems.fromNPC(this);
            System.out.println("InventoryItems created: " + item);
            InventoryItems.addToInventory(item);
            InventoryItems.printInventory();
            this.setMapEntityStatus(MapEntityStatus.REMOVED);
            System.out.println("Compressor with ID: " + this.id + " set to REMOVED");
        }
    }
    

    @Override
    public void draw(GraphicsHandler graphicsHandler) {
        super.draw(graphicsHandler);
    }
}