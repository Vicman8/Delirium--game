package Maps;

import EnhancedMapTiles.PushableRock;
import Level.*;
import NPCs.Bug;
import NPCs.CondensingCoil;
import NPCs.Dinosaur;
import NPCs.TheThim;
import NPCs.TheThimImposter;
import Scripts.SimpleTextScript;
import Scripts.DiningRoom.TheThimQuiz;
import Tilesets.CommonTileset;

import Tilesets.MiscIndoorTileset;

import java.util.ArrayList;

// Represents a test map to be used in a level
public class DiningRoom extends Map {

    public DiningRoom() {
        super("dining_room_map.txt", new MiscIndoorTileset());
        this.playerStartPosition = getMapTile(10, 9).getLocation();
    }

    

    /*
     * @Override
    public ArrayList<EnhancedMapTile> loadEnhancedMapTiles() {
        ArrayList<EnhancedMapTile> enhancedMapTiles = new ArrayList<>();

        // PushableRock pushableRock = new PushableRock(getMapTile(2, 7).getLocation());
        // enhancedMapTiles.add(pushableRock);

        for (MapTile tile : mapTiles) {
            if (tile.getTileIndex() == 3) {
                int x = Math.round(tile.getX() / tileset.getScaledSpriteWidth());
                int y = Math.round(tile.getY() / tileset.getScaledSpriteHeight());

                setMapTile(x, y, tileset.getTile(0).build(tile.getX(), tile.getY()));

                PushableRock pushableRock = new PushableRock(getMapTile(x, y).getLocation());
                enhancedMapTiles.add(pushableRock);
            }
        }

        return enhancedMapTiles;
    }
     */

    @Override
    public ArrayList<NPC> loadNPCs() {
        ArrayList<NPC> npcs = new ArrayList<>();
        TheThim theThim = new TheThim(1, getMapTile(7, 7).getLocation());
        theThim.setInteractScript(new TheThimQuiz());
        //figure out how to have the Victor fight here

        npcs.add(theThim);
        CondensingCoil condensingCoil = new CondensingCoil(2 , getMapTile(7,7).getLocation());
        npcs.add(condensingCoil);



        

        return npcs;
    }

    @Override
    public ArrayList<Trigger> loadTriggers() {
        ArrayList<Trigger> triggers = new ArrayList<>();
        return triggers;
    }

    @Override
    public void loadScripts() {
        getMapTile(7, 3).setInteractScript(new SimpleTextScript("Kaegen: Wow! The chefs did a great job!"));
        getMapTile(7, 4).setInteractScript(new SimpleTextScript("Kaegen: Wow! The chefs did a great job!"));
        // 7,3 table
        // 7,4 table

        getMapTile(9, 1).setInteractScript(new SimpleTextScript("Kaegen: Just a standard fridge."));
        getMapTile(10, 1).setInteractScript(new SimpleTextScript("Kaegen: The sink is shiny.\nGlad they clean it often."));
        getMapTile(11, 1).setInteractScript(new SimpleTextScript("Kaegen: The oven smells great!"));
        //9,1 Fridge
        //10,1 Sink
        //11,1 Oven

        getMapTile(13, 1).setInteractScript(new SimpleTextScript("Kaegen: Nice flowers."));
        getMapTile(6, 1).setInteractScript(new SimpleTextScript("Kaegen: Nice flowers."));
        //13,1 Flowers?
        //6,1 Flowers?
        
        getMapTile(7, 1).setInteractScript(new SimpleTextScript("Kaegen: Wish they'd use the pizza oven more."));
        //7,1 Pizza Oven?


    }
}