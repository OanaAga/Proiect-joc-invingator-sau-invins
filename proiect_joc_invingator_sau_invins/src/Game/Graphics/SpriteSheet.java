package Game.Graphics;

import java.awt.image.BufferedImage;

public class SpriteSheet{
    private BufferedImage striteSheet;
    private static final int tileWidth=40;
    private static final int tileHeight=40;

    public SpriteSheet(BufferedImage buffImg)
    {
        striteSheet=buffImg;
    }
    public BufferedImage crop(int x,int y)
    {
        return striteSheet.getSubimage(x*tileWidth,y*tileHeight,tileWidth,tileHeight);

    }
    /*! fn public BufferedImage crop64(int x,int y)
    Functie de cropare pentru elemente de 64x64 pixeli
     */
    public BufferedImage crop64(int x,int y)
    {
        return striteSheet.getSubimage(x*64,y*64,64,64);
    }

}
