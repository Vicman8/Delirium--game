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

public class THEVICMANM extends NPC{

    public THEVICMANM(int id, Point location) {
        super(id, location.x, location.y, new SpriteSheet(ImageLoader.load("VictorThrowingUpAnimation_1.png"), 29, 29), "STAND_LEFT");
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
                   new FrameBuilder(spriteSheet.getSprite(0, 0))
                           .withScale(3)
                           .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                           .build()
           });

           put("WALK_LEFT", new Frame[] {
            new FrameBuilder(spriteSheet.getSprite(0, 1), 40)
                    .withScale(3)
                    .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                    .build(),
                    new FrameBuilder(spriteSheet.getSprite(0, 2), 40)
                    .withScale(3)
                    .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                    .build(),
                    new FrameBuilder(spriteSheet.getSprite(0, 3), 40)
                    .withScale(3)
                    .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                    .build(),
                    new FrameBuilder(spriteSheet.getSprite(1, 0), 40)
                    .withScale(3)
                    .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                    .build(),
                    new FrameBuilder(spriteSheet.getSprite(1, 1), 40)
                    .withScale(3)
                    .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                    .build(),
                    new FrameBuilder(spriteSheet.getSprite(1, 2), 40)
                    .withScale(3)
                    .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                    .build(),
                    new FrameBuilder(spriteSheet.getSprite(1, 3), 40)
                    .withScale(3)
                    .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                    .build(),
                    new FrameBuilder(spriteSheet.getSprite(2, 0), 40)
                    .withScale(3)
                    .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                    .build(),
                    new FrameBuilder(spriteSheet.getSprite(2, 1), 40)
                    .withScale(3)
                    .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                    .build(),
                    new FrameBuilder(spriteSheet.getSprite(2, 2), 40)
                    .withScale(3)
                    .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                    .build(),
                    new FrameBuilder(spriteSheet.getSprite(2, 3), 40)
                    .withScale(3)
                    .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                    .build(),
                    new FrameBuilder(spriteSheet.getSprite(3, 0), 40)
                    .withScale(3)
                    .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                    .build(),
                    new FrameBuilder(spriteSheet.getSprite(3, 1), 40)
                    .withScale(3)
                    .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                    .build(),
                    new FrameBuilder(spriteSheet.getSprite(3, 2), 40)
                    .withScale(3)
                    .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                    .build(),
                    new FrameBuilder(spriteSheet.getSprite(3, 3), 40)
                    .withScale(3)
                    .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                    .build(),
                    new FrameBuilder(spriteSheet.getSprite(4, 0), 40)
                    .withScale(3)
                    .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                    .build(),
                    new FrameBuilder(spriteSheet.getSprite(4, 1), 40)
                    .withScale(3)
                    .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                    .build(),
                    new FrameBuilder(spriteSheet.getSprite(4, 2), 40)
                    .withScale(3)
                    .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                    .build()
            });

            put("WALK_RIGHT", new Frame[] {
                new FrameBuilder(spriteSheet.getSprite(0, 1), 40)
                        .withScale(3)
                        .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                        .build(),
                        new FrameBuilder(spriteSheet.getSprite(0, 2), 40)
                        .withScale(3)
                        .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                        .build(),
                        new FrameBuilder(spriteSheet.getSprite(0, 3), 40)
                        .withScale(3)
                        .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                        .build(),
                        new FrameBuilder(spriteSheet.getSprite(1, 0), 40)
                        .withScale(3)
                        .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                        .build(),
                        new FrameBuilder(spriteSheet.getSprite(1, 1), 40)
                        .withScale(3)
                        .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                        .build(),
                        new FrameBuilder(spriteSheet.getSprite(1, 2), 40)
                        .withScale(3)
                        .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                        .build(),
                        new FrameBuilder(spriteSheet.getSprite(1, 3), 40)
                        .withScale(3)
                        .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                        .build(),
                        new FrameBuilder(spriteSheet.getSprite(2, 0), 40)
                        .withScale(3)
                        .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                        .build(),
                        new FrameBuilder(spriteSheet.getSprite(2, 1), 40)
                        .withScale(3)
                        .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                        .build(),
                        new FrameBuilder(spriteSheet.getSprite(2, 2), 40)
                        .withScale(3)
                        .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                        .build(),
                        new FrameBuilder(spriteSheet.getSprite(2, 3), 40)
                        .withScale(3)
                        .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                        .build(),
                        new FrameBuilder(spriteSheet.getSprite(3, 0), 40)
                        .withScale(3)
                        .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                        .build(),
                        new FrameBuilder(spriteSheet.getSprite(3, 1), 40)
                        .withScale(3)
                        .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                        .build(),
                        new FrameBuilder(spriteSheet.getSprite(3, 2), 40)
                        .withScale(3)
                        .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                        .build(),
                        new FrameBuilder(spriteSheet.getSprite(3, 3), 40)
                        .withScale(3)
                        .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                        .build(),
                        new FrameBuilder(spriteSheet.getSprite(4, 0), 40)
                        .withScale(3)
                        .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                        .build(),
                        new FrameBuilder(spriteSheet.getSprite(4, 1), 40)
                        .withScale(3)
                        .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                        .build(),
                        new FrameBuilder(spriteSheet.getSprite(4, 2), 40)
                        .withScale(3)
                        .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                        .build()
                });
        }};
    }

    @Override
    public void draw(GraphicsHandler graphicsHandler) {
        super.draw(graphicsHandler);
    }

}