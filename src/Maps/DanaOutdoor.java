package Maps;
import Level.Trigger;
import Level.Map;
import Level.NPC;
import Level.Tileset;
import Tilesets.DanaTilesetOutdoorNormal;
import Tilesets.HeatDormTilesetIndoor;
import Game.ScreenCoordinator;

import java.util.ArrayList;

public class DanaOutdoor extends Map{
    //ScreenCoordinator screenCoordinator;
    public DanaOutdoor(/*ScreenCoordinator screenCoordinator*/) {
        super("dana_dorm_outdoor_map.txt", new DanaTilesetOutdoorNormal());
        this.playerStartPosition = getMapTile(17, 12).getLocation();
        //this.screenCoordinator = screenCoordinator;
    }

    

    /*
     * @Override
    public ArrayList<NPC> loadNPCs() {

        return npcs;
        
    }

     @Override
    public ArrayList<Trigger> loadTriggers() {
        ArrayList<Trigger> triggers = new ArrayList<>();
        return triggers;
    }


    @Override
    public void loadScripts() {

    }
     */
    

} 