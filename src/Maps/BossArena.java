package Maps;
import Level.Trigger;
import NPCs.CirculatingFan;
import NPCs.Compressor;
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
import Scripts.DeliriousDana.VictorFight;
import Scripts.DeliriousDana.VictorFight;
import Scripts.DeliriousOutdoor.Diabear;
import Scripts.DeliriousOutdoor.FirstBearFight;
import Scripts.DeliriousOutdoor.Scary;
import Scripts.DeliriousOutdoor.Scary2;
import Scripts.DeliriousOutdoor.Scary3;
import Scripts.DormMap.FanScript;
import Scripts.Field.FinalBoss;
import Scripts.MyMap.StudentScript;
import Scripts.Outdoor.HelperGuyIntro;
import Level.Map;
import Level.NPC;
import Tilesets.DormTilesetOutdoor;
import Tilesets.DormTilesetOutdoorHeat;
import Tilesets.HeatDormTilesetIndoor;

import java.util.ArrayList;

import Game.Audio;

public class BossArena extends Map{

    public BossArena() {
        super("boss_arena_map.txt", new DormTilesetOutdoorHeat());
        this.playerStartPosition = getMapTile(2, 10).getLocation();
    }

    
    @Override
    public ArrayList<NPC> loadNPCs() {
        ArrayList<NPC> npcs = new ArrayList<>();

        Bear bear = new Bear(1, getMapTile(8,5).getLocation());
        bear.setInteractScript(new FinalBoss());
        npcs.add(bear);


        /*
         * Fan fan = new Fan(1,getMapTile(7,5).getLocation()
        fan.setInteractScript(new FanScript());
        npcs.add(fan);

        CirculatingFan circulatingFan = new CirculatingFan(1, getMapTile(11,18).getLocation());
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