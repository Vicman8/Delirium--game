package Maps;

import Engine.GraphicsHandler;
import Engine.ImageLoader;
import GameObject.ImageEffect;
import GameObject.Sprite;
import Level.Map;
import Tilesets.DormTilesetOutdoor;
import Tilesets.MenuTileset;
import Tilesets.WinTileSet;
import Utils.Colors;
import Utils.Point;

// Represents the map that is used as a background for the main menu and credits menu screen
public class GameCompleteMap extends Map {

    private Sprite historyMan;

    public GameCompleteMap() {
        
         super("game_complete_map.txt", new WinTileSet());

         Point historyManLocation = getMapTile(8, 1).getLocation();
         historyMan = new Sprite(ImageLoader.loadSubImage("MainCharacterSpriteSheet_2.png", Colors.MAGENTA, 0, 0, 29, 29));
         historyMan.setScale(3);
         historyMan.setLocation(historyManLocation.x, historyManLocation.y);
        
        
        
         
    }

    @Override
    public void draw(GraphicsHandler graphicsHandler) {
        super.draw(graphicsHandler);
        historyMan.draw(graphicsHandler);
    }
}