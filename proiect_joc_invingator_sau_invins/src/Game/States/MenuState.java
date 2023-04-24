package Game.States;
import Game.Game;
import Game.Graphics.Assets;
import Game.Links;
import Game.Graphics.ImageLoader;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.sql.SQLException;
import Game.DataBaseException;

public class MenuState extends State{
    private BufferedImage menuState;
    Rectangle but1,but2,but3,but4;
    public MenuState()
    {
        super();
        menuState=ImageLoader.LoadImage("/textures/meniuFinal.png");
        but1=new Rectangle(280,315,240,60);
        but2=new Rectangle(280,410,240,60);
        but3=new Rectangle(280,515,240,60);
        but4=new Rectangle(280,620,240,60);
    }
    @Override
    public void Update() throws SQLException {
        if(Links.game.mouseInput.clickRight==true && but1.contains(Links.game.mouseInput.getX(),Links.game.mouseInput.getY()) )
        {
            Game.level1State.level1=true;
            ChooseCharacter1.isWater1=false;
            ChooseCharacter1.isFire1 =false;
            ChooseCharacter1.isAir1=false;
            ChooseCharacter2.isFire2=false;
            ChooseCharacter2.isAir2=false;
            ChooseCharacter2.isWater2=false;
            Links.game.mouseInput.clickRight=false;
            if(!SettingsState.stop) {
                Assets.MenuMusic.play();
                Assets.LevelMusic.stop();
            }
            State.SetState(Links.game.chooseCharacter1);
        }
        if(Links.game.mouseInput.clickRight==true && but2.contains(Links.game.mouseInput.getX(),Links.game.mouseInput.getY()) )
        {

            Links.game.mouseInput.clickRight=false;

            try
            {
                if(Links.player1.scor+Links.player2.scor<2 || Links.player1==null ||Links.player2==null )
                {
                    throw new DataBaseException();
                }
                else
                {
                    Game.database.updateSave(Level1State.s);
                }
            }
            catch (DataBaseException e)
            {
                System.out.println("DataBaseException.");
            }

        }
        if(Links.game.mouseInput.clickRight==true && but3.contains(Links.game.mouseInput.getX(),Links.game.mouseInput.getY()) )
        {
            Links.game.mouseInput.clickRight=false;
            State.SetState(Links.game.scoreState);
        }
        if(Links.game.mouseInput.clickRight==true && but4.contains(Links.game.mouseInput.getX(),Links.game.mouseInput.getY()) )
        {
            Links.game.mouseInput.clickRight=false;
            State.SetState(Links.game.settingsState);
        }
    }

    @Override
    public void Draw() {
        Links.g.drawImage(menuState,0,0,820,800, null);
        Links.game.getBs().show();
        Links.g.dispose();
    }
}
