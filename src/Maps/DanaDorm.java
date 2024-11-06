package Maps;
import Level.Trigger;
import NPCs.Preeda;
import NPCs.Stache;
import NPCs.StacheM;
import NPCs.THEVICMAN;
import NPCs.WaterCooler;
import Scripts.SimpleTextScript;
import Scripts.Dana.DanaIntro;
import Scripts.DeliriousOutdoor.FirstBearFight;
import Level.Map;
import Level.NPC;
import Level.Tileset;
import Tilesets.DanaDormTileset;
import Tilesets.HeatDormTilesetIndoor;
import Game.Audio;
import Game.ScreenCoordinator;

import java.util.ArrayList;

public class DanaDorm extends Map{
    //ScreenCoordinator screenCoordinator;
    public DanaDorm(/*ScreenCoordinator screenCoordinator*/) {
        super("dana_dorm_map.txt", new DanaDormTileset());
        this.playerStartPosition = getMapTile(36, 17).getLocation();
        //this.screenCoordinator = screenCoordinator;
        Audio.playAudio("Audio Resources/Mountainview Courtyard.wav", true);
    }

   
    
    @Override
    public ArrayList<NPC> loadNPCs() {
        ArrayList<NPC> npcs = new ArrayList<>();

        THEVICMAN vicman = new THEVICMAN(1, getMapTile(3, 2).getLocation());
        npcs.add(vicman);

        Preeda preeda = new Preeda(2, getMapTile(19,12).getLocation());
        preeda.setInteractScript(new DanaIntro());
        npcs.add(preeda);

        Stache stache = new Stache(2, getMapTile(27,11).getLocation());
        //stache.setInteractScript(new FollowMC())
        npcs.add(stache);

         WaterCooler waterCooler = new WaterCooler(4, getMapTile(25, 13).getLocation());
         npcs.add(waterCooler);

        return npcs;
        
    }

 
     @Override
    public ArrayList<Trigger> loadTriggers() {
        ArrayList<Trigger> triggers = new ArrayList<>();
        return triggers;
    }


    @Override
    public void loadScripts() {
        // coordinates needed
        getMapTile(18, 2).setInteractScript(new SimpleTextScript("Kaegen: This is Preeda's bed."));
        getMapTile(18, 3).setInteractScript(new SimpleTextScript("Kaegen: This is Preeda's bed."));
        
        getMapTile(22, 2).setInteractScript(new SimpleTextScript("Kaegen: This is Preeda's roommate's bed."));
        getMapTile(22, 3).setInteractScript(new SimpleTextScript("Kaegen: This is Preeda's roommate's bed."));
        
        getMapTile(18, 9).setInteractScript(new SimpleTextScript("Kaegen: Is this a Rubix Cube?\n Didn't think Preeda would have one."));
        getMapTile(22, 9).setInteractScript(new SimpleTextScript("Kaegen: That is a really nice scarf.\nToo bad its useless in this heat."));
        
        getMapTile(20, 1).setInteractScript(new SimpleTextScript("Kaegen: The view from here isn't nearly as\ngood as Mountainview's"));//(20,1) Dana window view
        
        getMapTile(8, 10).setInteractScript(new SimpleTextScript("Kaegen: This is... quite the decoration on this door."));//(8,10) Victor Room
        
        getMapTile(3, 10).setInteractScript(new SimpleTextScript("Kaegen: This sign reads 'HOT'. Seems like common knowledge\nthat it's starting to get hot everywhere."));//(3,10) Weird Sign
        getMapTile(37, 13).setInteractScript(new SimpleTextScript("Kaegen: Parts on the ground are a hazard to anyone\nwalking! Why won't staff pick it up?"));//(37,13) A.C Parts on ground
    }

} 