package Game.States;
import Game.Characters.Fire;
import Game.Characters.Water;
import Game.Characters.Air;
import Game.Graphics.Assets;
import Game.Links;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ChooseCharacter1 extends State{

    private Rectangle boxF;
    private Rectangle boxW;
    private Rectangle boxA;
    static boolean isFire1=false;
    static boolean isWater1=false;
    static boolean isAir1=false;
    static boolean alege1=false;
    public static BufferedImage[] imagDublura;
    public ChooseCharacter1()
    {
        boxW=new Rectangle(130,320,90,225);
        boxF=new Rectangle(335,310,95,215);
        boxA=new Rectangle(510,340,135,205);
    }
    /*!
     fn public void Update()
     Aceasta functie instantiaza primul personaj in functie de optiunea utilizatorului(click pe pictograma respectiva) si actualizeaza starea jocului
     */
    @Override
    public void Update() {
        if (alege1 == false) {
            if (Links.game.mouseInput.clickRight == true && boxW.contains(Links.game.mouseInput.getX(), Links.game.mouseInput.getY())) {
                Game.Links.player1 = Water.getInstance(1 * 40, 13 * 40, 40, 40, 15, 30, Assets.waterDown[0], 0);
                Game.Links.player1.putere=Assets.waterP;
                imagDublura=Assets.waterDown;
                isWater1 = true;
                Links.game.mouseInput.clickRight = false;

            }
            if (Links.game.mouseInput.clickRight == true && boxA.contains(Links.game.mouseInput.getX(), Links.game.mouseInput.getY())) {

                Game.Links.player1 = Air.getInstance(1 * 40, 13 * 40, 40, 40, 15, 30, Assets.airDown[0]);
                Game.Links.player1.putere=Assets.airP;
                Links.game.mouseInput.clickRight = false;
                imagDublura=Assets.airDown;
                isAir1 = true;
            }
            if (Links.game.mouseInput.clickRight == true && boxF.contains(Links.game.mouseInput.getX(), Links.game.mouseInput.getY())) {
                Links.player1 = Fire.getInstance(1 * 40, 13 * 40, 40, 40, 15, 30, Assets.fireDown[0], 0);

                Game.Links.player1.putere=Assets.fireP;
                Links.game.mouseInput.clickRight = false;
                imagDublura=Assets.fireDown;
                isFire1 = true;
            }
            if(isFire1==true || isWater1==true || isAir1==true)
            {
                alege1=true;

            }
        }

        // System.out.println(Links.game.mouseInput.getX()+ " "+Links.game.mouseInput.getY() );
        Links.game.mouseInput.clickRight=false;
        if(alege1==true) {
            alege1=false;
            State.SetState(Links.game.personaj1State);
        }
    }

    @Override
    public void Draw() {
        Links.g.drawImage(Assets.chooseCh,0,0,820,800, null);
        Links.g.drawImage(Assets.ChWater,50,300,250,250, null);
        Links.g.drawImage(Assets.ChFire,250,300,250,250, null);
        Links.g.drawImage(Assets.ChAir,450,300,250,250, null);
        Links.game.getBs().show();
        Links.g.dispose();

    }

}
