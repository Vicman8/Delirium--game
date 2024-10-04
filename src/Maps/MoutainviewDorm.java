package Maps;

import Level.Map;
import Level.Tileset;
import Tilesets.DormTilesetIndoor;

public class MoutainviewDorm extends Map{

    public MoutainviewDorm() {
        super("mountainview_dorm_map.txt", new DormTilesetIndoor());
        this.playerStartPosition = getMapTile(15, 15).getLocation();
    }

}
