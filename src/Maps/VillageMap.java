package Maps;




import Level.Map;
import Level.NPC;
import Level.Trigger;
import NPCs.Bug;
import NPCs.Dinosaur;
import NPCs.Walrus;
import NPCs.Student;
import NPCs.Stache;
import NPCs.GMA;
import NPCs.PubSafety;
import NPCs.Fan;
import Scripts.MyMap.*;
import Scripts.TestMap.LostBallScript;
import Scripts.SimpleTextScript;
import Scripts.DormMap.FanScript;
import Scripts.DormMap.StartIntro;
import Tilesets.CommonTileset;
import Utils.Point;
import Game.ScreenCoordinator;

import java.util.ArrayList;

import Game.ScreenCoordinator;

public class VillageMap extends Map {

    public ScreenCoordinator screenCoordinator;
        
    public VillageMap(/*ScreenCoordinator screenCoordinator*/) {
        super("my_map.txt", new CommonTileset());
        this.playerStartPosition = getMapTile(21, 16).getLocation();
        //this.screenCoordinator = screenCoordinator;
    }

    @Override
    public ArrayList<NPC> loadNPCs() {
        ArrayList<NPC> npcs = new ArrayList<>();

        Stache stache = new Stache(1, getMapTile(4, 27).getLocation().subtractY(40));
        stache.setInteractScript(new StudentScript());
        npcs.add(stache);

        GMA gma = new GMA(3, getMapTile(27, 5).getLocation().subtractX(20));
        gma.setInteractScript(new BugScript());
        npcs.add(gma);
        
        PubSafety pubsafety = new PubSafety(2, getMapTile(15, 1).getLocation());
        //dinosaur.setExistenceFlag("hasTalkedToDino");
        pubsafety.setInteractScript(new DinoScript());
        npcs.add(pubsafety);

        Student student = new Student(4, getMapTile(5, 15).getLocation());
        student.setInteractScript(new WalrusScript());
        npcs.add(student);

        Fan fan = new Fan(4,getMapTile(23,16).getLocation()/*, screenCoordinator */);
        fan.setInteractScript(new FanScript());
        npcs.add(fan);

        return npcs;
    }

    //Make sure this works before pushing
    //Show this to group
    @Override
    public ArrayList<Trigger> loadTriggers() {
        ArrayList<Trigger> triggers = new ArrayList<>();
        triggers.add(new Trigger(950, 830, 100, 1, new StartIntro(),"introStarted")); //bottom
        triggers.add(new Trigger(950, 760, 1, 80, new StartIntro(),"introStarted")); //side
        triggers.add(new Trigger(1050, 760, 1, 80, new StartIntro(),"introStarted")); //side
        return triggers;
    }

    /*
     * @Override
    public ArrayList<Trigger> loadTriggers() {
        ArrayList<Trigger> triggers = new ArrayList<>();
        triggers.add(new Trigger(790, 1030, 100, 10, new LostBallScript(), "hasLostBall"));
        triggers.add(new Trigger(790, 960, 10, 80, new LostBallScript(), "hasLostBall"));
        triggers.add(new Trigger(890, 960, 10, 80, new LostBallScript(), "hasLostBall"));
        return triggers;
     */

    @Override
    public void loadScripts() {
        getMapTile(25, 15).setInteractScript(new SimpleTextScript("Kaegan's Dorm"));

        getMapTile(7,26).setInteractScript(new SimpleTextScript("Men's Bathroom"));

        getMapTile(11, 15).setInteractScript(new SimpleTextScript("Lounge"));

        getMapTile(20, 4).setInteractScript(new SimpleTextScript("Dino's house"));

    }



    /*
        

     * @Override
    public ArrayList<EnhancedMapTile> loadEnhancedMapTiles() {
        ArrayList<EnhancedMapTile> enhancedMapTiles = new ArrayList<>();

        PushableRock pushableRock = new PushableRock(getMapTile(2, 7).getLocation());
        enhancedMapTiles.add(pushableRock);

        return enhancedMapTiles;
    }

    @Override
    public ArrayList<NPC> loadNPCs() {
        ArrayList<NPC> npcs = new ArrayList<>();

        Walrus walrus = new Walrus(1, getMapTile(4, 28).getLocation().subtractY(40));
        walrus.setInteractScript(new WalrusScript());
        npcs.add(walrus);

        Dinosaur dinosaur = new Dinosaur(2, getMapTile(13, 4).getLocation());
        dinosaur.setExistenceFlag("hasTalkedToDinosaur");
        dinosaur.setInteractScript(new DinoScript());
        npcs.add(dinosaur);
        
        Bug bug = new Bug(3, getMapTile(7, 12).getLocation().subtractX(20));
        bug.setInteractScript(new BugScript());
        npcs.add(bug);

        return npcs;
    }

    @Override
    public ArrayList<Trigger> loadTriggers() {
        ArrayList<Trigger> triggers = new ArrayList<>();
        triggers.add(new Trigger(790, 1030, 100, 10, new LostBallScript(), "hasLostBall"));
        triggers.add(new Trigger(790, 960, 10, 80, new LostBallScript(), "hasLostBall"));
        triggers.add(new Trigger(890, 960, 10, 80, new LostBallScript(), "hasLostBall"));
        return triggers;
    }

    @Override
    public void loadScripts() {
        getMapTile(21, 19).setInteractScript(new SimpleTextScript("Cat's house"));

        getMapTile(7, 26).setInteractScript(new SimpleTextScript("Walrus's house"));

        getMapTile(20, 4).setInteractScript(new SimpleTextScript("Dino's house"));

        getMapTile(2, 6).setInteractScript(new TreeScript());
    }
     */
}

