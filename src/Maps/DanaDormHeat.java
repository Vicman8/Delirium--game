package Maps;
import Level.Trigger;
import NPCs.Fan;
import NPCs.Preeda;
import NPCs.Stache;
import NPCs.StacheM;
import NPCs.THEVICMAN;
import NPCs.THEVICMANM;
import Scripts.SimpleTextScript;
import Scripts.Dana.DanaIntro;
import Scripts.DeliriousDana.DDanaIntro;
import Scripts.DeliriousDana.SlashedAC;
import Scripts.DeliriousDana.TrailScript;
import Scripts.DeliriousDana.VictorFight;
import Scripts.DeliriousDana.VictorIntro;
import Scripts.DeliriousDorm.DeliriumIntro;
import Level.Map;
import Level.NPC;
import Level.Tileset;
import Tilesets.DanaDormHeatTileset;
import Tilesets.HeatDormTilesetIndoor;
import Game.ScreenCoordinator;

import java.util.ArrayList;

public class DanaDormHeat extends Map{
    //ScreenCoordinator screenCoordinator;
    public DanaDormHeat(/*ScreenCoordinator screenCoordinator*/) {
        super("dana_dorm_heat_map.txt", new DanaDormHeatTileset());
        this.playerStartPosition = getMapTile(36, 17).getLocation();
        //this.screenCoordinator = screenCoordinator;
    }

    @Override
    public ArrayList<NPC> loadNPCs() {
        ArrayList<NPC> npcs = new ArrayList<>();

        THEVICMANM vicmanM = new THEVICMANM(1, getMapTile(3, 2).getLocation());
        vicmanM.setInteractScript(new VictorFight());
        //figure out how to have the Victor fight here
        npcs.add(vicmanM);

        //THEVICMAN vicman = new THEVICMAN(4, getMapTile(2,3).getLocation());
        //vicman.setInteractScript(new VictorFight());
        //npcs.add(vicman);


        Preeda preeda = new Preeda(2, getMapTile(19,12).getLocation());
        preeda.setInteractScript(new DDanaIntro());
        npcs.add(preeda);

        StacheM stache = new StacheM(2, getMapTile(27,11).getLocation());
        //stache.setInteractScript(new RoommateClue())
        npcs.add(stache);

        Fan fan = new Fan(1,getMapTile(25,12).getLocation()/*, screenCoordinator*/);
        npcs.add(fan);

        return npcs;
        
    }
    
     @Override
    public ArrayList<Trigger> loadTriggers() {
        ArrayList<Trigger> triggers = new ArrayList<>();
        triggers.add(new Trigger(300, 600, 150, 1, new TrailScript(),"trailFollowed")); //bottom
        triggers.add(new Trigger(300, 460, 1, 140, new TrailScript(),"trailFollowed")); //side
        triggers.add(new Trigger(450, 460, 1, 140, new TrailScript(),"trailFollowed")); //side


        return triggers;
    }


    @Override
    public void loadScripts() {
        getMapTile(38,14).setInteractScript(new SlashedAC());
        
    }

    

} 