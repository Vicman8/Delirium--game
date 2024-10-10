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
import NPCs.Walrus;
import Scripts.DeliriousOutdoor.FirstBearFight;
import Scripts.DeliriousOutdoor.Scary;
import Scripts.DeliriousOutdoor.Scary2;
import Scripts.DeliriousOutdoor.Scary3;
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
<<<<<<< HEAD
        this.playerStartPosition = getMapTile(10, 10).getLocation();
=======
        this.playerStartPosition = getMapTile(9, 8).getLocation();
>>>>>>> 4cb609805493e00c95acd5e3ee739a85fc313fc6
    }

    
    @Override
    public ArrayList<NPC> loadNPCs() {
        ArrayList<NPC> npcs = new ArrayList<>();

        Walrus TotallyABear = new Walrus(1, getMapTile(19, 17).getLocation().subtractY(40));
        TotallyABear.setInteractScript(new FirstBearFight());
        npcs.add(TotallyABear);

        StacheM stacheM = new StacheM(1, getMapTile(15, 15).getLocation().subtractY(40));
        stacheM.setInteractScript(new Scary());
        npcs.add(stacheM);

        PubSafetyM pubSafetyM = new PubSafetyM(1, getMapTile(12, 19).getLocation().subtractY(40));
        pubSafetyM.setInteractScript(new Scary3());
        npcs.add(pubSafetyM);

        StudentM studentM = new StudentM(1, getMapTile(16, 20).getLocation().subtractY(40));
        studentM.setInteractScript(new Scary2());
        npcs.add(studentM);


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