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
import Level.Player;
import Game.GameState;
import Game.ScreenCoordinator;

import java.util.HashMap;

public class WaterBottle extends NPC {
    //public ScreenCoordinator screenCoordinator = new ScreenCoordinator();
    

    protected ScreenCoordinator screenCoordinator;

    public WaterBottle(int id, Point location/*, ScreenCoordinator screenCoordinator*/) {
        super(id, location.x, location.y, new SpriteSheet(ImageLoader.load("WaterBottle.png"), 20, 20), "STAND_LEFT");
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

        if (Keyboard.isKeyDown(Key.T) && player.isNear(this, (int) (getWidth() * 1.5))) {
            //setMap(GameState.DORM););
            // int quantity = 0;
            // Inventory.addItem("Fan", + quantity);
            // quantity = quantity  + 1;
        }
    }

    @Override
    public void draw(GraphicsHandler graphicsHandler) {
        super.draw(graphicsHandler);
    }
}