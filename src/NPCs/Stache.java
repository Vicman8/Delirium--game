package NPCs;

import Builders.FrameBuilder;
import Engine.GraphicsHandler;
import Engine.ImageLoader;
import Engine.Key;
import Engine.Keyboard;
import GameObject.Frame;
import GameObject.ImageEffect;
import GameObject.SpriteSheet;
import Level.MapEntityStatus;
import Level.NPC;
import Level.Player;
import Utils.Point;

import java.util.HashMap;

// This class is for the walrus NPC
public class Stache extends NPC {

    public Stache(int id, Point location) {
        super(id, location.x, location.y, new SpriteSheet(ImageLoader.load("NPCStache.png"), 30, 30), "STAND_LEFT");
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
        }};
    }

 @Override
    public void update(Player player) {
        super.update(player);

        if (Keyboard.isKeyDown(Key.E) && player.isNear(this, (int) (getWidth() * 1.5))) {
            setMapEntityStatus(MapEntityStatus.REMOVED);
            int quantity = 0;
            quantity = quantity  + 1;
        }
    }

    @Override
    public void draw(GraphicsHandler graphicsHandler) {
        super.draw(graphicsHandler);
    }
}