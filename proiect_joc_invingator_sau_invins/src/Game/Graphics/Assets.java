package Game.Graphics;

import java.awt.image.BufferedImage;

public class Assets {
    public static BufferedImage grass;

    public static BufferedImage fireRight[]=new BufferedImage[7];
    public static BufferedImage fireLeft[]=new BufferedImage[7];
    public static BufferedImage fireUp[]=new BufferedImage[6];
    public static BufferedImage fireDown[]=new BufferedImage[6];
    public static BufferedImage fireP[]=new BufferedImage[8];

    public static BufferedImage waterRight[]=new BufferedImage[8];
    public static BufferedImage waterUp[]=new BufferedImage[8];
    public static BufferedImage waterDown[]=new BufferedImage[8];
    public static BufferedImage waterLeft[]=new BufferedImage[8];
    public static BufferedImage waterP[]=new BufferedImage[8];

    public static BufferedImage airRight[]=new BufferedImage[5];
    public static BufferedImage airUp[]=new BufferedImage[5];
    public static BufferedImage airDown[]=new BufferedImage[5];
    public static BufferedImage airLeft[]=new BufferedImage[5];
    public static BufferedImage airP[]=new BufferedImage[5];

    public static BufferedImage chooseCh;
    public static BufferedImage ChAir;
    public static BufferedImage ChFire;
    public static BufferedImage ChWater;
    public static BufferedImage player2;
    public static BufferedImage player1;
    public static BufferedImage menu;
    public static BufferedImage pause;

    public static Sound MenuMusic;
    public static Sound LevelMusic;
    public static Sound WinMusic;

