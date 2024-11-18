package Maps;
import Level.Trigger;
import NPCs.Student;
import NPCs.THEVICMANM;
import NPCs.TheThimImposter;
import Scripts.Dana.ImposterThimineur;
import Scripts.DeliriousDana.VictorFight;
import Level.Map;
import Level.NPC;
import Level.Tileset;
import Tilesets.DanaTilesetOutdoorNormal;
import Tilesets.HeatDormTilesetIndoor;
import Game.Audio;
import Game.ScreenCoordinator;

import java.util.ArrayList;

public class DanaOutdoor extends Map{
    //ScreenCoordinator screenCoordinator;
    public DanaOutdoor(/*ScreenCoordinator screenCoordinator*/) {
        super("dana_dorm_outdoor_map.txt", new DanaTilesetOutdoorNormal());
        this.playerStartPosition = getMapTile(22, 10).getLocation();
        //this.screenCoordinator = screenCoordinator;
        Audio.playAudio("Audio Resources/Mountainview Courtyard.wav", true);
    }

    

    
    @Override
    public ArrayList<NPC> loadNPCs() {
        ArrayList<NPC> npcs = new ArrayList<>();
        TheThimImposter Thimposter = new TheThimImposter(1, getMapTile(11, 12).getLocation());
        Thimposter.setInteractScript(new ImposterThimineur());
        npcs.add(Thimposter);

        Student student = new Student(2,getMapTile(16, 6).getLocation());

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