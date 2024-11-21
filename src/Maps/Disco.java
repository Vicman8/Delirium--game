package Maps;

import EnhancedMapTiles.PushableRock;
import Level.*;
import NPCs.Bug;
import NPCs.CirculatingFan;
import NPCs.Dinosaur;
import Scripts.SimpleTextScript;
import Scripts.TestMap.*;
import Tilesets.CommonTileset;
import Tilesets.MiscIndoorTileset;

import java.util.ArrayList;

// Represents a test map to be used in a level
public class Disco extends Map {

    public Disco() {
        super("disco_map.txt", new MiscIndoorTileset());
        this.playerStartPosition = getMapTile(10, 8).getLocation();
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

        //Walrus walrus = new Walrus(1, getMapTile(4, 28).getLocation().subtractY(40));
        //walrus.setInteractScript(new WalrusScript());
        //npcs.add(walrus);

        //CirculatingFan circulatingFan = new CirculatingFan(1, getMapTile(10,10).getLocation());
        //npcs.add(circulatingFan);

        return npcs;
    }

    @Override
    public ArrayList<Trigger> loadTriggers() {
        ArrayList<Trigger> triggers = new ArrayList<>();
        return triggers;
    }

    @Override
    public void loadScripts() {
        getMapTile(6, 1).setInteractScript(new SimpleTextScript("Kaegen: The painting enhances the happiness of the room."));
        getMapTile(7, 1).setInteractScript(new SimpleTextScript("Kaegen: Why the need for food in here?"));
        getMapTile(9, 1).setInteractScript(new SimpleTextScript("Kaegen: Just bring food from the dining hall!"));
        getMapTile(11, 1).setInteractScript(new SimpleTextScript("Kaegen: This room is bright enough already!"));
        getMapTile(14, 1).setInteractScript(new SimpleTextScript("Kaegen: This room is bright enough already!"));
        //14,1 Painting
        //6,1 Fridge
        //7,1 Oven
        //9,1 Lights?
        //11,1 Lights?

    }
}
