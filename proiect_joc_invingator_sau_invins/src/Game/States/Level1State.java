package Game.States;
import Game.*;
import Game.Characters.Elements;
import Game.Characters.Score;
import Game.Graphics.Assets;
import Game.Map.Map1;
import java.awt.*;


import static Game.Map.Map1.*;

public class Level1State extends State {
    private Rectangle win;
    private Rectangle col[]=new Rectangle[6];
    public static boolean level1=false;
    static Score s=new Score();
    public Level1State()
    {
        super();
        col[0]=new Rectangle(160,520,35,35);
        col[1]=new Rectangle(285,360,35,35);
        col[2]=new Rectangle(360,400,35,35);
        col[3]=new Rectangle(200,145,35,35);
        col[4]=new Rectangle(190,645,35,35);
        col[5]=new Rectangle(585,285,35,35);
        win=new Rectangle(480,400,40,40);
    }
    @Override
    public void Update() throws InterruptedException {
        Game.level1State.level1=true;
        Level2State.stop1=false;
        Level2State.stop2=false;

        if(win.intersects(Links.player1.box.r)==true)
        {
            Links.player1.scor++;
            for(int i=0;i<9;i++)
            {
                Links.player1.stari[i]=true;
                Links.player2.stari[i]=true;

            }
            Links.player1.nrEntitati=0;
            Links.player2.nrEntitati=0;
            if(!SettingsState.stop) {
                Assets.LevelMusic.stop();
                Assets.WinMusic.play();
            }
            State.SetState(Links.game.levelComplet);
        }
        if(win.intersects(Links.player2.box.r)==true)
        {
            Links.player1.scor++;
            for(int i=0;i<9;i++)
            {
                Links.player1.stari[i]=true;
                Links.player2.stari[i]=true;

            }
            Links.player1.nrEntitati=0;
            Links.player2.nrEntitati=0;
            if(!SettingsState.stop) {
                Assets.LevelMusic.stop();
                Assets.WinMusic.play();
            }
            State.SetState(Links.game.levelComplet);

        }
        if(Elements.GetCollision(Rectangle1,Links.player1.getX(), Links.player1.getY(),Links.game.keyInput.right1,Links.game.keyInput.left1,Links.game.keyInput.up1,Links.game.keyInput.down1)==true) {
            Links.player1.Stop();
        }
        else
        {
            Links.player1.Update1();
        }
        if(Elements.GetCollision(Rectangle1,Links.player2.getX(),Links.player2.getY(),Links.player2.butoaneRect[0].contains(Links.game.mouseInput.getX(),Links.game.mouseInput.getY()),Links.player2.butoaneRect[2].contains(Links.game.mouseInput.getX(),Links.game.mouseInput.getY()),Links.player2.butoaneRect[1].contains(Links.game.mouseInput.getX(),Links.game.mouseInput.getY()),Links.player2.butoaneRect[3].contains(Links.game.mouseInput.getX(),Links.game.mouseInput.getY()))==true) {
            Links.player2.Stop();
        }
        else
        {
            Links.player2.Update2();
        }
        for(int i=0;i<6;i++) {

             if(col[i].intersects( Links.player1.box.r)==true || col[i].intersects( Links.player2.box.r)==true)
             {
                 State.SetState(Links.game.fail);
            }
        }
        if(Map1.rec1.contains(Links.game.mouseInput.getX(),Links.game.mouseInput.getY()) && Links.game.mouseInput.clickRight==true)
        {
            if(!SettingsState.stop) {
                Assets.LevelMusic.stop();
                Assets.MenuMusic.play();
            }
            State.SetState(Links.game.menuState);
        }
        if(Map1.rec2.contains(Links.game.mouseInput.getX(),Links.game.mouseInput.getY()) && Links.game.mouseInput.clickRight==true)
        {
            if(!SettingsState.stop) {
                Assets.LevelMusic.stop();
                Assets.MenuMusic.play();
            }
            Links.game.mouseInput.clickRight=false;
            State.SetState(Links.game.pause);
        }
        s.entitati_player1_lev1=Links.player1.nrEntitati;
        s.entitati_player2_lev1=Links.player2.nrEntitati;
    }

    @Override
    public void Draw()  {
        Map1 m=new Map1();
        m.Draw(Links.g);

        Links.player1.Draw();
        Links.player2.Draw();
        Links.g.setColor(Color.DARK_GRAY);
        Links.g.setFont(new Font("Purisa", Font.PLAIN, 18));
        Links.g.drawString("Player1: "+Links.player1.nrEntitati+" ", 40, 30);
        Links.g.drawString("Player2: "+Links.player2.nrEntitati+" ",330, 30);
        Links.g.drawImage(Links.player1.putere[0],130,12,null);
        Links.g.drawImage(Links.player2.putere[0],415,12,null);


    }


}
