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
import Game.ScreenCoordinator;

import java.util.HashMap;

public class CirculatingFan extends NPC {
    //public ScreenCoordinator screenCoordinator = new ScreenCoordinator();
    
    public CirculatingFan(int id, Point location, InventoryItems inventoryItems) {
        super(id, location.x, location.y, new SpriteSheet(ImageLoader.load("CirculatingFan.png"), 30, 30), "STAND_LEFT");
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

    //Makes the fan addable to the inventory
    @Override
    public void update(Player player) {
        super.update(player);

        if (Keyboard.isKeyDown(Key.E) && player.isNear(this, (int) (getWidth() * 1.5))) {
            setMapEntityStatus(MapEntityStatus.REMOVED);
            int quantity = 0;
        }
    }
    

    @Override
    public void draw(GraphicsHandler graphicsHandler) {
        super.draw(graphicsHandler);
    }
}