package Maps;
import Level.Trigger;
import Level.Map;
import Level.NPC;
import Level.Tileset;
import NPCs.Fan;
import Scripts.SimpleTextScript;
import Scripts.DeliriousDorm.DeliriumFan;
import Scripts.DeliriousDorm.DeliriumIntro;
import Scripts.DormMap.FanScript;
import Scripts.DormMap.StartIntro;
import Scripts.TestMap.TreeScript;
import Tilesets.DormTilesetIndoor;
import Tilesets.HeatDormTilesetIndoor;
import Game.ScreenCoordinator;

import java.util.ArrayList;

public class MountainviewDormHeat extends Map{
    ScreenCoordinator screenCoordinator;
    public MountainviewDormHeat(/*ScreenCoordinator screenCoordinator*/) {
        super("mountainview_dorm__heat_map.txt", new HeatDormTilesetIndoor());
        this.playerStartPosition = getMapTile(8, 12).getLocation();
        //this.screenCoordinator = screenCoordinator;
    }

    @Override
    public ArrayList<NPC> loadNPCs() {
        ArrayList<NPC> npcs = new ArrayList<>();

        Fan fan = new Fan(1,getMapTile(7,5).getLocation()/* , screenCoordinator*/);
        fan.setInteractScript(new DeliriumFan());
        npcs.add(fan);

        return npcs;
    }

     @Override
    public ArrayList<Trigger> loadTriggers() {
        ArrayList<Trigger> triggers = new ArrayList<>();
        triggers.add(new Trigger(500, 530, 100, 1, new DeliriumIntro(),"mcUnfainted")); //bottom
        triggers.add(new Trigger(500, 460, 1, 80, new DeliriumIntro(),"mcUnfainted")); //side
        triggers.add(new Trigger(600, 460, 1, 80, new DeliriumIntro(),"mcUnfainted")); //side
        return triggers;
    }


    @Override
    public void loadScripts() {
        getMapTile(5, 5).setInteractScript(new SimpleTextScript("Kaegen: This is mine own sleep chamber.\nThe cov'rs smelleth quaint funky."));

        getMapTile(5,7).setInteractScript(new SimpleTextScript("Kaegen: Mine own hist'ry textbook!\nT's gone! Mine own drawings!"));

        getMapTile(7,7).setInteractScript(new SimpleTextScript("Kaegen: Mine own rug from home!\nWho is't did replace t with a dead beareth?!"));

        getMapTile(7,8).setInteractScript(new SimpleTextScript("Kaegen: Mine own rug from home!\nWho is't did replace t with a dead beareth?!"));
        
        getMapTile(8,7).setInteractScript(new SimpleTextScript("Kaegen: Mine own rug from home!\nWho is't did replace t with a dead beareth?!"));

        getMapTile(8,8).setInteractScript(new SimpleTextScript("Kaegen: Mine own rug from home!\nWho is't did replace t with a dead beareth?!"));

        getMapTile(5,8).setInteractScript(new SimpleTextScript("Kaegen: Mine own hist'ry textbook!\n T's gone! Mine own drawings!"));

        getMapTile(12,7).setInteractScript(new SimpleTextScript("Kaegen: Mine own roommate's laptop is gone!\nWhat is happening???"));

        getMapTile(12,8).setInteractScript(new SimpleTextScript("Kaegen: Mine own roommate's laptop is gone!\nWhat is happening???"));

        getMapTile(12,5).setInteractScript(new SimpleTextScript("Kaegen: Mine own roommate's phoneth is gone!\nHopefully nobody did steal t."));
    }
    

} 