    public static BufferedImage butoane[]=new BufferedImage[2];
    public static void Init()
    {
        SpriteSheet sheet=new SpriteSheet(ImageLoader.LoadImage("/textures/elements1.png"));
        SpriteSheet fire=new SpriteSheet(ImageLoader.LoadImage("/textures/fireDown.png"));
        SpriteSheet air=new SpriteSheet(ImageLoader.LoadImage("/textures/aer1.png"));
        SpriteSheet water=new SpriteSheet(ImageLoader.LoadImage("/textures/apa1.png"));
        SpriteSheet putere=new SpriteSheet(ImageLoader.LoadImage("/textures/obiecte.png"));
        SpriteSheet but=new SpriteSheet(ImageLoader.LoadImage("/textures/butoane.png"));
        chooseCh=ImageLoader.LoadImage("/textures/menu.jpg");
        ChAir=ImageLoader.LoadImage("/textures/air.png");
        ChFire=ImageLoader.LoadImage("/textures/fire.png");
        ChWater=ImageLoader.LoadImage("/textures/water.png");
        player1=ImageLoader.LoadImage("/textures/player1t.jpg");
        player2=ImageLoader.LoadImage("/textures/player2t.jpg");
        menu=ImageLoader.LoadImage("/textures/player2t.jpg");
        pause=ImageLoader.LoadImage("/textures/player2t.jpg");
        grass=sheet.crop(0,0);

        butoane[0]=but.crop64(0,0);
        butoane[1]=but.crop64(5,0);
        fireDown[0]=fire.crop64(0,0);
        fireDown[1]=fire.crop64(1,0);
        fireDown[2]=fire.crop64(2,0);
        fireDown[3]=fire.crop64(3,0);
        fireDown[4]=fire.crop64(4,0);
        fireDown[5]=fire.crop64(5,0);
        fireUp[0]=fire.crop64(0,1);
        fireUp[1]=fire.crop64(1,1);
        fireUp[2]=fire.crop64(2,1);
        fireUp[3]=fire.crop64(3,1);
        fireUp[4]=fire.crop64(4,1);
        fireUp[5]=fire.crop64(5,1);
        fireRight[0]=fire.crop64(0,2);
        fireRight[1]=fire.crop64(1,2);
        fireRight[2]=fire.crop64(2,2);
        fireRight[3]=fire.crop64(3,2);
        fireRight[4]=fire.crop64(4,2);
        fireRight[5]=fire.crop64(5,2);
        fireRight[6]=fire.crop64(6,2);
        fireLeft[0]=fire.crop64(0,3);
        fireLeft[1]=fire.crop64(1,3);
        fireLeft[2]=fire.crop64(2,3);
        fireLeft[3]=fire.crop64(3,3);
        fireLeft[4]=fire.crop64(4,3);
        fireLeft[5]=fire.crop64(5,3);
        fireLeft[6]=fire.crop64(6,3);

        fireP[0]=putere.crop64(0,1);
        fireP[1]=putere.crop64(1,1);
        fireP[2]=putere.crop64(2,1);
        fireP[3]=putere.crop64(3,1);
        fireP[4]=putere.crop64(4,1);
        fireP[5]=putere.crop64(5,1);
        fireP[6]=putere.crop64(6,1);
        fireP[7]=putere.crop64(7,1);

        waterDown[0]=water.crop64(0,0);
        waterDown[1]=water.crop64(1,0);
        waterDown[2]=water.crop64(2,0);
        waterDown[3]=water.crop64(3,0);
        waterDown[4]=water.crop64(4,0);
        waterDown[5]=water.crop64(5,0);
        waterDown[6]=water.crop64(6,0);
        waterDown[7]=water.crop64(7,0);
        waterUp[0]=water.crop64(0,3);
        waterUp[1]=water.crop64(1,3);
        waterUp[2]=water.crop64(2,3);
        waterUp[3]=water.crop64(3,3);
        waterUp[4]=water.crop64(4,3);
        waterUp[5]=water.crop64(5,3);
        waterUp[6]=water.crop64(6,3);
        waterUp[7]=water.crop64(7,3);
        waterRight[0]=water.crop64(0,1);
        waterRight[1]=water.crop64(1,1);
        waterRight[2]=water.crop64(2,1);
        waterRight[3]=water.crop64(3,1);
        waterRight[4]=water.crop64(4,1);
        waterRight[5]=water.crop64(5,1);
        waterRight[6]=water.crop64(6,1);
        waterRight[7]=water.crop64(7,1);
        waterLeft[0]=water.crop64(0,2);
        waterLeft[1]=water.crop64(1,2);
        waterLeft[2]=water.crop64(2,2);
        waterLeft[3]=water.crop64(3,2);
        waterLeft[4]=water.crop64(4,2);
        waterLeft[5]=water.crop64(5,2);
        waterLeft[6]=water.crop64(6,2);
        waterLeft[7]=water.crop64(7,2);

        waterP[0]=putere.crop64(0,2);
        waterP[1]=putere.crop64(1,2);
        waterP[2]=putere.crop64(2,2);
        waterP[3]=putere.crop64(3,2);
        waterP[4]=putere.crop64(4,2);
        waterP[5]=putere.crop64(5,2);
        waterP[6]=putere.crop64(6,2);
        waterP[7]=putere.crop64(7,2);

        airDown[0]=air.crop64(0,0);
        airDown[1]=air.crop64(1,0);
        airDown[2]=air.crop64(2,0);
        airDown[3]=air.crop64(3,0);
        airDown[4]=air.crop64(4,0);
        airUp[0]=air.crop64(0,3);
        airUp[1]=air.crop64(1,3);
        airUp[2]=air.crop64(2,3);
        airUp[3]=air.crop64(3,3);
        airUp[4]=air.crop64(4,3);

        airRight[0]=air.crop64(0,2);
        airRight[1]=air.crop64(1,2);
        airRight[2]=air.crop64(2,2);
        airRight[3]=air.crop64(3,2);
        airRight[4]=air.crop64(4,2);
        airLeft[0]=air.crop64(0,3);
        airLeft[1]=air.crop64(1,3);
        airLeft[2]=air.crop64(2,3);
        airLeft[3]=air.crop64(3,3);
        airLeft[4]=air.crop64(4,3);

        airP[0]=putere.crop64(0,0);
        airP[1]=putere.crop64(1,0);
        airP[2]=putere.crop64(2,0);
        airP[3]=putere.crop64(3,0);
        airP[4]=putere.crop64(4,0);

        MenuMusic   = new Sound("res/music/menuSound.wav");
        LevelMusic=new Sound("res/music/level.wav");
        WinMusic=new Sound("res/music/win.wav");
    }
}
