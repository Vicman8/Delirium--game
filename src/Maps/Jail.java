package Maps;

import EnhancedMapTiles.PushableCrate;
import Level.*;
import NPCs.Bug;
import NPCs.Compressor;
import NPCs.Dinosaur;
// import NPCs.ITEMS.ItemCompressor;
import Scripts.SimpleTextScript;
import Scripts.ACParts.CompressorScript;
import Scripts.TestMap.*;
import Tilesets.CommonTileset;
import Tilesets.MiscIndoorTileset;
import Tilesets.MiscIndoorTileSetHeat;

import GameObject.Frame;
import java.util.ArrayList;

import Engine.ImageLoader;

// Represents a test map to be used in a level
public class Jail extends Map {


    public Jail() {
        super("jail_map.txt", new MiscIndoorTileSetHeat());
        this.playerStartPosition = getMapTile(10, 9).getLocation();
    }


    
    @Override
    public ArrayList<EnhancedMapTile> loadEnhancedMapTiles() {
        ArrayList<EnhancedMapTile> enhancedMapTiles = new ArrayList<>();

        int[][] coordinates = {
            {7, 5}, {12, 4}, {10, 5}, {9, 2}, {9, 6}, {11, 3}, {9, 5},
            {7, 3}, {12, 5}, {10, 7}, {11, 2}, {8, 5}, {11, 5}, {9, 7},
            {13, 5}, {14, 5}, {10, 4}
        };
        
        for (int[] coordinate : coordinates) {
            PushableCrate pushableCrate = new PushableCrate(getMapTile(coordinate[0], coordinate[1]).getLocation());
            enhancedMapTiles.add(pushableCrate);
        }

        /*
         * for (MapTile tile : mapTiles) {
            if (tile.getTileIndex() == 9) {
                int x = Math.round(tile.getX() / tileset.getScaledSpriteWidth());
                int y = Math.round(tile.getY() / tileset.getScaledSpriteHeight());

                setMapTile(x, y, tileset.getTile(0).build(tile.getX(), tile.getY()));

                PushableRock pushableRock = new PushableRock(getMapTile(x, y).getLocation());
                enhancedMapTiles.add(pushableRock);
            }
        }
         */

        return enhancedMapTiles;
    }

    @Override
    public ArrayList<NPC> loadNPCs() {
        ArrayList<NPC> npcs = new ArrayList<>();

        Compressor walrus = new Compressor(1, getMapTile(8, 3).getLocation().subtractY(40));
        walrus.setInteractScript(new CompressorScript());
        npcs.add(walrus);

        return npcs;
    }

    // @Override
    // public ArrayList<InventoryItems> loadInventoryItems(){
    //     ArrayList<InventoryItems> inventoryItems = new ArrayList<>();
    //     ItemCompressor itemCompressor = new ItemCompressor(getMapTile(8, 3).getLocation(), new Frame(ImageLoader.load("Compressor.png")));
    //     inventoryItems.add(itemCompressor);

    //     return inventoryItems;
    // }

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
