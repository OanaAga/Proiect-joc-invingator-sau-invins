package Game.Characters;
import Game.Graphics.Assets;
import Game.Links;
import java.awt.image.BufferedImage;

public class Air extends Elements{

    private BufferedImage actual ;
    public BufferedImage[] putere;
    boolean right=false,left=false, up=false,down=false;
    boolean play=false;
    int W=35;
    int H=35;
    private static Air instance;
    public Air(int x, int y, int width, int height, int widthR, int heightR,BufferedImage img) {
        super(x, y, width, height, widthR,heightR,img);
        actual=Assets.airDown[0];
        putere=Assets.airP;
    }
    /*! fn  public static Air getInstance(int x, int y, int width, int height, int widthR, int heightR,BufferedImage img)
    Functie pentru Singleton
     */
    public static Air getInstance(int x, int y, int width, int height, int widthR, int heightR,BufferedImage img)
    {
        if (instance == null)
            instance = new Air(x,y,width,height, widthR,heightR,img);
        return instance;
    }
    public static void resetInstance() {
        instance = null;
    }

    @Override
    public void Draw() {
        if (play == true) {

            if (down == true) {
                DrawPers(Assets.airDown);
                down = false;
                play = false;
            } else if (up == true) {
                DrawPers(Assets.airUp);
                up = false;
                play = false;
            }
            else if (right == true) {
                DrawPers(Assets.airRight);
                right = false;
                play = false;
            }
            else if (left == true) {
                DrawPers(Assets.airLeft);
                left = false;
                play = false;
            }
        }else
        {
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
