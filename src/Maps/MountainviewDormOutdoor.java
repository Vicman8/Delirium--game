package Maps;
import Level.Trigger;
import NPCs.GMA;
import NPCs.PubSafety;
import NPCs.Stache;
import NPCs.Student;
import NPCs.THEVICMAN;
import NPCs.TheThim;
import Scripts.MyMap.StudentScript;
import Level.Map;
import Level.NPC;
import Tilesets.DormTilesetOutdoor;

import java.util.ArrayList;

public class MountainviewDormOutdoor extends Map{

    public MountainviewDormOutdoor() {
        super("mountainview_dorm_map_outdoor.txt", new DormTilesetOutdoor());
        this.playerStartPosition = getMapTile(10, 10).getLocation();
    }

    @Override
    public ArrayList<NPC> loadNPCs() {
        ArrayList<NPC> npcs = new ArrayList<>();

        TheThim thim = new TheThim(1, getMapTile(4, 27).getLocation().subtractY(40));
        npcs.add(thim);

        GMA gma = new GMA(1, getMapTile(5, 27).getLocation().subtractY(40));
        npcs.add(gma);

        Stache stache = new Stache(1, getMapTile(6, 27).getLocation().subtractY(40));
        npcs.add(stache);

        PubSafety pubSafety = new PubSafety(1, getMapTile(7, 27).getLocation().subtractY(40));
        npcs.add(pubSafety);

        Student student = new Student(1, getMapTile(8, 27).getLocation().subtractY(40));
        npcs.add(student);

        THEVICMAN thevicman = new THEVICMAN(1, getMapTile(9, 27).getLocation().subtractY(40));
        npcs.add(thevicman);

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