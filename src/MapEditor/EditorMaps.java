package MapEditor;

import Level.Map;
import Maps.OutskirtsMap;
import Maps.ShoreMap;
import Maps.TitleScreenMap;
import Maps.Victor;
import Maps.MenuMap;
import Maps.MountainviewDormHeat;
import Maps.MountainviewDormOutdoor;
import Maps.MountainviewDormOutdoorHeat;
import Maps.MoutainviewDorm;
import Maps.DanaDorm;
import Maps.DanaDormHeat;
import Maps.DanaOutdoor;
import Maps.DanaOutdoorHeat;
import Maps.DiningRoom;
import Maps.DiningRoomHeat;
import Maps.Disco;
import Maps.Jail;

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
            add("MountainviewDormHeat");
            add("MountainviewDormOutdoor");
            add("MountainviewDormOutdoorHeat");
            add("DanaDorm");
            add("DanaDormHeat");
            add("DanaOutdoor");
            add("DanaOutdoorHeat");
            add("Victor");
            add("Disco");
            add("DiningRoom");
            add("Jail");
            add("DiningRoomHeat");

        }};
    }

    public static Map getMapByName(String mapName) {
        switch(mapName) {
            case "TitleScreen":
                return new TitleScreenMap();
            case "MenuMap":
                return new MenuMap();
            case "OutskirtsMap":
                return new OutskirtsMap();
            case "ShoreMap":
                return new ShoreMap();
            case "MountainviewDorm":
                return new MoutainviewDorm();
            case "MountainviewDormHeat":
                return new MountainviewDormHeat();
            case "MountainviewDormOutdoor":
                return new MountainviewDormOutdoor();
            case "MountainviewDormOutdoorHeat":
                return new MountainviewDormOutdoorHeat();
            case "DanaDorm":
                return new DanaDorm();
            case "DanaDormHeat":
                return new DanaDormHeat();
            case "DanaOutdoor":
                return new DanaOutdoor();
            case "DanaOutdoorHeat":
                return new DanaOutdoorHeat();
            case "Victor":
                return new Victor();
            case "Disco":
                return new Disco();
            case "DiningRoom":
                return new DiningRoom();
            case "DiningRoomHeat":
                return new DiningRoomHeat();
            case "Jail":
                return new Jail();
            default:
                throw new RuntimeException("Unrecognized map name");
        }
    }
}
