package Game.Characters;
import Game.Graphics.Assets;
import Game.Links;
import java.awt.image.BufferedImage;

public class Fire extends Elements{

    public BufferedImage actual ;
    boolean right=false,left=false, up=false,down=false;
    boolean play=false;
    int W=35;
    int H=35;
    private static Fire instance;
    public Fire(int x, int y, int width, int height, int widthR, int heightR,BufferedImage img,int index) {
        super(x, y, width,  height, widthR,heightR,img);
        actual=Assets.fireDown[0];
    }
    @Override
    public void Draw() {
        if (play == true) {

            if (down == true) {

                DrawPers(Assets.fireDown);
                down = false;
                play = false;
            } else if (up == true) {
                DrawPers(Assets.fireUp);
                up = false;
                play = false;
            }
            else if (right == true) {
                DrawPers(Assets.fireRight);
                right = false;
                play = false;
            }
            else if (left == true) {
                DrawPers(Assets.fireLeft);
                left = false;
                play = false;
            }
        }else
        {
            Links.g.drawImage(actual, x, y, H, W, null);
        }

    }
    /*! fn  public static Fire getInstance(int x, int y, int width, int height, int widthR, int heightR,BufferedImage img,int index)
    Functie pentru Singleton
     */
    public static Fire getInstance(int x, int y, int width, int height, int widthR, int heightR,BufferedImage img,int index)
    {
        if (instance == null)
            instance = new Fire(x,y,width,height, widthR,heightR,img,index);
        return instance;
    }
    public static void resetInstance() {
        instance = null;
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
