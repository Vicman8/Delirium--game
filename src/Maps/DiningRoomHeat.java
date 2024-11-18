package Maps;

import EnhancedMapTiles.PushableRock;
import Level.*;
import NPCs.Bug;
import NPCs.Dinosaur;
import NPCs.TheKingThim;
import NPCs.TheThim;
import Scripts.SimpleTextScript;
import Scripts.Field.FinalBoss;
import Scripts.Field.FinalTest;
import Scripts.TestMap.*;
import Tilesets.CommonTileset;
import Tilesets.MiscIndoorTileset;
import Tilesets.MiscIndoorTileSetHeat;

import java.util.ArrayList;

// Represents a test map to be used in a level
public class DiningRoomHeat extends Map {

    public DiningRoomHeat() {
        super("dining_room_heat_map.txt", new MiscIndoorTileSetHeat());
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

        TheKingThim theKingThim = new TheKingThim(1, getMapTile(7, 7).getLocation());
        theKingThim.setInteractScript(new FinalBoss());
        //figure out how to have the Victor fight here
        npcs.add(theKingThim);

        return npcs;
    }

    @Override
    public ArrayList<Trigger> loadTriggers() {
        ArrayList<Trigger> triggers = new ArrayList<>();
        return triggers;
    }

    @Override
    public void loadScripts() {
        getMapTile(7, 3).setInteractScript(new SimpleTextScript("Kaegen: Wow! King Thimineur's chefs must have\nput a lot of time into this food!"));
        getMapTile(7, 4).setInteractScript(new SimpleTextScript("Kaegen: Wow! King Thimineur's chefs must have\nput a lot of time into this food!"));
        // 7,3 table
        // 7,4 table

        getMapTile(9, 1).setInteractScript(new SimpleTextScript("Kaegen: Where didst the fridge wend?!"));
        getMapTile(10, 1).setInteractScript(new SimpleTextScript("Kaegen: The sinketh seemeth so much simpler."));
        getMapTile(11, 1).setInteractScript(new SimpleTextScript("Kaegen: This seemeth similar to a pizza oven."));
        //9,1 Fridge
        //10,1 Sink
        //11,1 Oven

        getMapTile(6, 1).setInteractScript(new SimpleTextScript("Kaegen: I'm fain I anon knoweth who is't\nputteth up the flags."));
        
        //6,1 Thimineur Flag

        getMapTile(6, 1).setInteractScript(new SimpleTextScript("Kaegen: This torch might not but beest\nhath used to keepeth the oven going."));
        //7,1 Torch

    }
}