package Level;

import java.awt.Color;
import java.io.IOException;
import Engine.DefaultScreen;
import Engine.GameWindow;
import Engine.GraphicsHandler;
import Engine.Key;
import Engine.KeyLocker;
import Engine.Keyboard;
import Engine.Screen;
import Engine.ScreenManager;
import Game.GameState;
import Game.SaveIO;
import GameObject.GameObject;
import GameObject.Rectangle;
import GameObject.SpriteSheet;
import Screens.InventoryScreen;
import Utils.Direction;
import Game.ScreenCoordinator;

public abstract class Player extends GameObject {
    // values that affect player movement
    // these should be set in a subclass
    protected float walkSpeed = 0;
    protected float sprintSpeed = 2;
    protected int interactionRange = 1;
    protected Direction currentWalkingXDirection;
    protected Direction currentWalkingYDirection;
    protected Direction lastWalkingXDirection;
    protected Direction lastWalkingYDirection;

    // values used to handle player movement
    protected float moveAmountX, moveAmountY;
    protected float lastAmountMovedX, lastAmountMovedY;

    // values used to keep track of player's current state
    protected PlayerState playerState;
    protected PlayerState previousPlayerState;
    protected Direction facingDirection;
    protected Direction lastMovementDirection;

    // define keys
    protected KeyLocker keyLocker = new KeyLocker();
    protected Key MOVE_LEFT_KEY = Key.LEFT;
    protected Key MOVE_RIGHT_KEY = Key.RIGHT;
    protected Key MOVE_UP_KEY = Key.UP;
    protected Key MOVE_DOWN_KEY = Key.DOWN;
    protected Key INTERACT_KEY = Key.SPACE;
    protected Key SWITCH_WORLD = Key.Q;
    protected Key SPRINT = Key.SHIFT;
    protected Key PUNCH = Key.J;
    protected Key KICK = Key.K;
    private Inventory inventory;

    protected boolean isLocked = false;

    public int posPrintDelay = 0;

    public Player(SpriteSheet spriteSheet, float x, float y, String startingAnimationName) {
        super(spriteSheet, x, y, startingAnimationName);
        facingDirection = Direction.RIGHT;
        playerState = PlayerState.STANDING;
        previousPlayerState = playerState;
        this.affectedByTriggers = true;
    }

    public void update(){
        if (!isLocked) {
            moveAmountX = 0;
            moveAmountY = 0;

            // if player is currently playing through level (has not won or lost)
            // update player's state and current actions, which includes things like determining how much it should move each frame and if its walking or jumping
            do {
                previousPlayerState = playerState;
                handlePlayerState();
            } while (previousPlayerState != playerState);

            // move player with respect to map collisions based on how much player needs to move this frame
            lastAmountMovedY = super.moveYHandleCollision(moveAmountY);
            lastAmountMovedX = super.moveXHandleCollision(moveAmountX);
            
            // if() {
            //     //Inventory.addItem();
            //     System.out.println("In");
            // }
        }
        
        handlePlayerAnimation();
        updateLockedKeys();
        
        // update player's animation
        
        super.update();
        
        posPrintDelay++;
        if (posPrintDelay == 180){
            System.out.println("Player coordinates are ("+this.getX()+" ,"+this.getY()+")");
            posPrintDelay = 0;
        }
    }

    // public void inventory(GraphicsHandler graphicsHandler, InventoryScreen inventoryScreen){
    //     inventory.showInventory(graphicsHandler, inventoryScreen);;
    // }
    
    // based on player's current state, call appropriate player state handling method
    protected void handlePlayerState() {
        switch (playerState) {
            case STANDING:
                playerStanding();
                break;
            case WALKING:
                playerWalking();
                break;
            case ATTACKING:
        }
    }

    // player STANDING state logic
    protected void playerStanding() {
        if (!keyLocker.isKeyLocked(INTERACT_KEY) && Keyboard.isKeyDown(INTERACT_KEY)) {
            
            keyLocker.lockKey(INTERACT_KEY);
            map.entityInteract(this);
        }

        // if a walk key is pressed, player enters WALKING state
        if (Keyboard.isKeyDown(MOVE_LEFT_KEY) || Keyboard.isKeyDown(MOVE_RIGHT_KEY) || Keyboard.isKeyDown(MOVE_UP_KEY) || Keyboard.isKeyDown(MOVE_DOWN_KEY)) {
            playerState = PlayerState.WALKING;
            //System.out.println("walking");
        }
    } 

