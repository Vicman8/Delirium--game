package Maps;
import Level.Trigger;
import NPCs.GMA;
import NPCs.HelperGuy;
import NPCs.PubSafety;
import NPCs.Stache;
import NPCs.Student;
import NPCs.THEVICMAN;
import NPCs.TheThim;
import NPCs.ArtThim;
import NPCs.Bear;
import Scripts.DeliriousOutdoor.FirstBearFight;
import Scripts.MyMap.StudentScript;
import Scripts.Outdoor.CheckUp;
import Scripts.Outdoor.Exclaim;
import Scripts.Outdoor.HelperGuyIntro;
import Scripts.Outdoor.How;
import Level.Map;
import Level.NPC;
import Tilesets.DormTilesetOutdoor;

import java.util.ArrayList;
import Game.Audio;
//import javax.imageio.plugins.bmp.BMPImageWriteParam;

public class MountainviewDormOutdoor extends Map{

    public MountainviewDormOutdoor() {
        super("mountainview_dorm_map_outdoor.txt", new DormTilesetOutdoor());
        this.playerStartPosition = getMapTile(10, 10).getLocation();
        this.playerStartPosition = getMapTile(9, 8).getLocation();
        Audio.playAudio("Audio Resources\\Mountainview Courtyard.wav", true);
    }

    @Override
    public ArrayList<NPC> loadNPCs() {
        ArrayList<NPC> npcs = new ArrayList<>();

        Stache stache = new Stache(1, getMapTile(15, 20).getLocation().subtractY(40));
        stache.setInteractScript(new Exclaim());
        npcs.add(stache);

        PubSafety pubSafety = new PubSafety(2, getMapTile(12, 24).getLocation().subtractY(40));
        pubSafety.setInteractScript(new CheckUp());
        npcs.add(pubSafety);

        Student student = new Student(3, getMapTile(16, 25).getLocation().subtractY(40));
        student.setInteractScript(new How());
        npcs.add(student);

        HelperGuy helperGuy = new HelperGuy(4, getMapTile(0, 15).getLocation().subtractY(40));
        helperGuy.setInteractScript(new HelperGuyIntro());
        npcs.add(helperGuy);

        ArtThim artThim = new ArtThim(5, getMapTile(0, 12).getLocation().subtractY(40));
        npcs.add(artThim);

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