package Maps;
import Level.Trigger;
import NPCs.THEVICMAN;
import Scripts.DeliriousOutdoor.FirstBearFight;
import Level.Map;
import Level.NPC;
import Level.Tileset;
import Tilesets.DanaDormTileset;
import Tilesets.HeatDormTilesetIndoor;
import Game.ScreenCoordinator;

import java.util.ArrayList;

public class DanaDorm extends Map{
    //ScreenCoordinator screenCoordinator;
    public DanaDorm(/*ScreenCoordinator screenCoordinator*/) {
        super("dana_dorm_map.txt", new DanaDormTileset());
        this.playerStartPosition = getMapTile(36, 17).getLocation();
        //this.screenCoordinator = screenCoordinator;
    }

   
    
    @Override
    public ArrayList<NPC> loadNPCs() {
        ArrayList<NPC> npcs = new ArrayList<>();

        THEVICMAN vicman = new THEVICMAN(1, getMapTile(3, 2).getLocation());
        npcs.add(vicman);

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