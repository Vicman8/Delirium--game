package Maps;
import Level.Trigger;
import NPCs.Preeda;
import NPCs.Stache;
import NPCs.StacheM;
import NPCs.THEVICMAN;
import NPCs.WaterCooler;
import Scripts.Dana.DanaIntro;
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

        Preeda preeda = new Preeda(2, getMapTile(19,12).getLocation());
        preeda.setInteractScript(new DanaIntro());
        npcs.add(preeda);

        Stache stache = new Stache(2, getMapTile(27,11).getLocation());
        //stache.setInteractScript(new FollowMC())
        npcs.add(stache);

         WaterCooler waterCooler = new WaterCooler(4, getMapTile(25, 13).getLocation());
         npcs.add(waterCooler);

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