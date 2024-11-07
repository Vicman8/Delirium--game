package Maps;
import Level.Trigger;
import NPCs.TheThimImposter;
import Level.Map;
import Level.NPC;
import Level.Tileset;
import Tilesets.DormTilesetOutdoorHeat;
import Tilesets.HeatDormTilesetIndoor;
import Game.Audio;
import Game.ScreenCoordinator;
import Scripts.DeliriousDanaOutdoor.ImposterThimineur;

import java.util.ArrayList;

public class DanaOutdoorHeat extends Map{
    //ScreenCoordinator screenCoordinator;
    public DanaOutdoorHeat(/*ScreenCoordinator screenCoordinator*/) {
        super("dana_dorm_outdoor_heat_map.txt", new DormTilesetOutdoorHeat());
        this.playerStartPosition = getMapTile(22, 10).getLocation();
        //this.screenCoordinator = screenCoordinator;
        Audio.playAudio("Audio Resources/Approach Ye Castle!.wav", true);
    }

    

    
    @Override
    public ArrayList<NPC> loadNPCs() {
        ArrayList<NPC> npcs = new ArrayList<>();
        TheThimImposter theThimImposter = new TheThimImposter(1, getMapTile(11, 12).getLocation());
        theThimImposter.setInteractScript(new ImposterThimineur());
        //figure out how to have the Victor fight here
        npcs.add(theThimImposter);

        return npcs;
        
    }

     /*@Override
    public ArrayList<Trigger> loadTriggers() {
        ArrayList<Trigger> triggers = new ArrayList<>();
        return triggers;
    }


    @Override
    public void loadScripts() {

    }
     */
    

} 