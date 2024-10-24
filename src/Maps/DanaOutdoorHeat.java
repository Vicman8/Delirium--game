package Maps;
import Level.Trigger;
import Level.Map;
import Level.NPC;
import Level.Tileset;
import Tilesets.HeatDormTilesetIndoor;
import Game.ScreenCoordinator;

import java.util.ArrayList;

public class DanaOutdoorHeat extends Map{
    //ScreenCoordinator screenCoordinator;
    public DanaOutdoorHeat(/*ScreenCoordinator screenCoordinator*/) {
        super("dana_dorm_outdoor_heat_map.txt", new HeatDormTilesetIndoor());
        //this.playerStartPosition = getMapTile(10, 10).getLocation();
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