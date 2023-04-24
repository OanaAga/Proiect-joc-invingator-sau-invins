package Game.States;
import Game.*;
import Game.Characters.Elements;
import Game.Graphics.Assets;
import Game.Map.Map1;
import Game.Map.Map2;
import java.awt.*;

import static Game.Map.Map1.Rectangle1;

public class Level2State extends State {
    private Rectangle win;
    private Rectangle col[]=new Rectangle[4];
    public static boolean dublura1=false;
    public static boolean dublura2=false;
    private Elements dublura;
    public static boolean stop1=false;
    public static boolean stop2=false;
    public static boolean level2=false;
    public static Elements Castigator;
    public Level2State()
    {
        super();
        col[0]=new Rectangle(600,215-15,35,20);
        col[1]=new Rectangle(175,400,35,20);
        col[2]=new Rectangle(415,215,35,20);
        col[3]=new Rectangle(215,525,35,20);
        win=new Rectangle(400,325,30,30);
    }
    @Override
    public void Update() throws InterruptedException {
        Game.level1State.level1=false;
        if(Elements.GetCollision(Map2.Rectangle1,Links.player1.getX(), Links.player1.getY(),Links.game.keyInput.right1,Links.game.keyInput.left1,Links.game.keyInput.up1,Links.game.keyInput.down1)==true || stop1==true) {
            Links.player1.Stop();
        }
        else
        {
            Links.player1.Update1();
        }
        if(Elements.GetCollision(Map2.Rectangle1,Links.player2.getX(),Links.player2.getY(),Links.player2.butoaneRect[0].contains(Links.game.mouseInput.getX(),Links.game.mouseInput.getY()),Links.player2.butoaneRect[2].contains(Links.game.mouseInput.getX(),Links.game.mouseInput.getY()),Links.player2.butoaneRect[1].contains(Links.game.mouseInput.getX(),Links.game.mouseInput.getY()),Links.player2.butoaneRect[3].contains(Links.game.mouseInput.getX(),Links.game.mouseInput.getY()))==true) {
            Links.player2.Stop();
        }
        else
        {
            Links.player2.Update2();
        }
        if(Map1.rec1.contains(Links.game.mouseInput.getX(),Links.game.mouseInput.getY()) && Links.game.mouseInput.clickRight==true)
        {
            if(!SettingsState.stop) {
                Assets.LevelMusic.stop();
                Assets.MenuMusic.play();
            }
            Links.game.mouseInput.clickRight=false;
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
        for(int i=0;i<4;i++) {

            if(col[i].intersects( Links.player1.box.r)==true || col[i].intersects( Links.player2.box.r)==true)
            {
                State.SetState(Links.game.fail);
            }
        }
        if(win.intersects(Links.player1.box.r)&& Links.player1.nrEntitati==9)
        {
            Links.player1.scor++;
            if(!SettingsState.stop) {
                Assets.LevelMusic.stop();
                Assets.WinMusic.play();
            }
            State.SetState(Links.game.levelComplet);
        }
        else if(win.intersects(Links.player2.box.r)&&Links.player2.nrEntitati==9)
        {
            Links.player2.scor++;
            if(!SettingsState.stop) {
                Assets.LevelMusic.stop();
                Assets.MenuMusic.stop();
                Assets.WinMusic.play();
            }
            Links.player2.captura=0;
            Links.player1.captura=0;
            State.SetState(Links.game.levelComplet);
        }
        captureaza(Links.player1,Links.player2);
        if((int)Links.player2.secondPassed/60>=5)
        {
            stop1=false;
        }
        if((int)Links.player1.secondPassed/60>=5)
        {
            stop2=false;
        }
        if(Links.player1.captura==3 || Links.player2.captura==3)
        {
            Links.player1.setXY(1*40,40*13);
            Links.player2.setXY(19*40,13*40);
            Links.player1.box.UpdateX(1*40);
            Links.player1.box.UpdateY(40*13);
            Links.player2.box.UpdateX(19*40);
            Links.player2.box.UpdateY(13*40);
            Game.level2State.level2=false;
            Links.player1.captura=0;
            Links.player2.captura=0;
            if(!SettingsState.stop) {
                Assets.LevelMusic.play();
                Assets.MenuMusic.stop();
            }
            State.SetState(Links.game.level1State);
        }
        Level1State.s.entitati_player1_lev2=Links.player1.nrEntitati;
        Level1State.s.entitati_player2_lev2=Links.player2.nrEntitati;
        Level1State.s.scor_player1=Links.player1.scor;
        Level1State.s.scor_player2=Links.player2.scor;

    }

    @Override
    public void Draw() {
        level2=true;
        Map2 m=new Map2();
        m.Draw(Links.g);
        Links.player1.Draw();
        Links.player2.Draw();

        if(Map2.recSuper1.intersects(Links.player1.box.r)==true || Map2.recSuper2.intersects(Links.player1.box.r)==true)
        {
            dublura=Links.player1.SuperPutere(ChooseCharacter1.imagDublura,Links.player2.getX()+10, Links.player2.getY()+10);
            dublura1=true;
            stop2=true;
        }
        else if(Map2.recSuper1.intersects(Links.player2.box.r)==true || Map2.recSuper2.intersects(Links.player2.box.r)==true)
        {
            dublura=Links.player2.SuperPutere(ChooseCharacter2.imagDublura,Links.player1.getX()+10, Links.player1.getY()+10);
            dublura2=true;
            stop1=true;
        }

        if(dublura1 && (int)Links.player1.secondPassed/60<5)
        {
            Links.player1.secondPassed++;
           // System.out.println("Time dublura1: "+(int)Links.player1.secondPassed/60);//practic avem 60 de frame-uri pe secunda
            dublura.Draw();
        }
        else if(dublura2 &&(int)Links.player2.secondPassed/60<5)
        {
            Links.player2.secondPassed++;
           // System.out.println("Time dublura2: "+(int)Links.player1.secondPassed/60);//practic avem 60 de frame-uri pe secunda
            dublura.Draw();
        }

        Links.g.setColor(Color.DARK_GRAY);
        Links.g.setFont(new Font("Purisa", Font.PLAIN, 18));
        Links.g.drawString("Player1: "+Links.player1.nrEntitati+" ", 150, 30);
        Links.g.drawString("Player2: "+Links.player2.nrEntitati+" ",430, 30);
        Links.g.drawImage(Links.player1.putere[0],240,12,null);
        Links.g.drawImage(Links.player2.putere[0],515,14,null);
        if(Links.player1.colecteazaAdversar)
        {

            Links.g.setColor(Color.DARK_GRAY);
            Links.g.setFont(new Font("Purisa", Font.PLAIN, 18));
            Links.g.drawString(" +"+Links.player1.captura+" ", 180+55+20, 30);
            Links.g.drawImage(Links.player2.putere[0],240+60,12,null);
        }
        if(Links.player2.colecteazaAdversar)
        {
            Links.g.setColor(Color.DARK_GRAY);
            Links.g.setFont(new Font("Purisa", Font.PLAIN, 18));
            Links.g.drawString(" +"+Links.player2.captura+" ",470+55+20, 30);
            Links.g.drawImage(Links.player1.putere[0],515+75,12,null);
        }


    }
    void captureaza(Elements el1,Elements el2)
    {
        for(int i=0;i<9;i++) {
            if (el1.box.r.intersects(el2.entitati[i]))
            {
               el1.colecteazaAdversar=true;
               if(el2.stari[i])
               {
                   el2.captura++;
               }
               el2.stari[i]=false;
            }
            if(el2.box.r.intersects(el1.entitati[i]))
            {
                el2.colecteazaAdversar=true;
                if(el1.stari[i])
                {
                    el1.captura++;
                }
                el1.stari[i]=false;
            }
        }
    }
}


