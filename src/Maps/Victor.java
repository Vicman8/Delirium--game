package Maps;

import EnhancedMapTiles.PushableRock;
import Game.Audio;
import Level.*;
import NPCs.Bug;
import NPCs.Dinosaur;
import Scripts.SimpleTextScript;
import Scripts.TestMap.*;
import Tilesets.CommonTileset;

import java.util.ArrayList;

// Represents a test map to be used in a level
public class Victor extends Map {

    public Victor() {
        super("victor_map.txt", new CommonTileset());
        //this.playerStartPosition = getMapTile(17, 20).getLocation();
        Audio.playAudio("Audio Resources/boing2.wav",true);
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

        return npcs;
    }

    @Override
    public ArrayList<Trigger> loadTriggers() {
        ArrayList<Trigger> triggers = new ArrayList<>();
        return triggers;
    }

    @Override
    public void loadScripts() {

    }
}
