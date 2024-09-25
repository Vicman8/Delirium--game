package Maps;

import Level.Map;
import Tilesets.CommonTileset;

public class ShoreMap extends Map{
    public ShoreMap() {
        super("shore_map.txt", new CommonTileset());
        //this.playerStartPosition = getMapTile(28, 18).getLocation();
    }

}
