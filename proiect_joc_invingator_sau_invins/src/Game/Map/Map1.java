package Game.Map;
import java.awt.*;
import java.awt.image.BufferedImage;


import Game.GameWindow.GameWindow;
import Game.Graphics.Assets;
import Game.Links;
import Game.Graphics.ImageLoader;
import Game.Tiles.Tile;

import java.util.Vector;


public class Map1 {
    public static Vector<RectangleI> Rectangle1 = new Vector<>();//dreptunghiuri pentru butoane
    public static Rectangle rec1=new Rectangle(19*40-8,5,53,15);
    public static Rectangle rec2=new Rectangle(19*40-8,26,53,15);
    static BufferedImage[] butoane =new BufferedImage[4];
    public  static int[][] map1=new int[][]{
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1},
            {1, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1},
            {1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1},
            {1, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1},
            {1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1},
            {1, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1},
            {1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1},
            {1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0, 1, 0, 1},
            {1, 0, 0, 1, 1, 0, 1, 0, 1, 0, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 1},
            {1, 1, 0, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1},
            {1, 1, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 1},
            {0, 0, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 0},
            {1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 1, 1},
            {1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1},
            {1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
            {1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1},
            {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},

    };
    public static void Draw(Graphics g) {
        BufferedImage background;
        BufferedImage comoara;
        ImageLoader img =new ImageLoader();
        background=ImageLoader.LoadImage("/textures/backgroundComp.png");
        comoara=ImageLoader.LoadImage("/textures/comoara.png");
        butoane[0]=ImageLoader.LoadImage("/textures/button1.png");
        butoane[1]=ImageLoader.LoadImage("/textures/button2.png");
        butoane[2]=ImageLoader.LoadImage("/textures/button3.png");
        butoane[3]=ImageLoader.LoadImage("/textures/button4.png");
        GameWindow.WindowFrame.resize(820,800);
        g.drawImage(background,0,0,820,20*40,null);
        g.drawImage(comoara,480,400,400,400,null);
        g.drawImage(butoane[0],775+5-15-2,720-5-2,25,25,null);
        g.drawImage(butoane[1],750+5-15-2,700-5-2,25,25,null);
        g.drawImage(butoane[2],725+5-15-2,720-5-2,25,25,null);
        g.drawImage(butoane[3],750+5-15-2,740-5-2,25,25,null);
        DrawTree(g);
        DrawBush(g);
        DrawRock(g);
        DrawButtons();
        Links.player1.EntityPers1map1(Links.player1.putere);
        Links.player2.EntityPers2map1(Links.player2.putere);
        for(int i=0;i< map1.length;i++)
                {
                    for(int j=0;j< map1[i].length;j++)
                    {
                        if(map1[i][j]==1)
                        {
                            Rectangle1.add(new RectangleI(j*Tile.TILE_HEIGHT,i*Tile.TILE_WIDTH,Tile.TILE_WIDTH,Tile.TILE_HEIGHT));
                        }
                    }
                }


    }
    /*!
    fn public static void DrawTree(Graphics g)
     Aceasta functie deseneaza copacii
     */
    public static void DrawTree(Graphics g)
    {
        Graphics gr= Links.g;
        BufferedImage tree;
        tree=ImageLoader.LoadImage("/textures/copac.png");
        //copaci sus stanga
        g.drawImage(tree,2*40-15,2*40-20,1050,1050,null);
        g.drawImage(tree,3*40,2*40+20,950,950,null);
        g.drawImage(tree,1*40+15,3*40+20,1000,1000,null);
        g.drawImage(tree,3*40+20,4*40,1000,1000,null);
        g.drawImage(tree,2*40+10,5*40,1050,1050,null);
        g.drawImage(tree,2*40-20,7*40-25,1000,1000,null);
        g.drawImage(tree,3*40-5,6*40+30,1050,1050,null);


        //copaci colt stanga
        g.drawImage(tree,10,14*40-10,900,1000,null);
        g.drawImage(tree,-30,15*40+10,900,1000,null);
        g.drawImage(tree,10,17*40-20,900,1100,null);

        //copac jos
        g.drawImage(tree,3*40,15*40+10,800,1000,null);

        //copaci dreapta mijloc
        g.drawImage(tree,15*40,14*40-30,1000,1100,null);
        g.drawImage(tree,14*40-20,13*40-15,900,1000,null);
        g.drawImage(tree,15*40+20,12*40-30,800,900,null);
        g.drawImage(tree,15*40+20,9*40,800,900,null);
        g.drawImage(tree,14*40,8*40-20,1000,1100,null);
        g.drawImage(tree,12*40+10,7*40,1000,1100,null);

        //copaci dreapta sus
        g.drawImage(tree,16*40+35,2*40-15,1000,1100,null);
        g.drawImage(tree,16*40+10,4*40-20,900,1000,null);
        g.drawImage(tree,16*40+45,6*40-30,1000,1100,null);
    }
    /*!
    fn public static void DrawBush(Graphics g)
     Aceasta functie deseneaza tufisurile
     */
    public static void DrawBush(Graphics g)
    {
        BufferedImage bush;
        bush=ImageLoader.LoadImage("/textures/bush.png");
        //sus
        g.drawImage(bush,10*40,4*40-35,800,700,null);
        g.drawImage(bush,9*40+15,4*40-20,700,650,null);
        g.drawImage(bush,11*40-5,4*40-17,650,650,null);

        //stanga
        g.drawImage(bush,19*40-10,10*40,900,900,null);
        g.drawImage(bush,18*40,11*40-20,800,800,null);
        g.drawImage(bush,19*40+5,11*40-3,800,800,null);
        g.drawImage(bush,19*40-15,11*40+10,650,650,null);

        //dreapta
        g.drawImage(bush,2*40-22,8*40+3,600,600,null);
        g.drawImage(bush,2*40-10,8*40+21,650,650,null);
        g.drawImage(bush,2*40+18,8*40+15,650,650,null);

    }
    /*!
    fn public static void DrawRock(Graphics g)
     Aceasta functie deseneaza pietre
     */
    public static void DrawRock(Graphics g)
    {
        BufferedImage rock;
        rock=ImageLoader.LoadImage("/textures/rock.png");
        g.drawImage(rock,7*40-7,9*40-10,550,550,null);
        g.drawImage(rock,4*40-7,13*40-10,550,550,null);
        g.drawImage(rock,9*40-7,10*40-10,550,550,null);
        g.drawImage(rock,200-7,145-10,550,550,null);
        g.drawImage(rock,190-7,645-10,550,550,null);
        g.drawImage(rock,585-10,285-10,550,550,null);

    }
    /*!
    fn public static void DrawButtons(Graphics g)
     Aceasta functie deseneaza butoanele pentru meniul din joc
     */
    public static void DrawButtons()
    {
        Graphics gr=Links.g;
        Links.g.drawImage(Assets.butoane[0],18*40+30,-8,60,60,null);
        Links.g.drawImage(Assets.butoane[1],18*40+30,12,57,62,null);
    }

}
