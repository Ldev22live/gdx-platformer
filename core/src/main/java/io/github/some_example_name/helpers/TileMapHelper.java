package helpers;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTileMapRenderer;


public class TileMapHelper{
    private TiledMap tiledMap;

    public TileMapHelper(){

    }

    public OrthogonalTileMapRenderer setupMap(){
        tiledMap = new TmxMapLoader().load("maps/map0.tmx");
        return new OrthogonalTileMapRenderer(tiledMap);
;    }
}
