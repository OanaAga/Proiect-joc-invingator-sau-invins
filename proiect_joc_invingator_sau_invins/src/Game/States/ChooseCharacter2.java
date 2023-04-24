package Game.States;

import Game.Characters.Fire;
import Game.Characters.Water;
import Game.Characters.Air;
import Game.ChooseCharacterException;
import Game.Graphics.Assets;

import Game.Links;

import java.awt.*;
import java.awt.image.BufferedImage;


public class ChooseCharacter2 extends State{
    private Rectangle boxF;
    private Rectangle boxW;
    private Rectangle boxA;
    public static boolean alege2=false;
    public static boolean isFire2=false;
    public static boolean isWater2=false;
    public static boolean isAir2=false;
    public static BufferedImage[]imagDublura;
    public ChooseCharacter2()
    {
        boxW=new Rectangle(130,320,90,225);
        boxF=new Rectangle(335,310,95,215);
        boxA=new Rectangle(510,340,135,205);

    }
    /*!
     fn public void Update()
     Aceasta functie instantiaza cel de-al doilea personaj in functie de optiunea utilizatorului(click pe pictograma respectiva) si actualizeaza starea jocului
     */
    @Override
    public void Update() {
        if (alege2 == false) {//pt alegerea celui de-al doilea personaj
            try {
                if (Links.game.mouseInput.clickRight == true && ((boxW.contains(Links.game.mouseInput.getX(), Links.game.mouseInput.getY()) && ChooseCharacter1.isWater1 == true) || (boxW.contains(Links.game.mouseInput.getX(), Links.game.mouseInput.getY()) && ChooseCharacter1.isWater1 == true) || (boxF.contains(Links.game.mouseInput.getX(), Links.game.mouseInput.getY()) && ChooseCharacter1.isFire1 == true))) {
                    throw new ChooseCharacterException();
                }
            }
            catch (ChooseCharacterException e)
            {
                System.out.println("ChooseCharacterException.");
            }
            if (Links.game.mouseInput.clickRight == true && boxW.contains(Links.game.mouseInput.getX(), Links.game.mouseInput.getY()) && ChooseCharacter1.isWater1 == false) {
                Links.player2 = Water.getInstance(19*40,13*40,40,40,15, 30, Assets.waterDown[0], 0);
                Links.player2.putere=Assets.waterP;
                imagDublura=Assets.waterDown;
                isWater2 = true;
                Links.game.mouseInput.clickRight = false;
            } else if (Links.game.mouseInput.clickRight == true && boxA.contains(Links.game.mouseInput.getX(), Links.game.mouseInput.getY()) && ChooseCharacter1.isAir1 == false) {
                Links.player2 = Air.getInstance(19*40,13*40,40,40,15, 30, Assets.airDown[0]);
                Links.game.mouseInput.clickRight = false;
                Links.player2.putere=Assets.airP;
                imagDublura=Assets.airDown;
                isAir2 = true;
            } else if (Links.game.mouseInput.clickRight == true && boxF.contains(Links.game.mouseInput.getX(), Links.game.mouseInput.getY()) && ChooseCharacter1.isFire1 == false) {
                Links.player2 = Fire.getInstance(19*40,13*40,40,40,15, 30, Assets.fireDown[0], 0);
                Links.game.mouseInput.clickRight = false;
                Links.player2.putere=Assets.fireP;
                imagDublura=Assets.fireDown;
                isFire2 = true;
            }
            if(isAir2|| isFire2 || isWater2)
            {
                alege2=true;
            }

        }
        Links.game.mouseInput.clickRight=false;
        if(alege2) {
            alege2=false;
            State.SetState(Links.game.personaj2State);
        }
    }

    @Override
    public void Draw() {
        Links.g.drawImage(Assets.chooseCh,0,0,820,800, null);
        if(ChooseCharacter1.isWater1==true)
        {
            Links.g.drawImage(Assets.player1,50,300,250,250, null);
            Links.g.drawImage(Assets.ChWater,50,300,250,250, null);
        }
        else
        {
            Links.g.drawImage(Assets.ChWater,50,300,250,250, null);
        }

        if (ChooseCharacter1.isFire1 == true) {
            Links.g.drawImage(Assets.player1, 250, 300, 250, 250, null);
            Links.g.drawImage(Assets.ChFire, 250, 300, 250, 250, null);
        }
        else {
            Links.g.drawImage(Assets.ChFire, 250, 300, 250, 250, null);
        }

        if (ChooseCharacter1.isAir1 == true) {
            Links.g.drawImage(Assets.player1, 450, 300, 250, 250, null);
            Links.g.drawImage(Assets.ChAir, 450, 300, 250, 250, null);
        }
        else {
            Links.g.drawImage(Assets.ChAir, 450, 300, 250, 250, null);
        }
        Links.game.getBs().show();
        Links.g.dispose();

    }

}
