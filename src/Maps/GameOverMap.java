package Maps;

import Engine.GraphicsHandler;
import Engine.ImageLoader;
import GameObject.ImageEffect;
import GameObject.Sprite;
import Level.Map;
import Tilesets.MenuTileset;
import Utils.Colors;
import Utils.Point;

// Represents the map that is used as a background for the main menu and credits menu screen
public class GameOverMap extends Map {

    private Sprite medievalHistoryMan;

    public GameOverMap() {
        
         super("game_over_map.txt", new MenuTileset());

        
        Point medievalHistoryManLocation = getMapTile(7, 4).getLocation().subtractX(6).subtractY(7);
        medievalHistoryMan = new Sprite(ImageLoader.loadSubImage("MainCharacterWalkMedieval.png", Colors.MAGENTA, 0, 0, 29, 29));
        medievalHistoryMan.setScale(3);
        medievalHistoryMan.setLocation(medievalHistoryManLocation.x, medievalHistoryManLocation.y);
        
        
         
    }

    @Override
    public void draw(GraphicsHandler graphicsHandler) {
        super.draw(graphicsHandler);
        medievalHistoryMan.draw(graphicsHandler);
    }
}