    // player WALKING state logic
    protected void playerWalking() {
        if (!keyLocker.isKeyLocked(INTERACT_KEY) && Keyboard.isKeyDown(INTERACT_KEY)) {
            keyLocker.lockKey(INTERACT_KEY);
            map.entityInteract(this);
        }

        // if walk left key is pressed, move player to the left
        if (Keyboard.isKeyDown(MOVE_LEFT_KEY)) {
            //System.out.println("walk left");
            if(Keyboard.isKeyDown(SPRINT) && Keyboard.isKeyDown(MOVE_LEFT_KEY)){
                moveAmountX -= sprintSpeed;
                facingDirection = Direction.LEFT;
                currentWalkingXDirection = Direction.LEFT;
                lastWalkingXDirection = Direction.LEFT;
            }
            else{
                moveAmountX -= walkSpeed;
                facingDirection = Direction.LEFT;
                currentWalkingXDirection = Direction.LEFT;
                lastWalkingXDirection = Direction.LEFT;
            }
        }

        // if walk right key is pressed, move player to the right
        else if (Keyboard.isKeyDown(MOVE_RIGHT_KEY)) {
            if(Keyboard.isKeyDown(SPRINT) && Keyboard.isKeyDown(MOVE_RIGHT_KEY)){
                moveAmountX += sprintSpeed;
                facingDirection = Direction.RIGHT;
                currentWalkingXDirection = Direction.RIGHT;
                lastWalkingXDirection = Direction.RIGHT;
            }
            else{
                moveAmountX += walkSpeed;
                facingDirection = Direction.RIGHT;
                currentWalkingXDirection = Direction.RIGHT;
                lastWalkingXDirection = Direction.RIGHT;
            }
            
        }
        else {
            currentWalkingXDirection = Direction.NONE;
        }

        if (Keyboard.isKeyDown(MOVE_UP_KEY)) {
            if(Keyboard.isKeyDown(SPRINT) && Keyboard.isKeyDown(MOVE_UP_KEY)){
                moveAmountY -= sprintSpeed;
                facingDirection = Direction.UP;
                currentWalkingYDirection = Direction.UP;
                lastWalkingYDirection = Direction.UP;
            }
            else{
                moveAmountY -= walkSpeed;
                facingDirection = Direction.UP;
                currentWalkingYDirection = Direction.UP;
                lastWalkingYDirection = Direction.UP;
            }
            
        }
        else if (Keyboard.isKeyDown(MOVE_DOWN_KEY)) {
            if(Keyboard.isKeyDown(SPRINT) && Keyboard.isKeyDown(MOVE_DOWN_KEY)){
                moveAmountY += sprintSpeed;
                facingDirection = Direction.DOWN;
                currentWalkingYDirection = Direction.DOWN;
                lastWalkingXDirection = Direction.DOWN;
            }
            else{
                moveAmountY += walkSpeed;
                facingDirection = Direction.DOWN;
                currentWalkingYDirection = Direction.DOWN;
                lastWalkingYDirection = Direction.DOWN;
            }
            
            // else copy paste above and change walkSpeed to sprintSpeed
        }
        else {
            currentWalkingYDirection = Direction.NONE;
        }

        if ((currentWalkingXDirection == Direction.RIGHT || currentWalkingXDirection == Direction.LEFT) && currentWalkingYDirection == Direction.NONE) {
            lastWalkingYDirection = Direction.NONE;
        }

        if ((currentWalkingYDirection == Direction.UP || currentWalkingYDirection == Direction.DOWN) && currentWalkingXDirection == Direction.NONE) {
            lastWalkingXDirection = Direction.NONE;
        }

        if (Keyboard.isKeyUp(MOVE_LEFT_KEY) && Keyboard.isKeyUp(MOVE_RIGHT_KEY) && Keyboard.isKeyUp(MOVE_UP_KEY) && Keyboard.isKeyUp(MOVE_DOWN_KEY)) {
            playerState = PlayerState.STANDING;
        }
    }

    protected void updateLockedKeys() {
        if (Keyboard.isKeyUp(INTERACT_KEY) && !isLocked) {
            keyLocker.unlockKey(INTERACT_KEY);
        }
    }

    // anything extra the player should do based on interactions can be handled here
    protected void handlePlayerAnimation() {
        switch (playerState) {
            case STANDING:
                switch (facingDirection) {
                    case RIGHT:
                        this.currentAnimationName = "STAND_RIGHT";
                        break;
                    case LEFT:
                        this.currentAnimationName = "STAND_LEFT";
                        break;
                    case UP:
                        this.currentAnimationName = "STAND_UP";
                        break;
                    case DOWN:
                        this.currentAnimationName = "STAND_DOWN";
                        break;
                }
                break;
    
            case WALKING:
                switch (facingDirection) {
                    case RIGHT:
                        this.currentAnimationName = "WALK_RIGHT";
                        break;
                    case LEFT:
                        this.currentAnimationName = "WALK_LEFT";
                        break;
                    case UP:
                        this.currentAnimationName = "WALK_UP";
                        break;
                    case DOWN:
                        this.currentAnimationName = "WALK_DOWN";
                        break;
                }
                break;
    
            case ATTACKING:
                switch (facingDirection) {
                    case RIGHT:
                        this.currentAnimationName = "ATTACK_RIGHT";
                        break;
                    case LEFT:
                        this.currentAnimationName = "ATTACK_LEFT";
                        break;
                }
                break;
    
            // Handle other states similarly
        }
    }
    

