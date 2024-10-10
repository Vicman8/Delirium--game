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
import Level.Inventory;
import Level.MapEntityStatus;
import Level.NPC;
<<<<<<< HEAD
import Level.Player;
=======
import Game.ScreenCoordinator;
>>>>>>> 4cb609805493e00c95acd5e3ee739a85fc313fc6

import java.util.HashMap;

public class Fan extends NPC {
    //public ScreenCoordinator screenCoordinator = new ScreenCoordinator();
    
    public Fan(int id, Point location/*, ScreenCoordinator screenCoordinator*/) {
        super(id, location.x, location.y, new SpriteSheet(ImageLoader.load("Fan1.png"), 30, 30), "STAND_LEFT");
        //this.screenCoordinator = screenCoordinator;
    }

    @Override
    public HashMap<String, Frame[]> loadAnimations(SpriteSheet spriteSheet) {
        return new HashMap<String, Frame[]>() {{
            put("STAND_LEFT", new Frame[] {
                    new FrameBuilder(spriteSheet.getSprite(0, 0))
                            .withScale(3)
                            .withBounds(7, 13, 11, 7)
                            .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                            .build()
            });
            put("STAND_RIGHT", new Frame[] {
                   new FrameBuilder(spriteSheet.getSprite(0, 0))
                           .withScale(3)
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
            Inventory.addItem("Fan", + quantity);
            quantity = quantity  + 1;
        }
    }

    @Override
    public void draw(GraphicsHandler graphicsHandler) {
        super.draw(graphicsHandler);
    }
}