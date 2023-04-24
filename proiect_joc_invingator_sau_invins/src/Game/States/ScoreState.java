package Game.States;
import Game.DataBaseException;
import Game.Game;
import Game.Graphics.Assets;
import Game.Links;
import Game.Graphics.ImageLoader;
import Game.ScoreException;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ScoreState extends State{
    private BufferedImage menuState;
    Rectangle but1;
    Rectangle but2;
    boolean sari=false;
    public ScoreState()
    {
        super();
        but1=new Rectangle(280,510,110,60);
        but2=new Rectangle(420,510,110,40);
    }
    @Override
    public void Update() {
        if(!SettingsState.stop) {
            Assets.MenuMusic.stop();
            Assets.LevelMusic.play();
        }
        if(Links.game.mouseInput.clickRight==true && but1.contains(Links.game.mouseInput.getX(),Links.game.mouseInput.getY()))
        {
            Links.game.mouseInput.clickRight=false;
            Game.level1State.level1=true;
            ChooseCharacter1.isWater1=false;
            ChooseCharacter1.isFire1 =false;
            ChooseCharacter1.isAir1=false;
            ChooseCharacter2.isFire2=false;
            ChooseCharacter2.isAir2=false;
            ChooseCharacter2.isWater2=false;
            if(!SettingsState.stop) {
                Assets.MenuMusic.play();
                Assets.LevelMusic.stop();
            }
            State.SetState(Links.game.chooseCharacter1);
        }
        else if((Links.game.mouseInput.clickRight==true && but2.contains(Links.game.mouseInput.getX(),Links.game.mouseInput.getY()))|| sari==true)
        {
            Links.game.mouseInput.clickRight=false;
            State.SetState(Links.game.menuState);

        }
    }

    @Override
    public void Draw() {
        BufferedImage background;
        BufferedImage score;
        background=ImageLoader.LoadImage("/textures/menu.jpg");
        score=ImageLoader.LoadImage("/textures/score.png");
        try
        {
            if(Links.player1==null || Links.player2==null)
            {
                throw new ScoreException();
            }
            else
            {
                Links.g.drawImage(background,0,0,820,800, null);
                Links.g.drawImage(score,150,150,500,500, null);
                Links.g.setColor(Color.BLACK);
                Links.g.setFont(new Font("Purisa", Font.PLAIN, 20));

                if(Game.level1State.level1==true)
                {
                    Links.g.drawString("nivel1:", 300, 420);
                    Links.g.drawString(Level1State.s.entitati_player1_lev1+" ", 380, 420);
                    Links.g.drawString(Level1State.s.entitati_player2_lev1+" ", 420, 420);
                }
                if(Game.level1State.level1==true)
                {
                    Links.g.drawString("nivel2:", 300, 450);
                    Links.g.drawString(Level1State.s.entitati_player1_lev2+" ", 380, 450);
                    Links.g.drawString(Level1State.s.entitati_player2_lev2+" ", 420, 450);
                }


            }
        }
        catch (ScoreException e)
        {
            System.out.println("ScoreException.");
            sari=true;

        }
        Links.game.getBs().show();
        Links.g.dispose();

    }
}
