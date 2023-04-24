package Game.Characters;
import Game.Graphics.Assets;
import Game.Links;
import java.awt.image.BufferedImage;

public class Water extends Elements {
    private BufferedImage actual;
    public BufferedImage[] putere;
    boolean right = false, left = false, up = false, down = false;
    boolean play = false;
    int W = 35;
    int H = 35;
    private static Water instance;
    public Water(int x, int y, int width, int height,int widthR, int heightR, BufferedImage img,int index) {
        super(x, y, width, height,widthR,heightR, img);
        actual = Assets.waterDown[0];
        putere=Assets.waterP;
    }
    /*! fn  public static Water getInstance(int x, int y, int width, int height, int widthR, int heightR,BufferedImage img,int index)
   Functie pentru Singleton
    */
    public static Water getInstance(int x, int y, int width, int height, int widthR, int heightR,BufferedImage img,int index)
    {
        if (instance == null)
            instance = new Water(x,y,width,height, widthR,heightR,img,index);
        return instance;
    }
    public static void resetInstance() {
        instance = null;
    }


    @Override
    public void Draw() {
        if (play == true) {
            if (down == true) {
                DrawPers(Assets.waterDown);
                down = false;
                play = false;
            } else if (up == true) {
                DrawPers(Assets.waterUp);
                up = false;
                play = false;
            } else if (right == true) {
                DrawPers(Assets.waterRight);
                right = false;
                play = false;
            } else if (left == true) {
                DrawPers(Assets.waterLeft);
                left = false;
                play = false;
            }
        }
        else {
            Links.g.drawImage(actual, x, y, H, W, null);
        }

    }
    public void Stop()
    {
        play=false;
    }

    public int getX()
    {
        return x;
    }
    public int getY()
    {
        return y;
    }
}
