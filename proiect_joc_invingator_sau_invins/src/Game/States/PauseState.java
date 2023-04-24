package Game.States;
import Game.GameWindow.GameWindow;
import Game.Graphics.Assets;
import Game.Links;
import Game.Graphics.ImageLoader;
import Game.Input.MouseInput;

import java.awt.*;
import java.awt.image.BufferedImage;

public class PauseState extends State{
    private BufferedImage pauseState;
    private BufferedImage background;
    public PauseState()
    {
        super();
        pauseState=ImageLoader.LoadImage("/textures/pause.png");
        background=ImageLoader.LoadImage("/textures/menu.jpg");

    }
    @Override
    public void Update() {
        if(Links.game.mouseInput.clickRight==true && new Rectangle(300,290,210,50).contains(Links.game.mouseInput.getX(),Links.game.mouseInput.getY()))
        {
            if(!SettingsState.stop) {
                Assets.LevelMusic.play();
                Assets.MenuMusic.stop();
            }
            Links.game.mouseInput.clickRight=false;
            if(Level1State.level1) {
                State.SetState(Links.game.level1State);
            }
            if(Level2State.level2)
            {
                State.SetState(Links.game.level2State);
            }
        }
        if(Links.game.mouseInput.clickRight==true && new Rectangle(300,355,210,50).contains(Links.game.mouseInput.getX(),Links.game.mouseInput.getY()))
        {
            Links.game.mouseInput.clickRight=false;
            ChooseCharacter1.isWater1=false;
            ChooseCharacter1.isFire1 =false;
            ChooseCharacter1.isAir1=false;
            ChooseCharacter2.isFire2=false;
            ChooseCharacter2.isAir2=false;
            ChooseCharacter2.isWater2=false;
            if(!SettingsState.stop) {
                Assets.LevelMusic.stop();
                Assets.MenuMusic.play();
            }
            State.SetState(Links.game.chooseCharacter1);
        }
        if(Links.game.mouseInput.clickRight==true && new Rectangle(300,415,210,50).contains(Links.game.mouseInput.getX(),Links.game.mouseInput.getY()))
        {
            Links.game.mouseInput.clickRight=false;
            if(!SettingsState.stop) {
                Assets.LevelMusic.stop();
                Assets.MenuMusic.play();
            }
            State.SetState(Links.game.menuState);
        }
        if(Links.game.mouseInput.clickRight==true && new Rectangle(300,485,210,50).contains(Links.game.mouseInput.getX(),Links.game.mouseInput.getY()))
        {
            Links.game.mouseInput.clickRight=false;
            GameWindow.close();

        }

    }

    @Override
    public void Draw() {
        Links.g.drawImage(background,0,0,820,800, null);
        Links.g.drawImage(pauseState,150,150,500,500,null);
        System.out.println(Links.game.mouseInput.getX()+" "+Links.game.mouseInput.getY());
        Links.game.getBs().show();
        Links.g.dispose();

    }
}
