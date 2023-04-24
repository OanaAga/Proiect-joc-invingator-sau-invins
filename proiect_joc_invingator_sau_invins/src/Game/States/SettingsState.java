package Game.States;
import Game.Graphics.Assets;
import Game.Links;
import Game.Graphics.ImageLoader;

import java.awt.*;
import java.awt.image.BufferedImage;

public class SettingsState extends State{
    private Rectangle rect1;
    private Rectangle rect2;
    private Rectangle rect3;
    private Rectangle rect4;
    private Rectangle rect5;
    private Rectangle but1;
    private Rectangle but2;
    public static boolean play=false;
    public static boolean stop=false;
    boolean vol1=false;
    boolean vol2=false;
    boolean vol3=false;
    BufferedImage button;

    public SettingsState()
    {
        super();
        button=ImageLoader.LoadImage("/textures/button.png");
        rect1=new Rectangle(225,255,133,30);
        rect2=new Rectangle(225+133,255,133,30);
        rect3=new Rectangle(225+133+133,255,133,30);
        rect4=new Rectangle(225,355,200,30);
        rect5=new Rectangle(425,355,200,30);
        but1=new Rectangle(210,560,200,60);
        but2=new Rectangle(445,560,200,60);
    }
    @Override
    public void Update() {
        if(Links.game.mouseInput.clickRight==true && rect4.contains(Links.game.mouseInput.getX(),Links.game.mouseInput.getY()))
        {
            Links.game.mouseInput.clickRight=false;
            stop=true;
            play=false;
            Assets.MenuMusic.stop();
        }
        else if(Links.game.mouseInput.clickRight==true && rect5.contains(Links.game.mouseInput.getX(),Links.game.mouseInput.getY()))
        {
            Links.game.mouseInput.clickRight=false;
            play=true;
            stop=false;
            Assets.MenuMusic.play();
        }
        if(Links.game.mouseInput.clickRight==true && rect1.contains(Links.game.mouseInput.getX(),Links.game.mouseInput.getY()))
        {
            Links.game.mouseInput.clickRight=false;
            Assets.MenuMusic.setVolume(0.3);
            Assets.LevelMusic.setVolume(0.3);
            Assets.WinMusic.setVolume(0.3);
            vol1=true;
            vol2=false;
            vol3=false;
        }
        else if (Links.game.mouseInput.clickRight==true && rect2.contains(Links.game.mouseInput.getX(),Links.game.mouseInput.getY()))
        {
            Links.game.mouseInput.clickRight=false;
            Assets.MenuMusic.setVolume(0.7);
            Assets.LevelMusic.setVolume(0.7);
            Assets.WinMusic.setVolume(0.7);
            vol1=false;
            vol2=true;
            vol3=false;
        }
        else if(Links.game.mouseInput.clickRight==true && rect3.contains(Links.game.mouseInput.getX(),Links.game.mouseInput.getY()))
        {
            Links.game.mouseInput.clickRight=false;
            Assets.MenuMusic.setVolume(1.5);
            Assets.LevelMusic.setVolume(1.5);
            Assets.WinMusic.setVolume(1.5);
            vol1=false;
            vol2=false;
            vol3=true;
        }
        if(Links.game.mouseInput.clickRight==true &&but1.contains(Links.game.mouseInput.getX(),Links.game.mouseInput.getY())) {
            Links.game.mouseInput.clickRight=false;
            State.SetState(Links.game.menuState);
        }
        else if(Links.game.mouseInput.clickRight==true &&but2.contains(Links.game.mouseInput.getX(),Links.game.mouseInput.getY())) {
            if(play)
            {
                stop=true;
                play=false;
            }
            if(stop)
            {
                stop=false;
                play=true;
            }

            Links.game.mouseInput.clickRight=false;
            State.SetState(Links.game.menuState);
        }
    }

    @Override
    public void Draw() {
        BufferedImage background;
        BufferedImage settings;
        background=ImageLoader.LoadImage("/textures/menu.jpg");
        settings=ImageLoader.LoadImage("/textures/settings.png");
        Links.g.drawImage(background,0,0,820,800, null);
        Links.g.drawImage(settings,0,0,820,800, null);
        if(play==true)
            Links.g.drawImage(button,500,345,45,45, null);
        else if(stop==true)
            Links.g.drawImage(button,300,345,45,45, null);
        if(vol1)
            Links.g.drawImage(button,290,245,45,45, null);
        else if(vol2)
            Links.g.drawImage(button,290+110,245,45,45, null);
        else if(vol3)
            Links.g.drawImage(button,290+133+110,245,45,45, null);

       // System.out.println(Links.game.mouseInput.getX()+" "+Links.game.mouseInput.getY());
        Links.game.getBs().show();
        Links.g.dispose();

    }
}
