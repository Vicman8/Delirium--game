package NPCs;


import Builders.FrameBuilder;
import Engine.GraphicsHandler;
import Engine.ImageLoader;
import GameObject.Frame;
import GameObject.ImageEffect;
import GameObject.SpriteSheet;
import Level.NPC;
import Utils.Point;

import java.util.HashMap;

public class TheThim extends NPC{

    public TheThim(int id, Point location) {
        super(id, location.x, location.y, new SpriteSheet(ImageLoader.load("TheThimSpriteSheet_1.png"), 29, 29), "STAND_RIGHT");
    }

    @Override
    public HashMap<String, Frame[]> loadAnimations(SpriteSheet spriteSheet) {
        return new HashMap<String, Frame[]>() {{
            put("STAND_LEFT", new Frame[] {
                    new FrameBuilder(spriteSheet.getSprite(0, 0))
                            .withScale(3)
                            .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                            .build()
            });
            put("STAND_RIGHT", new Frame[] {
                   new FrameBuilder(spriteSheet.getSprite(0, 0), 20)
                           .withScale(3)
                           .build(),
                           new FrameBuilder(spriteSheet.getSprite(0, 1), 20)
                           .withScale(3)
                           .build(),
                           new FrameBuilder(spriteSheet.getSprite(0, 0), 20)
                           .withScale(3)
                           .build(),
           });
           put("WALK_LEFT", new Frame[] {
            new FrameBuilder(spriteSheet.getSprite(0, 3), 20)
                           .withScale(3)
                           .build(),
                           new FrameBuilder(spriteSheet.getSprite(1, 1), 20)
                           .withScale(3)
                           .build(),
                           new FrameBuilder(spriteSheet.getSprite(1, 2), 20)
                           .withScale(3)
                           .build(),
                           new FrameBuilder(spriteSheet.getSprite(1, 3),200)
                           .withScale(3)
                           .build()
    });
    put("WALK_RIGHT", new Frame[] {
        new FrameBuilder(spriteSheet.getSprite(0, 3), 20)
                           .withScale(3)
                           .build(),
                           new FrameBuilder(spriteSheet.getSprite(1, 1), 20)
                           .withScale(3)
                           .build(),
                           new FrameBuilder(spriteSheet.getSprite(1, 2), 20)
                           .withScale(3)
                           .build(),
                           new FrameBuilder(spriteSheet.getSprite(3, 1), 20)
                           .withScale(3)
                           .build()
   });
        }};
    }

    @Override
    public void draw(GraphicsHandler graphicsHandler) {
        super.draw(graphicsHandler);
    }

}
