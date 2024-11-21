package Engine;

import Game.ScreenCoordinator;
import Level.Player;

//don't worry about this class, this is here just in case
public class GlobalVariables {
//NOTE: the player position is already saved in Screen Coordinator
    public static ScreenCoordinator screenCoordinator;
    public static Player player;

    public GlobalVariables(ScreenCoordinator screenCoordinator){
        GlobalVariables.screenCoordinator = screenCoordinator;
    }
    
    public GlobalVariables(Player player){
        GlobalVariables.player = player;
    }
}
