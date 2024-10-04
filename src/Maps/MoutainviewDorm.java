package Maps;
import Level.Trigger;
import Level.Map;
import Level.NPC;
import Level.Tileset;
import NPCs.Fan;
import Scripts.SimpleTextScript;
import Scripts.DormMap.FanScript;
import Scripts.DormMap.StartIntro;
import Tilesets.DormTilesetIndoor;

import java.util.ArrayList;

public class MoutainviewDorm extends Map{

    public MoutainviewDorm() {
        super("mountainview_dorm_map.txt", new DormTilesetIndoor());
        this.playerStartPosition = getMapTile(10, 10).getLocation();
    }

    @Override
    public ArrayList<NPC> loadNPCs() {
        ArrayList<NPC> npcs = new ArrayList<>();

        Fan fan = new Fan(1,getMapTile(6,5).getLocation());
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

}
