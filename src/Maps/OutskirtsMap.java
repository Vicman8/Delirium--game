package Maps;

import Level.Map;
import Tilesets.CommonTileset;

public class OutskirtsMap extends Map{

    public OutskirtsMap() {
        super("outskirts_map.txt", new CommonTileset());
        this.playerStartPosition = getMapTile(28, 18).getLocation();
    }

}
