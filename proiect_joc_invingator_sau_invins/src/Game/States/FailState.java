package Game.States;
import Game.Graphics.Assets;
import Game.Graphics.ImageLoader;
import Game.Links;
import java.awt.image.BufferedImage;

public class FailState extends State  {
    private BufferedImage image;
    BufferedImage fail;
    public FailState()
    {
        super();
        ImageLoader im=new ImageLoader();
        image=im.LoadImage("/textures/menu.jpg");
    }
    @Override
    public void Update() throws InterruptedException {

        if(Links.game.mouseInput.clickRight==true && Links.game.mouseInput.getX()<600 && Links.game.mouseInput.getY()<600)
        {

            Links.game.mouseInput.clickRight=false;
            if(!SettingsState.stop) {
                Assets.LevelMusic.stop();
                Assets.MenuMusic.play();
            }
            State.SetState(Links.game.menuState);
        }
    }

    @Override
    public void Draw() {
        fail=ImageLoader.LoadImage("/textures/fail.png");
        Links.g.drawImage(image, 0, 0,Links.game.GetWidth(), Links.game.GetHeight(), null);
        Links.g.drawImage(fail,150,150,500,500,null);
        Links.game.getBs().show();
        Links.g.dispose();
    }
}
