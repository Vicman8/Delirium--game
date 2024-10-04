package MapEditor;

import Level.Map;
import Maps.MyMap;
import Maps.OutskirtsMap;
import Maps.ShoreMap;
import Maps.TestMap;
import Maps.TitleScreenMap;
import Maps.MenuMap;
import Maps.MoutainviewDorm;

import java.util.ArrayList;

public class EditorMaps {
    public static ArrayList<String> getMapNames() {
        return new ArrayList<String>() {{
            add("TestMap");
            add("TitleScreen");
            add("MyMap");
            add("MenuMap");
            add("OutskirtsMap");
            add("ShoreMap");
            add("MountainviewDorm");
        }};
    }

    public static Map getMapByName(String mapName) {
        switch(mapName) {
            case "TestMap":
                return new TestMap();
            case "TitleScreen":
                return new TitleScreenMap();
            case "MyMap":
                return new MyMap();
            case "MenuMap":
                return new MenuMap();
            case "OutskirtsMap":
                return new OutskirtsMap();
            case "ShoreMap":
                return new ShoreMap();
            case "MountainviewDorm":
                return new MoutainviewDorm();
            default:
                throw new RuntimeException("Unrecognized map name");
        }
    }
}
