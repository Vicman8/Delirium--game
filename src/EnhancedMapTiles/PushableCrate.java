package EnhancedMapTiles;

import Builders.FrameBuilder;
import Engine.ImageLoader;
import Engine.Key;
import Engine.Keyboard;
import GameObject.Frame;
import GameObject.GameObject;
import GameObject.SpriteSheet;
import Level.EnhancedMapTile;
import Level.Player;
import Level.PlayerState;
import Level.TileType;
import Utils.Direction;
import Utils.Point;

// This class is for the special rock in the map that can be moved around by the player
// when the player walks into it, it will be "pushed" forward in the same direction the player was moving in
public class PushableCrate extends EnhancedMapTile {
    public PushableCrate(Point location) {
        super(location.x, location.y, new SpriteSheet(ImageLoader.load("CrateMedieval.png"), 16, 16), TileType.NOT_PASSABLE);
    }

    @Override
    public void update(Player player) {
        super.update(player);

        // if (Keyboard.isKeyDown(Key.E) && player.isNear(this, (int) (getWidth() * 1.5))) {
        //     setMapEntityStatus(mapEntityStatus.REMOVED);
        // }

        if (player.touching(this) && player.getPlayerState() == PlayerState.WALKING) {
            if (player.getCurrentWalkingXDirection() == Direction.LEFT) {
                if (canMoveLeft(player)) {
                    moveXHandleCollision(-1);
                    // System.out.println("Moving Left");
                }
            }
            else if (player.getCurrentWalkingXDirection() == Direction.RIGHT) {
                if (canMoveRight(player)) {
                    moveXHandleCollision(1);
                    // System.out.println("moving right");
                }
            }
             if (player.getCurrentWalkingYDirection() == Direction.UP) {
                if (canMoveUp(player)) {
                    moveYHandleCollision(-1);
                    // System.out.println("Moving up");
                }
            }
            else if (player.getCurrentWalkingYDirection() == Direction.DOWN) {
                if (canMoveDown(player)) {
                    moveYHandleCollision(1);
                    // System.out.println("moving down");
                }
            }
        }
    }

    private boolean canMoveLeft(Player player) {
        return player.getBounds().getX1() <= getBounds().getX2() + 1 && player.getBounds().getX2() > getBounds().getX2() && canMoveX(player);
    }

    private boolean canMoveRight(Player player) {
        return player.getBounds().getX2() + 1 >= getBounds().getX1() && player.getBounds().getX1() < getBounds().getX1() && canMoveX(player);
        
    }

    private boolean canMoveX(Player player) {
        return (player.getBounds().getY1() <= getBounds().getY2() && player.getBounds().getY2() >= getBounds().getY2()) ||
                (player.getBounds().getY2() >= getBounds().getY1() && player.getBounds().getY1() <= getBounds().getY1()) ||
                (player.getBounds().getY2() <= getBounds().getY2() && player.getBounds().getY1() >= getBounds().getY1());
    }

    private boolean canMoveUp(Player player) {
        return player.getBounds().getY1() <= getBounds().getY2() + 1 && player.getBounds().getY2() > getBounds().getY2() && canMoveY(player);
    }

    private boolean canMoveDown(Player player) {
        return player.getBounds().getY2() + 1 >= getBounds().getY1() && player.getBounds().getY1() < getBounds().getY1() && canMoveY(player);
    }

    private boolean canMoveY(Player player) {
        return (player.getBounds().getX1() <= getBounds().getX2() && player.getBounds().getX2() >= getBounds().getX2()) ||
                (player.getBounds().getX2() >= getBounds().getX1() && player.getBounds().getX1() <= getBounds().getX1()) ||
                (player.getBounds().getX2() <= getBounds().getX2() && player.getBounds().getX1() >= getBounds().getX1());
    }

    @Override
    protected GameObject loadBottomLayer(SpriteSheet spriteSheet) {
        Frame frame = new FrameBuilder(spriteSheet.getSubImage(0, 0))
                .withScale(3)
                .build();
        return new GameObject(x, y, frame);
    }
}
