package Players;

import Builders.FrameBuilder;
import Engine.GraphicsHandler;
import Engine.ImageLoader;
import GameObject.Frame;
import GameObject.ImageEffect;
import GameObject.SpriteSheet;
import Level.Player;

import java.util.HashMap;

// This is the class for the Cat player character
// basically just sets some values for physics and then defines animations
public class TIMETODANCE extends Player {

    public TIMETODANCE(float x, float y) {
        super(new SpriteSheet(ImageLoader.load("PlayerDancing_1.png"), 29, 29), x, y, "STAND_RIGHT");
        walkSpeed = 2.0f;
        sprintSpeed = 5.5f;
    }

    public void update() {
        super.update();
    }

    public void draw(GraphicsHandler graphicsHandler) {
        super.draw(graphicsHandler);
    }

    @Override
    public HashMap<String, Frame[]> loadAnimations(SpriteSheet spriteSheet) {
        return new HashMap<String, Frame[]>() {{
            put("STAND_RIGHT", new Frame[] {
                    new FrameBuilder(spriteSheet.getSprite(0, 0), 40)
                            .withScale(3)
                            .withBounds(6, 12, 12, 7)
                            .build(),
                        new FrameBuilder(spriteSheet.getSprite(0, 1), 40)
                        .withScale(3)
                        .withBounds(6, 12, 12, 7)
                        .build(),
                        new FrameBuilder(spriteSheet.getSprite(0, 2), 40)
                            .withScale(3)
                            .withBounds(6, 12, 12, 7)
                            .build(),
                        new FrameBuilder(spriteSheet.getSprite(0, 3), 40)
                        .withScale(3)
                        .withBounds(6, 12, 12, 7)
                        .build(),
                        new FrameBuilder(spriteSheet.getSprite(0, 4), 40)
                            .withScale(3)
                            .withBounds(6, 12, 12, 7)
                            .build(),
                        new FrameBuilder(spriteSheet.getSprite(1, 0), 40)
                        .withScale(3)
                        .withBounds(6, 12, 12, 7)
                        .build(),
                        new FrameBuilder(spriteSheet.getSprite(1, 1), 40)
                            .withScale(3)
                            .withBounds(6, 12, 12, 7)
                            .build(),
                            new FrameBuilder(spriteSheet.getSprite(1, 2))
                            .withScale(3)
                            .withBounds(6, 12, 12, 7)
                            .build()
            });

            put("STAND_LEFT", new Frame[] {
                new FrameBuilder(spriteSheet.getSprite(0, 0), 40)
                .withScale(3)
                .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                .withBounds(6, 12, 12, 7)
                .build(),
            new FrameBuilder(spriteSheet.getSprite(0, 1), 40)
            .withScale(3)
            .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
            .withBounds(6, 12, 12, 7)
            .build(),
            new FrameBuilder(spriteSheet.getSprite(0, 2), 40)
                .withScale(3)
                .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                .withBounds(6, 12, 12, 7)
                .build(),
            new FrameBuilder(spriteSheet.getSprite(0, 3), 40)
            .withScale(3)
            .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
            .withBounds(6, 12, 12, 7)
            .build(),
            new FrameBuilder(spriteSheet.getSprite(0, 4), 40)
                .withScale(3)
                .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                .withBounds(6, 12, 12, 7)
                .build(),
            new FrameBuilder(spriteSheet.getSprite(1, 0), 40)
            .withScale(3)
            .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
            .withBounds(6, 12, 12, 7)
            .build(),
            new FrameBuilder(spriteSheet.getSprite(1, 1), 40)
                .withScale(3)
                .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                .withBounds(6, 12, 12, 7)
                .build(),
                new FrameBuilder(spriteSheet.getSprite(1, 2))
                .withScale(3)
                .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                .withBounds(6, 12, 12, 7)
                .build()
            });

            put("WALK_RIGHT", new Frame[] {
                    new FrameBuilder(spriteSheet.getSprite(1, 2), 20)
                            .withScale(3)
                            .withBounds(6, 12, 12, 7)
                            .build(),
                    new FrameBuilder(spriteSheet.getSprite(1, 4), 20)
                            .withScale(3)
                            .withBounds(6, 12, 12, 7)
                            .build(),
                    new FrameBuilder(spriteSheet.getSprite(1, 2), 20)
                            .withScale(3)
                            .withBounds(6, 12, 12, 7)
                            .build(),
                    new FrameBuilder(spriteSheet.getSprite(1, 4), 20)
                            .withScale(3)
                            .withBounds(6, 12, 12, 7)
                            .build()
            });

            put("WALK_LEFT", new Frame[] {
                new FrameBuilder(spriteSheet.getSprite(2, 1), 40)
                .withScale(3)
                .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                .withBounds(6, 12, 12, 7)
                .build(),
            new FrameBuilder(spriteSheet.getSprite(2, 2), 40)
            .withScale(3)
            .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
            .withBounds(6, 12, 12, 7)
            .build(),
            new FrameBuilder(spriteSheet.getSprite(2, 3), 40)
                .withScale(3)
                .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                .withBounds(6, 12, 12, 7)
                .build(),
            new FrameBuilder(spriteSheet.getSprite(2, 4), 40)
            .withScale(3)
            .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
            .withBounds(6, 12, 12, 7)
            .build(),
            new FrameBuilder(spriteSheet.getSprite(3, 0), 40)
                .withScale(3)
                .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                .withBounds(6, 12, 12, 7)
                .build(),
            new FrameBuilder(spriteSheet.getSprite(3, 1), 40)
            .withScale(3)
            .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
            .withBounds(6, 12, 12, 7)
            .build(),
            new FrameBuilder(spriteSheet.getSprite(3, 2), 40)
                .withScale(3)
                .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                .withBounds(6, 12, 12, 7)
                .build()
            });

        
        put("STAND_UP", new Frame[] {
                new FrameBuilder(spriteSheet.getSprite(2, 0))
                        .withScale(3)
                        .withBounds(6, 12, 12, 7)
                        .build()
        });

        put("STAND_DOWN", new Frame[] {
                new FrameBuilder(spriteSheet.getSprite(2, 1))
                        .withScale(3)
                        .withBounds(6, 12, 12, 7)
                        .build()
        });

        put("WALK_UP", new Frame[] {
            new FrameBuilder(spriteSheet.getSprite(3, 3), 5)
            .withScale(3)
            .withBounds(6, 12, 12, 7)
            .build(),
    new FrameBuilder(spriteSheet.getSprite(3, 4), 10)
            .withScale(3)
            .withBounds(6, 12, 12, 7)
            .build(),
    new FrameBuilder(spriteSheet.getSprite(4, 0), 10)
            .withScale(3)
            .withBounds(6, 12, 12, 7)
            .build(),
    new FrameBuilder(spriteSheet.getSprite(4, 1), 5)
            .withScale(3)
            .withBounds(6, 12, 12, 7)
            .build(),
            new FrameBuilder(spriteSheet.getSprite(4, 2), 10)
            .withScale(3)
            .withBounds(6, 12, 12, 7)
            .build(),
    new FrameBuilder(spriteSheet.getSprite(4, 3), 5)
            .withScale(3)
            .withBounds(6, 12, 12, 7)
            .build()
        });

        put("WALK_DOWN", new Frame[] {
            new FrameBuilder(spriteSheet.getSprite(3, 3), 5)
            .withScale(3)
            .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
            .withBounds(6, 12, 12, 7)
            .build(),
    new FrameBuilder(spriteSheet.getSprite(3, 4), 10)
            .withScale(3)
            .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
            .withBounds(6, 12, 12, 7)
            .build(),
    new FrameBuilder(spriteSheet.getSprite(4, 0), 10)
            .withScale(3)
            .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
            .withBounds(6, 12, 12, 7)
            .build(),
    new FrameBuilder(spriteSheet.getSprite(4, 1), 5)
            .withScale(3)
            .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
            .withBounds(6, 12, 12, 7)
            .build(),
            new FrameBuilder(spriteSheet.getSprite(4, 2), 10)
            .withScale(3)
            .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
            .withBounds(6, 12, 12, 7)
            .build(),
    new FrameBuilder(spriteSheet.getSprite(4, 3), 5)
            .withScale(3)
            .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
            .withBounds(6, 12, 12, 7)
            .build()
        });
        }};
    }

