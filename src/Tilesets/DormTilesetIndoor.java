package Tilesets;

import Builders.FrameBuilder;
import Builders.MapTileBuilder;
import Engine.ImageLoader;
import GameObject.Frame;
import GameObject.ImageEffect;
import Level.TileType;
import Level.Tileset;

import java.util.ArrayList;

// This class represents a "common" tileset of standard tiles defined in the CommonTileset.png file
public class DormTilesetIndoor extends Tileset {

    public DormTilesetIndoor() {
        super(ImageLoader.load("DormTilesetIndoor.png"), 16, 16, 3);
    }

    @Override
    public ArrayList<MapTileBuilder> defineTiles() {
        ArrayList<MapTileBuilder> mapTiles = new ArrayList<>();

        //wall
        Frame wallFrame = new FrameBuilder(getSubImage(0, 0))
                .withScale(tileScale)
                .build();
        
        MapTileBuilder wallTile= new MapTileBuilder(wallFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(wallTile);

        Frame posterFrame = new FrameBuilder(getSubImage(0, 1))
                .withScale(tileScale)
                .build();
        
        MapTileBuilder posterTile= new MapTileBuilder(posterFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(posterTile);

        Frame[] windowFrames = new Frame[] {
            new FrameBuilder(getSubImage(0, 2), 65)
                .withScale(tileScale)
                .build(),
            new FrameBuilder(getSubImage(0, 3), 65)
                    .withScale(tileScale)
                    .build(),
            new FrameBuilder(getSubImage(0, 2), 65)
                    .withScale(tileScale)
                    .build(),
            new FrameBuilder(getSubImage(0, 3), 65)
                    .withScale(tileScale)
                    .build()
        };

        MapTileBuilder windowTile = new MapTileBuilder(windowFrames)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(windowTile);

        Frame tapestryFrame = new FrameBuilder(getSubImage(0, 4))
                .withScale(tileScale)
                .build();
        
        MapTileBuilder tapestryTile= new MapTileBuilder(tapestryFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(tapestryTile);

        Frame topBedFrame = new FrameBuilder(getSubImage(1, 0))
                .withScale(tileScale)
                .build();
        
        MapTileBuilder topBedTile= new MapTileBuilder(topBedFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(topBedTile);

        Frame bottomBedFrame = new FrameBuilder(getSubImage(1, 1))
                .withScale(tileScale)
                .build();
        
        MapTileBuilder bottomBedTile= new MapTileBuilder(bottomBedFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(bottomBedTile);

        Frame floorFrame = new FrameBuilder(getSubImage(1, 2))
                .withScale(tileScale)
                .build();
        
        MapTileBuilder floorTile= new MapTileBuilder(floorFrame)
                .withTileType(TileType.PASSABLE);

        mapTiles.add(floorTile);

        Frame carpetTLFrame = new FrameBuilder(getSubImage(1, 3))
                .withScale(tileScale)
                .build();
        
        MapTileBuilder carpetTLTile= new MapTileBuilder(carpetTLFrame)
                .withTileType(TileType.PASSABLE);

        mapTiles.add(carpetTLTile);

        Frame carpetTRFrame = new FrameBuilder(getSubImage(1, 4))
                .withScale(tileScale)
                .build();
        
        MapTileBuilder carpetTRTile= new MapTileBuilder(carpetTRFrame)
                .withTileType(TileType.PASSABLE);

        mapTiles.add(carpetTRTile);

        Frame topBedFrameAlt = new FrameBuilder(getSubImage(2, 0))
                .withScale(tileScale)
                .build();
        
        MapTileBuilder topBedTileAlt = new MapTileBuilder(topBedFrameAlt)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(topBedTileAlt);

        Frame bottomBedFrameAlt = new FrameBuilder(getSubImage(2, 1))
                .withScale(tileScale)
                .build();
        
        MapTileBuilder bottomBedTileAlt = new MapTileBuilder(bottomBedFrameAlt)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(bottomBedTileAlt);

        Frame clothesFrame = new FrameBuilder(getSubImage(2, 2))
                .withScale(tileScale)
                .build();
        
        MapTileBuilder clothesTile = new MapTileBuilder(clothesFrame)
                .withTileType(TileType.PASSABLE);

        mapTiles.add(clothesTile);

        Frame carpetBLFrame = new FrameBuilder(getSubImage(2, 3))
                .withScale(tileScale)
                .build();
        
        MapTileBuilder carpetBLTile= new MapTileBuilder(carpetBLFrame)
                .withTileType(TileType.PASSABLE);

        mapTiles.add(carpetBLTile);

        Frame carpetBRFrame = new FrameBuilder(getSubImage(2, 4))
                .withScale(tileScale)
                .build();
        
        MapTileBuilder carpetBRTile= new MapTileBuilder(carpetBRFrame)
                .withTileType(TileType.PASSABLE);

        mapTiles.add(carpetBRTile);

        Frame closet1Frame = new FrameBuilder(getSubImage(3, 0))
                .withScale(tileScale)
                .build();
        
        MapTileBuilder closet1Tile= new MapTileBuilder(closet1Frame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(closet1Tile);

        Frame closet2Frame = new FrameBuilder(getSubImage(3, 1))
                .withScale(tileScale)
                .build();
        
        MapTileBuilder closet2Tile= new MapTileBuilder(closet2Frame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(closet2Tile);

        Frame desk1Frame = new FrameBuilder(getSubImage(3, 2))
                .withScale(tileScale)
                .build();
        
        MapTileBuilder desk1Tile= new MapTileBuilder(desk1Frame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(desk1Tile);

        Frame desk2Frame = new FrameBuilder(getSubImage(3, 3))
                .withScale(tileScale)
                .build();
        
        MapTileBuilder desk2Tile= new MapTileBuilder(desk2Frame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(desk2Tile);

        Frame deskTopFrame = new FrameBuilder(getSubImage(3, 4))
                .withScale(tileScale)
                .build();
        
        MapTileBuilder deskTopTile= new MapTileBuilder(deskTopFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(deskTopTile);

        Frame laptopFrame = new FrameBuilder(getSubImage(4, 0))
                .withScale(tileScale)
                .build();
        
        MapTileBuilder lapTopTile= new MapTileBuilder(deskTopFrame)
                .withTopLayer(laptopFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(lapTopTile);

        Frame waterBottleFrame = new FrameBuilder(getSubImage(4, 1))
                .withScale(tileScale)
                .build();
        
        MapTileBuilder waterBottleTile= new MapTileBuilder(topBedFrameAlt)
                .withTopLayer(waterBottleFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(waterBottleTile);

        Frame penFrame = new FrameBuilder(getSubImage(4, 2))
                .withScale(tileScale)
                .build();
        
        MapTileBuilder penTile= new MapTileBuilder(topBedFrameAlt)
                .withTopLayer(penFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(penTile);

        Frame pencilAndNotebookFrame = new FrameBuilder(getSubImage(4, 3))
                .withScale(tileScale)
                .build();
        
        MapTileBuilder pencilAndNotebookTile= new MapTileBuilder(deskTopFrame)
                .withTopLayer(pencilAndNotebookFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(pencilAndNotebookTile);

        Frame phoneFrame = new FrameBuilder(getSubImage(4, 4))
                .withScale(tileScale)
                .build();
        
        MapTileBuilder phoneTile= new MapTileBuilder(topBedFrameAlt)
                .withTopLayer(phoneFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(phoneTile);

        return mapTiles;
    }
}