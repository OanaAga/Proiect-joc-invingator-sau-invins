package Game.Map;

import Game.GameWindow.GameWindow;
import Game.Graphics.Assets;
import Game.Graphics.ImageLoader;
import Game.Links;
import Game.Tiles.Tile;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Vector;

public class Map2 {
    public static Vector<RectangleI> Rectangle1 = new Vector<>();

    public static Rectangle recSuper1=new Rectangle(40*13+12+2*40,40*11+7+1*40,25,25);
    public static Rectangle recSuper2=new Rectangle(40*6+5+3*40,40*10+7+1*40,25,25);
    static BufferedImage[] butoane =new BufferedImage[4];
    public static int[][] map2=new int[][]{
            {1, 1, 1, 1, 1, 1, 1, 1,1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1},
            {1,1,0,1,1,1,0,1,0,1,1,1,1,0,1,0,1,0,1,1},
            {1,1,0,1,0,1,1,1,0,0,1,0,1,1,1,0,1,0,1,1},
            {1,1,0,0,0,0,0,1,0,1,1,0,1,0,0,0,1,0,1,1},
            {1,1,1,1,1,1,0,1,1,1,0,0,1,0,0,0,1,0,1,1},
            {1,1,0,1,0,1,0,1,0,0,0,0,1,0,1,1,1,0,1,1},
            {1,1,0,1,0,1,0,1,0,1,1,0,1,1,1,0,1,0,1,1},
            {0,0,0,1,0,0,0,1,0,1,0,0,0,0,1,0,1,0,0,0},
            {1,1,0,1,1,1,0,1,0,1,1,1,1,0,1,0,1,1,1,1},
            {1,1,0,0,0,1,0,0,0,0,1,0,1,0,1,0,1,0,1,1},
            {1,1,0,1,1,1,1,1,1,0,1,0,1,0,0,0,0,0,1,1},
            {1,1,0,1,0,0,1,0,1,1,1,0,1,1,1,0,1,0,1,1},
            {1,1,0,0,0,0,1,0,0,0,1,0,1,0,1,1,1,0,1,1},
            {1,1,0,1,0,0,1,1,1,0,1,0,1,0,0,0,0,0,1,1},
            {1,1,0,1,0,0,0,0,1,0,0,0,1,0,1,1,1,0,1,1},
            {1,1,0,1,1,0,1,0,1,1,0,1,1,0,1,0,1,1,1,1},
            {1,1,0,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0,1,1},
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
    };
    public static void Draw(Graphics g) {
        BufferedImage background;
        ImageLoader img = new ImageLoader();
        background = ImageLoader.LoadImage("/textures/peisaj2.png");
        BufferedImage coif=ImageLoader.LoadImage("/textures/coif.png");
        BufferedImage coroana=ImageLoader.LoadImage("/textures/coroana.png");
        GameWindow.WindowFrame.resize(800,800);
        g.drawImage(background, 0, 0, 800, 20 * 40, null);
        g.drawImage(coif,40*13+12+2*40,40*11+7+1*40,25,25,null);
        g.drawImage(coif,40*6+5+3*40,40*10+7+1*40,25,25,null);
        g.drawImage(coroana,40*10+5,40*8+10,25,25,null);
        butoane[0]=ImageLoader.LoadImage("/textures/button1.png");
        butoane[1]=ImageLoader.LoadImage("/textures/button2.png");
        butoane[2]=ImageLoader.LoadImage("/textures/button3.png");
        butoane[3]=ImageLoader.LoadImage("/textures/button4.png");
        g.drawImage(butoane[0],775+5-15-2,720-5-2,25,25,null);
        g.drawImage(butoane[1],750+5-15-2,700-5-2,25,25,null);
        g.drawImage(butoane[2],725+5-15-2,720-5-2,25,25,null);
        g.drawImage(butoane[3],750+5-15-2,740-5-2,25,25,null);
        DrawRock(Links.g);
        for(int i=0;i< map2.length;i++)
        {
            for (int j=0;j< map2[i].length;j++)
            {
                if(map2[i][j]==1) {
                    Rectangle1.add(new RectangleI(j*Tile.TILE_HEIGHT,i*Tile.TILE_WIDTH,Tile.TILE_WIDTH,Tile.TILE_HEIGHT));
                }
            }
        }
        DrawButtons();
        Links.player1.EntityPers1map2(Links.player1.putere);
        Links.player2.EntityPers2map2(Links.player2.putere);
    }
    /*!
    fn public static void DrawButtons(Graphics g)
     Aceasta functie deseneaza butoane
     */
    public static void DrawButtons()
    {
        Links.g.drawImage(Assets.butoane[0],18*40,-8,60,60,null);
        Links.g.drawImage(Assets.butoane[1],18*40,12,57,63,null);
    }
    /*!
    fn public static void DrawRock(Graphics g)
     Aceasta functie deseneaza pietre
     */
    public static void DrawRock(Graphics g)
    {
        BufferedImage rock;
        rock=ImageLoader.LoadImage("/textures/rock.png");
        g.drawImage(rock,600,215-15,550,550,null);
        g.drawImage(rock,185-30,400-10,550,550,null);
        g.drawImage(rock,415-20,215-15,550,550,null);
        g.drawImage(rock,215-15,520,550,550,null);

    }

}
