package Maps;
import Level.Trigger;
import Level.Map;
import Level.NPC;
import Level.Tileset;
import NPCs.Fan;
import Scripts.SimpleTextScript;
import Scripts.DormMap.FanScript;
import Scripts.DormMap.StartIntro;
import Scripts.TestMap.TreeScript;
import Tilesets.DormTilesetIndoor;
import Game.ScreenCoordinator;

import java.util.ArrayList;

public class MoutainviewDorm extends Map{
    public ScreenCoordinator screenCoordinator;

    public MoutainviewDorm(/*ScreenCoordinator screenCoordinator*/) {
        super("mountainview_dorm_map.txt", new DormTilesetIndoor());
        this.playerStartPosition = getMapTile(10, 10).getLocation();
    }

    @Override
    public ArrayList<NPC> loadNPCs() {
        ArrayList<NPC> npcs = new ArrayList<>();

        Fan fan = new Fan(1,getMapTile(7,5).getLocation()/*, screenCoordinator*/);
        fan.setInteractScript(new FanScript());
        npcs.add(fan);

        return npcs;
    }

     @Override
    public ArrayList<Trigger> loadTriggers() {
        ArrayList<Trigger> triggers = new ArrayList<>();
        triggers.add(new Trigger(500, 530, 100, 1, new StartIntro(),"introStarted")); //bottom
        triggers.add(new Trigger(500, 460, 1, 80, new StartIntro(),"introStarted")); //side
        triggers.add(new Trigger(600, 460, 1, 80, new StartIntro(),"introStarted")); //side
        return triggers;
    }

     @Override
    public void loadScripts() {
        getMapTile(5, 5).setInteractScript(new SimpleTextScript("Kaegen: This is my bed.\nThe covers smell pretty funky."));

        getMapTile(5,7).setInteractScript(new SimpleTextScript("Kaegen: My history textbook has some of the\n most detailed drawings of George Washington in them!"));

        getMapTile(5,8).setInteractScript(new SimpleTextScript("Kaegen: My history textbook has some of the\nmost detailed drawings of George Washington in them!"));

        getMapTile(12,7).setInteractScript(new SimpleTextScript("Kaegen: This is my roommate's laptop.\nThe keys are all sweaty."));

        getMapTile(12,8).setInteractScript(new SimpleTextScript("Kaegen: This is my roommate's laptop.\nThe keys are all sweaty."));

        getMapTile(12,5).setInteractScript(new SimpleTextScript("Kaegen: My roommate keeps forgetting his phone.\nHow is he gonna get help if he ends up fainting?"));
    }

}