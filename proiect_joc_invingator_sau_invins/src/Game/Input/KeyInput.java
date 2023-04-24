package Game.Input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyInput implements KeyListener {
    public static boolean up;
    public static boolean down;
    public static boolean left;
    public static boolean right;
    public static boolean up1;
    public static boolean down1;
    public static boolean right1;
    public static boolean left1;

    public KeyInput()
    {
        up=down=left=right=false;
        up1=down1=left1=right1=false;
    }
    /*! \fn public void keyTyped(KeyEvent e)
       \brief keyTyped nu are corp, deoarece nu este folosita
    */
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code=e.getKeyCode();
        switch(code)
        {
            case KeyEvent.VK_A:
                left1=true;
                break;
            case KeyEvent.VK_S:
                down1=true;
                break;
            case KeyEvent.VK_D:
                right1=true;
                break;
            case KeyEvent.VK_W:
                up1=true;
                break;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code=e.getKeyCode();
        switch(code)
        {
            case KeyEvent.VK_A:
                left1=false;
                break;
            case KeyEvent.VK_S:
                down1=false;
                break;
            case KeyEvent.VK_D:
                right1=false;
                break;
            case KeyEvent.VK_W:
                up1=false;
                break;
        }
    }
}