    /*
     * @Override
    public HashMap<String, Frame[]> loadAnimations(SpriteSheet spriteSheet) {
        return new HashMap<String, Frame[]>() {{
            put("STAND_RIGHT", new Frame[] {
                    new FrameBuilder(spriteSheet.getSprite(0, 0), 40)
                            .withScale(3)
                            .withBounds(6, 12, 12, 7)
                            .build(),
                        new FrameBuilder(spriteSheet.getSprite(0, 1), 40)
                        .withScale(3)
                        .withBounds(6, 12, 12, 7)
                        .build()
            });

            put("STAND_LEFT", new Frame[] {
                    new FrameBuilder(spriteSheet.getSprite(0, 0), 40)
                            .withScale(3)
                            .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                            .withBounds(6, 12, 12, 7)
                            .build(),
                            new FrameBuilder(spriteSheet.getSprite(0, 1), 40)
                            .withScale(3)
                            .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                            .withBounds(6, 12, 12, 7)
                            .build()
            });

            put("WALK_RIGHT", new Frame[] {
                    new FrameBuilder(spriteSheet.getSprite(0, 0), 5)
                            .withScale(3)
                            .withBounds(6, 12, 12, 7)
                            .build(),
                    new FrameBuilder(spriteSheet.getSprite(0, 3), 10)
                            .withScale(3)
                            .withBounds(6, 12, 12, 7)
                            .build(),
                    new FrameBuilder(spriteSheet.getSprite(1, 0), 10)
                            .withScale(3)
                            .withBounds(6, 12, 12, 7)
                            .build(),
                    new FrameBuilder(spriteSheet.getSprite(0, 0), 5)
                            .withScale(3)
                            .withBounds(6, 12, 12, 7)
                            .build()
            });

            put("WALK_LEFT", new Frame[] {
                    new FrameBuilder(spriteSheet.getSprite(0, 0), 5)
                            .withScale(3)
                            .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                            .withBounds(6, 12, 12, 7)
                            .build(),
                    new FrameBuilder(spriteSheet.getSprite(0, 3), 10)
                            .withScale(3)
                            .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                            .withBounds(6, 12, 12, 7)
                            .build(),
                    new FrameBuilder(spriteSheet.getSprite(1, 0), 10)
                            .withScale(3)
                            .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                            .withBounds(6, 12, 12, 7)
                            .build(),
                    new FrameBuilder(spriteSheet.getSprite(0, 0), 5)
                            .withScale(3)
                            .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                            .withBounds(6, 12, 12, 7)
                            .build()
            });

        
        put("STAND_UP", new Frame[] {
                new FrameBuilder(spriteSheet.getSprite(2, 0))
                        .withScale(3)
                        .withBounds(6, 12, 12, 7)
                        .build()
        });

        put("STAND_DOWN", new Frame[] {
                new FrameBuilder(spriteSheet.getSprite(1, 1))
                        .withScale(3)
                        .withBounds(6, 12, 12, 7)
                        .build()
        });

        put("WALK_UP", new Frame[] {
                new FrameBuilder(spriteSheet.getSprite(2, 0), 5)
                        .withScale(3)
                        .withBounds(6, 12, 12, 7)
                        .build(),
                new FrameBuilder(spriteSheet.getSprite(2, 1), 10)
                        .withScale(3)
                        .withBounds(6, 12, 12, 7)
                        .build(),
                new FrameBuilder(spriteSheet.getSprite(2, 3), 10)
                        .withScale(3)
                        .withBounds(6, 12, 12, 7)
                        .build(),
                new FrameBuilder(spriteSheet.getSprite(2, 0), 5)
                        .withScale(3)
                        .withBounds(6, 12, 12, 7)
                        .build()
        });

        put("WALK_DOWN", new Frame[] {
                new FrameBuilder(spriteSheet.getSprite(1, 1), 5)
                        .withScale(3)
                        .withBounds(6, 12, 12, 7)
                        .build(),
                new FrameBuilder(spriteSheet.getSprite(1, 2), 10)
                        .withScale(3)
                        .withBounds(6, 12, 12, 7)
                        .build(),
                new FrameBuilder(spriteSheet.getSprite(1, 3), 10)
                        .withScale(3)
                        .withBounds(6, 12, 12, 7)
                        .build(),
                new FrameBuilder(spriteSheet.getSprite(1, 1), 5)
                        .withScale(3)
                        .withBounds(6, 12, 12, 7)
                        .build()
        });
        }};
    }
     */
}