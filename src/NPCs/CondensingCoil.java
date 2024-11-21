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
import Level.MapEntityStatus;
import Level.NPC;
import Game.ScreenCoordinator;

import java.util.HashMap;

public class CondensingCoil extends NPC {
    //public ScreenCoordinator screenCoordinator = new ScreenCoordinator();
    
    public CondensingCoil(int id, Point location/*, ScreenCoordinator screenCoordinator*/) {
        super(id, location.x, location.y, new SpriteSheet(ImageLoader.load("CondensingCoil.png"), 30, 30), "STAND_LEFT");
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


    

    @Override
    public void draw(GraphicsHandler graphicsHandler) {
        super.draw(graphicsHandler);
    }
}