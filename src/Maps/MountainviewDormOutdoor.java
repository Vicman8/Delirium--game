package Maps;
import Level.Trigger;
import NPCs.GMA;
import NPCs.PubSafety;
import NPCs.Stache;
import NPCs.Student;
import NPCs.THEVICMAN;
import NPCs.TheThim;
import NPCs.Walrus;
import Scripts.DeliriousOutdoor.FirstBearFight;
import Scripts.MyMap.StudentScript;
<<<<<<< HEAD
=======
import Scripts.Outdoor.CheckUp;
import Scripts.Outdoor.Exclaim;
import Scripts.Outdoor.How;
>>>>>>> 4cb609805493e00c95acd5e3ee739a85fc313fc6
import Level.Map;
import Level.NPC;
import Tilesets.DormTilesetOutdoor;

import java.util.ArrayList;

public class MountainviewDormOutdoor extends Map{

    public MountainviewDormOutdoor() {
        super("mountainview_dorm_map_outdoor.txt", new DormTilesetOutdoor());
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

<<<<<<< HEAD
        Stache stache = new Stache(1, getMapTile(6, 27).getLocation().subtractY(40));
        npcs.add(stache);

        PubSafety pubSafety = new PubSafety(1, getMapTile(7, 27).getLocation().subtractY(40));
        npcs.add(pubSafety);

        Student student = new Student(1, getMapTile(8, 27).getLocation().subtractY(40));
=======
        Stache stache = new Stache(2, getMapTile(15, 15).getLocation().subtractY(40));
        stache.setInteractScript(new Exclaim());
        npcs.add(stache);

        PubSafety pubSafety = new PubSafety(3, getMapTile(12, 19).getLocation().subtractY(40));
        pubSafety.setInteractScript(new CheckUp());
        npcs.add(pubSafety);

        Student student = new Student(4, getMapTile(16, 20).getLocation().subtractY(40));
        student.setInteractScript(new How());
>>>>>>> 4cb609805493e00c95acd5e3ee739a85fc313fc6
        npcs.add(student);

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