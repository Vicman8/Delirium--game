package Maps;

import EnhancedMapTiles.PushableRock;
import Game.Audio;
import Level.*;
import NPCs.Buddha;
import NPCs.Bug;
import NPCs.Cat;
import NPCs.Confucius;
import NPCs.DameTuCosita;
import NPCs.Dinosaur;
import NPCs.Jesus;
import NPCs.MLK;
import NPCs.Moses;
import NPCs.MountRushmore;
import NPCs.Sal;
import Scripts.SimpleTextScript;
import Scripts.TestMap.*;
import Scripts.VictorRoom.ImYou;
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

        Confucius confucius = new Confucius(2, getMapTile(5, 3).getLocation());
        confucius.setInteractScript(new DinoScript());
        npcs.add(confucius);

        MLK mLK = new MLK(2, getMapTile(8, 3).getLocation());
        mLK.setInteractScript(new DinoScript());
        npcs.add(mLK);

        MountRushmore mountRushmore = new MountRushmore(2, getMapTile(11, 3).getLocation());
        mountRushmore.setInteractScript(new DinoScript());
        npcs.add(mountRushmore);

        DameTuCosita dameTuCosita = new DameTuCosita(2, getMapTile(14, 3).getLocation());
        dameTuCosita.setInteractScript(new DinoScript());
        npcs.add(dameTuCosita);

        Moses moses = new Moses(2, getMapTile(17, 3).getLocation());
        moses.setInteractScript(new DinoScript());
        npcs.add(moses);

        Buddha buddha = new Buddha(2, getMapTile(20, 3).getLocation());
        buddha.setInteractScript(new DinoScript());
        npcs.add(buddha);

        Jesus jesus = new Jesus(2, getMapTile(17, 5).getLocation());
        jesus.setInteractScript(new DinoScript());
        npcs.add(jesus);

        Sal sal = new Sal(2, getMapTile(20, 5).getLocation());
        sal.setInteractScript(new DinoScript());
        npcs.add(sal);

        Cat cat = new Cat(2, getMapTile(17, 8).getLocation());
        cat.setInteractScript(new ImYou());
        npcs.add(cat);

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