    @Override
    public void onEndCollisionCheckX(boolean hasCollided, Direction direction, GameObject entityCollidedWith) { }

    @Override
    public void onEndCollisionCheckY(boolean hasCollided, Direction direction, GameObject entityCollidedWith) { }

    public PlayerState getPlayerState() {
        return playerState;
    }

    public void setPlayerState(PlayerState playerState) {
        this.playerState = playerState;
    }

    public Direction getFacingDirection() {
        return facingDirection;
    }

    public void setFacingDirection(Direction facingDirection) {
        this.facingDirection = facingDirection;
    }

    
    public Rectangle getInteractionRange() {
        return new Rectangle(
            getBounds().getX1() - interactionRange,
            getBounds().getY1() - interactionRange,
            getBounds().getWidth() + (interactionRange * 2),
            getBounds().getHeight() + (interactionRange * 2));
    }
    
    public Key getInteractKey() { return INTERACT_KEY; }
    public Direction getCurrentWalkingXDirection() { return currentWalkingXDirection; }
    public Direction getCurrentWalkingYDirection() { return currentWalkingYDirection; }
    public Direction getLastWalkingXDirection() { return lastWalkingXDirection; }
    public Direction getLastWalkingYDirection() { return lastWalkingYDirection; }

    
    public void lock() {
        isLocked = true;
        playerState = PlayerState.STANDING;
        switch (facingDirection) {
            case RIGHT:
                this.currentAnimationName = "STAND_RIGHT";
                break;
            case LEFT:
                this.currentAnimationName = "STAND_LEFT";
                break;
            case UP:
                this.currentAnimationName = "STAND_UP";
                break;
            case DOWN:
                this.currentAnimationName = "STAND_DOWN";
                break;
        }
    }
    

    public void unlock() {
        isLocked = false;
        playerState = PlayerState.STANDING;
        switch (facingDirection) {
            case RIGHT:
                this.currentAnimationName = "STAND_RIGHT";
                break;
            case LEFT:
                this.currentAnimationName = "STAND_LEFT";
                break;
            case UP:
                this.currentAnimationName = "STAND_UP";
                break;
            case DOWN:
                this.currentAnimationName = "STAND_DOWN";
                break;
        }
    }
    

    // used by other files or scripts to force player to stand
    public void stand(Direction direction) {
        playerState = PlayerState.STANDING;
        facingDirection = direction;
        switch (direction) {
            case RIGHT:
                this.currentAnimationName = "STAND_RIGHT";
                break;
            case LEFT:
                this.currentAnimationName = "STAND_LEFT";
                break;
            case UP:
                this.currentAnimationName = "STAND_UP";
                break;
            case DOWN:
                this.currentAnimationName = "STAND_DOWN";
                break;
        }
    }
    

    // used by other files or scripts to force player to walk
    public void walk(Direction direction, float speed) {
        playerState = PlayerState.WALKING;
        facingDirection = direction;
        switch (direction) {
            case RIGHT:
                this.currentAnimationName = "WALK_RIGHT";
                moveX(speed);
                break;
            case LEFT:
                this.currentAnimationName = "WALK_LEFT";
                moveX(-speed);
                break;
            case UP:
                this.currentAnimationName = "WALK_UP";
                moveY(-speed);
                break;
            case DOWN:
                this.currentAnimationName = "WALK_DOWN";
                moveY(speed);
                break;
        }
    }

    public void attack(Direction direction, float speed) {
        playerState = PlayerState.ATTACKING;
        facingDirection = direction;
        switch (direction) {
            case RIGHT:
                this.currentAnimationName = "ATTACK_RIGHT";
                moveX(speed);
                break;
            case LEFT:
                this.currentAnimationName = "ATTACK_LEFT";
                moveX(-speed);
                break;
        }
        // Logic to perform attack
    }
    

    // Uncomment this to have game draw player's bounds to make it easier to visualize
    
    // public void draw(GraphicsHandler graphicsHandler) {
    //     super.draw(graphicsHandler);
    //     drawBounds(graphicsHandler, new Color(255, 0, 0, 100));
    // }
    
}
