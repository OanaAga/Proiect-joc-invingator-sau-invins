package Game.States;
import Game.Characters.Elements;
import Game.Game;
import Game.Graphics.Assets;
import Game.Graphics.ImageLoader;
import Game.Links;

import java.awt.*;
import java.awt.image.BufferedImage;

public class LevelCompletState extends State  {
    private BufferedImage image;
    public LevelCompletState()
    {
        super();
        ImageLoader im=new ImageLoader();
        image=im.LoadImage("/textures/nivComplet.png");

    }
    @Override
    public void Update() {
        Links.player1.nrEntitati=0;
        Links.player2.nrEntitati=0;

        for(int i=0;i<9;i++) {
            Links.player1.stari[i]=true;
            Links.player2.stari[i]=true;
        }
        if(Links.player1.scor==2)
        {

        }
        else if(Links.player2.scor==2)
        {

        }
        if(Links.game.mouseInput.clickRight==true)
        {
            if(!SettingsState.stop) {
                Assets.LevelMusic.play();
                Assets.WinMusic.stop();
            }
            if(Game.level1State.level1==true) {
                Links.game.mouseInput.clickRight = false;
                Game.level1State.level1=false;
                Game.level2State.level2=true;
                Links.player1.setXY(1*40,8*40);
                Links.player2.setXY(18*40,8*40);
                Links.player1.UpdatePosition(1*40,8*40);
                Links.player2.UpdatePosition(18*40,8*40);
                State.SetState(Links.game.level2State);
            }
            else if(Game.level2State.level2==true)
            {
                Links.game.mouseInput.clickRight = false;
                State.SetState(Links.game.win);
            }
        }
    }

    @Override
    public void Draw() {
        Links.g.drawImage(image, 0, 0,Links.game.GetWidth(), Links.game.GetHeight(), null);
        Links.game.getBs().show();
        Links.g.dispose();
    }
}
