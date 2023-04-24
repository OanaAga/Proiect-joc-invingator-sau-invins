package Game.States;
import Game.Graphics.Assets;
import Game.Links;


public class Personaj2State extends State{
    public Personaj2State() {

    }
    @Override
    public void Update() {
        if(!SettingsState.stop) {
            Assets.MenuMusic.stop();
            Assets.LevelMusic.play();
        }
        State.SetState(Links.game.level1State);

    }

    @Override
    public void Draw() {
        Links.g.drawImage(Assets.chooseCh,0,0,820,800, null);

        if(ChooseCharacter1.isWater1==true)
        {
            Links.g.drawImage(Assets.player1,75,300,200,250, null);
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

        if(ChooseCharacter2.isWater2==true)
        {
            Links.g.drawImage(Assets.player2,50,300,250,250, null);
            Links.g.drawImage(Assets.ChWater,50,300,250,250, null);
        }
        else
        {
            Links.g.drawImage(Assets.ChWater,50,300,250,250, null);
        }

        if (ChooseCharacter2.isFire2 == true) {
            Links.g.drawImage(Assets.player2, 250, 300, 250, 250, null);
            Links.g.drawImage(Assets.ChFire, 250, 300, 250, 250, null);
        }
        else {
            Links.g.drawImage(Assets.ChFire, 250, 300, 250, 250, null);
        }


        if (ChooseCharacter2.isAir2 == true) {
            Links.g.drawImage(Assets.player2, 450, 300, 250, 250, null);
            Links.g.drawImage(Assets.ChAir, 450, 300, 250, 250, null);
        }
        else {
            Links.g.drawImage(Assets.ChAir, 450, 300, 250, 250, null);
        }

        Links.game.getBs().show();
        Links.g.dispose();
        try {
            Thread.currentThread().sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
