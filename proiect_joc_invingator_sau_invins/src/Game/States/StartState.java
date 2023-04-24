package Game.States;
import Game.Graphics.Assets;
import Game.Graphics.ImageLoader;
import Game.Input.MouseInput;
import Game.Links;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class StartState extends State  {
    private BufferedImage startGame;

    public StartState()
    {
        super();
        startGame=ImageLoader.LoadImage("/textures/startFinal.png");
        Assets.MenuMusic.play();
    }
    @Override
    public void Update() {

        if(Links.game.mouseInput.clickRight==true && (Links.game.mouseInput.getX()>280 || MouseInput.getX()<520 ) &&(Links.game.mouseInput.getY()>315 || Links.game.mouseInput.getY()<375))
        {
            Links.game.mouseInput.clickRight=false;
            State.SetState(Links.game.menuState);
        }
    }

    @Override
    public void Draw() {
        BufferStrategy x =Links.game.getWnd().GetCanvas().getBufferStrategy();
        Links.game.setBs(x);
        /// Verific daca buffer strategy a fost construit sau nu
        if (Links.game.getBs() == null) {
            /// Se executa doar la primul apel al metodei Draw()
            try {
                /// Se construieste tripul buffer
                Links.game.getWnd().GetCanvas().createBufferStrategy(3);
                return;
            } catch (Exception e) {
                /// Afisez informatii despre problema aparuta pentru depanare.
                e.printStackTrace();
            }
        }
        Graphics g;
        g=Links.game.getBs().getDrawGraphics();
        g.clearRect(0,0,Links.game.GetWidth(),Links.game.GetHeight());
        g.drawImage(startGame,0,0,820,800, null);
        Links.g.setColor(Color.BLACK);
        Links.g.setFont(new Font("Purisa", Font.PLAIN, 20));
        Links.g.drawString("Tap to continue", 327, 430);
        Links.game.getBs().show();
        g.dispose();
    }
}
