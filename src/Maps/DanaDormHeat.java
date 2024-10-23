package Maps;
import Level.Trigger;
import NPCs.THEVICMAN;
import NPCs.THEVICMANM;
import Level.Map;
import Level.NPC;
import Level.Tileset;
import Tilesets.DanaDormHeatTileset;
import Tilesets.HeatDormTilesetIndoor;
import Game.ScreenCoordinator;

import java.util.ArrayList;

public class DanaDormHeat extends Map{
    //ScreenCoordinator screenCoordinator;
    public DanaDormHeat(/*ScreenCoordinator screenCoordinator*/) {
        super("dana_dorm_heat_map.txt", new DanaDormHeatTileset());
        this.playerStartPosition = getMapTile(36, 17).getLocation();
        //this.screenCoordinator = screenCoordinator;
    }

    @Override
    public ArrayList<NPC> loadNPCs() {
        ArrayList<NPC> npcs = new ArrayList<>();

        THEVICMANM vicmanM = new THEVICMANM(1, getMapTile(3, 2).getLocation());
        npcs.add(vicmanM);

        return npcs;
        
    }
    /*
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