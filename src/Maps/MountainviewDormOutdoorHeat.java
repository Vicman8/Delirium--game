package Maps;
import Level.Trigger;
import NPCs.CirculatingFan;
// import NPCs.Compressor;
import NPCs.CondensingCoil;
import NPCs.EvaporatorCoil;
import NPCs.GMA;
import NPCs.GMAM;
import NPCs.HelperGuy;
import NPCs.PubSafety;
import NPCs.PubSafetyM;
import NPCs.Stache;
import NPCs.StacheM;
import NPCs.Student;
import NPCs.StudentM;
import NPCs.THEVICMAN;
import NPCs.THEVICMANM;
import NPCs.TheThim;
import NPCs.Bear;
import NPCs.CirculatingFan;
import Scripts.ACParts.CirculatingFanScript;
import Scripts.DeliriousDana.VictorFight;
import Scripts.DeliriousDana.VictorFight;
import Scripts.DeliriousOutdoor.Diabear;
import Scripts.DeliriousOutdoor.FirstBearFight;
import Scripts.DeliriousOutdoor.Scary;
import Scripts.DeliriousOutdoor.Scary2;
import Scripts.DeliriousOutdoor.Scary3;
import Scripts.DormMap.FanScript;
import Scripts.MyMap.StudentScript;
import Scripts.Outdoor.HelperGuyIntro;
import Level.Map;
import Level.NPC;
import Tilesets.DormTilesetOutdoor;
import Tilesets.DormTilesetOutdoorHeat;
import Tilesets.HeatDormTilesetIndoor;

import java.util.ArrayList;

import Game.Audio;

public class MountainviewDormOutdoorHeat extends Map{

    public MountainviewDormOutdoorHeat() {
        super("mountainview_dorm_map_outdoor_heat.txt", new DormTilesetOutdoorHeat());
        this.playerStartPosition = getMapTile(9, 8).getLocation();
        this.playerStartPosition = getMapTile(10, 10).getLocation();
        Audio.playAudio("Audio Resources\\Approach Ye Castle!.wav", true);
    }

    
    @Override
    public ArrayList<NPC> loadNPCs() {
        ArrayList<NPC> npcs = new ArrayList<>();

        StacheM stacheM = new StacheM(1, getMapTile(15, 20).getLocation().subtractY(40));
        stacheM.setInteractScript(new Scary());
        npcs.add(stacheM);

        PubSafetyM pubSafetyM = new PubSafetyM(1, getMapTile(12, 24).getLocation().subtractY(40));
        pubSafetyM.setInteractScript(new Scary3());
        npcs.add(pubSafetyM);

        StudentM studentM = new StudentM(1, getMapTile(16, 25).getLocation().subtractY(40));
        studentM.setInteractScript(new Scary2());
        npcs.add(studentM);

        HelperGuy helperGuy = new HelperGuy(4, getMapTile(0, 15).getLocation().subtractY(40));
        helperGuy.setInteractScript(new HelperGuyIntro());
        npcs.add(helperGuy);

        /*
         * Fan fan = new Fan(1,getMapTile(7,5).getLocation()
        fan.setInteractScript(new FanScript());
        npcs.add(fan);

        CirculatingFan circulatingFan = new CirculatingFan(1, getMapTile(11,18).getLocation());
        circulatingFan.setInteractScript(new CirculatingFanScript());
        npcs.add(circulatingFan);

        Compressor compressor = new Compressor(1, getMapTile(11,19).getLocation());
        npcs.add(compressor);

        CondensingCoil condensingCoil = new CondensingCoil(1, getMapTile(11,20).getLocation());
        npcs.add(condensingCoil);

        EvaporatorCoil evaporatorCoil = new EvaporatorCoil(1, getMapTile(11,21).getLocation());
        npcs.add(evaporatorCoil);
         */

        


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