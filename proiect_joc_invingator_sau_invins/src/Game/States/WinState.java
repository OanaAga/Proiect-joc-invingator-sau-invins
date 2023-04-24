package Game.States;
import Game.Game;
import Game.Graphics.ImageLoader;
import Game.Links;
import java.awt.image.BufferedImage;

public class WinState extends State  {
    private BufferedImage image;
    public WinState(Game game)
    {
        super();
        ImageLoader im=new ImageLoader();
        image=im.LoadImage("/textures/win1.png");
    }
    @Override
    public void Update() {
        if(Links.game.mouseInput.clickRight==true )
        {
            Links.game.mouseInput.clickRight=false;
            State.SetState(Links.game.menuState);
        }
    }

    @Override
    public void Draw() {
        Links.g.drawImage(image, 0, 0,Links.game.GetWidth(), Links.game.GetHeight(), null);
        Links.game.getBs().show();
        Update();
        Links.g.dispose();
    }
}
