package Maps;

import Engine.GraphicsHandler;
import Engine.ImageLoader;
import GameObject.ImageEffect;
import GameObject.Sprite;
import Level.Map;
import Tilesets.UncommonTileset;
import Utils.Colors;
import Utils.Point;

// Represents the map that is used as a background for the main menu and credits menu screen
public class MenuMap extends Map {

    private Sprite cat;
    private Sprite historyMan;

    public MenuMap() {
        
         super("menu_screen_map.txt", new UncommonTileset());
        
       

        Point historyManLocation = getMapTile(8, 4).getLocation().subtractX(6).subtractY(7);
        historyMan = new Sprite(ImageLoader.loadSubImage("MainCharacterWalk_1.png", Colors.MAGENTA, 0, 0, 29, 29));
        historyMan.setScale(3);
        historyMan.setImageEffect(ImageEffect.FLIP_HORIZONTAL);
        historyMan.setLocation(historyManLocation.x, historyManLocation.y);
        
         
    }

    @Override
    public void draw(GraphicsHandler graphicsHandler) {
        super.draw(graphicsHandler);
        historyMan.draw(graphicsHandler);
    }
}