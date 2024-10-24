package Maps;
import Level.Trigger;
import NPCs.GMA;
import NPCs.PubSafety;
import NPCs.Stache;
import NPCs.Student;
import NPCs.THEVICMAN;
import NPCs.TheThim;
import NPCs.Bear;
import Scripts.DeliriousOutdoor.FirstBearFight;
import Scripts.MyMap.StudentScript;
import Scripts.Outdoor.CheckUp;
import Scripts.Outdoor.Exclaim;
import Scripts.Outdoor.How;
import Level.Map;
import Level.NPC;
import Tilesets.DormTilesetOutdoor;

import java.util.ArrayList;
import Game.Audio;
import javax.imageio.plugins.bmp.BMPImageWriteParam;

public class MountainviewDormOutdoor extends Map{

    public MountainviewDormOutdoor() {
        super("mountainview_dorm_map_outdoor.txt", new DormTilesetOutdoor());
        this.playerStartPosition = getMapTile(10, 10).getLocation();
        //Audio.playMusic(""); //TODO
        this.playerStartPosition = getMapTile(9, 8).getLocation();
    }

    @Override
    public ArrayList<NPC> loadNPCs() {
        ArrayList<NPC> npcs = new ArrayList<>();

        Bear bear = new Bear(1, getMapTile(19, 17).getLocation().subtractY(40));
        bear.setInteractScript(new FirstBearFight());
        npcs.add(bear);

        Stache stache = new Stache(2, getMapTile(15, 15).getLocation().subtractY(40));
        stache.setInteractScript(new Exclaim());
        npcs.add(stache);

        PubSafety pubSafety = new PubSafety(3, getMapTile(12, 19).getLocation().subtractY(40));
        pubSafety.setInteractScript(new CheckUp());
        npcs.add(pubSafety);

        Student student = new Student(4, getMapTile(16, 20).getLocation().subtractY(40));
        student.setInteractScript(new How());
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