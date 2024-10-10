package Maps;
import Level.Trigger;
import NPCs.GMA;
import NPCs.GMAM;
import NPCs.PubSafety;
import NPCs.PubSafetyM;
import NPCs.Stache;
import NPCs.StacheM;
import NPCs.Student;
import NPCs.StudentM;
import NPCs.THEVICMAN;
import NPCs.THEVICMANM;
import NPCs.TheThim;
import Scripts.MyMap.StudentScript;
import Level.Map;
import Level.NPC;
import Tilesets.DormTilesetOutdoor;
import Tilesets.DormTilesetOutdoorHeat;
import Tilesets.HeatDormTilesetIndoor;

import java.util.ArrayList;

public class MountainviewDormOutdoorHeat extends Map{

    public MountainviewDormOutdoorHeat() {
        super("mountainview_dorm_map_outdoor_heat.txt", new DormTilesetOutdoorHeat());
        this.playerStartPosition = getMapTile(10, 10).getLocation();
    }

    
    @Override
    public ArrayList<NPC> loadNPCs() {
        ArrayList<NPC> npcs = new ArrayList<>();

        StacheM stacheM = new StacheM(1, getMapTile(6, 27).getLocation().subtractY(40));
        npcs.add(stacheM);

        PubSafetyM pubSafetyM = new PubSafetyM(1, getMapTile(7, 27).getLocation().subtractY(40));
        npcs.add(pubSafetyM);

        StudentM studentM = new StudentM(1, getMapTile(8, 27).getLocation().subtractY(40));
        npcs.add(studentM);

        THEVICMANM thevicmanM = new THEVICMANM(1, getMapTile(9, 27).getLocation().subtractY(40));
        npcs.add(thevicmanM);

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

}