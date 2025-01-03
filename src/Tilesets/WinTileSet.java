package Tilesets;

import Builders.FrameBuilder;
import Builders.MapTileBuilder;
import Engine.ImageLoader;
import GameObject.Frame;
import GameObject.ImageEffect;
import Level.TileType;
import Level.Tileset;

import java.util.ArrayList;

public class WinTileSet extends Tileset{

    private Frame grassFrame;

    public WinTileSet() {
        super(ImageLoader.load("DormTilesetOutdoor_1.png"), 16, 16, 3);
    }

    @Override
    public ArrayList<MapTileBuilder> defineTiles() {
        ArrayList<MapTileBuilder> mapTiles = new ArrayList<>();

        //Upper building

        Frame brickFrame = new FrameBuilder(getSubImage(0, 0))
                .withScale(tileScale)
                .build();

        MapTileBuilder brickTile = new MapTileBuilder(brickFrame)
                    .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(brickTile);

        Frame brickEndFrame = new FrameBuilder(getSubImage(0, 1))
                .withScale(tileScale)
                .build();

        MapTileBuilder brickEndTile = new MapTileBuilder(brickEndFrame)
                    .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(brickEndTile);

        Frame brickWindowFrame1 = new FrameBuilder(getSubImage(0, 2))
                .withScale(tileScale)
                .build();

        MapTileBuilder brickWindowTile1 = new MapTileBuilder(brickWindowFrame1)
                    .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(brickWindowTile1);

        Frame brickWindowFrame2 = new FrameBuilder(getSubImage(0, 3))
                .withScale(tileScale)
                .build();

        MapTileBuilder brickWindowTile2 = new MapTileBuilder(brickWindowFrame2)
                    .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(brickWindowTile2);

        Frame brickVentFrame = new FrameBuilder(getSubImage(0, 4))
                .withScale(tileScale)
                .build();

        MapTileBuilder brickVentTile = new MapTileBuilder(brickVentFrame)
                    .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(brickVentTile);

        Frame brickStartFrame = new FrameBuilder(getSubImage(1, 0))
                .withScale(tileScale)
                .build();

        MapTileBuilder brickStartTile = new MapTileBuilder(brickStartFrame)
                    .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(brickStartTile);

        

        //Lower building

        Frame brickEndGrassFrame = new FrameBuilder(getSubImage(1, 1))
                .withScale(tileScale)
                .build();

        MapTileBuilder brickEndGrassTile = new MapTileBuilder(brickEndGrassFrame)
                    .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(brickEndGrassTile);

        Frame brickWindowFrame3 = new FrameBuilder(getSubImage(1, 2))
                .withScale(tileScale)
                .build();

        MapTileBuilder brickWindowTile3 = new MapTileBuilder(brickWindowFrame3)
                    .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(brickWindowTile3);

        Frame brickWindowFrame4 = new FrameBuilder(getSubImage(1, 3))
                .withScale(tileScale)
                .build();

        MapTileBuilder brickWindowTile4 = new MapTileBuilder(brickWindowFrame4)
                    .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(brickWindowTile4);

        Frame brickFrame2 = new FrameBuilder(getSubImage(1, 4))
                .withScale(tileScale)
                .build();

        MapTileBuilder brickTile2 = new MapTileBuilder(brickFrame2)
                    .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(brickTile2);

        Frame brickThingFrame = new FrameBuilder(getSubImage(02, 0))
                .withScale(tileScale)
                .build();

        MapTileBuilder brickThingTile = new MapTileBuilder(brickThingFrame)
                    .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(brickThingTile);

        Frame brickFanFrame = new FrameBuilder(getSubImage(02, 1))
                .withScale(tileScale)
                .build();

        MapTileBuilder brickFanTile = new MapTileBuilder(brickFanFrame)
                    .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(brickFanTile);

        Frame brickPosterFrame = new FrameBuilder(getSubImage(2, 2))
                .withScale(tileScale)
                .build();

        MapTileBuilder brickPosterTile = new MapTileBuilder(brickPosterFrame)
                    .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(brickPosterTile);

        Frame brickAdFrame = new FrameBuilder(getSubImage(2, 3))
                .withScale(tileScale)
                .build();

        MapTileBuilder brickAdTile = new MapTileBuilder(brickAdFrame)
                    .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(brickAdTile);

        Frame brickIDKFrame = new FrameBuilder(getSubImage(2, 4))
                .withScale(tileScale)
                .build();

        MapTileBuilder brickIDKTile = new MapTileBuilder(brickIDKFrame)
                    .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(brickIDKTile);

        Frame brickWindowFrameLong = new FrameBuilder(getSubImage(3, 3))
                .withScale(tileScale)
                .build();

        MapTileBuilder brickWindowTileLong = new MapTileBuilder(brickWindowFrameLong)
                    .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(brickWindowTileLong);

        Frame brickFrameDoor = new FrameBuilder(getSubImage(3, 4))
                .withScale(tileScale)
                .build();

        MapTileBuilder brickTileDoor = new MapTileBuilder(brickFrameDoor)
                    .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(brickTileDoor);

        

        //Roof

        Frame grassFrame = new FrameBuilder(getSubImage(5, 3))
                .withScale(tileScale)
                .build();

        MapTileBuilder grassTile = new MapTileBuilder(grassFrame)
                    .withTileType(TileType.PASSABLE);

        mapTiles.add(grassTile);

        Frame roofCenterFrame = new FrameBuilder(getSubImage(3, 0))
                .withScale(tileScale)
                .build();

        MapTileBuilder roofCenterTile = new MapTileBuilder(roofCenterFrame)
                    .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(roofCenterTile);

        Frame roofRightFrame = new FrameBuilder(getSubImage(3, 1))
                .withScale(tileScale)
                .build();

        MapTileBuilder roofRightTile = new MapTileBuilder(grassFrame)
                    .withTopLayer(roofRightFrame)
                    .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(roofRightTile);

        Frame roofLeftFrame = new FrameBuilder(getSubImage(3, 2))
                .withScale(tileScale)
                .build();

        MapTileBuilder roofLeftTile = new MapTileBuilder(grassFrame)
                    .withTopLayer(roofLeftFrame)
                    .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(roofLeftTile);

        //Tower

        Frame brickMetalWindowFrame = new FrameBuilder(getSubImage(4, 0))
                .withScale(tileScale)
                .build();

        MapTileBuilder brickMetalWindowTile = new MapTileBuilder(brickMetalWindowFrame)
                    .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(brickMetalWindowTile);

        Frame brickTowerFrame1 = new FrameBuilder(getSubImage(4, 1))
                .withScale(tileScale)
                .build();

        MapTileBuilder brickTowerTile1 = new MapTileBuilder(brickTowerFrame1)
                    .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(brickTowerTile1);

        Frame brickTowerFrame2 = new FrameBuilder(getSubImage(4, 2))
                .withScale(tileScale)
                .build();

        MapTileBuilder brickTowerTile2 = new MapTileBuilder(brickTowerFrame2)
                    .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(brickTowerTile2);

        Frame brickTowerFrame3 = new FrameBuilder(getSubImage(4, 3))
                .withScale(tileScale)
                .build();

        MapTileBuilder brickTowerTile3 = new MapTileBuilder(brickTowerFrame3)
                    .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(brickTowerTile3);

        Frame brickTowerFrameRoof = new FrameBuilder(getSubImage(4, 4))
                .withScale(tileScale)
                .build();

        MapTileBuilder brickTowerTileRoof = new MapTileBuilder(brickTowerFrameRoof)
                    .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(brickTowerTileRoof);

        Frame stainedGlassFrame1 = new FrameBuilder(getSubImage(5, 0))
                .withScale(tileScale)
                .build();

        MapTileBuilder stainedGlassTile1 = new MapTileBuilder(stainedGlassFrame1)
                    .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(stainedGlassTile1);

        Frame stainedGlassFrame2 = new FrameBuilder(getSubImage(5, 1))
                .withScale(tileScale)
                .build();

        MapTileBuilder stainedGlassTile2 = new MapTileBuilder(stainedGlassFrame2)
                    .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(stainedGlassTile2);

        Frame centerGlassFrame = new FrameBuilder(getSubImage(5, 2))
                .withScale(tileScale)
                .build();

        MapTileBuilder centerGlassTile = new MapTileBuilder(centerGlassFrame)
                    .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(centerGlassTile);

        //Walk path

        

        Frame pavementFrame = new FrameBuilder(getSubImage(5, 4))
                .withScale(tileScale)
                .build();

        MapTileBuilder pavementTile = new MapTileBuilder(pavementFrame)
                    .withTileType(TileType.PASSABLE);

        mapTiles.add(pavementTile);

        Frame brickFrameDoorMirror = new FrameBuilder(getSubImage(3, 4))
                .withScale(tileScale)
                .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                .build();

        MapTileBuilder brickTileDoorMirror = new MapTileBuilder(brickFrameDoorMirror)
                    .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(brickTileDoorMirror);

        Frame grassFrameNotPassableFrame = new FrameBuilder(getSubImage(5, 3))
                .withScale(tileScale)
                .build();

        MapTileBuilder grassFrameNotPassableTile = new MapTileBuilder(grassFrameNotPassableFrame)
                    .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(grassFrameNotPassableTile);

        Frame pavementFrameNotPassableFrame = new FrameBuilder(getSubImage(5, 4))
                .withScale(tileScale)
                .build();

        MapTileBuilder pavementFrameNotPassableTile = new MapTileBuilder(pavementFrameNotPassableFrame)
                    .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(pavementFrameNotPassableTile);

        return mapTiles;
    }

}
