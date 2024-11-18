package Maps;

import EnhancedMapTiles.PushableRock;
import Level.*;
import NPCs.Bug;
import NPCs.Dinosaur;
import Scripts.SimpleTextScript;
import Scripts.TestMap.*;
import Tilesets.CommonTileset;
import Tilesets.MiscIndoorTileset;
import Tilesets.MiscIndoorTileSetHeat;

import java.util.ArrayList;

// Represents a test map to be used in a level
public class Jail extends Map {

    public Jail() {
        super("jail_map.txt", new MiscIndoorTileSetHeat());
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

        getMapTile(6, 2).setInteractScript(new SimpleTextScript("Kaegen: Alas, the prison'rs receiveth nay privacy\ncoequal at which hour sleeping."));
        getMapTile(6, 3).setInteractScript(new SimpleTextScript("Kaegen: Alas, the prison'rs receiveth nay privacy\ncoequal at which hour sleeping."));
        getMapTile(6, 5).setInteractScript(new SimpleTextScript("Kaegen: Alas, the prison'rs receiveth nay privacy\ncoequal at which hour sleeping."));
        getMapTile(6, 6).setInteractScript(new SimpleTextScript("Kaegen: Alas, the prison'rs receiveth nay privacy\ncoequal at which hour sleeping."));
        getMapTile(6, 8).setInteractScript(new SimpleTextScript("Kaegen: Alas, the prison'rs receiveth nay privacy\ncoequal at which hour sleeping."));
        getMapTile(6, 9).setInteractScript(new SimpleTextScript("Kaegen: Alas, the prison'rs receiveth nay privacy\ncoequal at which hour sleeping."));
        // 6,2 Bed 1
        // 6,3 Bed 1
        // 6,5 Bed 2
        // 6,6 Bed 2
        // 6,8 Bed 3
        // 6,9(nice) Bed 3

        getMapTile(7, 1).setInteractScript(new SimpleTextScript("Kaegen: The jail wouldst beest pitch black if it\nbe true the torches weren't here."));
        getMapTile(8, 1).setInteractScript(new SimpleTextScript("Kaegen: Art these... torture instruments?"));
        getMapTile(9, 1).setInteractScript(new SimpleTextScript("Kaegen: These pots art fusty and did chip.\nCompletely unusable."));
        getMapTile(10, 1).setInteractScript(new SimpleTextScript("Kaegen: People could'st setteth fireth to the jail with this!"));
        //7,1 Torch
        //8,1 Mysterious Items
        //9,1 Pots
        //10,1 Candle
        
        getMapTile(12, 1).setInteractScript(new SimpleTextScript("Kaegen: These art gallows! Those gents perform executions on campus?!"));
        getMapTile(12, 2).setInteractScript(new SimpleTextScript("Kaegen: These art gallows! Those gents perform executions on campus?!"));
        //12,1 Torture Instrument
        //12,2 ^^

        getMapTile(7, 1).setInteractScript(new SimpleTextScript("Kaegen: The jail wouldst beest pitch black if it\nbe true the torches weren't here."));
        //13,1 Torch


    }
}
