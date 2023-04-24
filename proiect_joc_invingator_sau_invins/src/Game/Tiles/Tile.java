package Game.Tiles;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Tile {
    private static final int NO_TILES=40;
    public static Tile[] tiles=new Tile[NO_TILES];

    public static Tile grassTile=new GrassTile(1);

    public static final int TILE_WIDTH  = 40;
    public static final int TILE_HEIGHT = 40;
    public BufferedImage img;
    public boolean collision=false;
    protected final int id;

    public Tile(BufferedImage image, int idd)
    {
        img=image;
        id=idd;

        tiles[id]=this;
    }
    public void Update()
    {

    }
    public void Draw(Graphics g,int x,int y)
    {
        g.drawImage(img,x,y,TILE_WIDTH,TILE_HEIGHT,null);
    }
    public void DrawTree(Graphics g,int x,int y,int hight,int width)
    {
        g.drawImage(img,x,y,hight,width,null);
    }
    public boolean IsSolid()
    {
        return false;
    }
    public int GetId(){
        return id;
    }
    public static final Tile getTile(int id) {
        return tiles[id];
    }

}
